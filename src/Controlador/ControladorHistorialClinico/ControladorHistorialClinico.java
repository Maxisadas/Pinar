/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorHistorialClinico;

import Controlador.DTO.DTODetalleInforme;
import Controlador.Persistencia.FachadaInterna;
import Modelo.DetalleInforme;
import Modelo.DetalleInforme.TipoInforme;
import Modelo.ExpertoHistorialClinico;
import java.util.List;

/**
 *
 * @author User
 */
public class ControladorHistorialClinico {
    ExpertoHistorialClinico experto=new ExpertoHistorialClinico();
    
    public List<DTODetalleInforme> buscarHistorialPorPaciente(Long idPaciente,TipoInforme tipoInforme){
            FachadaInterna.getInstancia().iniciarTransaccion();
            List<DTODetalleInforme> list = experto.buscarHistorialPorPaciente(idPaciente, tipoInforme);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return list;
        } 
    
}
