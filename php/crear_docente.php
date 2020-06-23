<?php


if (isset($_POST['crear'])) {

    include "conexion.php";

    /* Datos del formulario */
    $id=$_POST['id_doc'];
    $nombre=$_POST['nombre_doc'];
    $apellido=$_POST['apellido_doc'];
    $correo=$_POST['correo_doc'];
    $contrasena=$_POST['contrasena_doc'];
    $contrasena2=$_POST['contrasena2_doc'];
    $codigo=$_POST['grupo_doc'];
    
    

    if($contrasena == $contrasena2){
        /* Si las contraseñas nigresadas son correctas insertará el nuevo docente */
        $consulta = "INSERT INTO tbl_docente (id_docente, nombre_doc, apellido_doc, correo_doc, contrasena_doc, codigo_g) VALUES ('$id','$nombre','$apellido','$correo','$contrasena','$codigo')";
        $insertar = mysqli_query($conexion,$consulta);
    
        if ($insertar) {
            /* Si el registro se realizó lanzará una alerta y lo enviará a la vista docentes */
            echo "<script>alert('Registro Exitoso');</script>";
            echo "<script>window.location='../admin/docentes.php';</script>";
        }else{
            /* Si ocurre un error a la hora de insertar mostrará el mensaje */
            echo "Error en la consulta";
        }

    }else{
        /* Si las contraseñas ingresadas no coinciden lo enviará a l vista nuevo docente*/
        echo "<script>alert('Las contraseñas no coinciden');</script>";
        echo "<script>window.location='../admin/nuevo_docente.php';</script>";
    }


}   



?>