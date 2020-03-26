<?php
include('php/conexion.php');
require('PHPMailer/Exception.php');
require('PHPMailer/PHPMailer.php');
require('PHPMailer/SMTP.php');
require('PHPMailer/OAuth.php');

$correo = $_POST['correo'];
$asunto = $_POST['asunto'];
$mensaje = $_POST['msg'];
$body = "Correo:". $correo. "<br>Asunto:". $asunto. "<br>Mensaje:". $mensaje;

$query = mysqli_query($conexion, "SELECT * FROM tbl_docente WHERE correo_doc='$correo'");
$row = mysqli_num_rows($query);

if ($row==1) {


    
    $mail = new PHPMailer\PHPMailer\PHPMailer();
    //Server settings
    $mail->SMTPDebug = 0;                      // Enable verbose debug output
    $mail->isSMTP();                                            // Send using SMTP
    $mail->Host       = 'smtp.gmail.com';                    // Set the SMTP server to send through
    $mail->SMTPAuth   = true;                                   // Enable SMTP authentication
    $mail->Username   = 'schooltime010@gmail.com';                     // SMTP username
    $mail->Password   = 'DcJ&2019.ST';                               // SMTP password
    $mail->SMTPSecure = 'tls';         // Enable TLS encryption; `PHPMailer::ENCRYPTION_SMTPS` encouraged
    $mail->Port       = 587;                                    // TCP port to connect to, use 465 for `PHPMailer::ENCRYPTION_SMTPS` above
            //Recipients
    $mail->setFrom('schooltime010@gmail.com', 'SchoolTime');
    
         // Add a recipient
    // Content
    $mail->isHTML(true);                                  // Set email format to HTML
    $mail->Subject = 'Cambio de Horario';
    $mail->Body    = $body;


$mail->addAddress($correo);

if(!$mail->send()){
    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
} else{
    echo "E-Mail enviado";
}
 
}else{
    echo "<script type='text/javascript'>alert('Error correo no existe');</script>";
} 