<?php


if (isset($_POST['crear'])) {

    /* Datos del formulario */
    $grado_g=$_POST['grado'];
    $grupo_g=$_POST['grupo'];
    $jornada=$_POST['jornada'];
    $codigo_g=$_POST['codigo_grupo'];
    $id_jornada="J1";

    /* Convertir la variable jornada
    al como está insertado en la db */
    if($jornada=="Manana"){
        $id_jornada="J1";
    }else{
        $id_jornada="J2";
    }

    include "conexion.php";

    /* Insertar en la tabla grupo */
    $consulta = "INSERT INTO tbl_grupo (codigo_g, grado_g, grupo_g, id_jornada) VALUES ('$codigo_g','$grado_g','$grupo_g','$id_jornada')";
    $insertar = mysqli_query($conexion,$consulta);
    
    if ($insertar) {
		/* Si el registró se realizó mostrará una alerta y lo enviará a la vista conjunto de grupo */
        echo "<script>alert('Registro Exitoso');</script>";
		
		echo "<script>window.location='../admin/conj_grupos.php?id=$id_jornada';</script>";
		
	}else{
        /* Si ocurrió un error a la hora de insertar saldrá el mensaje */
		echo "Error en la consulta";
	}

}

?>