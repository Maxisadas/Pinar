/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DTO;

/**
 *
 * @author Maxi
 */
public class DTOEspecializacion {
    
    private Long idEspecializacion;

    public Long getIdEspecializacion() {
        return idEspecializacion;
    }

    public void setIdEspecializacion(Long idEspecializacion) {
        this.idEspecializacion = idEspecializacion;
    }

    public String getNombreEspecializacion() {
        return nombreEspecializacion;
    }

    public void setNombreEspecializacion(String nombreEspecializacion) {
        this.nombreEspecializacion = nombreEspecializacion;
    }
    private String nombreEspecializacion;
    
}
