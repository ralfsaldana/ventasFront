/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.ProductoDAO;
import dao.VentaDAO;
import dto.DetalleVenta;
import dto.Producto;
import dto.Venta;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.ExcelUtil;

/**
 *
 * @author rsaldana
 */
public class BLVentas {
    
    public void actualizarStockProducto(ArrayList<DetalleVenta> detalleVenta) throws Exception{        
        Producto productoObtenido = null;
        for(DetalleVenta detalle : detalleVenta){
            productoObtenido = new ProductoDAO().obtenerProductoPorId(detalle.getIdProducto());
            productoObtenido.setCantidadProducto(productoObtenido.getCantidadProducto() - detalle.getCantidad());            
            new ProductoDAO().actualizarStockProducto(productoObtenido); 
        }        
    }
    
    public void insertarCabeceraYDetalleVenta(Venta venta) throws Exception{
        new VentaDAO().insertarCabeceraYDetalleVenta(venta); 
    }
    
    public ArrayList<Venta> buscarVentasPorFecha(Date desde, Date hasta) throws Exception{
        return new VentaDAO().buscarVentasPorFecha(desde, hasta);
    }
    
    public ArrayList<DetalleVenta> buscarDetalleVenta(Long idVenta) throws Exception{
        return new VentaDAO().buscarDetalleVenta(idVenta);
    }
    
    public byte[] generarExcelReporteVentas(ArrayList<Venta> items) throws Exception {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            workbook.setSheetName(0, "Ventas");

            CellStyle titleStyle = ExcelUtil.crearEstiloNegrita(workbook);
            Font font = workbook.createFont();
            font.setBold(true);
            titleStyle.setFont(font);

            XSSFRow titleRow = sheet.createRow(1);
            XSSFCell cellTitle = titleRow.createCell(1);
            cellTitle.setCellStyle(titleStyle);
            cellTitle.setCellValue("Listado de Ventas");

            CellStyle headerStyle = ExcelUtil.crearEstiloCabeceraConBorde(workbook);

            String[] cabecera = {"RUC", "Nombre o Razón Social", "Total"};

            XSSFRow headerRow = sheet.createRow(3);
            for (int i = 0; i < cabecera.length; i++) {
                XSSFCell cell = headerRow.createCell(i + 1);
                cell.setCellStyle(headerStyle);
                cell.setCellValue(cabecera[i]);
            }

            CellStyle cellStyle = ExcelUtil.crearEstiloCeldaConBorde(workbook);
            for (int i = 0; i < items.size(); ++i) {
                XSSFRow dataRow = sheet.createRow(i + 4);
                Venta venta = items.get(i);

                XSSFCell ruc = dataRow.createCell(1);
                ruc.setCellValue(venta.getRUC());
                ruc.setCellStyle(cellStyle);

                XSSFCell nombre = dataRow.createCell(2);
                nombre.setCellValue(venta.getNombreRazonSocial());
                nombre.setCellStyle(cellStyle);

                XSSFCell total = dataRow.createCell(3);
                total.setCellValue(venta.getTotal().toString());
                total.setCellStyle(cellStyle);
            }

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            workbook.write(bos);
            return bos.toByteArray();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
