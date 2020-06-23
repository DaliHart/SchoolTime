<?php

class PruebaTest extends \PHPUnit_Framework_TestCase {

    public function test_probar_que_los_dos_mas_dos_es_cuatro() {
        $res = 2 + 2;
        $this->assertEquals(4,$res);
    }

}