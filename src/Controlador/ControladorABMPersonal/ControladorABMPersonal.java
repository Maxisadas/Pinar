/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorABMPersonal;

import Controlador.DTO.DTOArea;
import Controlador.DTO.DTOEspecializacion;
import Controlador.DTO.DTOPersonal;
import Controlador.DTO.DTORol;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoABMPersonal;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladorABMPersonal {
    ExpertoABMPersonal experto = new ExpertoABMPersonal();
    public List<DTOPersonal> buscar(){
        FachadaInterna.getInstancia().iniciarTransaccion();
        List<DTOPersonal> lista = experto.buscar();
        FachadaInterna.getInstancia().finalizarTransaccion();
        return lista;
        
    }
    
    public List<DTORol> buscarRol(){
        FachadaInterna.getInstancia().iniciarTransaccion();
        return experto.buscarRol();
        
    }
    
    public List<DTOEspecializacion> buscarEspecialidad(){
         FachadaInterna.getInstancia().iniciarTransaccion();
        return experto.buscarEspecialidad();
    }
    
    public List<DTOArea> buscarArea(){
         FachadaInterna.getInstancia().iniciarTransaccion();
        return experto.buscarArea();
    }
    
    public DTOPersonal buscar(Long idPersonal){
        FachadaInterna.getInstancia().iniciarTransaccion();
        DTOPersonal personal = experto.buscar(idPersonal);
        FachadaInterna.getInstancia().finalizarTransaccion();
        return personal;
        
    }
    
    public boolean iniciarAlta(DTOPersonal dtopersonal){
        boolean exito = experto.iniciarAlta(dtopersonal);
        FachadaInterna.getInstancia().finalizarTransaccion();
        return exito;
    }
    
    public void iniciarModificar(DTOPersonal dtopersonal){
        experto.iniciarModificar(dtopersonal);
        FachadaInterna.getInstancia().finalizarTransaccion();
        
    }
    
    public boolean iniciarBaja(Long idPersonal){
       FachadaInterna.getInstancia().iniciarTransaccion();
       boolean exito = experto.iniciarBaja(idPersonal);
       FachadaInterna.getInstancia().finalizarTransaccion();
       return exito;
        
    }
    
    public boolean darAltaNuevamente(Long idPersonal){
        FachadaInterna.getInstancia().iniciarTransaccion();
        boolean exito = experto.darAltaNuevamente(idPersonal);
        FachadaInterna.getInstancia().finalizarTransaccion();
        return exito;
        
    }
    
    
    
}
