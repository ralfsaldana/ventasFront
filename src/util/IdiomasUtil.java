/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author rsaldana
 */
public class IdiomasUtil {

    public static ResourceBundle rb;
    
    static{
        Locale locale = Locale.getDefault();
        rb = ResourceBundle.getBundle("properties/MyResources", locale);        
    }
    
    public static String getLabel(String key){
        return rb.getString(key);
    }
    
    
}

