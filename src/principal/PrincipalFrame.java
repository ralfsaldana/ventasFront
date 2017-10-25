/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;


import util.IdiomasUtil;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import util.MensajesUtil;
import ventanas.ImportarDatosForm;
import ventanas.MantenimientoClientesForm;
import ventanas.MantenimientoProductosForm;
import ventanas.ReporteVentasForm;
import ventanas.VentasForm;


/**
 *
 * @author Ralf
 */
public class PrincipalFrame extends JFrame implements ActionListener{

    DesktopConFondo desktop = new DesktopConFondo();
    JMenuItem menuItemOpciones, menuItemProductos, menuItemVentas, menuItemClientes;    
    JMenuItem menuItemReporteVentas;      
    JRadioButtonMenuItem checkDefault,checkNimbus,checkLiquid, checkMetal;
    
    public PrincipalFrame(){
        super("Sistema Integrado de Operaciones");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/logo2.PNG"));
        setIconImage(icon.getImage());                 
        add(new ToolBar(desktop, this), BorderLayout.NORTH);
        add(desktop, BorderLayout.CENTER);
        setSize(900,700);
        buildMenuBar();
        setVisible(true);
        setLocationRelativeTo(null);            
    }

    private void buildMenuBar(){
        JMenuBar barra = new JMenuBar(); 
        barra.setOpaque(true);
        JMenu menuOperaciones = buildMenuOperaciones();
        barra.add(buildMenuOperaciones());         
        barra.add(buildMenuMantenimientos());  
        barra.add(buildMenuReportes());
        barra.add(buildMenuConfiguracion());
        barra.setBackground(menuOperaciones.getBackground());
        setJMenuBar(barra);
    }
   
    
    public JMenu buildMenuMantenimientos(){
        JMenu menuMantenimientos = new JMenu("Mantenimientos");
        menuMantenimientos.setMnemonic(KeyEvent.VK_M);
        
        menuItemProductos = new JMenuItem("Productos");
        menuItemProductos.setMnemonic(KeyEvent.VK_P); 
        menuItemProductos.addActionListener(this);   
        
        menuItemClientes = new JMenuItem("Clientes");
        menuItemClientes.setMnemonic(KeyEvent.VK_C); 
        menuItemClientes.addActionListener(this);   
        
        menuMantenimientos.add(menuItemProductos);   
        menuMantenimientos.add(menuItemClientes);  
                
        return menuMantenimientos;
    }
    
    public JMenu buildMenuOperaciones(){
        JMenu menuOperaciones = new JMenu("Operaciones");
        menuOperaciones.setMnemonic(KeyEvent.VK_O);
        
        menuItemVentas = new JMenuItem("Ventas");
        menuItemVentas.setMnemonic(KeyEvent.VK_V); 
        menuItemVentas.addActionListener(this);   
        
        menuOperaciones.add(menuItemVentas);              
        return menuOperaciones;
    }
    
    public JMenu buildMenuReportes(){
        JMenu menuReportes = new JMenu("Reportes");
        menuReportes.setMnemonic(KeyEvent.VK_R);
        
        menuItemReporteVentas = new JMenuItem("Reporte Ventas");
        menuItemReporteVentas.setMnemonic(KeyEvent.VK_V); 
        menuItemReporteVentas.addActionListener(this);   
        
        menuReportes.add(menuItemReporteVentas);                
        return menuReportes;
    }
    
    public JMenu buildMenuConfiguracion(){
        JMenu menuConfiguracion = new JMenu("Configuración");
        menuConfiguracion.setMnemonic(KeyEvent.VK_C);
        
        JMenu subMenuLookAndFeel = new JMenu("Apariencia");       
        checkDefault = new JRadioButtonMenuItem("Clásico"); 
        checkNimbus = new JRadioButtonMenuItem("Nimbus");
        //checkLiquid = new JRadioButtonMenuItem("Liquid");
        checkMetal = new JRadioButtonMenuItem("Metal", true);
        ButtonGroup group = new ButtonGroup();
        group.add(checkMetal);        
        //group.add(checkLiquid);
        group.add(checkNimbus);
        group.add(checkDefault);
       
        subMenuLookAndFeel.add(checkMetal);        
        subMenuLookAndFeel.add(checkNimbus);
        //subMenuLookAndFeel.add(checkLiquid);
        subMenuLookAndFeel.add(checkDefault);
        
        checkDefault.addActionListener(this);   
        checkNimbus.addActionListener(this);   
        //checkLiquid.addActionListener(this);   
        checkMetal.addActionListener(this);   
        
        menuConfiguracion.add(subMenuLookAndFeel);               
        return menuConfiguracion;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == checkMetal) {
                UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(this);  
                update(getGraphics());
            }else if (e.getSource() == checkDefault) {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(this);  
                update(getGraphics());
            }else if(e.getSource() == checkNimbus) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this); 
                update(getGraphics());
            }else if(e.getSource() == checkLiquid) {
                //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
                //SwingUtilities.updateComponentTreeUI(this); 
                //update(getGraphics());
            }else{
                if (e.getSource() == menuItemOpciones) {
                    desktop.add(new ImportarDatosForm(this));                
                }
                if (e.getSource() == menuItemProductos) {
                    desktop.add(new MantenimientoProductosForm(this));                
                }
                if (e.getSource() == menuItemClientes) {
                    desktop.add(new MantenimientoClientesForm(this));                
                }
                if (e.getSource() == menuItemVentas) {
                    desktop.add(new VentasForm(this));                
                }
                if (e.getSource() == menuItemReporteVentas) {
                    desktop.add(new ReporteVentasForm(this));                
                }
                desktop.getAllFrames()[desktop.getAllFrames().length - 1].moveToFront();     
            }      
        } catch (Exception ex) {
            MensajesUtil.mostrarMensajeError(ex.getMessage()); 
        }
        
    }
    
}
