<?php
session_start();

if (isset($_POST['ingresar'])) {

	require("conexion.php");

	$usuario=$_POST['usuario'];
	$pass=$_POST['contrasena'];
	$_SESSION['usuario']=$usuario;
	$rol="";

     $query = mysqli_query($conexion,"SELECT * FROM tbl_administrador WHERE usuario_adm = '$usuario' AND contrasena_adm = '$pass'");
	 $queryA = "SELECT * FROM tbl_administrador WHERE usuario_adm = '$usuario' AND contrasena_adm = '$pass'";
	 $resultado=$conexion->query($queryA);
	 $rowA=$resultado->fetch_assoc();

	 $queryM = mysqli_query($conexion,"SELECT * FROM tbl_moderador WHERE usuario_mod = '$usuario' AND contrasena_mod = '$pass'");
	 $queryMod = "SELECT * FROM tbl_moderador WHERE usuario_mod = '$usuario' AND contrasena_mod = '$pass'";
	 $resultadoM=$conexion->query($queryMod);
	 $rowM=$resultadoM->fetch_assoc();


	 if($consulta = mysqli_num_rows($query)>0 ){
		 echo "<script>window.location='../admin/eventos.php'</script>";
		/* echo "<script>window.location='../admin/eventos.php'</script>"; */

     }elseif($consulta = mysqli_num_rows($queryM)>0 ){
		 echo "<script>window.location='../admin/eventos.php'</script>";

     }else{
	 	echo "<script>alert('Usuario o contraseña incorrectos')</script>";
		echo "<script>window.location='../login.php'</script>";
	 }
	
}

 ?>
