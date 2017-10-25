/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rsaldana
 */
public class Venta {
    
    private Long idVenta;
    private String RUC;
    private String nombreRazonSocial;
    private BigDecimal subtotal;
    private BigDecimal IGVCalculado;
    private BigDecimal total;
    private Date fechaVenta;
    private ArrayList<DetalleVenta> detalleVenta;

    /**
     * @return the RUC
     */
    public String getRUC() {
        return RUC;
    }

    /**
     * @param RUC the RUC to set
     */
    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    /**
     * @return the nombreRazonSocial
     */
    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }

    /**
     * @param nombreRazonSocial the nombreRazonSocial to set
     */
    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }

    /**
     * @return the subtotal
     */
    public BigDecimal getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the IGVCalculado
     */
    public BigDecimal getIGVCalculado() {
        return IGVCalculado;
    }

    /**
     * @param IGVCalculado the IGVCalculado to set
     */
    public void setIGVCalculado(BigDecimal IGVCalculado) {
        this.IGVCalculado = IGVCalculado;
    }

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * @return the fechaVenta
     */
    public Date getFechaVenta() {
        return fechaVenta;
    }

    /**
     * @param fechaVenta the fechaVenta to set
     */
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * @return the detalleVenta
     */
    public ArrayList<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    /**
     * @param detalleVenta the detalleVenta to set
     */
    public void setDetalleVenta(ArrayList<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    /**
     * @return the idVenta
     */
    public Long getIdVenta() {
        return idVenta;
    }

    /**
     * @param idVenta the idVenta to set
     */
    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }
}
