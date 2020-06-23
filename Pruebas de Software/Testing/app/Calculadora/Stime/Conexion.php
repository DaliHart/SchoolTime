<?php

namespace App\Calculadora\Stime;

class Conexion {

    public function conectar(){
        $conexion = mysqli_connect("localhost", "root","", "stime") or die ("error en la conexion");
        return $conexion;
    }
}



?>