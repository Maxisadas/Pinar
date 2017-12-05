/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorABMArea;

import Controlador.DTO.DTOArea;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoABMArea;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladorABMArea {
    
    ExpertoABMArea experto = new ExpertoABMArea();
    
    public boolean iniciarAlta(String nombreArea){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarAlta(nombreArea);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
        }
        
        public boolean iniciarModificacion(Long idArea,String nombreArea){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarModificacion(idArea, nombreArea);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
        }
        
        public boolean iniciarBaja(Long idArea){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarBaja(idArea);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
            
        }
        
        public List<DTOArea> buscar(){
            FachadaInterna.getInstancia().iniciarTransaccion();
            List<DTOArea> listadtoespecialidad = experto.buscar();
            FachadaInterna.getInstancia().finalizarTransaccion();
            return listadtoespecialidad;
        }
    
}
