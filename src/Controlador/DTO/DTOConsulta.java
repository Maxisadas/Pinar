/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DTO;

import java.util.Date;

/**
 *
 * @author Maxi
 */
public class DTOConsulta {
    
    private String detalleConsulta;
    private String nombreArea;
    private Long numeroConsulta;
    private String prioridad;
    private String nombreProfesional;
    private boolean visto;
    private Date fechaCreacion;
    private String nombrePersonaEnvia;
    private Long idAbuelo;
    private String nombreAbuelo;
    private byte[] foto;

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNombreAbuelo() {
        return nombreAbuelo;
    }

    public void setNombreAbuelo(String nombreAbuelo) {
        this.nombreAbuelo = nombreAbuelo;
    }

    public Long getIdAbuelo() {
        return idAbuelo;
    }

    public void setIdAbuelo(Long idAbuelo) {
        this.idAbuelo = idAbuelo;
    }

  
    public String getNombrePersonaEnvia() {
        return nombrePersonaEnvia;
    }

    public void setNombrePersonaEnvia(String nombrePersonaEnvia) {
        this.nombrePersonaEnvia = nombrePersonaEnvia;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public String getNombreProfesional() {
        return nombreProfesional;
    }

    public void setNombreProfesional(String nombreProfesional) {
        this.nombreProfesional = nombreProfesional;
    }

    public String getDetalleConsulta() {
        return detalleConsulta;
    }

    public void setDetalleConsulta(String detalleConsulta) {
        this.detalleConsulta = detalleConsulta;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    
    
}
