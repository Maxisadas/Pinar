/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOAbuelo;
import Controlador.Persistencia.HibernateUtil;

/**
 *
 * @author User
 */
public class ExpertoBuscarAbuelo {
    public DTOAbuelo buscarPorDNI(String documento){
        if(documento!=null){
            Paciente paciente=(Paciente)HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.dni=:dni").setParameter("dni", documento).uniqueResult();
            if(paciente!=null){
                return Paciente.buildDTO(paciente);
            }
        }
        return null;
    }
}
