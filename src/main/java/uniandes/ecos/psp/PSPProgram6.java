/**
 * Autor: Edgar Alexander Aguilar Bolaños
 * Fecha de Creación: 04/04/2017
 * Propósito: Clase principal del programa PSP5 (Calculo de la integral)
 * Notas especiales:
 * @author  Edgar Alexander Aguilar Bolaños
 * @version 1.0
*/
package uniandes.ecos.psp;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/** Clase principal del programa PSP5 (Calculo de la integral)
 * Created by edgaguil on 4/04/2017.
 */
public class PSPProgram6
{
    /**
     * Metodo de inicio del programa
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Integer puerto = System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 4567;
        port(puerto);
        get("/psp5/test1", (req, res) -> calcularValorIntegral(TestPSP5.Test1), new FreeMarkerEngine());
        get("/psp5/test2", (req, res) -> calcularValorIntegral(TestPSP5.Test2), new FreeMarkerEngine());
        get("/psp5/test3", (req, res) -> calcularValorIntegral(TestPSP5.Test3), new FreeMarkerEngine());
        get("/psp6", (req, res) -> calcularValoresX(), new FreeMarkerEngine());
    }

    private static ModelAndView calcularValoresX()
    {
        Map<String, Object> atributosSalida = new HashMap<>();

        try
        {
            ControladorCalculo controladorEstadistica = new ControladorCalculo();
            ModeloCalculoIntegral modeloCalculoIntegralTest1 = new ModeloCalculoIntegral(6, 0.2);
            ModeloCalculoIntegral modeloCalculoIntegralTest2 = new ModeloCalculoIntegral(15, 0.45);
            ModeloCalculoIntegral modeloCalculoIntegralTest3 = new ModeloCalculoIntegral(4, 0.495);

            modeloCalculoIntegralTest1 = controladorEstadistica.calcularValorX(modeloCalculoIntegralTest1);
            modeloCalculoIntegralTest2 = controladorEstadistica.calcularValorX(modeloCalculoIntegralTest2);
            modeloCalculoIntegralTest3 = controladorEstadistica.calcularValorX(modeloCalculoIntegralTest3);

            atributosSalida.put("valorPTest1", String.format("%1$,.3f", modeloCalculoIntegralTest1.getValorEsperado()));
            atributosSalida.put("valorDOFTest1", modeloCalculoIntegralTest1.getGradosLibertad());
            atributosSalida.put("valorXEsperadoTest1", String.format("%1$,.5f", 0.55338));
            atributosSalida.put("valorXCalculadoTest1", String.format("%1$,.10f", modeloCalculoIntegralTest1.getValorX()));

            atributosSalida.put("valorPTest2", String.format("%1$,.3f", modeloCalculoIntegralTest2.getValorEsperado()));
            atributosSalida.put("valorDOFTest2", modeloCalculoIntegralTest2.getGradosLibertad());
            atributosSalida.put("valorXEsperadoTest2", String.format("%1$,.5f", 1.75305));
            atributosSalida.put("valorXCalculadoTest2", String.format("%1$,.10f", modeloCalculoIntegralTest2.getValorX()));

            atributosSalida.put("valorPTest3", String.format("%1$,.3f", modeloCalculoIntegralTest3.getValorEsperado()));
            atributosSalida.put("valorDOFTest3", modeloCalculoIntegralTest3.getGradosLibertad());
            atributosSalida.put("valorXEsperadoTest3", String.format("%1$,.5f", 4.60409));
            atributosSalida.put("valorXCalculadoTest3", String.format("%1$,.10f", modeloCalculoIntegralTest3.getValorX()));
        }
        catch (Exception e)
        {
            atributosSalida.put("message", "Se presento un error intente mas tarde." + e);
            return new ModelAndView(atributosSalida, "error.ftl");
        }

        return new ModelAndView(atributosSalida, "psp6.ftl");
    }

    /**
     * Metodo encargado de mostrar los resultados de los calculos
     * @param testPSP5 Test que se va a solicitar y desplegar los resultados
     * @return Vista que contiene los resultados de los calculos para el test solicitado
     */
    private static ModelAndView calcularValorIntegral(TestPSP5 testPSP5)
    {
        Map<String, Object> atributosSalida = new HashMap<>();

        try
        {
            ControladorCalculo controladorEstadistica = new ControladorCalculo();
            ModeloCalculoIntegral modeloCalculoIntegral = controladorEstadistica.calcularValorIntegral(testPSP5);

            if (modeloCalculoIntegral != null)
            {
                String formatoValorX = "0 a x = %1$,.4f";
                atributosSalida.put("numeroTest", testPSP5.toString());
                atributosSalida.put("valorX", String.format(formatoValorX, modeloCalculoIntegral.getValorX()));
                atributosSalida.put("gradosLibertad", modeloCalculoIntegral.getGradosLibertad());
                atributosSalida.put("valorEsperado", String.format("%1$,.5f", modeloCalculoIntegral.getValorEsperado()));
                atributosSalida.put("valorActual", String.format("%1$,.10f", modeloCalculoIntegral.getResultadoCalculo()));
            }

        }
        catch (Exception e)
        {
            atributosSalida.put("message", "Se presento un error intente mas tarde." + e);
            return new ModelAndView(atributosSalida, "error.ftl");
        }

        return new ModelAndView(atributosSalida, "psp5.ftl");
    }
}
