/*
 * ESTE PROGRAMA FUE HECHO CON JAVA 1.7 update 51
 */
package principal;

import ventanas.Splash;
import util.PropiedadesConexionBD;
import javax.swing.JOptionPane;

/**
 *
 * @author rsaldana
 */
public class Sio {

   
    public static void main(String[] args) {
        try {
            new PropiedadesConexionBD().inicializarPropiedades();
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");                        
            new Thread(new Splash()).start();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }       
    }
}
