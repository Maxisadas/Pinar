/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DTO;

/**
 *
 * @author Maxi
 */
public class DTOFormulario {
    
    private String nombreArea;
    private String nombreApellidoPaciente;
    private String informetext;
    private Long idAbuelo;
    private Long idPersonal;

    public Long getIdAbuelo() {
        return idAbuelo;
    }

    public void setIdAbuelo(Long idAbuelo) {
        this.idAbuelo = idAbuelo;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getInformetext() {
        return informetext;
    }

    public void setInformetext(String informetext) {
        this.informetext = informetext;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getNombreApellidoPaciente() {
        return nombreApellidoPaciente;
    }

    public void setNombreApellidoPaciente(String nombreApellidoPaciente) {
        this.nombreApellidoPaciente = nombreApellidoPaciente;
    }
    
}
