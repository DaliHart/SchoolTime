<?php

session_start();
include "conexion.php";

	$contrasena=$_POST['contrasena'];
	$nueva_contra=$_POST['n_contrasena'];
	$nueva_contra2=$_POST['confir_n_contrasena'];
	
	$usuarioa=$_SESSION['usuario'];
    $usuariom=$_SESSION['usuario'];
    


     $query = mysqli_query($conexion,"SELECT * FROM tbl_administrador WHERE usuario_adm= '$usuarioa'");
     $queryM = mysqli_query($conexion,"SELECT * FROM tbl_moderador WHERE usuario_mod = '$usuariom'");

	 if($consulta = mysqli_num_rows($query)>0 ){


        if($nueva_contra == $nueva_contra2){

            $queryAdm="SELECT * FROM tbl_administrador WHERE usuario_adm = '$usuarioa'";
            $resultado=$conexion->query($queryAdm);
            $rowAdm=$resultado->fetch_assoc();
            $id=$rowAdm['id_administrador'];
            $antigua_contra=$rowAdm['contrasena_adm'];

            if($antigua_contra==$contrasena){

                $query="UPDATE tbl_administrador SET
                contrasena_adm='$nueva_contra'
                WHERE id_administrador='$id'";
                $resultado=$conexion->query($query);
        
                if($resultado){
                    echo "<script>alert('La contraseña se cambió');</script>";
                    echo "<script>window.location='../admin/perfil.php'</script>";
                }else{
                    echo "<script>alert('Ocurrió un error al cambiar la contraseña');</script>";
                    echo "<script>window.location='../admin/contrasena.php'</script>";

                }

            }else{
                echo "<script>alert('La contraseña ingresada no coincide con la actual');</script>";
                echo "<script>window.location='../admin/contrasena.php'</script>";
            }
    

        }else{
            echo "<script>alert('Las contraseñas no coinciden');</script>";
            echo "<script>window.location='../admin/contrasena.php'</script>";
    
        }



		 

     }elseif($consulta = mysqli_num_rows($queryM)>0 ){

        if($nueva_contra == $nueva_contra2){

            $queryMod="SELECT * FROM tbl_moderador WHERE usuario_mod = '$usuariom'";
            $resultado=$conexion->query($queryMod);
            $rowMod=$resultado->fetch_assoc();
            $id=$rowMod['id_moderador'];
            $antigua_contra=$rowMod['contrasena_mod'];

            if($antigua_contra==$contrasena){

                $query="UPDATE tbl_moderador SET
                contrasena_mod='$nueva_contra'
                WHERE id_moderador='$id'";
                $resultado=$conexion->query($query);
        
                if($resultado){
                    echo "<script>alert('La contraseña se cambió');</script>";
                    echo "<script>window.location='../moderador/perfil_mod.php'</script>";
                }else{
                    echo "<script>alert('Ocurrió un error al cambiar la contraseña');</script>";
                }

            }else{
                echo "<script>alert('La contraseña ingresada no coincide con la actual');</script>";
            }
    


        }else{
            echo "<script>alert('Las contraseñas no coinciden');</script>";
            echo "<script>window.location='../moderador/contrasena_mod.php'</script>";
        }


     }else{
	 	echo "<script>alert('Ocurrió un error')</script>";
		echo "<script>window.location='../login.php'</script>";
     }
     


?>