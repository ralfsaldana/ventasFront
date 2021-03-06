/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import util.PanelGenerico;

import dto.Producto;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import servicio.ProductoService;
import util.PlaceHolder;
import ventanas.MantenimientoProductosForm;

/**
 *
 * @author rsaldana
 */
public class PanelProductos extends PanelGenerico implements ListSelectionListener, KeyListener{

    
    private DefaultTableModel model;
    private MantenimientoProductosForm mantenimientoProductosForm;
    private Long idProductoSeleccionado;
    private Boolean indicadorEditar = Boolean.FALSE;
    
    /**
     * Creates new form PanelProductos
     */
    public PanelProductos(MantenimientoProductosForm mantenimientoProductosForm) {
        try {            
            this.mantenimientoProductosForm = mantenimientoProductosForm;
            initComponents();
            txtBuscar.addKeyListener(this);            
            configurarTabla();        
            listarProductos(new ProductoService().listarProductos());
            configurarListenerMayusculas(this);
            
            PlaceHolder placeholder = new PlaceHolder("Pulse \"Limpiar\" antes iniciar la búsqueda", txtBuscar);
            placeholder.changeAlpha(0.75f);
            placeholder.changeStyle(Font.ITALIC);
            
        } catch (Exception e) {
           mostrarMensajeError(e.getMessage());
        }
    }

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
    
    private void configurarTabla(){
        model = (DefaultTableModel)tabla.getModel();
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
    
    private void listarProductos(ArrayList<Producto> items) {           
            model.setRowCount(items.size());
            int fila = 0;
            for(Producto e : items) {
                model.setValueAt(e.getIdProducto(), fila, 0);
                model.setValueAt(e.getCodigoProducto(), fila, 1);
                model.setValueAt(e.getDescripcionProducto(), fila, 2);                        
                model.setValueAt(e.getPrecioProducto(), fila, 3);
                model.setValueAt(e.getCantidadProducto(), fila, 4);                        
                fila ++;
            }
    }
    
    private void  limpiar(){
        try{
            idProductoSeleccionado = null;
            indicadorEditar = Boolean.FALSE;
            
            txtPrecio.setText(""); 
            txtBuscar.setText("");
            txtCodigoProducto.setText("");
            txtDescripcionProducto.setText("");
            txtCantidad.setText("");            
            btnAnadirModificar.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("images/add.png")));
            btnAnadirModificar.setText("Añadir"); 
            
        } catch (Exception e) {
           mostrarMensajeError(e.getMessage());
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

        jLabel3 = new javax.swing.JLabel();
        btnAnadirModificar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        txtDescripcionProducto = new javax.swing.JTextField();
        btnAnadirModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        jLabel3.setText("Descripción");

        btnAnadirModificar1.setText("Añadir");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Producto"));

        jLabel1.setText("Código: *");

        jLabel2.setText("Descripción: *");

        jLabel4.setText("Stock: *");

        btnAnadirModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAnadirModificar.setText("Añadir");
        btnAnadirModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clean.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel6.setText("Precio: *");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnadirModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnadirModificar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Productos"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Código", "Descripción", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.Object.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(350);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jLabel5.setText("Buscar por descripción:");

        txtBuscar.setToolTipText("Pulse \"Limpiar\" antes de escribir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        try {
            limpiar();
            listarProductos(new ProductoService().listarProductos());
            tabla.clearSelection();
        } catch (Exception e) {
            mostrarMensajeError(e.getMessage());
        }       
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAnadirModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirModificarActionPerformed
        try {
            if(txtCodigoProducto.getText().isEmpty() || txtDescripcionProducto.getText().isEmpty() || 
               txtCantidad.getText().isEmpty()){
               mostrarMensajeAdvertencia(MENSAJE_VALIDAR_TODO);
            }else{
                Producto p = new Producto();
                p.setCodigoProducto(txtCodigoProducto.getText());
                p.setDescripcionProducto(txtDescripcionProducto.getText());
                p.setCantidadProducto(new Long(txtCantidad.getText()));
                p.setPrecioProducto(new BigDecimal(txtPrecio.getText())); 
                if(indicadorEditar.equals(Boolean.TRUE)){                     
                    p.setIdProducto(idProductoSeleccionado);
                    ProductoService service = new ProductoService();
                    service.actualizarProducto(p);
                    listarProductos(new ProductoService().listarProductos());
                    mostrarMensajeInformativo(MENSAJE_EXITO_MODIFICAR);
                    limpiar();                            
                }else{
                    ProductoService service = new ProductoService();
                    service.insertarProducto(p);
                    listarProductos(new ProductoService().listarProductos());
                    mostrarMensajeInformativo(MENSAJE_EXITO_GRABAR);
                    limpiar();
                }                
            }
        } catch (Exception e) {
            mostrarMensajeError(e.getMessage());
        }        
    }//GEN-LAST:event_btnAnadirModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      if(tabla.getSelectedRow()>0 && idProductoSeleccionado != null){
          try {
              new ProductoService().eliminarProducto(idProductoSeleccionado);
              listarProductos(new ProductoService().listarProductos());
              mostrarMensajeInformativo(MENSAJE_EXITO_ELIMINAR_REGISTRO);
          } catch (Exception e) {
              mostrarMensajeError(e.getMessage());
          }
      }else{
          mostrarMensajeAdvertencia(MENSAJE_VALIDAR_SELECCIONAR);
      }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadirModificar;
    private javax.swing.JButton btnAnadirModificar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtDescripcionProducto;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

   
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(tabla.getSelectedRowCount()>0){
            this.idProductoSeleccionado = (Long) tabla.getValueAt(tabla.getSelectedRow(), 0);
            txtCodigoProducto.setText((String) tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            txtDescripcionProducto.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
            txtPrecio.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString()); 
            txtCantidad.setText(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
            indicadorEditar = Boolean.TRUE; 
            btnAnadirModificar.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("images/edit.png")));
            btnAnadirModificar.setText("Editar"); 
        }        
    }

    
    @Override
    public void keyPressed(KeyEvent e) { 
        if(!indicadorEditar){
            try {
            ProductoService service = new ProductoService();           
            if(txtBuscar.getText().isEmpty()){
                listarProductos(service.listarProductos());
            }else{
                listarProductos(service.filtrarProductos(txtBuscar.getText()));
            }
        } catch (Exception xe) {
            xe.printStackTrace();
            mostrarMensajeError(xe.getMessage());
        }    
        }           
    }
    
    @Override
    public void keyTyped(KeyEvent e) {     
        super.keyTyped(e); 
    }

    @Override
    public void keyReleased(KeyEvent e) {        
    }
}
