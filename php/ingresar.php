<?php 
session_start();
if (isset($_POST['ingresar'])) {

	require("conexion.php");

	/* Datos del formulario */
	$usuarioa=$_POST['usuario'];
	$passa=$_POST['contrasena'];
	$usuariom=$_POST['usuario'];
	$passm=$_POST['contrasena'];
	$_SESSION['usuario']=$usuarioa;
	$_SESSION['usuario']=$usuariom;

	/* Consulta a las tablas administrador y moderador para comprobar quién está ingresando */
     $query = mysqli_query($conexion,"SELECT * FROM tbl_administrador WHERE usuario_adm= '$usuarioa' AND contrasena_adm= '$passa'");
     $queryM = mysqli_query($conexion,"SELECT * FROM tbl_moderador WHERE usuario_mod = '$usuariom' AND contrasena_mod= '$passm'");


	 if($consulta = mysqli_num_rows($query)>0 ){
		 /* Si el usuario es administrador lo enviará a la vista de enventos del administrador */
		 echo "<script>window.location='../admin/eventos.php?id=PROGRAMADO'</script>";
		/* echo "<script>window.location='../admin/eventos.php'</script>"; */

     }elseif($consulta = mysqli_num_rows($queryM)>0 ){
		 /* Si el usuario es moderador lo enviará a la vista de eventos de moderador */
        header('location:../moderador/eventos_mod.php');

     }else{
		 /* Si el usuario o contraseña son incorrectos lo enviará al login */
	 	echo "<script>alert('Usuario o contraseña incorrectos')</script>";
		echo "<script>window.location='../login.php'</script>";
	 }
	
}

 ?>