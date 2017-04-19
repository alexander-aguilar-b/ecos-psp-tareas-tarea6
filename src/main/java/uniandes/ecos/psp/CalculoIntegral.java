/**
 * Autor: Edgar Alexander Aguilar Bolaños
 * Fecha de Creación: 04/04/2017
 * Propósito: Clase encargada de realizar calculos integrales
 * Notas especiales:
 * @author Edgar Alexander Aguilar
 * @version 1.0
*/

package uniandes.ecos.psp;

/**
 * Clase encargada de realizar calculos integrales
 * Created by edgaguil on 4/04/2017.
 */
public class CalculoIntegral
{
    /**
     * Metodo que obtiene el valor de la integral con el valor de error maximo permitido
     * @param modeloCalculoIntegral Objeto que contiene los datos sobre los cuales se va a realizar el calculo
     * @return Objeto con la informacion de los parametros de entrada y el resultado opbtenido
     */
    public ModeloCalculoIntegral calcularValorIntegral(ModeloCalculoIntegral modeloCalculoIntegral)
    {
        double valorIntegralAnterior = 0;
        double valorIntegralActual = 0;
        double valorIntegral = 0;

        if (modeloCalculoIntegral != null)
        {

            int iteracion = 1;

            boolean errorAceptable = false;

            do
            {
                valorIntegral = calcularValorIntegralIndividual(modeloCalculoIntegral);
                valorIntegralAnterior = valorIntegralActual;
                valorIntegralActual = valorIntegral;

                modeloCalculoIntegral.setNumeroSegmentos(2*modeloCalculoIntegral.getNumeroSegmentos());

                if (iteracion > 1)
                {
                    if (valorIntegralAnterior - valorIntegralActual <= modeloCalculoIntegral.getValorErrorAceptable())
                    {
                        modeloCalculoIntegral.setResultadoCalculo(valorIntegralActual);
                        errorAceptable = true;
                    }
                }

                iteracion += 1;

            } while(errorAceptable == false);

        }

        return modeloCalculoIntegral;
    }

    /**
     * Realiza el calculo de la funcion F(x) para el valor y grados de libertad indicados
     * @param gradosLibertad Valor del numero de grados de libertad para realizar el calculo
     * @param valorX Valor de X hasta el cual se van a realizar los calculos
     * @return Valor de la funcion F(x) para el valor y grados de libertad indicados
     */
    public  double calcularFx(int gradosLibertad, double valorX)
    {
        double valorFx = 0;

        if (gradosLibertad != 0)
        {
            double valorConstanteFx = 0;
            double numerador = calcularGamma((gradosLibertad + 1) / 2.0);
            double denominador = Math.pow(gradosLibertad * Math.PI, 0.5) * calcularGamma((gradosLibertad / 2.0));

            valorConstanteFx = numerador / denominador;

            valorFx = valorConstanteFx * Math.pow(1 + (Math.pow(valorX, 2) / gradosLibertad), -(gradosLibertad + 1) / 2.0);
        }
        return valorFx;
    }

    /**
     * Realiza el calculo integral individual a partir de los datos de entrada
     * @param modeloCalculoIntegral Modelo que contiene los datos a partir de los cuales se va a realizar el calculo de la integral
     * @return Valor de la integral calculada
     */
    public double calcularValorIntegralIndividual(ModeloCalculoIntegral modeloCalculoIntegral)
    {
        float sumatoriaTotal = 0;

        double valorIntegral = 0;

        int numeroSegmentos = modeloCalculoIntegral.getNumeroSegmentos();

        if (numeroSegmentos != 0)
        {
            int gradosLibertad = modeloCalculoIntegral.getGradosLibertad();

            double valorW = modeloCalculoIntegral.getValorX()/ numeroSegmentos;

            for (int i = 0; i <= numeroSegmentos; i = i + 1)
            {
                double valorXi = valorW * i;
                double resultadoFx = calcularFx(gradosLibertad, valorXi);


                if (i == 0 || i == numeroSegmentos)
                {
                    sumatoriaTotal += resultadoFx;
                }
                else if ((i % 2) == 0)
                {
                    if (i <= numeroSegmentos -2)
                    {
                        sumatoriaTotal += 2* resultadoFx;
                    }
                }
                else
                {
                    sumatoriaTotal += 4* resultadoFx;
                }
            }

            valorIntegral = (valorW / 3)*( sumatoriaTotal );

        }

        return valorIntegral;
    }

