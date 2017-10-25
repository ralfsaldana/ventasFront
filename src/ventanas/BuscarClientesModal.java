/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import dto.Cliente;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import paneles.PanelBuscarClientes;
import paneles.PanelVentas;

/**
 *
 * @author rsaldana
 */
public class BuscarClientesModal extends JDialog{
    
    private PanelVentas panelVentas = null;
       
    public BuscarClientesModal(Frame framePadre, boolean flag, PanelVentas panelVentas){
        this.panelVentas = panelVentas;
        setTitle("Buscar Cliente");        
        setModal(flag);
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/clientes.png"));
        setIconImage(icon.getImage());        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        setResizable(false);        
        setContentPane(new PanelBuscarClientes(this));        
        pack();         
        this.setLocationRelativeTo(null); 
    }
    
    public void setClienteSeleccionado(Cliente clienteSeleccionado){      
        panelVentas.pintarDatosClienteSeleccionado(clienteSeleccionado); 
    }
    
}
