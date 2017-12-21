/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="historialClinico")
public class HistorialClinico implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @OneToOne
    private Paciente paciente;
    @OneToOne
    private HistorialClinicoEstado historialEstado;

    public HistorialClinicoEstado getHistorial() {
        return historialEstado;
    }

    public void setHistorial(HistorialClinicoEstado historialEstado) {
        this.historialEstado = historialEstado;
    }

    public HistorialClinico() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
}
