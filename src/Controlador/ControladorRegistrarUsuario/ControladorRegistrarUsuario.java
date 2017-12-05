/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorRegistrarUsuario;

import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import Modelo.ExpertoRegistrarUsuario;
import Modelo.Usuario;


/**
 *
 * @author Maxi
 */
public class ControladorRegistrarUsuario {
    ExpertoRegistrarUsuario experto = new ExpertoRegistrarUsuario();
    
    public boolean verificarPersonal(String dniPersonal){
    FachadaInterna.getInstancia().iniciarTransaccion();
        return experto.verificarPersonal(dniPersonal);
        
    }
    
    public boolean inciarAlta(String nombreUsuario, String password, String dniPersonal){
        
        boolean exito = experto.inciarAlta(nombreUsuario, password, dniPersonal);
        if(exito){
            FachadaInterna.getInstancia().finalizarTransaccion();
            return exito;
        }else{
            return exito;
        }
    }
    
    
}
