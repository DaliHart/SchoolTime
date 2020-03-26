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
    $mail->setFrom('schooltime010@gmail.com', 'SchoolTime');




$query="SELECT * FROM tbl_docente";
$resultado=$conexion->query($query);
while ($row=$resultado->fetch_assoc()){

    $mail->isHTML(true);        
    $mail->Subject = 'Cambio de Horario';
    $mail->Body    = $body;
    $mail->addAddress($row["correo_doc"]);

    if(!$mail->send()){
        echo $row['correo_doc'];
        echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
    } else{
        echo "E-Mail enviado";
    }
    $mail->ClearAddresses();
    
}

    

/* if ($row==1) {
}else{
    echo "<script type='text/javascript'>alert('Error correo no existe');</script>";
} */ 