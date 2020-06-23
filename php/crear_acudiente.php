<?php


if (isset($_POST['crear'])) {

    include "conexion.php";

    /* Datos del formulario HTML */
    $id=$_POST['id_acu'];
    $nombre=$_POST['nombre_acu'];
    $apellido=$_POST['apellido_acu'];
    $correo=$_POST['correo_acu'];
    $contrasena=$_POST['contrasena_acu'];
    $contrasena2=$_POST['contrasena2_acu'];
    $codigo=$_POST['grupo_acu'];
    
    

    if($contrasena == $contrasena2){
        /* Si las contraseñas ingresados son iguales registrará el nuevo acudiente */
        $consulta = "INSERT INTO tbl_acudiente (id_acudiente, nombre_acu, apellido_acu, correo_acu, contrasena_acu, codigo_g) VALUES ('$id','$nombre','$apellido','$correo','$contrasena','$codigo')";
        $insertar = mysqli_query($conexion,$consulta);
    
        if ($insertar) {
            /* Si el registró se realizó lanzará la alerta y lo redirigirá a la vista grupos */
            echo "<script>alert('Registro Exitoso');</script>";
            echo "<script>window.location='../admin/grupos_desc.php?id=$codigo';</script>";
        }else{
            /* Si ocurrió un error mostrará el mensaje */
            echo "Error en la consulta";
        }

    }else{
        /* Si las contraseñas ingresadas no coinciden lanzará la alerta y lo redirigirá a la 
        vista nuevo acudiente */
        echo "<script>alert('Las contraseñas no coinciden');</script>";
        echo "<script>window.location='../admin/nuevo_acudiente.php';</script>";
    }


}   



?>