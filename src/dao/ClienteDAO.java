/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.ConexionUtil;
import dto.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rsaldana
 */
public class ClienteDAO {
    
    public ArrayList<Cliente> listarClientes() throws Exception {
        Connection c = null;
        Statement st =null;    
        ResultSet rs  =null;
        try {            
            c =  new ConexionUtil().getConexion();            
            st = c.createStatement();
            rs = st.executeQuery("select * from cliente;");
            ArrayList<Cliente> items = new ArrayList<Cliente>();
            Cliente cli = null;
            while(rs.next()){
               cli = new Cliente();
               cli.setIdCliente(rs.getLong("idCliente"));
               cli.setNroDocumentoIdentidad(rs.getString("nroDocumentoIdentidad"));   
               cli.setNombreRazonSocial(rs.getString("nombreRazonSocial"));
               cli.setRuc(rs.getString("ruc"));
               cli.setDireccion(rs.getString("direccion"));
               cli.setTelefono(rs.getString("telefono"));
               cli.setEmail(rs.getString("email"));    
               items.add(cli);
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
    
     
    public ArrayList<Cliente> filtrarClientes(String filtro) throws Exception {
        Connection c = null;
        Statement st =null;    
        ResultSet rs  =null;
        try {            
            c =  new ConexionUtil().getConexion();            
            st = c.createStatement();
            rs = st.executeQuery("select * from cliente where nombreRazonSocial like '"+filtro+"%';");
            ArrayList<Cliente> items = new ArrayList<Cliente>();
            Cliente cli = null;
            while(rs.next()){
               cli = new Cliente();
               cli.setIdCliente(rs.getLong("idCliente"));
               cli.setNroDocumentoIdentidad(rs.getString("nroDocumentoIdentidad"));   
               cli.setNombreRazonSocial(rs.getString("nombreRazonSocial"));
               cli.setRuc(rs.getString("ruc"));
               cli.setDireccion(rs.getString("direccion"));
               cli.setTelefono(rs.getString("telefono"));
               cli.setEmail(rs.getString("email"));  
               items.add(cli);
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
    
    
    public void insertarCliente(Cliente cli) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new ConexionUtil().getConexion();       
            st = c.prepareStatement("insert into cliente(nroDocumentoIdentidad, ruc, nombreRazonSocial, direccion, telefono, email) values (?,?,?,?,?,?);");            
            st.setString(1, cli.getNroDocumentoIdentidad()); 
            st.setString(2, cli.getRuc()); 
            st.setString(3, cli.getNombreRazonSocial());  
            st.setString(4, cli.getDireccion()); 
            st.setString(5, cli.getTelefono());
            st.setString(6, cli.getEmail());
            st.executeUpdate();
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    }
     
    public void actualizarCliente(Cliente cli) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new ConexionUtil().getConexion();       
            st = c.prepareStatement("update cliente set nroDocumentoIdentidad=?, ruc=?, nombreRazonSocial=?, direccion=?, telefono=?, email=? where idCliente=?;");            
            st.setString(1, cli.getNroDocumentoIdentidad()); 
            st.setString(2, cli.getRuc()); 
            st.setString(3, cli.getNombreRazonSocial());  
            st.setString(4, cli.getDireccion()); 
            st.setString(5, cli.getTelefono());
            st.setString(6, cli.getEmail());
            st.setLong(7, cli.getIdCliente());
            st.executeUpdate();
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    }
    
    public void eliminarCliente(Long idCliente) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new ConexionUtil().getConexion();       
            st = c.prepareStatement("delete from cliente where idCliente=?;");                        
            st.setLong(1, idCliente);  
            st.executeUpdate();
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    }
    
    public Cliente obtenerClientePorId(Long idCliente) throws Exception {
        Connection c = null;
        PreparedStatement st =null;    
        ResultSet rs  =null;
        Cliente cli = null;
        try {            
            c =  new ConexionUtil().getConexion();            
            st = c.prepareStatement("select * from cliente where idCliente = ?;");
            st.setLong(1, idCliente);
            rs = st.executeQuery();
            if(rs.next()){
                cli = new Cliente();
                cli.setIdCliente(rs.getLong("idCliente"));
                cli.setNroDocumentoIdentidad(rs.getString("nroDocumentoIdentidad"));   
                cli.setNombreRazonSocial(rs.getString("nombreRazonSocial"));
                cli.setRuc(rs.getString("ruc"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setEmail(rs.getString("email"));  
            }    
            return cli;
        } catch (Exception e) {     
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(rs!=null)rs.close();
            if(st!=null)st.close();           
        }  
    }
    
}
