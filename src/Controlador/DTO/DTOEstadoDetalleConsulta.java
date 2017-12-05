/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DTO;

/**
 *
 * @author User
 */
public class DTOEstadoDetalleConsulta {
    
    private Long id;
    private String nombre;

    public DTOEstadoDetalleConsulta() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
