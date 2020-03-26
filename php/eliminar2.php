<?php

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

$id=$_REQUEST['id_evento'];

$queryEvento="SELECT * FROM tbl_evento 
WHERE id_evento='$id'";
$resultadoEvento=$conexion->query($queryEvento);
$rowEvento=$resultadoEvento->fetch_assoc();
$titulo_e = $rowEvento['titulo_e'];
$descripcion_e = $rowEvento['descripcion_e'];



/* Eliminar Fecha */

$queryFecha="SELECT * FROM tbl_evento AS evento 
INNER JOIN tbl_fecha_evento AS fecha ON evento.id_fecha=fecha.id_fecha 
WHERE evento.id_evento='$id'";
$resultadoFecha=$conexion->query($queryFecha);
$rowFecha=$resultadoFecha->fetch_assoc();
$id_fecha = $rowFecha['id_fecha'];
$fecha_e = $rowFecha['fecha_evento'];

$queryF="DELETE FROM tbl_fecha_evento WHERE id_fecha='$id_fecha'";
$resultadoF=$conexion->query($queryF);

/* Eliminar Hora */

$queryHora="SELECT * FROM tbl_evento AS evento 
INNER JOIN tbl_hora_evento AS hora ON evento.id_horas=hora.id_horas 
WHERE evento.id_evento='$id'";
$resultadoHora=$conexion->query($queryHora);
$rowHora=$resultadoHora->fetch_assoc();
$id_hora = $rowHora['id_horas'];
$hora_e = $rowHora['hora_evento'];

$queryF="DELETE FROM tbl_hora_evento WHERE id_horas='$id_hora'";
$resultadoF=$conexion->query($queryF);

//Contenido del Email
$headers = "Content-Type: text/plain; charset=UTF-8\n";
$subject= "Cancelado - ".$titulo_e;
$body = "<meta charset='utf-8'>";
$body.= "<h1> Evento cancelado.</h1>";
$body.= "<p>".$descripcion_e."</p>";
$body.= "<p> Fecha: ".$fecha_e."</p>";
$body.= "<p> Hora: ".$hora_e."</p>";
$body.= "<br><small> Los datos de este evento fueron eliminados. </small>";


	//Enviar Emails
	
	$consultaExG="SELECT * FROM tbl_eventoxgrupo WHERE id_evento='$id'";
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
			} else{
				echo "E-Mail enviado";
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
			} else{
				echo "E-Mail enviado";
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
			} else{
				echo "E-Mail enviado";
			}
			$mail->ClearAddresses();
    
			}

		}

	}


/* Eliminar Evento X Grupo */

$queryExG="DELETE FROM tbl_eventoxgrupo WHERE id_evento='$id'";
$resultadoExG=$conexion->query($queryExG);



/* Eliminar Evento */

$query="DELETE FROM tbl_evento WHERE id_evento='$id'";
$resultado=$conexion->query($query);
if ($resultado) {
	if($rol=="Moderador"){
		header("location:../moderador/eventos.php");
	}else{
		header("location:../admin/eventos.php");
	}
	
}else{
	echo "Error";
}

?>