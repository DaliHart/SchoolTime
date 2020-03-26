<?php


if (isset($_POST['registrar'])) {
	

	$id_evento = $_POST['id_evento'];
	$titulo_e= $_POST['titulo_e'];
	$descripcion_e = $_POST['descripcion_e'];
	$tipo_e = $_POST['tipo_e'];
	$fecha_e = $_POST['fecha_e'];
	$hora_e = $_POST['hora_e'];
	$para = $_POST['para'];
	$grupo = $_POST['grupo'];
	$id_fecha="";
	$id_horas="";
	$id_evento="";


	$estudiantes="0";
	$docentes="0";
	$acudientes="0";


	/* PROVISIONALES */
	$tipo="00C";
	$id_mod="589796";
	$id_admin="968796";

	if($tipo_e =="Celebracion"){
		global $tipo;
		$tipo_e = "00A";

	}elseif($tipo_e =="Cambio"){
		global $tipo;
		$tipo_e = "00B";
	}else{
		global $tipo;
		$tipo_e = "00C";
	}

	for ($a=0; $a<sizeof ($para); $a++){
		global $estudiantes;
		global $acudientes;
		global $docentes;

		if($para[$a]=="estudiantes"){
			$estudiantes="1";
		}
		if($para[$a]=="docentes"){
			$docentes="1";
		}
		if($para[$a]=="acudientes"){
			$acudientes="1";
		}
	}
	

	include "conexion.php";

	$consultaFecha = "INSERT INTO tbl_fecha_evento (id_fecha, fecha_publicacion, fecha_evento, fecha_eliminacion, fecha_creacion) VALUES (uuid(), now(), '$fecha_e', DATE_ADD('$fecha_e', INTERVAL 1 DAY), now())";
	$insertarFecha = mysqli_query($conexion,$consultaFecha);

	$consultaHora = "INSERT INTO tbl_hora_evento (id_horas, hora_publicacion, hora_evento, hora_eliminacion, fecha_creacion_hora ) VALUES (uuid(), now(), '$hora_e', '00:00:00', now())";
	$insertarHora = mysqli_query($conexion,$consultaHora);

	$query="SELECT id_fecha FROM tbl_fecha_evento order by fecha_creacion desc limit 1";
	$resultado=$conexion->query($query);
	while ($rowF=$resultado->fetch_assoc()){
		global $id_fecha;
		$id_fecha = $rowF['id_fecha'];

	}

	$consultaH="SELECT id_horas FROM tbl_hora_evento order by fecha_creacion_hora desc limit 1";
	$resul=$conexion->query($consultaH);
	while ($rowH=$resul->fetch_assoc()){
		global $id_horas;
		$id_horas = $rowH['id_horas'];

	}
	
	$consulta = "INSERT INTO tbl_evento (titulo_e, descripcion_e, id_tipo, id_fecha, id_horas, id_administrador, id_moderador, fecha_creacion_evento) VALUES ('$titulo_e', '$descripcion_e', '$tipo_e', '$id_fecha', '$id_horas','$id_admin','$id_mod', now())";
	$insertar = mysqli_query($conexion,$consulta);

	$consultaE="SELECT id_evento FROM tbl_evento order by fecha_creacion_evento desc limit 1";
	$result=$conexion->query($consultaE);
	while ($rowE=$result->fetch_assoc()){
		global $id_evento;
		$id_evento = $rowE['id_evento'];
	}

	for ($a=0; $a<sizeof ($grupo); $a++){
		$consultaEvento_Grupo = "INSERT INTO tbl_eventoxgrupo (id_evento, codigo_g, estudiante, acudiente, docente) VALUES ('$id_evento','".$grupo[$a]."','$estudiantes','$acudientes','$docentes')";
		$insertarEvento_Grupo =mysqli_query($conexion,$consultaEvento_Grupo);
		if($insertarEvento_Grupo){
			
		}else{
			echo "<script> alert('Error en el registro');</script>";
		}
	}
	



	if ($insertar) {
		
		echo "<script>window.location='../admin/eventos.php';</script>";
		
	}else{
		echo "Ocurrió un error";
	}	
    }


?>