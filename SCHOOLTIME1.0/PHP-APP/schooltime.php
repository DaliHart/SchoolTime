<?php
error_reporting(0);
//Datos del servidor, base de datos
$servername = "localhost";
$dbname = "schooltime";
$username = "root";
$password = "";

$con = mysqli_connect($servername,$username,$password, $dbname) or die(mysqli_error($con));// se realiza la conexión.
mysqli_set_charset ($con , "utf8");

$action = $_GET["act"];
   switch ($action) {
   case 'evento':
      $codigo = $_GET["codigo"];
      $sql = "SELECT `titulo`,`tipo`,`fecha`,`hora`,`descripcion` FROM `tblevento` WHERE `codigo`='$codigo'";
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
         $sql = "SELECT `$codigo` FROM `$tabla` WHERE `$cedula`='$cedula1'";
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
