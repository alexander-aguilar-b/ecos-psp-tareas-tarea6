/**
 * Autor: Edgar Alexander Aguilar Bolaños
 * Fecha de Creación: 04/04/2017
 * Propósito: Clase contenedora de los datos sobre los que se realiza el calculo de la integral
 * Notas especiales:
 * @author  Edgar Alexander Aguilar Bolaños
 * @version 1.0
*/
package uniandes.ecos.psp;

/**
 * Clase contenedora de los datos sobre los que se realiza el calculo de la integral
 * Created by edgaguil on 4/04/2017.
 */
public class ModeloCalculoIntegral
{
    //Variable que almacena el numero de grados de libertad
    private int gradosLibertad;

    //Variable que almacena el valor de X hasta el cual que van a realizar los calculos
    private double valorX;

    // Variable que almacena el numero de segmentos que se van  a emplear para calcular el valor de la integral
    private int numeroSegmentos;

    //Variable que almacena el Error aceptable para el calculo
    private double valorErrorAceptable;

    //Variable que almacena el Resultado del calculo de la integral
    private double resultadoCalculo;

    //Variable que almacena el valor esperado para el calculo de la integral
    private double valorEsperado;

    /**
     * Constructor de la clase
     * @param valorX Valor de X hasta el cual que van a realizar los calculos
     * @param gradosLibertad Numero de grados de libertad
     * @param numeroSegmentos Numero de segmentos que se van  a emplear para calcular el valor de la integral
     * @param valorErrorAceptable Error aceptable para el calculo
     * @param valorEsperado Valor esperado para el calculo de la integral
     */
    public ModeloCalculoIntegral(double valorX, int gradosLibertad, int numeroSegmentos, double valorErrorAceptable, double valorEsperado)
    {
        this.gradosLibertad = gradosLibertad;
        this.valorX = valorX;
        this.numeroSegmentos = numeroSegmentos;
        this.valorErrorAceptable = valorErrorAceptable;
        this.valorEsperado = valorEsperado;
    }

    /**
     * Constructor por defecto
     */
    public ModeloCalculoIntegral()
    {
    }

    /**
     * Constructor de la calse
     * @param gradosLibertad Numero de grados de libertad
     * @param valorEsperado Valor esperado para el calculo de la integral
     */
    public ModeloCalculoIntegral(int gradosLibertad, double valorEsperado)
    {
        this.gradosLibertad = gradosLibertad;
        this.valorEsperado = valorEsperado;
    }

    /**
     * @return Devuelve el numero de grados de libertad
     */
    public int getGradosLibertad()
    {
        return gradosLibertad;
    }

    /**
     * @return Devuelve el numero de segmentos
     */
    public int getNumeroSegmentos()
    {
        return numeroSegmentos;
    }

    /**
     * Asigna el valor del numeros de segmentos
     * @param numeroSegmentos Numero de segmentos
     */
    public void setNumeroSegmentos(int numeroSegmentos)
    {
        this.numeroSegmentos = numeroSegmentos;
    }

    /**
     * @return Valor de X hasta el cual se realizan los calculos
     */
    public double getValorX()
    {
        return valorX;
    }

    /**
     * @return Error aceptable para el calculo de la integral
     */
    public double getValorErrorAceptable()
    {
        return valorErrorAceptable;
    }

    /**
     * @return Valor esperado para el calculo
     */
    public double getValorEsperado()
    {
        return valorEsperado;
    }

    /**
     * @return Valor de la integral calculado
     */
    public double getResultadoCalculo()
    {
        return resultadoCalculo;
    }

    /**
     * @param resultadoCalculo Asigna el resultado del calculo de la integral
     */
    public void setResultadoCalculo(double resultadoCalculo)
    {
        this.resultadoCalculo = resultadoCalculo;
    }

    /**
     * Asigna el valor de X hasta el cual se realiza el calculo de la integral
      * @param valorX
     */
    public void setValorX(double valorX)
    {
        this.valorX = valorX;
    }

    /**
     * Establece el valor de error aceptable
     * @param valorErrorAceptable
     */
    public void setValorErrorAceptable(double valorErrorAceptable)
    {
        this.valorErrorAceptable = valorErrorAceptable;
    }
}
