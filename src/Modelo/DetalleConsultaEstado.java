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

/**
 *
 * @author User
 */
@Entity
@Table(name="detalleConsultaEstado")
public class DetalleConsultaEstado implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @Column
    private Date fechaHoraEstado;
    @ManyToOne
    private EstadoDetalleConsulta estadoDetalleConsulta;
    @ManyToOne 
    private DetalleConsulta detalleConsulta;

    public DetalleConsultaEstado() {
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

    public EstadoDetalleConsulta getEstadoDetalleConsulta() {
        return estadoDetalleConsulta;
    }

    public void setEstadoDetalleConsulta(EstadoDetalleConsulta estadoDetalleConsulta) {
        this.estadoDetalleConsulta = estadoDetalleConsulta;
    }

    public Date getFechaHoraEstado() {
        return fechaHoraEstado;
    }

    public void setFechaHoraEstado(Date fechaHoraEstado) {
        this.fechaHoraEstado = fechaHoraEstado;
    }
    
    
    
}
