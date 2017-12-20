/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorRealizarSugerencia;

import Controlador.DTO.DTOConsulta;
import Controlador.DTO.DTOPersonal;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoRealizarSugerencia;
import Modelo.TipoPrioridad;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladorRealizarSugerencia {
    
    ExpertoRealizarSugerencia experto = new ExpertoRealizarSugerencia();
    
    public List<DTOPersonal> buscar(Long idPersonal){
        FachadaInterna.getInstancia().iniciarTransaccion();
        return experto.buscar(idPersonal);
        
        
    }
    
    public List<TipoPrioridad> buscarPrioridad(){
        List<TipoPrioridad> lista = experto.buscarPrioridad();
        return lista;
    }
    
    public boolean realizarConsulta(List<DTOConsulta> dto,String nombrePersonalEnvia){
        boolean exito = experto.realizarConsulta(dto,nombrePersonalEnvia);
        FachadaInterna.getInstancia().finalizarTransaccion();
        return exito;
    }
    
    public boolean realizarConsulta(DTOConsulta dto,String nombrePersonalEnvia){
        boolean exito = experto.realizarConsulta(dto, nombrePersonalEnvia);
        FachadaInterna.getInstancia().finalizarTransaccion();
        return exito;
    }
    
}
