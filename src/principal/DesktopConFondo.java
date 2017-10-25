/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author rsaldana
 */
public class DesktopConFondo extends JDesktopPane implements MouseListener{

    private int x = 0;
    private int y = 0;
    private JPopupMenu popup;
    JMenuItem item1,item2,item3;

    public DesktopConFondo(){
        addMouseListener(this);
        buildPopupMenu();
        
    }

    
    
    
    //sobreescribe el metodo paint para agregar una imagen de fondo al JDesktopPane
    @Override
    public void paint(Graphics g) {
//         ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/fondo.jpg"));
//         x = (getWidth() - icon.getIconWidth())/2;
//         y = (getHeight() - icon.getIconHeight())/2;
         g.setColor(new Color(244,249,252));
         g.fillRect(0, 0, getWidth(), getHeight());
//         g.drawImage(icon.getImage(), x , y , icon.getIconWidth(), icon.getIconHeight(),this);         
         setOpaque(false);
         super.paint(g);

     }


    private void buildPopupMenu() {
        popup = new JPopupMenu("Opciones");
        item1 = new JMenuItem("Ordenar ventanas");
        item2 = new JMenuItem("Cerrar todas la ventanas");
        item3 = new JMenuItem("Minimizar todas la ventanas");
        popup.add(item1);        
        popup.add(item3);
        popup.addSeparator();
        popup.add(item2);

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                int x = 10;
                int y = 10;
                for (JInternalFrame f : getAllFrames()) {
                    try {
                        if(f.isIcon()) f.setIcon(false);
                        f.moveToFront();
                        f.setLocation(x, y);
                        f.requestFocusInWindow();
                        x += 20;
                        y += 30;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                for (JInternalFrame f : getAllFrames()) {
                    f.dispose();
                }
            }
        });

        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                for (JInternalFrame f : getAllFrames()) {
                    try {
                        f.setIcon(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });


    }

    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if((e.getModifiers() & e.BUTTON3_MASK) != 0 ){
            if(getAllFrames().length>0){
             item1.setEnabled(true);
             item2.setEnabled(true);
             item3.setEnabled(true);
            }
            else{
             item1.setEnabled(false);
             item2.setEnabled(false);
             item3.setEnabled(false);
            }
            popup.show(this, e.getX(), e.getY());
        }
    }

    

    




}
