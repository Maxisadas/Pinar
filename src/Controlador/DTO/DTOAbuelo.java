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
public class DTOAbuelo {

    private Long id;

    private String apellido;
   
    private Double peso;
   
    private Double talla;
  
    private String dni;
   
    private int edad;

    private Date fechadeNacimiento;
    private Date fechaAlta;
    private Date fechaBaja;
    private String rutafotoPaciente;
    private String motivoBaja;

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    public String getRutafotoPaciente() {
        return rutafotoPaciente;
    }

    public void setRutafotoPaciente(String rutafotoPaciente) {
        this.rutafotoPaciente = rutafotoPaciente;
    }
    private String nombre;
    private DTOObraSocial DTOobraSocial;

    public DTOObraSocial getDTOobraSocial() {
        return DTOobraSocial;
    }

    public void setDTOobraSocial(DTOObraSocial DTOobraSocial) {
        this.DTOobraSocial = DTOobraSocial;
    }
    private byte[] foto;

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechadeNacimiento() {
        return fechadeNacimiento;
    }

    public void setFechadeNacimiento(Date fechadeNacimiento) {
        this.fechadeNacimiento = fechadeNacimiento;
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


}
