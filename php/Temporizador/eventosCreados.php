

<?php
 include "../conexion.php";

 date_default_timezone_set('America/Chicago');
 $fecha = date('Y-m-d');
 echo $fecha;
 
 $hora = date('h:i:s');


 $query="SELECT * FROM tbl_fecha_evento ORDER BY fecha_creacion";
 $resultado=$conexion->query($query);



 while ($rowF=$resultado->fetch_assoc()){

    //Datos de la table fecha
    $id_fecha = $rowF['id_fecha'];
    $fecha_eliminacion = $rowF['fecha_eliminacion'];
    

     if($resultado ){
        
        if($fecha == $fecha_eliminacion){
            echo "Hola!!";
           


            $queryE="UPDATE tbl_evento SET
            estado_e='CUMPLIDO'
            WHERE id_fecha='$id_fecha'";
            $resultadoE=$conexion->query($queryE);

            if($resultadoE){
                echo "May be it's all right";
            }else{
                echo "No se pudo actualizar";
            }
        }
    }else{
        echo "Ocurrió un error";
    }
 }


 
        





?>