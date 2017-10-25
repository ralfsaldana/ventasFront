/*
 * *********************************************************************
 * ESTA CLASE ESTA PENSADA PARA REEMPLAZARSE POR UN CLIENTE DE SERVICIO WEB
 * *********************************************************************
 */
package servicio;

import dto.Cliente;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import negocio.BLCliente;
import org.springframework.web.client.RestTemplate;
import util.ServiciosUtil;

/**
 *
 * @author rsaldana
 */
public class ClienteService {
    
    public ArrayList<Cliente> listarClientes() throws Exception{ 
        //return new BLCliente().listarClientes();
        try {
            RestTemplate restTemplate = new RestTemplate();
            Cliente[] result = restTemplate.getForObject(ServiciosUtil.LISTAR_CLIENTES, Cliente[].class);
            List<Cliente> lista = Arrays.asList(result);
            return new ArrayList(lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void insertarCliente(Cliente p) throws Exception{
        //new BLCliente().insertarCliente(p);
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(ServiciosUtil.INSERTAR_CLIENTE, p, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void actualizarCliente(Cliente p) throws Exception{
        new BLCliente().actualizarCliente(p);
    }
    
    public ArrayList<Cliente> filtrarClientes(String filtro) throws Exception{
        return new BLCliente().filtrarClientes(filtro);
    }
    
    public void eliminarCliente(Long idProducto) throws Exception{
        new BLCliente().eliminarCliente(idProducto);
    }
    
    public Cliente obtenerClientePorId(Long id) throws Exception{
        return new BLCliente().obtenerClientePorId(id);
    }
}
