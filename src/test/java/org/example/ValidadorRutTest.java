package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorRutTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testRutSinPuntoSinGuion() {
        String resultadoEsperado1 = "203543840";
        assertEquals(ValidadorRut.rutSinPuntoSinGuion("20.354.384-0"),resultadoEsperado1);
    }

    @Test
    void testInvertirCadena() {
        String resultadoEsperado1 = "048345302";
        assertEquals(ValidadorRut.invertirCadena("203543840"),resultadoEsperado1);
    }

    @Test
    void testRutSinDigitoVerificador() {
        String resultadoEsperado1 = "48345302";
        assertEquals(ValidadorRut.rutSinDigitoVerificador("048345302"),resultadoEsperado1);
    }

    @Test
    void testConvertirInt() {
        int[] resultadoEsperado1 = {4,8,3,4,5,3,0,2};
        assertArrayEquals(ValidadorRut.convertirInt("48345302"), resultadoEsperado1);
    }

    @Test
    void testCrearCadena2() {
        int[] resultadoEsperado1 = {2,3,4,5,6,7,2,3};
        assertArrayEquals(ValidadorRut.crearCadena2(new int[]{4, 8, 3, 4, 5, 3, 0, 2}), resultadoEsperado1);
    }

    @Test
    void testDigitoVerificador() {
        String resultadoEsperado1 = "0";
        int[] cadena1 =  {4, 8, 3, 4, 5, 3, 0, 2};
        int[] cadena2 =  {2, 3, 4, 5, 6, 7, 2, 3};
        assertEquals(ValidadorRut.digitoVerificador(cadena1,cadena2), resultadoEsperado1);
    }
}