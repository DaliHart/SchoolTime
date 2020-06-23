<?php


if (isset($_POST['crear'])) {

    include "conexion.php";

    /* Datos del formulario HTML */
    $id=$_POST['id_e'];
    $nombre=$_POST['nombre_e'];
    $apellido=$_POST['apellido_e'];
    $matricula=$_POST['matricula_e'];
    $correo=$_POST['correo_e'];
    $contrasena=$_POST['contrasena_e'];
    $contrasena2=$_POST['contrasena2_e'];
    $codigo=$_POST['grupo_e'];
    
    

    if($contrasena == $contrasena2){
        /* Si las contraseñas ingresadas coninciden insertará el nuevo estudiante */
        $consulta = "INSERT INTO tbl_estudiante (id_estudiante, nombre_e, apellido_e, matricula_e, correo_e, contrasena_e, codigo_g) VALUES ('$id','$nombre','$apellido','$matricula','$correo','$contrasena','$codigo')";
        $insertar = mysqli_query($conexion,$consulta);
    
        if ($insertar) {
            /* Si el registró se realizó lanzará una alerta y lo enviará a la vista grupos descripción */
            echo "<script>alert('Registro Exitoso');</script>";
            echo "<script>window.location='../admin/grupos_desc.php?id=$codigo';</script>";
        }else{
            /* Si ocurre un error y no se inserta mostrará el mensaje */
            echo "Error en la consulta";
        }

    }else{
        /* Si las contraseñas no coinciden lanzará una alerta y lo enviará a la vista nuevo estudiante */
        echo "<script>alert('Las contraseñas no coinciden');</script>";
        echo "<script>window.location='../admin/nuevo_estudiante.php';</script>";
    }


}   



?>