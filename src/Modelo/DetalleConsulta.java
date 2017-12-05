/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
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
@Table(name="detalleConsulta")
public class DetalleConsulta implements Serializable{
    @Id @GeneratedValue
    private Long id;
    @Column
    private String detalleConsulta;
    @ManyToOne
    private TipoPrioridad tipoPrioridad;

    public DetalleConsulta() {
    }

    public String getDetalleConsulta() {
        return detalleConsulta;
    }

    public void setDetalleConsulta(String detalleConsulta) {
        this.detalleConsulta = detalleConsulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public TipoPrioridad getTipoPrioridad() {
        return tipoPrioridad;
    }

    public void setTipoPrioridad(TipoPrioridad tipoPrioridad) {
        this.tipoPrioridad = tipoPrioridad;
    }
    
    
    
}
