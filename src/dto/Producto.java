/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author rsaldana
 */
public class Producto implements Serializable{
    
    private Long idProducto;
    private String codigoProducto;
    private Long cantidadProducto;
    private String descripcionProducto;
    private BigDecimal precioProducto;

    public Producto(){
    }    
    
    public Producto(Long idProducto, String codigoProducto, Long cantidadProducto, String descripcionProducto, BigDecimal precioProducto){
        this.idProducto = idProducto;
        this.codigoProducto = codigoProducto;
        this.cantidadProducto = cantidadProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
    }
    
    
    /**
     * @return the idProducto
     */
    public Long getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the codigoProducto
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the cantidadProducto
     */
    public Long getCantidadProducto() {
        return cantidadProducto;
    }

    /**
     * @param cantidadProducto the cantidadProducto to set
     */
    public void setCantidadProducto(Long cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    /**
     * @return the descripcionProducto
     */
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    /**
     * @param descripcionProducto the descripcionProducto to set
     */
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    /**
     * @return the precioProducto
     */
    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    /**
     * @param precioProducto the precioProducto to set
     */
    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    
}
