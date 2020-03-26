<?php

include "conexion.php";

$id=$_REQUEST['id'];
$titulo_e = $_POST['titulo_e'];
$descripcion_e = $_POST['descripcion_e'];
$tipo_e = $_POST['tipo_e'];
$fecha_e = $_POST['fecha_e'];
$hora_e = $_POST['hora_e'];
$para = $_POST['para'];
$grupo = $_POST['grupo'];

$estudiantes="0";
$docentes="0";
$acudientes="0";

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

$query="UPDATE tbl_evento SET
titulo_e='$titulo_e',
descripcion_e='$descripcion_e',
id_tipo='$tipo_e'
WHERE id_evento='$id'";
$resultado=$conexion->query($query);

/* Actualizar Fecha */

$queryIdFecha="SELECT * FROM tbl_fecha_evento AS fecha INNER JOIN 
tbl_evento AS evento ON fecha.id_fecha=evento.id_fecha 
WHERE evento.id_evento='$id'";
$resultadoIdFecha=$conexion->query($queryIdFecha);
$rowIdFecha=$resultadoIdFecha->fetch_assoc();
$id_fecha = $rowIdFecha['id_fecha'];

$queryF="UPDATE tbl_fecha_evento SET
fecha_evento='$fecha_e',
fecha_eliminacion=DATE_ADD('$fecha_e', INTERVAL 1 DAY)
WHERE id_fecha='$id_fecha'";
$resultadoF=$conexion->query($queryF);

/* Actualizar Hora */

$queryIdHora="SELECT * FROM tbl_hora_evento AS hora INNER JOIN 
tbl_evento AS evento ON hora.id_horas=evento.id_horas 
WHERE evento.id_evento='$id'";
$resultadoIdHora=$conexion->query($queryIdHora);
$rowIdHora=$resultadoIdHora->fetch_assoc();
$id_hora = $rowIdHora['id_horas'];

$queryH="UPDATE tbl_hora_evento SET
hora_evento='$hora_e'
WHERE id_horas='$id_hora'";
$resultadoH=$conexion->query($queryH);

/* Actualizar Grupos y Roles */

$queryGyR="DELETE FROM tbl_eventoxgrupo WHERE id_evento='$id'";
$resultadoGyR=$conexion->query($queryGyR);

for ($a=0; $a<sizeof ($grupo); $a++){
	$consultaEvento_Grupo = "INSERT INTO tbl_eventoxgrupo (id_evento, codigo_g, estudiante, acudiente, docente) VALUES ('$id','".$grupo[$a]."','$estudiantes','$acudientes','$docentes')";
	$insertarEvento_Grupo =mysqli_query($conexion,$consultaEvento_Grupo);
	if(!$insertarEvento_Grupo){
		echo "<script> alert('Ocurrió un error');</script>";
	}
}


if ($resultado && $resultadoF && $resultadoH && $insertarEvento_Grupo) {
	header('location:../admin/eventos.php');
}else{
	echo "Error";
}
?>

