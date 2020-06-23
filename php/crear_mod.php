<?php


if (isset($_POST['crear'])) {

    include "conexion.php";
    /* Datos del formulario */
    $nombre=$_POST['nombre_mod'];
    $apellido=$_POST['apellido_mod'];
    $cargo=$_POST['cargo_mod'];
    $usuario=$_POST['usuario_mod'];
    $contrasena=$_POST['contrasena_mod'];
    $contrasena2=$_POST['contrasena2_mod'];
    

    if($contrasena == $contrasena2){
        /* Si las contraseñas coinciden se insertará en la db */
        $consulta = "INSERT INTO tbl_moderador (id_moderador, nombre_mod, apellido_mod, usuario_mod, contrasena_mod, cargo_mod) VALUES (uuid(),'$nombre','$apellido','$usuario','$contrasena','$cargo')";
        $insertar = mysqli_query($conexion,$consulta);
    
        if ($insertar) {
            /* Si el registró se realizó laznará una alerta y lo enviará a la vista moderadores */
            echo "<script>alert('Registro Exitoso');</script>";
            echo "<script>window.location='../admin/moderadores.php';</script>";
        }else{
            /* Si ocurrió un error a la hora de insertar saldrá el mensaje */
            echo "Error en la consulta";
        }

    }else{
        /* Si las contrseñas ingresadas no coinciden lo enviará a la vista nuevo moderador */
        echo "<script>alert('Las contraseñas no coinciden');</script>";
        echo "<script>window.location='../admin/nuevo_moderador.php';</script>";
    }


}   



?>