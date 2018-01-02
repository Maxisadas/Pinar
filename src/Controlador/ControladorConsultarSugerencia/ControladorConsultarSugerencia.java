/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorConsultarSugerencia;

import Controlador.DTO.DTOConsulta;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoConsultarSugerencia;
import Modelo.Personal;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladorConsultarSugerencia {
    
    ExpertoConsultarSugerencia experto = new ExpertoConsultarSugerencia();
    
    public List<DTOConsulta> verificarSugerencias(Personal personal){
        FachadaInterna.getInstancia().iniciarTransaccion();
        List<DTOConsulta> listdto = experto.verificarSugerencias(personal);
        FachadaInterna.getInstancia().finalizarTransaccion();
        return listdto;
    }
    
    public void visto(DTOConsulta dto){
        FachadaInterna.getInstancia().iniciarTransaccion();
        experto.visto(dto);
        FachadaInterna.getInstancia().finalizarTransaccion();
    }
    
}
