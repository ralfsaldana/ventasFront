/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author rsaldana
 */
public class NumerosUtil {
    
    public static final BigDecimal PORCENTAJE_IGV = new BigDecimal("0.19");
    
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
    
     public static BigDecimal redondearDecimales(BigDecimal valorInicial, int numeroDecimales) {
        return valorInicial.setScale(numeroDecimales, RoundingMode.HALF_UP);
    }
}
