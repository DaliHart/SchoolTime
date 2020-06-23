<?php

include "conexion.php";
/* Datos del formulario */
$id=$_REQUEST['id'];
$nombre = $_POST['nombre_mod'];
$apellido = $_POST['apellido_mod'];
$cargo = $_POST['cargo_mod'];

/* Actualizar Moderador */
$query="UPDATE tbl_moderador SET
nombre_mod='$nombre',
apellido_mod='$apellido',
cargo_mod='$cargo'
WHERE id_moderador='$id'";
$resultado=$conexion->query($query);


if ($resultado) {
	/* Si se actualizó lo enviará a la vista moderador */
	echo "<script>window.location='../admin/moderadores.php';</script>";
}else{
	/* Si no actualizó mostrará el mensaje y lo enviará a la vista moderadores */
    echo "<script>alert('Ocurrió un error');</script>";
	echo "<script>window.location='../admin/moderadores.php';</script>";
}
?>
