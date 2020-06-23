
<!-- Acerca del Archivo cron.bat
Permite automatizar tareas y ejecutar instrucciones una vez se abre.
En este caso ejecuta este archivo (eventosCreados.php)
Para que el proceso sea automático se utilizó la herramienta System Scheduler 
(El instalador es ssfree.exe) para ejecutar el archivo bat cada cierto 
tiempo y de forma oculta. -->
<?php
 include "../conexion.php";

 /* Adquirir la fecha y hora de Chicago, la cual es la
 misma en Colombia */
 date_default_timezone_set('America/Chicago');

 /* Varibale en formato de fecha y-m-d
 de acuerdo a la zona asignada en este caso Chicago */
 $fecha = date('Y-m-d');
 echo $fecha;
 
 $hora = date('h:i:s');

/* Obtener la fecha de creación del evento */
 $query="SELECT * FROM tbl_fecha_evento ORDER BY fecha_creacion";
 $resultado=$conexion->query($query);



 while ($rowF=$resultado->fetch_assoc()){

    //Datos de la tabla fecha
    $id_fecha = $rowF['id_fecha'];
    $fecha_eliminacion = $rowF['fecha_eliminacion'];
    

     if($resultado ){
        
        /* Si la fecha de eliminación es igual o menor a la
        fecha actual el estado del evento cambiará a 'CUMPLIDO' */
        if($fecha >= $fecha_eliminacion){
            
           

            /* Cambio de estado a 'CUMPLIDO' */
            $queryE="UPDATE tbl_evento SET
            estado_e='CUMPLIDO'
            WHERE id_fecha='$id_fecha'";
            $resultadoE=$conexion->query($queryE);

            if($resultadoE){
                echo "Maybe it's all right";
            }else{
                echo "No se pudo actualizar";
            }
        }
    }else{
        echo "Ocurrió un error";
    }
 }


 
        





?>