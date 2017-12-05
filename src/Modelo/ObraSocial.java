/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOObraSocial;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name="obraSocial")
public class ObraSocial implements Serializable{
    @Id @GeneratedValue
    private Long id;
    @Column(name="nombreObraSocial")
    private String nombreObraSocial;
    @Column
    private String credencialDeAfiliacion;
    @Column
    private String fechaEmisionCredencial;
    @Column
    private String fechaVigenciaCredencial;
    @Column
    private String fechaAltaCredencial;
    @Column
    private String fechaVencimientoCredencial;
    @Column
    private String numeroBeneficio;
    @Column
    private String gp;
    @Column
    private String emitidoPor;
    @Column
    private String expedienteNro;
    @Column
    private String disposicionNro;
    @Column
    private String domicilio;
    @Column
    private String localidad;
    @Column
    private String nombremedicoCabecera;
    @Column
    private String numeroMedicoCabecera;
    @Column
    private String fechaVigenciaMedico;
    @Column 
    private String moduloInternacion;
    @Column
    private String nroModulo;
    @Column
    private String fechaVigenciaModulo;

    public String getNombremedicoCabecera() {
        return nombremedicoCabecera;
    }

    public void setNombremedicoCabecera(String nombremedicoCabecera) {
        this.nombremedicoCabecera = nombremedicoCabecera;
    }

    public String getNumeroMedicoCabecera() {
        return numeroMedicoCabecera;
    }

    public void setNumeroMedicoCabecera(String numeroMedicoCabecera) {
        this.numeroMedicoCabecera = numeroMedicoCabecera;
    }

    public String getFechaVigenciaMedico() {
        return fechaVigenciaMedico;
    }

    public void setFechaVigenciaMedico(String fechaVigenciaMedico) {
        this.fechaVigenciaMedico = fechaVigenciaMedico;
    }

    public String getModuloInternacion() {
        return moduloInternacion;
    }

    public void setModuloInternacion(String moduloInternacion) {
        this.moduloInternacion = moduloInternacion;
    }

    public String getNroModulo() {
        return nroModulo;
    }

    public void setNroModulo(String nroModulo) {
        this.nroModulo = nroModulo;
    }

    public String getFechaVigenciaModulo() {
        return fechaVigenciaModulo;
    }

    public void setFechaVigenciaModulo(String fechaVigenciaModulo) {
        this.fechaVigenciaModulo = fechaVigenciaModulo;
    }
    

    public String getCredencialDeAfiliacion() {
        return credencialDeAfiliacion;
    }

    public void setCredencialDeAfiliacion(String credencialDeAfiliacion) {
        this.credencialDeAfiliacion = credencialDeAfiliacion;
    }

    public String getFechaEmisionCredencial() {
        return fechaEmisionCredencial;
    }

    public void setFechaEmisionCredencial(String fechaEmisionCredencial) {
        this.fechaEmisionCredencial = fechaEmisionCredencial;
    }

    public String getFechaVigenciaCredencial() {
        return fechaVigenciaCredencial;
    }

    public void setFechaVigenciaCredencial(String fechaVigenciaCredencial) {
        this.fechaVigenciaCredencial = fechaVigenciaCredencial;
    }

    public String getFechaAltaCredencial() {
        return fechaAltaCredencial;
    }

    public void setFechaAltaCredencial(String fechaAltaCredencial) {
        this.fechaAltaCredencial = fechaAltaCredencial;
    }

    public String getFechaVencimientoCredencial() {
        return fechaVencimientoCredencial;
    }

    public void setFechaVencimientoCredencial(String fechaVencimientoCredencial) {
        this.fechaVencimientoCredencial = fechaVencimientoCredencial;
    }

    public String getNumeroBeneficio() {
        return numeroBeneficio;
    }

    public void setNumeroBeneficio(String numeroBeneficio) {
        this.numeroBeneficio = numeroBeneficio;
    }

    public String getGp() {
        return gp;
    }

    public void setGp(String gp) {
        this.gp = gp;
    }

    public String getEmitidoPor() {
        return emitidoPor;
    }

    public void setEmitidoPor(String emitidoPor) {
        this.emitidoPor = emitidoPor;
    }

    public String getExpedienteNro() {
        return expedienteNro;
    }

    public void setExpedienteNro(String expedienteNro) {
        this.expedienteNro = expedienteNro;
    }

    public String getDisposicionNro() {
        return disposicionNro;
    }

    public void setDisposicionNro(String disposicionNro) {
        this.disposicionNro = disposicionNro;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public ObraSocial() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombreObraSocial() {
        return nombreObraSocial;
    }

    public void setNombreObraSocial(String nombreObraSocial) {
        this.nombreObraSocial = nombreObraSocial;
    }
    
    public static DTOObraSocial buildDTOObraSocial(ObraSocial obraSocial){
        DTOObraSocial dto= new DTOObraSocial();
        if(obraSocial.getNombreObraSocial()!=null){
        dto.setNombreObraSocial(obraSocial.getNombreObraSocial());
        }
        //Agregar los atributos restantes
        return dto;
    }
}
