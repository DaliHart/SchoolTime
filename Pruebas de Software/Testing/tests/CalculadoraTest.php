<?php

use App\Calculadora\Calculadora;

class CalculadoraTest extends \PHPUnit_Framework_TestCase {

    public function test_probar_la_funcion_suma() {
        $calculadora = new Calculadora;

        $suma = $calculadora->sumar(5,11);

        $this->assertEquals(16, $suma);
    }

}