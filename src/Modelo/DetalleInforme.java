/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="detalleInforme")
public class DetalleInforme implements Serializable{
    
    @Id @GeneratedValue
    private Long id;
    @Column(name="informeMedico")
    private String informeMedico;
    @OneToOne(fetch = FetchType.LAZY)
    private Informe informe;
    @Lob
    @Column(name="foto",nullable=true)
    private byte[] fotoPaciente;
    public DetalleInforme() {
    }

    public Long getId() {
        return id;
    }

    public String getInformeMedico() {
        return informeMedico;
    }

    public Informe getInforme() {
        return informe;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setInformeMedico(String informeMedico) {
        this.informeMedico = informeMedico;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public byte[] getFotoPaciente() {
        return fotoPaciente;
    }

    public void setFotoPaciente(byte[] fotoPaciente) {
        this.fotoPaciente = fotoPaciente;
    }
    
    
    
}
