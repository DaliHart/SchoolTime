<?php

include "conexion.php";

$id=$_REQUEST['id'];
$nombre = $_POST['nombre_mod'];
$apellido = $_POST['apellido_mod'];
$cargo = $_POST['cargo_mod'];

$query="UPDATE tbl_moderador SET
nombre_mod='$nombre',
apellido_mod='$apellido',
cargo_mod='$cargo'
WHERE id_moderador='$id'";
$resultado=$conexion->query($query);


if ($resultado) {
	echo "<script>window.location='../admin/moderadores.php';</script>";
}else{
    echo "<script>alert('Ocurrió un error');</script>";
	echo "<script>window.location='../admin/moderadores.php';</script>";
}
?>
