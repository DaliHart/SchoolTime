<?php

include "conexion.php";

/* Datos del formulario HTML */
$codigo=$_REQUEST['id'];
$codigo_grupo = $_POST['codigo_grupo'];
$jornada = $_POST['jornada'];



/* Actualizar Grupo */
$query="UPDATE tbl_grupo SET
codigo_g='$codigo_grupo'
WHERE codigo_g='$codigo'";
$resultado=$conexion->query($query);

$queryT="UPDATE tbl_grupo SET
id_jornada='$jornada'
WHERE codigo_g='$codigo'";
$resulta=$conexion->query($queryT);



if(!$resultado){
	/* Si ocurre un error en la consulta saldrá el mensaje */
	echo "<script>alert('Sólo puedes modificar el código si nadie se ha asociado a este grupo');</script>";
	echo "<script>window.location='../admin/actualizar_grupo.php?id=$codigo';</script>";
}elseif ($resultado OR $resulta) {
	/* Si alguna de las dos consulta se realizó lo enviará a conjunto de grupo */
	echo "<script>window.location='../admin/conj_grupos.php?id=$jornada';</script>";
}else{
	/* Si ocurre un error en las consultas saldrá el mensaje */
	echo "<script>alert('Ocurrió un error');</script>";
}
?>