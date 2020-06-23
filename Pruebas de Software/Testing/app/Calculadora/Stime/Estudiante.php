<?php

namespace App\Calculadora\Stime;
use App\Calculadora\Stime\Conexion;
use App\Calculadora\Excepciones\ErrorConsultaException;
use App\Calculadora\Excepciones\ContrasenaNoCoincideException;

class Estudiante {
    
    

    public function insertarEstudiante($id, $nombre, $apellido, $matricula, $correo, $contrasena, $contrasena2, $codigo ){

        $con = new Conexion;
        $conexion =$con->conectar();
        $consulta = "INSERT INTO tbl_estudiante (id_estudiante, nombre_e, apellido_e, matricula_e, correo_e, contrasena_e, codigo_g) VALUES ('$id','$nombre','$apellido','$matricula','$correo','$contrasena','$codigo')";
        $insertar = mysqli_query($conexion,$consulta);
        
        if($contrasena == $contrasena2){
            if ($insertar) {
                echo "<script>alert('Registro Exitoso');</script>";
                echo "<script>window.location='../admin/grupos_desc.php?id=$codigo';</script>";
            }else{
                throw new ErrorConsultaException();
            }
        } else{
            throw new ContrasenaNoCoincideException();
        }


        return $insertar;

    }

    public function editarEstudiante($id, $nombre, $apellido, $matricula, $correo, $codigo){

        $con = new Conexion;
        $conexion =$con->conectar();

        $query="UPDATE tbl_estudiante SET
        nombre_e='$nombre',
        apellido_e='$apellido',
        matricula_e='$matricula',
        correo_e='$correo',
        codigo_g='$codigo'
        WHERE id_estudiante='$id'";
        $resultado=$conexion->query($query);


        if ($resultado) {
            echo "<script>window.location='../admin/grupos_desc.php?id=$codigo';</script>";
        }else{
            throw new ErrorConsultaException();
        }

        return $resultado;

    }


}