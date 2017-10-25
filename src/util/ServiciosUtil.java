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
public class ServiciosUtil {
    
    public static String LISTAR_CLIENTES;
    public static String INSERTAR_CLIENTE;
    public static String ACTUALIZAR_CLIENTE;
    public static String FILTRAR_CLIENTES;
    public static String ELIMINAR_CLIENTE;
    public static String OBTENER_CLIENTE_POR_ID;
    
    static{
        try {
            ResourceBundle rb = ResourceBundle.getBundle("properties/servicios");
            LISTAR_CLIENTES = rb.getString("listarClientes");            
            INSERTAR_CLIENTE = rb.getString("insertarCliente");
            ACTUALIZAR_CLIENTE = rb.getString("actualizarCliente");
            FILTRAR_CLIENTES = rb.getString("filtrarClientes");
            ELIMINAR_CLIENTE = rb.getString("eliminarCliente");
            OBTENER_CLIENTE_POR_ID = rb.getString("obtenerClientePorId");
        } catch (Exception e) {
            System.out.println("Error leyendo properties de servicios rest");
            e.printStackTrace();
        }        
    }
    
    
}
