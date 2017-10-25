/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.ConexionUtil;
import dto.DetalleVenta;
import dto.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rsaldana
 */
public class VentaDAO {
    
    public void insertarCabeceraYDetalleVenta(Venta venta) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new ConexionUtil().getConexion();      
            c.setAutoCommit(false); 
            st = c.prepareStatement("insert into venta(ruc, nombreRazonSocial, subtotal, "
                    + "IGVCalculado, total, fechaVenta) values (?,?,?,?,?,CURRENT_TIMESTAMP);",Statement.RETURN_GENERATED_KEYS);            
            if(venta.getRUC().isEmpty() && venta.getNombreRazonSocial().isEmpty()){
                venta.setRUC("--");
                venta.setNombreRazonSocial("--");
            }
            st.setString(1, venta.getRUC()); 
            st.setString(2, venta.getNombreRazonSocial()); 
            st.setBigDecimal(3, venta.getSubtotal());  
            st.setBigDecimal(4, venta.getIGVCalculado()); 
            st.setBigDecimal(5, venta.getTotal());                     
            st.executeUpdate();
            
            Long idGenerado = null;
            ResultSet rs = st.getGeneratedKeys();
            while(rs.next()){
                idGenerado = rs.getLong(1);
            }
            
            for(DetalleVenta detalle : venta.getDetalleVenta()){
                st = c.prepareStatement("insert into detalle_venta(idVenta, codigoProducto, descripcionProducto, "
                        + "precioUnitario, cantidad, precioVenta) values (?,?,?,?,?,?);");  
                st.setLong(1, idGenerado);
                st.setString(2, detalle.getCodigoProducto());
                st.setString(3, detalle.getDescripcionProducto());
                st.setBigDecimal(4, detalle.getPrecioUnitario());
                st.setLong(5, detalle.getCantidad());
                st.setBigDecimal(6, detalle.getPrecioVenta());
                st.executeUpdate();
            }            
            c.commit();
        } catch (Exception e) {              
            c.rollback();
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    }
    
    public ArrayList<Venta> buscarVentasPorFecha(Date desde, Date hasta) throws Exception {
        Connection c = null;
        PreparedStatement st =null;    
        ResultSet rs  =null;
        try {            
            c =  new ConexionUtil().getConexion();           
            st = c.prepareStatement("select idVenta, fechaVenta, IGVCalculado, nombreRazonSocial, "
                    + "nombreRazonSocial,ruc,subtotal, total "
                    + "from venta where DATE(fechaVenta) "
                    + "between DATE(?) and DATE(?);" );                        
            st.setDate(1, new java.sql.Date(desde.getTime()));
            st.setDate(2, new java.sql.Date(hasta.getTime()));           
            rs = st.executeQuery();
            ArrayList<Venta> items = new ArrayList<Venta>();
            Venta p = null;
            while(rs.next()){
                p = new Venta();
                p.setIdVenta(rs.getLong("idVenta"));
                Timestamp timestamp = rs.getTimestamp("fechaVenta");                             
                p.setFechaVenta(new Date(timestamp.getTime()));
                p.setIGVCalculado(rs.getBigDecimal("IGVCalculado"));
                p.setNombreRazonSocial(rs.getString("nombreRazonSocial"));
                p.setRUC(rs.getString("ruc"));
                p.setSubtotal(rs.getBigDecimal("subtotal"));
                p.setTotal(rs.getBigDecimal("total"));
                items.add(p);
            }
            return items;
        } catch (Exception e) {     
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(rs!=null)rs.close();
            if(st!=null)st.close();           
        }                   
    }
    
    public ArrayList<DetalleVenta> buscarDetalleVenta(Long idVenta) throws Exception {
        Connection c = null;
        PreparedStatement st =null;    
        ResultSet rs  =null;
        try {            
            c =  new ConexionUtil().getConexion();            
            st = c.prepareStatement("select * from detalle_venta where idVenta = ?" );
            st.setLong(1, idVenta);          
            rs = st.executeQuery();
            ArrayList<DetalleVenta> items = new ArrayList<DetalleVenta>();
            DetalleVenta p = null;
            while(rs.next()){
                p = new DetalleVenta();
                p.setIdDetalleVenta(rs.getLong("idDetalleVenta"));
                p.setCantidad(rs.getLong("cantidad"));
                p.setCodigoProducto(rs.getString("codigoProducto"));
                p.setDescripcionProducto(rs.getString("descripcionProducto"));
                p.setPrecioUnitario(rs.getBigDecimal("precioUnitario"));
                p.setPrecioVenta(rs.getBigDecimal("precioVenta")); 
                items.add(p);
            }
            return items;
        } catch (Exception e) {     
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(rs!=null)rs.close();
            if(st!=null)st.close();           
        }                   
    }
}
