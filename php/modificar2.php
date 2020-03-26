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
$MAIL->Encoding   = 'base64'; 
$mail->setFrom('schooltime010@gmail.com', 'SchoolTime');

$id=$_REQUEST['id'];
$titulo_e = $_POST['titulo_e'];
$descripcion_e = $_POST['descripcion_e'];
$tipo_e = $_POST['tipo_e'];
$fecha_e = $_POST['fecha_e'];
$hora_e = $_POST['hora_e'];
$para = $_POST['para'];
$grupo = $_POST['grupo'];
$tipo_evento="";

if($tipo_e=="Celebracion"){
	$tipo_evento = "Celebración";
}

if($tipo_e=="Cambio"){
	$tipo_evento = "Cambio de horario";
}

if($tipo_e=="Reunion"){
    $tipo_evento = "Reunión";
}

//Contenido del Email
$headers = "Content-Type: text/plain; charset=UTF-8\n";
$subject= $titulo_e;
$body = "<meta charset='utf-8'>";
$body.= "<p>".$descripcion_e."</p>";
$body.= "<p> Fecha: ".$fecha_e."</p>";
$body.= "<p> Hora: ".$hora_e."</p>";
$body.= "<br><small> Los datos de este evento han sido actualizados. </small>";

$estudiantes="0";
$docentes="0";
$acudientes="0";

if($tipo_e =="Celebracion"){
	global $tipo_e;
	$tipo_e = "00A";

}elseif($tipo_e =="Cambio"){
	global $tipo_e;
	$tipo_e = "00B";
}else{
	global $tipo_e;
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


if ($resultado && $resultadoF && $resultadoH && $insertarEvento_Grupo) {
	header('location:../admin/eventos.php');
}else{
	echo "Error";
}
?>

