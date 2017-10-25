/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import util.PanelGenerico;
import dto.Cliente;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import servicio.ClienteService;
import util.PlaceHolder;
import ventanas.BuscarClientesModal;

/**
 *
 * @author rsaldana
 */
public class PanelBuscarClientes extends PanelGenerico implements ListSelectionListener, KeyListener, MouseListener {

    private BuscarClientesModal padre;
    private DefaultTableModel model;
    private Cliente clienteSeleccionado;
    
    /**
     * Creates new form PanelBuscarClientes
     */
    public PanelBuscarClientes(BuscarClientesModal padre) {
        this.padre = padre;
        initComponents();
        configurarTabla();
        txtNombreRazonSocial.addKeyListener(this); 
        tabla.addMouseListener(this);
        configurarListenerMayusculas(this);
        
        PlaceHolder placeholder = new PlaceHolder("Escriba un nombre o Razón Social", txtNombreRazonSocial);
        placeholder.changeAlpha(0.75f);
        placeholder.changeStyle(Font.ITALIC);
    }
    
    //Valida que solamente se pueda escribir en mayusculas en todas las cajas de texto
    private void configurarListenerMayusculas(Component c){         
        if(c instanceof JPanel){
             Component[] lista = ((JPanel)c).getComponents();
             if(lista!=null){
                 for(int i=0; i<lista.length;i++){
                     if(lista[i] instanceof JPanel){
                         configurarListenerMayusculas(lista[i]);
                     }else{
                         if(lista[i] instanceof JTextField){
                            JTextField textField = (JTextField)lista[i];
                            textField.addKeyListener(this);
                         }
                     }
                 }
             }
         }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreRazonSocial = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de Búsqueda"));

        jLabel2.setText("Nombre o Razón Social:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreRazonSocial)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "RUC", "Doc. Identidad", "Nombre o Razón Social"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void configurarTabla(){
        model = (DefaultTableModel)tabla.getModel(); 
        model.setRowCount(0);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);                         
        tabla.getSelectionModel().addListSelectionListener(this);        
        
        for(int i=0; i< tabla.getRowCount();i++){
            DefaultTableCellRenderer df = new  DefaultTableCellRenderer();
            df.setHorizontalAlignment(SwingConstants.LEFT);                  
            tabla.getColumnModel().getColumn(0).setCellRenderer(df); 
            tabla.getColumnModel().getColumn(1).setCellRenderer(df); 
            tabla.getColumnModel().getColumn(2).setCellRenderer(df);             
            tabla.getColumnModel().getColumn(3).setCellRenderer(df);   
        }
    }
    
     private void listarClientes(ArrayList<Cliente> items) {           
            model.setRowCount(items.size());
            int fila = 0;
            for(Cliente e : items) {
                model.setValueAt(e.getIdCliente(), fila, 0);
                model.setValueAt(e.getRuc(), fila, 1);
                model.setValueAt(e.getNroDocumentoIdentidad(), fila, 2);
                model.setValueAt(e.getNombreRazonSocial(), fila, 3);                                                             
                fila ++;
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtNombreRazonSocial;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {  
        super.keyTyped(e); 
    }

    @Override
    public void keyPressed(KeyEvent e) {   
        try {
                ClienteService service = new ClienteService();           
                if(txtNombreRazonSocial.getText().isEmpty()){
                    listarClientes(service.listarClientes());
                }else{
                    listarClientes(service.filtrarClientes(txtNombreRazonSocial.getText()));
                }
            } catch (Exception xe) {
                xe.printStackTrace();
                mostrarMensajeError(xe.getMessage());
            }    
    }

    @Override
    public void keyReleased(KeyEvent e) {        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
       try {
            if(tabla.getSelectedRowCount()>0){
                Long idClienteSeleccionado = (Long) tabla.getValueAt(tabla.getSelectedRow(), 0);
                this.clienteSeleccionado = new ClienteService().obtenerClientePorId(idClienteSeleccionado);                
            }        
        } catch (Exception ex) {
            mostrarMensajeError(ex.getMessage());
        }        
    }
  

    @Override
    public void mouseClicked(MouseEvent e) { 
       if(e.getClickCount()==2){
            padre.setClienteSeleccionado(this.clienteSeleccionado);
            padre.dispose();                 
       }
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
}