/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author rsaldana
 */
public class PanelGenerico extends JPanel implements KeyListener{
    
    public final String MENSAJE_EXITO_GRABAR = IdiomasUtil.getLabel("mensaje.exito.grabar");
    public final String MENSAJE_EXITO_MODIFICAR = IdiomasUtil.getLabel("mensaje.exito.modificar");    
    public final String MENSAJE_EXITO_ELIMINAR_REGISTRO = IdiomasUtil.getLabel("mensaje.exito.eliminar.registro");
    
    public final String MENSAJE_VALIDAR_TODO = IdiomasUtil.getLabel("mensaje.validar.todo");
    public final String MENSAJE_VALIDAR_SELECCIONAR = IdiomasUtil.getLabel("mensaje.validar.seleccionar");
    public final String MENSAJE_VALIDAR_OBLIGATORIOS = IdiomasUtil.getLabel("mensaje.validar.obligatorios");
    public final String MENSAJE_VALIDAR_NO_HAY_DATOS = IdiomasUtil.getLabel("mensaje.validar.sin.datos");
    public final String MENSAJE_VALIDAR_STOCK = IdiomasUtil.getLabel("mensaje.validar.stock");
        
    public final String MENSAJE_GRABAR_ARCHIVO_OK = IdiomasUtil.getLabel("mensaje.grabarArchivo.ok");
        
    
    public PanelGenerico(){
        super();               
    }
    
    public void mostrarMensajeAdvertencia(String mensaje){
        MensajesUtil.mostrarMensajeAdvertencia(mensaje);
    }
    
    public void mostrarMensajeInformativo(String mensaje){
        MensajesUtil.mostrarMensajeInformativo(mensaje);
    }
    
    public void mostrarMensajeError(String mensaje){
        MensajesUtil.mostrarMensajeError(mensaje);
    }

    //Se invoca desde las subclases para escribir solo en mayuscula
    @Override
    public void keyTyped(KeyEvent e) {         
        char charecter = e.getKeyChar();
	if (Character.isLowerCase(charecter)) {
            e.setKeyChar(Character.toUpperCase(charecter));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) { 
    }
        
}
