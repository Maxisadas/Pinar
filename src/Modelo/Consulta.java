/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
@Table(name="consulta")
public class Consulta implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private DetalleConsulta detalleConsulta;
    @ManyToOne
    private Personal personal;
    @Column
    private String nombrePersonalEnvia;
    @Column 
    private boolean visto;
    @Column
    private String AreaEnviada;
    @Column
    private String Nombreabuelo;
    @ManyToOne
    private Paciente paciente;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNombreabuelo() {
        return Nombreabuelo;
    }

    public void setNombreabuelo(String Nombreabuelo) {
        this.Nombreabuelo = Nombreabuelo;
    }

    public String getAreaEnviada() {
        return AreaEnviada;
    }

    public void setAreaEnviada(String AreaEnviada) {
        this.AreaEnviada = AreaEnviada;
    }

    public Date getFechaElaboracionConsulta() {
        return fechaElaboracionConsulta;
    }

    public void setFechaElaboracionConsulta(Date fechaElaboracionConsulta) {
        this.fechaElaboracionConsulta = fechaElaboracionConsulta;
    }
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaElaboracionConsulta;

    public String getNombrePersonalEnvia() {
        return nombrePersonalEnvia;
    }

    public void setNombrePersonalEnvia(String nombrePersonalEnvia) {
        this.nombrePersonalEnvia = nombrePersonalEnvia;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public Consulta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DetalleConsulta getDetalleConsulta() {
        return detalleConsulta;
    }

    public void setDetalleConsulta(DetalleConsulta detalleConsulta) {
        this.detalleConsulta = detalleConsulta;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }




    
    
}
