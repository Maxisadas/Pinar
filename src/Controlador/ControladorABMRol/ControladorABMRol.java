/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorABMRol;

import Controlador.DTO.DTORol;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoABMRol;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladorABMRol {
    
    ExpertoABMRol experto = new ExpertoABMRol();
    
        public boolean iniciarAlta(String nombreRol){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarAlta(nombreRol);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
        }
        
        public boolean iniciarModificacion(Long idRol,String nombreRol){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarModificacion(idRol, nombreRol);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
        }
        
        public boolean iniciarBaja(Long idRol){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarBaja(idRol);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
            
        }
        
        public List<DTORol> buscar(){
            FachadaInterna.getInstancia().iniciarTransaccion();
            List<DTORol> listadtorol = experto.buscar();
            FachadaInterna.getInstancia().finalizarTransaccion();
            return listadtorol;
        }
    
        
    
    
}
