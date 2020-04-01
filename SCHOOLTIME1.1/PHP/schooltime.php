<?php
error_reporting(0);
//Datos del servidor, base de datos
$servername = "localhost";
$dbname = "stime";
$username = "root";
$password = "";

$con = mysqli_connect($servername,$username,$password, $dbname) or die(mysqli_error($con));// se realiza la conexión.
mysqli_set_charset ($con , "utf8");

$action = $_GET["act"];
   switch ($action) {
   case 'evento':
      $codigo = $_GET["codigo"];
      $quien = $_GET["quien"];
      $sql = "select tbl_evento.titulo_e, tbl_evento.descripcion_e,tbl_eventoxgrupo.codigo_g,tbl_fecha_evento.fecha_evento,tbl_hora_evento.hora_evento,tbl_tipo_evento.id_tipo
                from tbl_fecha_evento inner join tbl_evento
                on tbl_fecha_evento.id_fecha=tbl_evento.id_fecha
                inner join tbl_hora_evento on tbl_hora_evento.id_horas=tbl_evento.id_horas
                inner join tbl_tipo_evento on tbl_tipo_evento.id_tipo=tbl_evento.id_tipo
                inner join tbl_eventoxgrupo on tbl_evento.id_evento=tbl_eventoxgrupo.id_evento
                where estado_e='PROGRAMADO' AND $quien=1 AND codigo_g='$codigo'";
      $q = $con->query($sql);   

      while($r = mysqli_fetch_assoc($q)) 
      {
          $rows[] = $r;
      }
      print json_encode($rows);
      break;
      case 'cedula':
         $cedula1 = $_GET["pin"];
         $tabla = $_GET["tabla"];
         $codigo = $_GET["codigo"];
         $cedula = $_GET["cedula"];
         $sql = "SELECT `$codigo` FROM `$tabla` WHERE $cedula ='$cedula1'";
         $q = $con->query($sql);   
   
         while($r = mysqli_fetch_assoc($q)) 
         {
             $rows[] = $r;
         }
         print json_encode($rows);
         break;
}

mysqli_close($con);

?>
