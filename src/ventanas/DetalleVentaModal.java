/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import paneles.PanelDetalleVenta;
import paneles.PanelReporteVentas;

/**
 *
 * @author rsaldana
 */
public class DetalleVentaModal extends JDialog{
    
    private PanelReporteVentas panelVentas = null;
       
    public DetalleVentaModal(Frame framePadre, boolean flag, PanelReporteVentas panelVentas, Long idVenta){
        this.panelVentas = panelVentas;
        setTitle("Detalle Venta");        
        setModal(flag);
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/report.png"));
        setIconImage(icon.getImage());        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        setResizable(false);        
        setContentPane(new PanelDetalleVenta(this, idVenta));        
        pack();         
        this.setLocationRelativeTo(null); 
    }

}