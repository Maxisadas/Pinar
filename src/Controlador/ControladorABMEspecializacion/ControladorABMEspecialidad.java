/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorABMEspecializacion;

import Controlador.DTO.DTOEspecializacion;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoABMEspecialidad;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladorABMEspecialidad {
    
        ExpertoABMEspecialidad experto = new ExpertoABMEspecialidad();
    
        public boolean iniciarAlta(String nombreEspecialidad){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarAlta(nombreEspecialidad);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
        }
        
        public boolean iniciarModificacion(Long idEspecialidad,String nombreEspecialidad){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarModificacion(idEspecialidad, nombreEspecialidad);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
        }
        
        public boolean iniciarBaja(Long idEspecialidad){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarBaja(idEspecialidad);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
            
        }
        
        public List<DTOEspecializacion> buscar(){
            FachadaInterna.getInstancia().iniciarTransaccion();
            List<DTOEspecializacion> listadtoespecialidad = experto.buscar();
            FachadaInterna.getInstancia().finalizarTransaccion();
            return listadtoespecialidad;
        }
    
}
