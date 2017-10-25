/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rsaldana
 */
public class FechaUtil {
    
    
    public static Date formatearFechaHora(Date fechaEntrada) throws Exception{
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String fechaString = fechaEntrada.toString(); 
        Date miFecha = formato.parse(fechaString); 
        return miFecha;
    }
    
    public static String formatearFechaHoraString(Date fechaEntrada) throws Exception{
        return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(fechaEntrada);        
    }
    
}
