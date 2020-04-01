<?php

include "conexion.php";

$id=$_REQUEST['id'];
$nombre = $_POST['nombre_acu'];
$apellido = $_POST['apellido_acu'];
$correo = $_POST['correo_acu'];
$grupo = $_POST['grupo_acu'];

$query="UPDATE tbl_acudiente SET
nombre_acu='$nombre',
apellido_acu='$apellido',
correo_acu='$correo',
codigo_g='$grupo'
WHERE id_acudiente='$id'";
$resultado=$conexion->query($query);


if ($resultado) {
	echo "<script>window.location='../admin/grupos_desc.php?id=$grupo';</script>";
}else{
	echo "Error";
}
?>