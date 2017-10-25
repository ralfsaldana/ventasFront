/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import ventanas.MantenimientoClientesForm;
import ventanas.MantenimientoProductosForm;
import ventanas.ReporteVentasForm;
import ventanas.VentasForm;

/**
 *
 * @author rsaldana
 */
public class ToolBar extends JToolBar implements ActionListener{
    
    private PrincipalFrame principal;
    private DesktopConFondo desktop;
    private JButton btnProductos, btnVentas, btnClientes, btnReporteVentas;
    
    public ToolBar(DesktopConFondo desktop, PrincipalFrame principal){      
        super("Herramientas");
        this.desktop = desktop;
        this.principal = principal;
        setFloatable(false); 
        setBorder(BorderFactory.createEtchedBorder()); 
        setOrientation(JToolBar.HORIZONTAL);
        setVisible(true);       
        buildBotones();
    }

    private void buildBotones() {
        ImageIcon imagenProductos = new ImageIcon(this.getClass().getClassLoader().getResource("images/grid-24.png"));
        ImageIcon imagenVentas = new ImageIcon(this.getClass().getClassLoader().getResource("images/money.png"));
        ImageIcon imagenClientes = new ImageIcon(this.getClass().getClassLoader().getResource("images/clientes.png"));
        ImageIcon imagenReporteVentas = new ImageIcon(this.getClass().getClassLoader().getResource("images/report.png"));
        
        btnVentas = new JButton(imagenVentas);
        btnVentas.setToolTipText("Ventas");
        btnVentas.setFocusPainted(false);
        btnVentas.addActionListener(this);
        
        btnProductos = new JButton(imagenProductos);
        btnProductos.setToolTipText("Mantenimiento Productos");
        btnProductos.setFocusPainted(false);
        btnProductos.addActionListener(this);
        
        btnClientes = new JButton(imagenClientes);
        btnClientes.setToolTipText("Mantenimiento Clientes");
        btnClientes.setFocusPainted(false);
        btnClientes.addActionListener(this);
        
        btnReporteVentas = new JButton(imagenReporteVentas);
        btnReporteVentas.setToolTipText("Reporte Ventas");
        btnReporteVentas.setFocusPainted(false);        
        btnReporteVentas.addActionListener(this);
                
        add(btnVentas);               
        add(btnProductos);   
        add(btnClientes); 
        addSeparator();
        add(btnReporteVentas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnProductos){           
           desktop.add(new MantenimientoProductosForm(principal));   
        }
        if(e.getSource() == btnVentas){           
           desktop.add(new VentasForm(principal));   
        }
        if(e.getSource() == btnClientes){           
           desktop.add(new MantenimientoClientesForm(principal));   
        }
        if(e.getSource() == btnReporteVentas){           
           desktop.add(new ReporteVentasForm(principal));   
        }
        desktop.getAllFrames()[desktop.getAllFrames().length-1].moveToFront();
    }
    
    
}
