/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import paneles.PanelProductos;
import principal.PrincipalFrame;

/**
 *
 * @author rsaldana
 */
public class MantenimientoProductosForm extends JInternalFrame{
    
    private PrincipalFrame principalFrame;
    
    public MantenimientoProductosForm(PrincipalFrame padre){
        super("Registro de Productos", true, true, false, true);
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/grid-24.png"));
        setFrameIcon(icon);
        this.principalFrame = padre;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);        
        setContentPane(new PanelProductos(this));
        pack();    
    }
    
    
    public PrincipalFrame getPrincipalFrame() {
        return principalFrame;
    }
    
}
