/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DTO;

import java.util.Date;

/**
 *
 * @author User
 */
public class DTODetalleInforme {
    
    private Long id; 
    private String informeMedico;
    private Date fechaElaboracion;
    private String personal;
    private String nombreArea;
    private String nombreMedico;
    private byte[] foto;

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public Long getId() {
        return id;
    }

    public Date getFechaElaboracion() {
        return fechaElaboracion;
    }

    public String getInformeMedico() {
        return informeMedico;
    }

    public String getPersonal() {
        return personal;
    }

    public void setFechaElaboracion(Date fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInformeMedico(String informeMedico) {
        this.informeMedico = informeMedico;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }
    
    
    
    
}