    /**
     * Calcula el valor de gamma para el numero especificado
     * @param valorX Numero para el cual se quiere obtener el valor del calculo de gamma
     * @return Valor de gamma para el numero especificado
     */
    public double calcularGamma(double valorX)
    {
        double valorGamma = 0;

        if (valorX == 1)
        {
            valorGamma = 1;
        }
        else if (valorX == 0.5)
        {
            valorGamma = Math.sqrt(Math.PI);
        }
        else if (valorX == (int)valorX)
        {
            float factorial = 1;

            for(int i = 1; i < valorX; i = i + 1)
            {
                factorial = factorial * i;
            }

            valorGamma = factorial;
        }
        else
        {
            valorGamma = (valorX - 1)*calcularGamma(valorX - 1);
        }

        return valorGamma;
    }

    /**
     * Metodo que realiza el calculo del valor de x para el cual se obtiene el valor esperado de la integral
     * @param modeloCalculoIntegral Objeto que contiene la informacion para realizar los calculos de la integral
     * @return Modelo que contiene la informacion de los datos de entrsada y resultados de los calculos
     */
    public ModeloCalculoIntegral calcularValorX(ModeloCalculoIntegral modeloCalculoIntegral)
    {
        double valorD = 0.5;
        double valorIntegralCalculado = 0;
        double errorAceptable = modeloCalculoIntegral.getValorErrorAceptable();
        double valorIntegralEsperado = modeloCalculoIntegral.getValorEsperado();

        boolean errorActualMayorCero;
        boolean errorAnteriorMayorCero;

        boolean calculoDentroErroAceptable = false;

        modeloCalculoIntegral.setValorX(1.0);

        valorIntegralCalculado = calcularValorIntegralIndividual(modeloCalculoIntegral);

        if ((valorIntegralCalculado <= (valorIntegralEsperado + errorAceptable)) && (valorIntegralCalculado >= (valorIntegralEsperado - errorAceptable)))
        {
            return modeloCalculoIntegral;
        }

        if (valorIntegralCalculado < (valorIntegralEsperado - errorAceptable))
        {
            modeloCalculoIntegral.setValorX(modeloCalculoIntegral.getValorX() + valorD);
        }
        if (valorIntegralCalculado > (valorIntegralEsperado + errorAceptable))
        {
            modeloCalculoIntegral.setValorX(modeloCalculoIntegral.getValorX() - valorD);
        }

        errorActualMayorCero =  valorIntegralCalculado > valorIntegralEsperado;

        do
        {
            valorIntegralCalculado = calcularValorIntegralIndividual(modeloCalculoIntegral);
            errorAnteriorMayorCero = errorActualMayorCero;
            errorActualMayorCero = valorIntegralCalculado > valorIntegralEsperado;

            if (errorAnteriorMayorCero != errorActualMayorCero)
            {
                valorD = valorD / 2;
            }

            if (valorIntegralCalculado < (valorIntegralEsperado - errorAceptable))
            {
                modeloCalculoIntegral.setValorX(modeloCalculoIntegral.getValorX() + valorD);
            }

            if (valorIntegralCalculado > (valorIntegralEsperado + errorAceptable))
            {
                modeloCalculoIntegral.setValorX(modeloCalculoIntegral.getValorX() - valorD);
            }

            calculoDentroErroAceptable = (valorIntegralCalculado <= (valorIntegralEsperado + errorAceptable)) && (valorIntegralCalculado >= (valorIntegralEsperado - errorAceptable));
        }
        while(calculoDentroErroAceptable == false);

        return modeloCalculoIntegral;
    }
}
