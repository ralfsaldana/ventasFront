/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.ClienteDAO;
import dto.Cliente;
import java.util.ArrayList;

/**
 *
 * @author rsaldana
 */
public class BLCliente {
    
    public ArrayList<Cliente> listarClientes() throws Exception{
       return new ClienteDAO().listarClientes();
    }
    
    public void insertarCliente(Cliente p) throws Exception{
        new ClienteDAO().insertarCliente(p);
    }
    
    public void actualizarCliente(Cliente p) throws Exception{
        new ClienteDAO().actualizarCliente(p);
    }
    
    public ArrayList<Cliente> filtrarClientes(String filtro) throws Exception{
        return new ClienteDAO().filtrarClientes(filtro);
    }
    
    public void eliminarCliente(Long idProducto) throws Exception{
        new ClienteDAO().eliminarCliente(idProducto);
    }
    
    public Cliente obtenerClientePorId(Long id) throws Exception{
        return new ClienteDAO().obtenerClientePorId(id);
    }
    
}
