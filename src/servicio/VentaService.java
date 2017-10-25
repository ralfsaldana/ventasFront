/*
 * *********************************************************************
 * ESTA CLASE ESTA PENSADA PARA REEMPLAZARSE POR UN POSIBLE SERVICIO WEB
 * *********************************************************************
 */
package servicio;

import dto.DetalleVenta;
import dto.Venta;
import java.util.ArrayList;
import java.util.Date;
import negocio.BLVentas;

/**
 *
 * @author rsaldana
 */
public class VentaService {
    
    
    public void insertarCabeceraYDetalleVenta(Venta venta) throws Exception{
        new BLVentas().insertarCabeceraYDetalleVenta(venta); 
    }
    
    public ArrayList<Venta> buscarVentasPorFecha(Date desde, Date hasta) throws Exception{
        return new BLVentas().buscarVentasPorFecha(desde, hasta);
    }
    
    public ArrayList<DetalleVenta> buscarDetalleVenta(Long idVenta) throws Exception{
        return new BLVentas().buscarDetalleVenta(idVenta);
    }
    
    public byte[] generarExcelReporteVentas(ArrayList<Venta> items) throws Exception{
        return new BLVentas().generarExcelReporteVentas(items);
    }
    
}
