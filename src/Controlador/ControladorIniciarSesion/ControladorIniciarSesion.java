/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorIniciarSesion;

import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoIniciarSesion;
import Modelo.Usuario;

/**
 *
 * @author Maxi
 */
public class ControladorIniciarSesion {
    ExpertoIniciarSesion experto = new ExpertoIniciarSesion();
     public boolean validarUsuario(String nombreUsuario, String password){
         FachadaInterna.getInstancia().iniciarTransaccion();
         return experto.validarUsuario(nombreUsuario, password);
     }
     
     public Usuario loguear(String nombreUsuario){
         Usuario usuario = experto.loguear(nombreUsuario);
       
         return usuario;
     }
    
}
