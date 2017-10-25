/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import paneles.PanelImportarDatos;
import principal.PrincipalFrame;
import util.ExcelUtil;


/**
 *
 * @author Ralf
 */
public class ImportarDatosForm extends JInternalFrame{

    private PrincipalFrame principalFrame;
    
    public ImportarDatosForm(PrincipalFrame padre){        
        super("Importar Datos", true, true, true, true);
        this.principalFrame = padre;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setFrameIcon(new ImageIcon(this.getClass().getClassLoader().getResource("images/grid-24.png")));
        setVisible(true);
        setResizable(true);        
        setContentPane(new PanelImportarDatos(this));
        pack();
        
        new ExcelUtil().leerExcel("C:\\Users\\rsaldana\\Desktop\\libro.xlsx"); 
    } 

    /**
     * @return the principalFrame
     */
    public PrincipalFrame getPrincipalFrame() {
        return principalFrame;
    }

    

}
