/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorGuardarFormularioEnfermeria;

import Controlador.DTO.DTOFormulario;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoFormularioEnfermeria;

/**
 *
 * @author Maxi
 */
public class ControladorFormularioEnfermeria {
    ExpertoFormularioEnfermeria experto = new ExpertoFormularioEnfermeria();
    
     public DTOFormulario buscar(Long idabuelo,Long idPersonal){
        FachadaInterna.getInstancia().iniciarTransaccion();
        return experto.buscar(idabuelo, idPersonal);
     }
     
     public boolean guardar(DTOFormulario dto){ 
         boolean exito = experto.guardar(dto);
         FachadaInterna.getInstancia().finalizarTransaccion();
         return exito;
     }
    
}
