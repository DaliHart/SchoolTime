<?php


if (isset($_POST['registrar'])) {
	session_start();
	
	
	/* Conexión db y librería PhpMailer para el envío de correos */
	include('conexion.php');
	require('../PHPMailer/Exception.php');
	require('../PHPMailer/PHPMailer.php');
	require('../PHPMailer/SMTP.php');
	require('../PHPMailer/OAuth.php');

	/* Datos para enviar el correo como
	la dirección y contraseña del correo de origen */
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
	
	
	/* Datos del formulario HTML */
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

	
	
	
	/* Variable que deben definirse necesariamente antes de iniciar
	pero no contienen información relevante */
	$id_admin = NULL;
	$id_mod = NULL;
	$estudiantes="0";
	$docentes="0";
	$acudientes="0";

	



	$query="SELECT id_fecha FROM tbl_fecha_evento order by fecha_creacion desc limit 1";
	$resultado=$conexion->query($query);
	while ($rowF=$resultado->fetch_assoc()){
		global $id_fecha;
		$id_fecha = $rowF['id_fecha'];

	}
	//

	/* PROVISIONALES */
	$tipo="00C";

	/* Convertir la variable tipo de evento para poder
	insertarlo en la base de datos */
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

	/* Ciclo para  adquirir los seleccionados en el campo para[]*/
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
	

	
	/* Insertar en la tabla fecha */
	$consultaFecha = "INSERT INTO tbl_fecha_evento (id_fecha, fecha_publicacion, fecha_evento, fecha_eliminacion, fecha_creacion) VALUES (uuid(), now(), '$fecha_e', DATE_ADD('$fecha_e', INTERVAL 1 DAY), now())";
	$insertarFecha = mysqli_query($conexion,$consultaFecha);

	/* Insertar en la tabla hora */
	$consultaHora = "INSERT INTO tbl_hora_evento (id_horas, hora_publicacion, hora_evento, hora_eliminacion, fecha_creacion_hora ) VALUES (uuid(), now(), '$hora_e', '00:00:00', now())";
	$insertarHora = mysqli_query($conexion,$consultaHora);

	/* Consultar el id de la fecha recién insertada */
	$query="SELECT id_fecha FROM tbl_fecha_evento order by fecha_creacion desc limit 1";
	$resultado=$conexion->query($query);
	while ($rowF=$resultado->fetch_assoc()){
		global $id_fecha;
		$id_fecha = $rowF['id_fecha'];

	}

	/* Consultar del id de la hora recién insertada */
	$consultaH="SELECT id_horas FROM tbl_hora_evento order by fecha_creacion_hora desc limit 1";
	$resul=$conexion->query($consultaH);
	while ($rowH=$resul->fetch_assoc()){
		global $id_horas;
		$id_horas = $rowH['id_horas'];

	}
	
	/* Insertar en evento */
	$consulta = "INSERT INTO tbl_evento (titulo_e, descripcion_e, estado_e, id_tipo, id_fecha, id_horas, fecha_creacion_evento) VALUES ('$titulo_e', '$descripcion_e', 'PROGRAMADO', '$tipo_e', '$id_fecha', '$id_horas',now())";
	$insertar = mysqli_query($conexion,$consulta);

	/* Consultar el id del evento recién insertado */
	$consultaE="SELECT id_evento FROM tbl_evento order by fecha_creacion_evento desc limit 1";
	$result=$conexion->query($consultaE);
	while ($rowE=$result->fetch_assoc()){
		global $id_evento;
		global $titulo_evento;
		$id_evento = $rowE['id_evento'];
	}

	//Consultar el id del usuario para registrar quién creó el evento
	$empty=$_SESSION['usuario'];
	$queryA = mysqli_query($conexion,"SELECT * FROM tbl_administrador WHERE usuario_adm= '$empty'");
	$queryM = mysqli_query($conexion,"SELECT * FROM tbl_moderador WHERE usuario_mod= '$empty'");
	//Consultar el id del administrador

	
	if($consulta = mysqli_num_rows($queryA)>0 ){	
		$query="SELECT * FROM tbl_administrador WHERE usuario_adm= '$empty'";
		$resultado=$conexion->query($query);
		$rowA=$resultado->fetch_assoc();
		$id_admin = $rowA['id_administrador'];
		
		/* Si el usuario es administrador se insertará su id y el id del evento en la tabla */
		$consultaAdmin_Evento = "INSERT INTO tbl_adminxevento (id_administrador, id_evento) VALUES ('$id_admin','$id_evento')";
		$insertarAdmin_Evento =mysqli_query($conexion,$consultaAdmin_Evento);
		if(!$insertarAdmin_Evento){
			echo "<script> alert('Error al registrar el id de administrador');</script>";
		}

	}else{
		if($consulta = mysqli_num_rows($queryM)>0){
			/* Si es un moderador quien está creando el evento se registrará su id en la tabla del evento */
			$queryC="SELECT * FROM tbl_moderador WHERE usuario_mod= '$empty'";
			$resul=$conexion->query($queryC);
			$rowM=$resul->fetch_assoc();
			$id_mod = $rowM['id_moderador'];

			$consultaMod_Evento = "INSERT INTO tbl_modxevento (id_moderador, id_evento) VALUES ('$id_mod','$id_evento')";
			$insertarMod_Evento =mysqli_query($conexion,$consultaMod_Evento);
			if(!$insertarMod_Evento){
				echo "<script> alert('Error al registrar el id de moderador');</script>";
			}
		}
	}

	
	/* Insertar en la tabla eventoxgrupo
	Esta tabla define a qué grupos va dirigido el evento */
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
	
	
	/* Consulta y siclo while para recorrer los grupos a los que se le enviará el correo  */
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
		
		/* Si el usuario es adminstrador los redirigirá a la vista eventos de administrador */
		if($id_admin != NULL){
			echo "<script>window.location='../admin/eventos.php?id=PROGRAMADO'</script>";
		}else{

			/* Si el usuario es moderador lo regirigirá a la vista eventos de moderador */
			if( $id_mod != NULL){
				echo "<script>window.location='../moderador/eventos_mod.php'</script>";
			}
		}
		
		
	}else{
		/* Si ocurre un error a la hora de insertar el evento imprimirá el mensaje*/
		echo "Ocurrió un error";
	}	
    }


?>