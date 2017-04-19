/******************************************************************/
/* Autor: Edgar Alexander Aguilar Bolaños
/* Fecha de Creación: 05/04/2017
/* Propósito: Clase encargada de las pruebas de la clase de calculos itegral
/* Notas especiales:
/******************************************************************/

import org.junit.Test;
import uniandes.ecos.psp.CalculoIntegral;
import uniandes.ecos.psp.ModeloCalculoIntegral;

import static org.junit.Assert.assertEquals;

/**
 * Clase encargada de las pruebas de la clase de calculos itegral
 * Created by edgaguil on 5/04/2017.
 */
public class TestCalculoIntegral
{

    /**
     * Metodo que realiza la prueba del calculo del valor de la integral
     */
    @Test
    public void TestCalularValorIntegral1()
    {
        ModeloCalculoIntegral modeloCalculoIntegral = new ModeloCalculoIntegral(1.1, 9, 10, 0.00001,  0.3500589);
        CalculoIntegral calculoIntegral = new CalculoIntegral();
        ModeloCalculoIntegral modeloCalculoIntegralSalida =  calculoIntegral.calcularValorIntegral(modeloCalculoIntegral);
        assertEquals(modeloCalculoIntegral.getValorEsperado(), modeloCalculoIntegralSalida.getResultadoCalculo(), 0.00001);
    }

    /**
     * Metodo que realiza la prueba del calculo del valor de la integral
     */
    @Test
    public void TestCalularValorIntegral2()
    {
        ModeloCalculoIntegral modeloCalculoIntegral = new ModeloCalculoIntegral(1.1812, 10, 10, 0.00001,  0.36757);
        CalculoIntegral calculoIntegral = new CalculoIntegral();
        ModeloCalculoIntegral modeloCalculoIntegralSalida =  calculoIntegral.calcularValorIntegral(modeloCalculoIntegral);
        assertEquals(modeloCalculoIntegral.getValorEsperado(), modeloCalculoIntegralSalida.getResultadoCalculo(), 0.00001);
    }

    /**
     * Metodo que realiza la prueba del calculo del valor de la integral
     */
    @Test
    public void TestCalularValorIntegral3()
    {
        ModeloCalculoIntegral modeloCalculoIntegral = new ModeloCalculoIntegral(2.750, 30, 10, 0.00001,  0.49500);
        CalculoIntegral calculoIntegral = new CalculoIntegral();
        ModeloCalculoIntegral modeloCalculoIntegralSalida =  calculoIntegral.calcularValorIntegral(modeloCalculoIntegral);
        assertEquals(modeloCalculoIntegral.getValorEsperado(), modeloCalculoIntegralSalida.getResultadoCalculo(), 0.00001);
    }

    /**
     * Metodo que realiza la prueba del calculo del valor de la integral de forma unitaria (sin realizar iteraciones para obtener el valor mas preciso)
     */
    @Test
    public void TestCalularValorIntegralIndividual()
    {
        ModeloCalculoIntegral modeloCalculoIntegral = new ModeloCalculoIntegral(1.1, 9, 10, 0.00001,  0.3500589);
        CalculoIntegral calculoIntegral = new CalculoIntegral();
        double resultadoIntegral =  calculoIntegral.calcularValorIntegralIndividual(modeloCalculoIntegral);
        assertEquals(modeloCalculoIntegral.getValorEsperado(), resultadoIntegral, 0.00001);
    }

    /**
     * Metodo que realiza la prueba del calculo de gama para un numero real
     */
    @Test
    public void TestCalcularGammaReal()
    {
        CalculoIntegral calculoIntegral = new CalculoIntegral();
        float valorX = (float)9/2;
        double valorGamma = calculoIntegral.calcularGamma(valorX);
        assertEquals(11.63173, valorGamma, 0.0001);
    }

    /**
     * Metodo que realiza la prueba del calculo de gama para un numero entero
     */
    @Test
    public void TestCalcularGammaEntero()
    {
        CalculoIntegral calculoIntegral = new CalculoIntegral();
        double valorGamma = calculoIntegral.calcularGamma(5);
        assertEquals(24, valorGamma, 0);
    }

    /**
     * Metodo que realiza la prueba del calculo de la funcion F(x)
     */
    @Test
    public void TestCalcularFxTest1()
    {
        CalculoIntegral calculoIntegral = new CalculoIntegral();

        double intervalo = 0.11;

        assertEquals(0.38803, calculoIntegral.calcularFx(9, intervalo*0), 0.0001);
        assertEquals(0.38544, calculoIntegral.calcularFx(9, intervalo*1), 0.0001);
        assertEquals(0.37777, calculoIntegral.calcularFx(9, intervalo*2), 0.0001);
        assertEquals(0.36539, calculoIntegral.calcularFx(9, intervalo*3), 0.0001);
    }

    /**
     * Metodo que realiza la prueba del calculo de la funcion F(x)
     */
    @Test
    public void TestCalcularFxTest2()
    {
        CalculoIntegral calculoIntegral = new CalculoIntegral();

        double intervalo = 1.1812/10.0;

        assertEquals(0.389108384, calculoIntegral.calcularFx(10, intervalo*0), 0.001);
        assertEquals(0.386135943, calculoIntegral.calcularFx(10, intervalo*1), 0.001);
        assertEquals(0.377378298, calculoIntegral.calcularFx(10, intervalo*2), 0.001);
        assertEquals(0.363298168, calculoIntegral.calcularFx(10, intervalo*3), 0.001);
    }

    /**
     * Metodo que realiza la prueba del calculo de la funcion F(x)
     */
    @Test
    public void TestCalcularValorXTest1()
    {
        CalculoIntegral calculoIntegral = new CalculoIntegral();

        ModeloCalculoIntegral modeloCalculoIntegral = new ModeloCalculoIntegral(6, 0.2);

        modeloCalculoIntegral.setValorX(1.0);
        modeloCalculoIntegral.setNumeroSegmentos(20);
        modeloCalculoIntegral.setValorErrorAceptable(0.000001);

        calculoIntegral.calcularValorX(modeloCalculoIntegral);

        assertEquals(0.55338, modeloCalculoIntegral.getValorX(), 0.001);
    }

    /**
     * Metodo que realiza la prueba del calculo de la funcion F(x)
     */
    @Test
    public void TestCalcularValorXTest2()
    {
        CalculoIntegral calculoIntegral = new CalculoIntegral();

        ModeloCalculoIntegral modeloCalculoIntegral = new ModeloCalculoIntegral(15, 0.45);

        modeloCalculoIntegral.setValorX(1.0);
        modeloCalculoIntegral.setNumeroSegmentos(20);
        modeloCalculoIntegral.setValorErrorAceptable(0.000001);

        calculoIntegral.calcularValorX(modeloCalculoIntegral);

        assertEquals(1.75305, modeloCalculoIntegral.getValorX(), 0.001);
    }

    /**
     * Metodo que realiza la prueba del calculo de la funcion F(x)
     */
    @Test
    public void TestCalcularValorXTest3()
    {
        CalculoIntegral calculoIntegral = new CalculoIntegral();

        ModeloCalculoIntegral modeloCalculoIntegral = new ModeloCalculoIntegral(4, 0.495);

        modeloCalculoIntegral.setValorX(1.0);
        modeloCalculoIntegral.setNumeroSegmentos(20);
        modeloCalculoIntegral.setValorErrorAceptable(0.000001);

        calculoIntegral.calcularValorX(modeloCalculoIntegral);

        assertEquals(4.60409, modeloCalculoIntegral.getValorX(), 0.001);
    }
}
