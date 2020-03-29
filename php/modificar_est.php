<?php

include "conexion.php";

$id=$_REQUEST['id'];
$nombre = $_POST['nombre_e'];
$apellido = $_POST['apellido_e'];
$matricula = $_POST['matricula_e'];
$correo = $_POST['correo_e'];
$grupo = $_POST['grupo_e'];

$query="UPDATE tbl_estudiante SET
nombre_e='$nombre',
apellido_e='$apellido',
matricula_e='$matricula',
correo_e='$correo',
codigo_g='$grupo'
WHERE id_estudiante='$id'";
$resultado=$conexion->query($query);


if ($resultado) {
	echo "<script>window.location='../admin/grupos_desc.php?id=$grupo';</script>";
}else{
	echo "Error";
}
?>
