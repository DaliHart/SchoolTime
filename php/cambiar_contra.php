<?php

session_start();
include "conexion.php";

    /* Adiquirir los datos desde el formulario HTML */
	$contrasena=$_POST['contrasena'];
	$nueva_contra=$_POST['n_contrasena'];
	$nueva_contra2=$_POST['confir_n_contrasena'];
	
	$usuarioa=$_SESSION['usuario'];
    $usuariom=$_SESSION['usuario'];
    

    /* Consulta para comprobar si el usuario es administrador o moderador */
     $query = mysqli_query($conexion,"SELECT * FROM tbl_administrador WHERE usuario_adm= '$usuarioa'");
     $queryM = mysqli_query($conexion,"SELECT * FROM tbl_moderador WHERE usuario_mod = '$usuariom'");

    /* Si el usuario es administrador hará lo siguiente */
	 if($consulta = mysqli_num_rows($query)>0 ){

        /* Si la contraseña y su confirmación son igual continuará */
        if($nueva_contra == $nueva_contra2){

            /* Consultar de los datos del administrador la contraseña actual */
            $queryAdm="SELECT * FROM tbl_administrador WHERE usuario_adm = '$usuarioa'";
            $resultado=$conexion->query($queryAdm);
            $rowAdm=$resultado->fetch_assoc();
            $id=$rowAdm['id_administrador'];
            $antigua_contra=$rowAdm['contrasena_adm'];

            /* Si la contraseña actual es igual a la ingresada continuará */
            if($antigua_contra==$contrasena){

                /* Cambio de la contraseña en el perfil administrador */
                $query="UPDATE tbl_administrador SET
                contrasena_adm='$nueva_contra'
                WHERE id_administrador='$id'";
                $resultado=$conexion->query($query);
        
                if($resultado){
                    /* Si el cambio se realizó lo redirigirá a la vista perfil del administrador */
                    echo "<script>alert('La contraseña se cambió');</script>";
                    echo "<script>window.location='../admin/perfil.php'</script>";
                }else{
                    /* Si el cambio no pudo realizarse mostrará una alerta y lo redirigirá a la vista contraseña */
                    echo "<script>alert('Ocurrió un error al cambiar la contraseña');</script>";
                    echo "<script>window.location='../admin/contrasena.php'</script>";

                }

            }else{
                /* Si la contraseña ingresada no conicide con la de la db mostrará una alerta
                y lo redirigirá a la vista contraseña */
                echo "<script>alert('La contraseña ingresada no coincide con la actual');</script>";
                echo "<script>window.location='../admin/contrasena.php'</script>";
            }
    

        }else{
            /* Si la contraseña nueva y su confirmación no coinciden lo devolverá a la
            vista contraseña */
            echo "<script>alert('Las contraseñas no coinciden');</script>";
            echo "<script>window.location='../admin/contrasena.php'</script>";
    
        }



		 
        /* Si el usuario es moderador realizará los mismos pasos,
        en este caso actualizando los datos en la tabla moderador */
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