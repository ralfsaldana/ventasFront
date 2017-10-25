/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import dto.Producto;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import paneles.PanelBuscarProductos;
import paneles.PanelVentas;

/**
 *
 * @author rsaldana
 */
public class BuscarProductosModal extends JDialog{
    
     private PanelVentas panelVentas = null;
       
    public BuscarProductosModal(Frame framePadre, boolean flag, PanelVentas panelVentas){
        this.panelVentas = panelVentas;
        setTitle("Buscar Producto");        
        setModal(flag);
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/grid-24.png"));
        setIconImage(icon.getImage());        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        setResizable(false);        
        setContentPane(new PanelBuscarProductos(this));        
        pack();         
        this.setLocationRelativeTo(null); 
    }
    
    public void setProductoSeleccionado(Producto clienteSeleccionado){      
        panelVentas.pintarDatosProductoSeleccionado(clienteSeleccionado); 
    }
    
    
}
