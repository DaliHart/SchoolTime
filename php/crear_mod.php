<?php


if (isset($_POST['crear'])) {

    include "conexion.php";

    $nombre=$_POST['nombre_mod'];
    $apellido=$_POST['apellido_mod'];
    $cargo=$_POST['cargo_mod'];
    $usuario=$_POST['usuario_mod'];
    $contrasena=$_POST['contrasena_mod'];
    $contrasena2=$_POST['contrasena2_mod'];
    

    if($contrasena == $contrasena2){
        
        $consulta = "INSERT INTO tbl_moderador (id_moderador, nombre_mod, apellido_mod, usuario_mod, contrasena_mod, cargo_mod) VALUES (uuid(),'$nombre','$apellido','$usuario','$contrasena','$cargo')";
        $insertar = mysqli_query($conexion,$consulta);
    
        if ($insertar) {
            echo "<script>alert('Registro Exitoso');</script>";
            echo "<script>window.location='../admin/moderadores.php';</script>";
        }else{
            echo "Error en la consulta";
        }

    }else{
        echo "<script>alert('Las contraseñas no coinciden');</script>";
        echo "<script>window.location='../admin/nuevo_moderador.php';</script>";
    }


}   



?>