<?php

include "conexion.php";

$id=$_REQUEST['id'];
$nombre = $_POST['nombre_doc'];
$apellido = $_POST['apellido_doc'];
$grupo = $_POST['grupo_doc'];

$query="UPDATE tbl_docente SET
nombre_doc='$nombre',
apellido_doc='$apellido',
codigo_g='$grupo'
WHERE id_docente='$id'";
$resultado=$conexion->query($query);


if ($resultado) {
	echo "<script>window.location='../admin/docentes.php';</script>";
}else{
	echo "Error";
}
?>
