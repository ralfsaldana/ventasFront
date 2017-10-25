/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import principal.PrincipalFrame;

/**
 *
 * @author rsaldana
 */
public class Splash extends JFrame implements Runnable{
    
    Thread t;
    
    public Splash(){        
        super();        
        setLayout(new BorderLayout());
        setSize(410,165);
        setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/Captura.PNG"));
        JLabel label = new JLabel(icon);
        add(label, BorderLayout.CENTER);        
        setUndecorated(true);          
    }

    @Override
    public void run() {
        try {
            setLocationRelativeTo(null);
            setVisible(true);
            t.sleep(3000);
            this.dispose();
            new PrincipalFrame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
