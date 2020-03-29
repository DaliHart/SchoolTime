<?php


if (isset($_POST['crear'])) {

    include "conexion.php";

    
    $id=$_POST['id_e'];
    $nombre=$_POST['nombre_e'];
    $apellido=$_POST['apellido_e'];
    $matricula=$_POST['matricula_e'];
    $correo=$_POST['correo_e'];
    $contrasena=$_POST['contrasena_e'];
    $contrasena2=$_POST['contrasena2_e'];
    $codigo=$_POST['grupo_e'];
    
    

    if($contrasena == $contrasena2){
        
        $consulta = "INSERT INTO tbl_estudiante (id_estudiante, nombre_e, apellido_e, matricula_e, correo_e, contrasena_e, codigo_g) VALUES ('$id','$nombre','$apellido','$matricula','$correo','$contrasena','$codigo')";
        $insertar = mysqli_query($conexion,$consulta);
    
        if ($insertar) {
            echo "<script>alert('Registro Exitoso');</script>";
            echo "<script>window.location='../admin/grupos_desc.php?id=$codigo';</script>";
        }else{
            echo "Error en la consulta";
        }

    }else{
        echo "<script>alert('Las contraseñas no coinciden');</script>";
        echo "<script>window.location='../admin/nuevo_estudiante.php';</script>";
    }


}   



?>