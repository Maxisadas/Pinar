/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DTO;

import Modelo.Especialidad;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class DTOPersonal {
    
    private String nombrePersonal;
    private String apellidoPersonal;
    private String dni;
    private Date fechaAlta;
    private Date fechaBaja;
    private String nombreRol;
    private String nombreArea;
    private List<DTOEspecializacion> listaEspecialidad;
    private Long id;

    public List<DTOEspecializacion> getListaEspecialidad() {
        return listaEspecialidad;
    }

    public void setListaEspecialidad(List<DTOEspecializacion> listaEspecialidad) {
        this.listaEspecialidad = listaEspecialidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getApellidoPersonal() {
        return apellidoPersonal;
    }

    public void setApellidoPersonal(String apellidoPersonal) {
        this.apellidoPersonal = apellidoPersonal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }


    
    
}
