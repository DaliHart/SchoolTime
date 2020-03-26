<?php


if (isset($_POST['registrar'])) {

	include('conexion.php');
	require('../PHPMailer/Exception.php');
	require('../PHPMailer/PHPMailer.php');
	require('../PHPMailer/SMTP.php');
	require('../PHPMailer/OAuth.php');

	$mail = new PHPMailer\PHPMailer\PHPMailer();
    //Server settings
    $mail->SMTPDebug = 0;                    
    $mail->isSMTP();                                          
    $mail->Host       = 'smtp.gmail.com';                  
    $mail->SMTPAuth   = true;       
    $mail->Username   = 'schooltime010@gmail.com';   
    $mail->Password   = 'DcJ&2019.ST';      
    $mail->SMTPSecure = 'tls';    
	$mail->Port       = 587;    
	$mail->CharSet    = 'UTF-8';
	$mail->Encoding   = 'base64';
	$mail->setFrom('schooltime010@gmail.com', 'SchoolTime');
	
	

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
		global $titulo_evento;
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

	


	/* //Enviar a docentes sin direccion de grupo
	if($Doc=="DOCENTES"){
		$consultaEvento_G = "INSERT INTO tbl_eventoxgrupo (id_evento, codigo_g, estudiante, acudiente, docente) VALUES ('$id_evento','$Doc','0','0','1')";
		$insertarEvento_G =mysqli_query($conexion,$consultaEvento_G);
		if($insertarEvento_G){

		}else{
			echo "<script> alert('Error en el registro');</script>";
		}
	} */


	//Enviar Emails
	$headers = "Content-Type: text/plain; charset=UTF-8\n";
	$subject= $titulo_e;
	$body = "<meta charset='utf-8'>";
	$body.= "<p>".$descripcion_e."</p>";
	$body.= "<p> Fecha: ".$fecha_e."</p>";
	$body.= "<p> Hora: ".$hora_e."</p>";

	$consultaExG="SELECT * FROM tbl_eventoxgrupo WHERE id_evento='$id_evento'";
	$resultE=$conexion->query($consultaExG);
	while ($rowExG=$resultE->fetch_assoc()){
		$codigo_g = $rowExG['codigo_g'];

		if($rowExG['estudiante']=="1"){
			//Enviar correo a estudiantes

			$queryEE="SELECT * FROM tbl_estudiante WHERE codigo_g='$codigo_g'";
			$resultadoEE=$conexion->query($queryEE);
			while ($rowEE=$resultadoEE->fetch_assoc()){

			$mail->isHTML(true);        
			$mail->Subject = $subject;
			$mail->Body    = $body;
			$mail->addAddress($rowEE["correo_e"]);

			if(!$mail->send()){
				echo $rowEE['correo_e'];
				echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
			} 
			$mail->ClearAddresses();
    
			}
		}

		if($rowExG['acudiente']=="1"){
			//Enviar correo a acudiente

			$queryEE="SELECT * FROM tbl_acudiente WHERE codigo_g='$codigo_g'";
			$resultadoEE=$conexion->query($queryEE);
			while ($rowEE=$resultadoEE->fetch_assoc()){

			$mail->isHTML(true);        
			$mail->Subject = $subject;
			$mail->Body    = $body;
			$mail->addAddress($rowEE["correo_acu"]);

			if(!$mail->send()){
				echo $rowEE['correo_acu'];
				echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
			}
			$mail->ClearAddresses();
    
			}

		}

		if($rowExG['docente']=="1"){
			//Enviar correo a docentes

			$queryEE="SELECT * FROM tbl_docente WHERE codigo_g='$codigo_g'";
			$resultadoEE=$conexion->query($queryEE);
			while ($rowEE=$resultadoEE->fetch_assoc()){

			$mail->isHTML(true);        
			$mail->Subject = $subject;
			$mail->Body    = $body;
			$mail->addAddress($rowEE["correo_doc"]);

			if(!$mail->send()){
				echo $rowEE['correo_doc'];
				echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
			} 
			$mail->ClearAddresses();
    
			}

		}

	}
	



	if ($insertar) {
		
		echo "<script>window.location='../admin/eventos.php';</script>";
		
	}else{
		echo "Ocurrió un error";
	}	
    }


?>