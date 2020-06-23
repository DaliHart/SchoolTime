<?php

use App\Calculadora\Stime\Estudiante;
use App\Calculadora\Excepciones\ErrorConsultaException;
use App\Calculadora\Excepciones\ContrasenaNoCoincideException;


class EstudianteTest extends \PHPUnit_Framework_TestCase {

    public function test_probar_la_funcion_insertar_inserte_un_nuevo_estudiante() {
        $estudiante = new Estudiante;
        //Cmabiar los datos cada vez que se ejecuten las pruebas
        $resultado = $estudiante->insertarEstudiante("235246","Molly","Peters","2131455","molly@email.com","123","123","34");

        $this->assertEquals(true, $resultado);
    }

    public function test_probar_la_funcion_insertar_cuando_ocurre_un_error_en_la_consulta_al_ingresar_un_grupo_que_no_existe (){
        $this->expectException(ErrorConsultaException::class);

        $estudiante = new Estudiante;

        $resultado = $estudiante->insertarEstudiante("23524","Molly","Peters","2131455","molly@email.com","123","123","345");

        

    }

    public function test_probar_que_la_funcion_editar_edite_un_estudiante_correctamente (){
        $estudiante = new Estudiante;

        $resultado = $estudiante->editarEstudiante("23524","Abby","Leeds","21314456","molly@email.com","34");

        $this->assertEquals(true, $resultado);
    }

    public function test_probar_que_la_funcion_arroge_un_error_cuando_los_datos_no_son_validos_al_ingresar_un_grupo_que_no_existe(){
        $this->expectException(ErrorConsultaException::class);
        
        $estudiante = new Estudiante;

        $resultado = $estudiante->editarEstudiante("23524","Abby","Leeds","21314456","molly@email.com","343453");

        //$this->assertEquals(false, $resultado);
        
    }

    public function test_probar_que_la_funcion_arroge_una_excepcion_cuando_las_contrasenas_no_coincidan(){
        $this->expectException(ContrasenaNoCoincideException::class);
        
        $estudiante = new Estudiante;

        $resultado = $estudiante->insertarEstudiante("23524","Abby","Leeds","21314456","molly@email.com","123","222","343453");
  
    }

}