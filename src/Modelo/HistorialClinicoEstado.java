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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="historialClinicoEstado")
public class HistorialClinicoEstado implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @Column(name="fecha_estado")
    private Date fechaEstado;
    @ManyToOne
    @JoinColumn(name="estado_historial_clinico_id")
    private EstadoHistorialClinico estadoHistorialClinico;
    

    public HistorialClinicoEstado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoHistorialClinico getEstadoHistorialClinico() {
        return estadoHistorialClinico;
    }

    public void setEstadoHistorialClinico(EstadoHistorialClinico estadoHistorialClinico) {
        this.estadoHistorialClinico = estadoHistorialClinico;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

  
}
