/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorABMEstadoDetalleConsulta;

import Controlador.DTO.DTOEstadoConsulta;
import Controlador.DTO.DTOEstadoDetalleConsulta;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoEstadoDetalleConsulta;
import java.util.List;

/**
 *
 * @author User
 */
public class ControladorABMEstadoDetalleConsulta {
    
    ExpertoEstadoDetalleConsulta experto = new ExpertoEstadoDetalleConsulta();
    
        public boolean iniciarAlta(String nombre){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarAlta(nombre);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
        }
        
        public boolean iniciarModificacion(Long id,String nombre){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarModificacion(id, nombre);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
        }
        
        public boolean iniciarBaja(Long id){
            FachadaInterna.getInstancia().iniciarTransaccion();
            boolean exito = experto.iniciarBaja(id);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
            
        }
        
        public List<DTOEstadoDetalleConsulta> buscar(){
            FachadaInterna.getInstancia().iniciarTransaccion();
            List<DTOEstadoDetalleConsulta> listadto = experto.buscar();
            FachadaInterna.getInstancia().finalizarTransaccion();
            return listadto;
        }
}
