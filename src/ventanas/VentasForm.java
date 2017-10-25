/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import paneles.PanelVentas;
import principal.PrincipalFrame;

/**
 *
 * @author rsaldana
 */
public class VentasForm extends JInternalFrame{
    
    private PrincipalFrame principalFrame;
    
    public VentasForm(PrincipalFrame padre){
        super("Ventas", true, true, false, true);
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/money.png"));
        setFrameIcon(icon);
        this.principalFrame = padre;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);        
        setContentPane(new PanelVentas(this));
        pack();    
    }
    
    
    public PrincipalFrame getPrincipalFrame() {
        return principalFrame;
    }
    
}
