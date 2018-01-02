/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorEnviarNotificacion;

import Controlador.DTO.DTOAbuelo;
import Controlador.DTO.DTOConsulta;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoEnviarNotificacion;
import Modelo.TipoPrioridad;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladorEnviarNotificacion {
    
    ExpertoEnviarNotificacion experto = new ExpertoEnviarNotificacion();
    
    public List<DTOAbuelo> buscar(){
        FachadaInterna.getInstancia().iniciarTransaccion();
        return experto.buscar();
        
    }
    
    public List<TipoPrioridad> buscarPrioridad(){
        FachadaInterna.getInstancia().iniciarTransaccion();
        return experto.buscarPrioridad();
    }
    
    public boolean realizarConsulta(DTOConsulta dto,String nombrePersonalEnvia,Long idPersonal,String areaEnviada){
        FachadaInterna.getInstancia().iniciarTransaccion();
        boolean exito = experto.realizarConsulta(dto, nombrePersonalEnvia, idPersonal, areaEnviada);
        FachadaInterna.getInstancia().finalizarTransaccion();
        return exito;
    }
    
}
