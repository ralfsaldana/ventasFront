/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import paneles.PanelClientes;
import principal.PrincipalFrame;

/**
 *
 * @author rsaldana
 */
public class MantenimientoClientesForm  extends JInternalFrame{
    
    private PrincipalFrame principalFrame;
    
    public MantenimientoClientesForm(PrincipalFrame padre){
        super("Registro de Clientes", true, true, false, true);
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/clientes.png"));
        setFrameIcon(icon);
        this.principalFrame = padre;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);        
        setContentPane(new PanelClientes(this));
        pack();    
    }
    
    public PrincipalFrame getPrincipalFrame() {
        return principalFrame;
    }

}