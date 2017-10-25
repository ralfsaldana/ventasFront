/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author rsaldana
 */
public class Cliente implements Serializable{
    
    private Long idCliente;
    private String nroDocumentoIdentidad;
    private String ruc;
    private String nombreRazonSocial;
    private String direccion;
    private String telefono;
    private String email;

    public Cliente(){        
    }
    
    public Cliente(Long idCliente, String nroDocumentoIdentidad, String ruc, String nombreRazonSocial, String direccion,String telefono){
        this.idCliente = idCliente;
        this.nroDocumentoIdentidad = nroDocumentoIdentidad;
        this.ruc = ruc;
        this.nombreRazonSocial = nombreRazonSocial;
        this.direccion = direccion;
        this.telefono = telefono;                
    }
    
    /**
     * @return the idCliente
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the nroDocumentoIdentidad
     */
    public String getNroDocumentoIdentidad() {
        return nroDocumentoIdentidad;
    }

    /**
     * @param nroDocumentoIdentidad the nroDocumentoIdentidad to set
     */
    public void setNroDocumentoIdentidad(String nroDocumentoIdentidad) {
        this.nroDocumentoIdentidad = nroDocumentoIdentidad;
    }

    /**
     * @return the ruc
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * @param ruc the ruc to set
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
