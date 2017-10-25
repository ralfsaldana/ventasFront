/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author rsaldana
 */
public class ExcelUtil {
    
    //prueba de concepto para leer cualquier archivo excel mostrar su contenido en consola
    public void leerExcel(String rutaArchivo){
        try {
            FileInputStream file = new FileInputStream(new File(rutaArchivo));
	
            // Crear el objeto que tendra el libro de Excel	
            XSSFWorkbook workbook = new XSSFWorkbook(file);	
	
            /*	
             * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.	
             * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator	
             * que nos permite recorrer cada una de las filas que contiene.	
             */
             XSSFSheet sheet = workbook.getSheetAt(0);
	     Iterator<Row> rowIterator = sheet.iterator();	
             Row row;
	
	    // Recorremos todas las filas para mostrar el contenido de cada celda	
            while (rowIterator.hasNext()){	
                row = rowIterator.next();
                // Obtenemos el iterator que permite recorres todas las celdas de una fila	
                Iterator<Cell> cellIterator = row.cellIterator();	
                Cell celda;
                
                while (cellIterator.hasNext()){	
                    celda = cellIterator.next();
		
                    // Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
                    switch(celda.getCellType()) {	
                        case Cell.CELL_TYPE_NUMERIC:	
                            if( DateUtil.isCellDateFormatted(celda) ){	
                                System.out.println(celda.getDateCellValue());	
                            }else{	
                                System.out.println(celda.getNumericCellValue());	
                            }
                            break;	
                        case Cell.CELL_TYPE_STRING:	
                            System.out.println(celda.getStringCellValue());	
                            break;	
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.println(celda.getBooleanCellValue());	
                            break;	
                    }	
                }
            }
            // cerramos el libro excel	
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static CellStyle crearEstiloCabeceraConBorde(XSSFWorkbook workbook){
        CellStyle headerStyle = workbook.createCellStyle();
        Font fontHeader = workbook.createFont();
        fontHeader.setBold(true);
        headerStyle.setFont(fontHeader);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerStyle.setTopBorderColor(HSSFColor.BLACK.index);
        headerStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        headerStyle.setRightBorderColor(HSSFColor.BLACK.index);
        headerStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        return headerStyle;
    }
    
    public static CellStyle crearEstiloCeldaConBorde(XSSFWorkbook workbook){
        CellStyle style = workbook.createCellStyle();        
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(HSSFColor.BLACK.index);
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        style.setRightBorderColor(HSSFColor.BLACK.index);
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        return style;
    }
    
     public static CellStyle crearEstiloNegrita(XSSFWorkbook workbook){
        CellStyle headerStyle = workbook.createCellStyle();
        Font fontHeader = workbook.createFont();
        fontHeader.setBold(true);        
        return headerStyle;
    }
    
}
