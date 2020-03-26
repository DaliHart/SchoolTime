<?php


if (isset($_POST['crear'])) {

    
    $grado_g=$_POST['grado'];
    $grupo_g=$_POST['grupo'];
    $jornada=$_POST['jornada'];
    $codigo_g=$_POST['codigo_grupo'];
    $id_jornada="J1";

    if($jornada=="Manana"){
        $id_jornada="J1";
    }else{
        $id_jornada="J2";
    }

    include "conexion.php";

    $consulta = "INSERT INTO tbl_grupo (codigo_g, grado_g, grupo_g, id_jornada) VALUES ('$codigo_g','$grado_g','$grupo_g','$id_jornada')";
    $insertar = mysqli_query($conexion,$consulta);
    
    if ($insertar) {
		
        echo "<script>alert('Registro Exitoso');</script>";
		
		echo "<script>window.location='../admin/conj_grupos.php?id=$id_jornada';</script>";
		
	}else{
		echo "Error en la consulta";
	}

}

?>