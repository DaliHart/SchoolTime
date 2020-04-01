

<?php
 include "conexion.php";

 $fecha = date('Y-m-d');

 date_default_timezone_set('America/Chicago');
 $hora = date('h:i:s');






 $query="SELECT * FROM tbl_fecha_evento";
 $resultado=$conexion->query($query);

 $query2="SELECT * FROM tbl_hora_evento";
 $resultado2=$conexion->query($query2);


 while (($rowF=$resultado->fetch_assoc())&&($rowF2=$resultado2->fetch_assoc())){
     $id_fecha = $rowF['id_fecha'];
     $fecha_publicacion = $rowF['fecha_publicacion'];
     $fecha_evento = $rowF['fecha_evento'];
     $fecha_eliminacion = $rowF['fecha_eliminacion'];
     $fecha_creacion = $rowF['fecha_creacion'];
     $hora2 = $rowF2['id_horas'];

     if($resultado && $resultado2){
        echo $fecha_creacion;
        echo $hora2;
    }

 }



        





?>