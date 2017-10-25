/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ResourceBundle;

/**
 *
 * @author rsaldana
 */
public class PropiedadesConexionBD {
    
    public static String DRIVER_BD = null;
    public static String CADENA_BD = null;
    public static String USER_BD = null;
    public static String PASSWORD_BD = null;
       
    
    public PropiedadesConexionBD(){       
    }
    
    public void inicializarPropiedades(){
        try {
            ResourceBundle rb = ResourceBundle.getBundle("properties/conexion"); 
           
            DRIVER_BD = rb.getString("conexion.driver");
            CADENA_BD = rb.getString("conexion.cadena");
            USER_BD = rb.getString("conexion.user");
            PASSWORD_BD = rb.getString("conexion.password");      
        } catch (Exception e) {
            e.printStackTrace();            
        }
    }
}
