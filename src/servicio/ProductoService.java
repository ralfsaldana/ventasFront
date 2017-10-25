/*
 * *********************************************************************
 * ESTA CLASE ESTA PENSADA PARA REEMPLAZARSE POR UN POSIBLE SERVICIO WEB
 * *********************************************************************
 */
package servicio;

import dto.DetalleVenta;
import dto.Producto;
import java.util.ArrayList;
import negocio.BLProducto;
import negocio.BLVentas;

/**
 *
 * @author rsaldana
 */
public class ProductoService {
 
    public ArrayList<Producto> listarProductos() throws Exception{
       return new BLProducto().listarProductos();
    }
    
    public void insertarProducto(Producto p) throws Exception{
        new BLProducto().insertarProducto(p);
    }
    
    public void actualizarProducto(Producto p) throws Exception{
        new BLProducto().actualizarProducto(p);
    }
    
    public ArrayList<Producto> filtrarProductos(String filtro) throws Exception{
        return new BLProducto().filtrarProductos(filtro);
    }
    
    public void eliminarProducto(Long idProducto) throws Exception{
        new BLProducto().eliminarProducto(idProducto);
    }
    
    public Producto obtenerProductoPorId(Long idProducto) throws Exception{
        return new BLProducto().obtenerProductoPorId(idProducto);
    }
    
    public void actualizarStockProducto(ArrayList<DetalleVenta> detalleVenta) throws Exception{        
        new BLVentas().actualizarStockProducto(detalleVenta); 
    }
}

