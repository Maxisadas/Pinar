/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorGuardarFormulario;

import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoGestionFormulario;

/**
 *
 * @author User
 */
public class ControladorGestionFormulario {
    ExpertoGestionFormulario experto=new ExpertoGestionFormulario();
    
    public boolean guardarFormulario(String nombreArea,String informeBasico,String informeAvanzado,String foto,String foto1,Long idPaciente){
        FachadaInterna.getInstancia().iniciarTransaccion();
        boolean resultado=experto.guardar(nombreArea, informeAvanzado, informeBasico,foto,foto1, idPaciente);
        FachadaInterna.getInstancia().finalizarTransaccion();
        return resultado;
    }
}
