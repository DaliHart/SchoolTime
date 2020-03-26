<?php

include "conexion.php";

$codigo=$_REQUEST['id'];
$codigo_grupo = $_POST['codigo_grupo'];
$jornada = $_POST['jornada'];




$query="UPDATE tbl_grupo SET
codigo_g='$codigo_grupo'
WHERE codigo_g='$codigo'";
$resultado=$conexion->query($query);

$queryT="UPDATE tbl_grupo SET
id_jornada='$jornada'
WHERE codigo_g='$codigo'";
$resulta=$conexion->query($queryT);



if(!$resultado){
	echo "<script>alert('Sólo puedes modificar el código si nadie se ha asociado a este grupo');</script>";
	echo "<script>window.location='../admin/actualizar_grupo.php?id=$codigo';</script>";
}elseif ($resultado OR $resulta) {
	echo "<script>window.location='../admin/conj_grupos.php?id=$jornada';</script>";
}else{
	echo "<script>alert('Ocurrió un error');</script>";
}
?>