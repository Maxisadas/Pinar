/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorCalendario;

import Controlador.Persistencia.FachadaInterna;
import Modelo.Evento;
import Modelo.ExpertoCalendario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladorCalendario {
    ExpertoCalendario experto = new ExpertoCalendario();
    
    public boolean organizarEvento(String mensaje, Date fechaElejida){
        FachadaInterna.getInstancia().iniciarTransaccion();
        boolean exito = experto.organizarEvento(mensaje, fechaElejida);
        FachadaInterna.getInstancia().finalizarTransaccion();
        return exito;
        
    }
    
    public List<Evento> consultarEvento(){
        return experto.consultarEvento();
    }
    
    
    
    
}
