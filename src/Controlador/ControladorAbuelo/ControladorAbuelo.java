/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ControladorAbuelo;

import Controlador.DTO.DTOAbuelo;
import Controlador.Persistencia.FachadaInterna;
import Modelo.ExpertoBuscarAbuelo;
import java.util.List;

/**
 *
 * @author User
 */
public class ControladorAbuelo {
    ExpertoBuscarAbuelo experto=new ExpertoBuscarAbuelo();
    
    public DTOAbuelo buscarPorDNI(String documento){
            FachadaInterna.getInstancia().iniciarTransaccion();
            DTOAbuelo dto = experto.buscarPorDNI(documento);
            FachadaInterna.getInstancia().finalizarTransaccion();
            return dto;
        }
    
}
