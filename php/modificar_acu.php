<?php

include "conexion.php";

/* Datos del formulario HTML */
$id=$_REQUEST['id'];
$nombre = $_POST['nombre_acu'];
$apellido = $_POST['apellido_acu'];
$correo = $_POST['correo_acu'];
$grupo = $_POST['grupo_acu'];

/* Actualizar Acudiente */
$query="UPDATE tbl_acudiente SET
nombre_acu='$nombre',
apellido_acu='$apellido',
correo_acu='$correo',
codigo_g='$grupo'
WHERE id_acudiente='$id'";
$resultado=$conexion->query($query);


if ($resultado) {
	/* Si se actualizó correctamente lo enviará a la vista grupos descripción */
	echo "<script>window.location='../admin/grupos_desc.php?id=$grupo';</script>";
}else{
	/* Si ocurrió un error y no actualizó saldrá el mensaje */
	echo "Error";
}
?>