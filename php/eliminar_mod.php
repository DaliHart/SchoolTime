<?php

include "conexion.php";

$id=$_REQUEST['id'];


$query="DELETE FROM tbl_moderador WHERE id_moderador='$id'";
$resultado=$conexion->query($query);
if ($resultado) {
		header("location:../admin/moderadores.php");
}else{
	echo "<script>alert('Sólo puedes eliminar este moderador si no ha creado eventos o eliminar primero los que creó.');</script>";
	echo "<script>window.location='../admin/moderadores.php';</script>";
}

?>