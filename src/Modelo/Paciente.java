/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOAbuelo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name="paciente")
public class Paciente implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @Column
    private String apellido;
    @Column
    private Double peso;
    @Column
    private Double talla;
    @Column
    private String dni;
    @Column
    private int edad;
    @Temporal(TemporalType.DATE)
    private Date fechadeNacimiento;
    @Column
    private Date fechaAlta;
    @Column
    private Date fechaBaja;
    @Column
    private String motivoBaja;

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }
    @Lob
    @Column(name="foto",nullable=false)
    private byte[] fotoPaciente;

    public byte[] getFotoPaciente() {
        return fotoPaciente;
    }

    public void setFotoPaciente(byte[] fotoPaciente) {
        this.fotoPaciente = fotoPaciente;
    }
    @Column
    private String nombre;
    @ManyToOne
    private ObraSocial obraSocial;
    
    public Paciente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }
        public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }
        public Date getFechadeNacimiento() {
        return fechadeNacimiento;
    }

    public void setFechadeNacimiento(Date fechadeNacimiento) {
        this.fechadeNacimiento = fechadeNacimiento;
    }
    
        public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public static DTOAbuelo buildDTO(Paciente paciente){
        DTOAbuelo dto= new DTOAbuelo();
        if(paciente.getId()!=null){
        dto.setId(paciente.getId());
        }
        if(paciente.getApellido()!=null){
        dto.setApellido(paciente.getApellido());
        }
        if(paciente.getDni()!=null){
        dto.setDni(paciente.getDni());
        }
        dto.setEdad(paciente.getEdad());
        if(paciente.getFechaAlta()!=null){
        dto.setFechaAlta(paciente.getFechaAlta());
        }
        if(paciente.getFechadeNacimiento()!=null){
        dto.setFechadeNacimiento(paciente.getFechadeNacimiento());
        }
        if(paciente.getFotoPaciente()!=null){
        dto.setFoto(paciente.getFotoPaciente());
        }
        if(paciente.getNombre()!=null){
        dto.setNombre(paciente.getNombre());    
        }
        if(paciente.getPeso()!=null){
        dto.setPeso(paciente.getPeso()); 
        }
        if(paciente.getTalla()!=null){
        dto.setTalla(paciente.getTalla()); 
        }
        if(paciente.getObraSocial()!=null){
        dto.setDTOobraSocial(ObraSocial.buildDTOObraSocial(paciente.getObraSocial()));
        }
        return dto;
    }
}
