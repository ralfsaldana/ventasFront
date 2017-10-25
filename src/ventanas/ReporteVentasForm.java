/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import paneles.PanelReporteVentas;
import principal.PrincipalFrame;

/**
 *
 * @author rsaldana
 */
public class ReporteVentasForm extends JInternalFrame{
    
    private PrincipalFrame principalFrame;
    
    public ReporteVentasForm(PrincipalFrame padre){
        super("Reporte Ventas", true, true, true, true);
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/report.png"));
        setFrameIcon(icon);
        this.principalFrame = padre;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(true);        
        setContentPane(new PanelReporteVentas(this));
        pack();    
    }
    
    
    public PrincipalFrame getPrincipalFrame() {
        return principalFrame;
    }
    
    
}
