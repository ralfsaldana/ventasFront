/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.ConexionUtil;
import dto.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rsaldana
 */
public class ProductoDAO {
    
    
    public ArrayList<Producto> listarProductos() throws Exception {
        Connection c = null;
        Statement st =null;    
        ResultSet rs  =null;
        try {            
            c =  new ConexionUtil().getConexion();            
            st = c.createStatement();
            rs = st.executeQuery("select * from producto;");
            ArrayList<Producto> items = new ArrayList<Producto>();
            Producto p = null;
            while(rs.next()){
                p = new Producto();
                p.setIdProducto(rs.getLong("idProducto"));
                p.setCodigoProducto(rs.getString("codigoProducto"));                            
                p.setCantidadProducto(rs.getLong("cantidadProducto"));
                p.setDescripcionProducto(rs.getString("descripcionProducto"));
                p.setPrecioProducto(rs.getBigDecimal("precioProducto"));
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
    
    
    public ArrayList<Producto> filtrarProductos(String filtro) throws Exception {
        Connection c = null;
        Statement st =null;    
        ResultSet rs  =null;
        try {            
            c =  new ConexionUtil().getConexion();            
            st = c.createStatement();
            rs = st.executeQuery("select * from producto where descripcionProducto like '"+filtro+"%';");
            ArrayList<Producto> items = new ArrayList<Producto>();
            Producto p = null;
            while(rs.next()){
                p = new Producto();
                p.setIdProducto(rs.getLong("idProducto"));
                p.setCodigoProducto(rs.getString("codigoProducto"));                            
                p.setCantidadProducto(rs.getLong("cantidadProducto"));
                p.setDescripcionProducto(rs.getString("descripcionProducto"));
                p.setPrecioProducto(rs.getBigDecimal("precioProducto"));
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
    
    
    public void insertarProducto(Producto p) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new ConexionUtil().getConexion();       
            st = c.prepareStatement("insert into producto(codigoProducto, cantidadProducto, descripcionProducto, precioProducto) values (?,?,?,?);");            
            st.setString(1, p.getCodigoProducto()); 
            st.setLong(2, p.getCantidadProducto()); 
            st.setString(3, p.getDescripcionProducto());  
            st.setBigDecimal(4, p.getPrecioProducto()); 
            st.executeUpdate();
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    }
    
    public void actualizarProducto(Producto p) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new ConexionUtil().getConexion();       
            st = c.prepareStatement("update producto set codigoProducto=?, cantidadProducto=?, descripcionProducto=?, precioProducto=? where idProducto=?;");            
            st.setString(1, p.getCodigoProducto()); 
            st.setLong(2, p.getCantidadProducto()); 
            st.setString(3, p.getDescripcionProducto());  
            st.setBigDecimal(4, p.getPrecioProducto());  
            st.setLong(5, p.getIdProducto());  
            st.executeUpdate();
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    }
    
    public void eliminarProducto(Long idProducto) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new ConexionUtil().getConexion();       
            st = c.prepareStatement("delete from producto where idProducto=?;");                        
            st.setLong(1, idProducto);  
            st.executeUpdate();
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    }
     public Producto obtenerProductoPorId(Long id) throws Exception {
        Connection c = null;
        PreparedStatement st =null;    
        ResultSet rs  =null;
        Producto p = null;
        try {            
            c =  new ConexionUtil().getConexion();            
            st = c.prepareStatement("select * from producto where idProducto = ?;");
            st.setLong(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                p = new Producto();
                p.setIdProducto(rs.getLong("idProducto"));
                p.setCodigoProducto(rs.getString("codigoProducto"));                            
                p.setCantidadProducto(rs.getLong("cantidadProducto"));
                p.setDescripcionProducto(rs.getString("descripcionProducto"));
                p.setPrecioProducto(rs.getBigDecimal("precioProducto"));
            }    
            return p;
        } catch (Exception e) {     
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(rs!=null)rs.close();
            if(st!=null)st.close();           
        }  
    }
     
    public void actualizarStockProducto(Producto p) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new ConexionUtil().getConexion();       
            st = c.prepareStatement("update producto set cantidadProducto=? where idProducto=?;");                     
            st.setLong(1, p.getCantidadProducto());             
            st.setLong(2, p.getIdProducto());  
            st.executeUpdate();
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    } 
}
