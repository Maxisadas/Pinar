/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOFormulario;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.util.Date;

/**
 *
 * @author Maxi
 */
public class ExpertoFormularioEnfermeria {
    
    public DTOFormulario buscar(Long idabuelo,Long idPersonal){
        Personal personal = (Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.id=" + idPersonal).uniqueResult();
        Paciente paciente = (Paciente) HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.id=" + idabuelo).uniqueResult();
        DTOFormulario dto = new DTOFormulario();
        dto.setNombreArea(personal.getArea().getNombreArea());
        dto.setNombreApellidoPaciente(paciente.getNombre() + " " + paciente.getApellido());
        return dto;
    }
    
    public boolean guardar(DTOFormulario dto){ 
            if(!dto.getInformetext().isEmpty()){
            Personal personal = (Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.id=" + dto.getIdPersonal()).uniqueResult();
            Paciente abuelo=(Paciente)HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.id=:id").setParameter("id", dto.getIdAbuelo()).uniqueResult();
            HistorialClinico historial=(HistorialClinico)HibernateUtil.getSession().createQuery("SELECT h FROM HistorialClinico h WHERE h.paciente.id=:id").setParameter("id", dto.getIdAbuelo()).uniqueResult();
            Informe informe=new Informe();
            informe.setFechaElaboracion(new Date());
            informe.setPaciente(abuelo);
            informe.setPersonal(personal);
            informe.setHistorialClinico(historial);
            DetalleInforme informeAv= new DetalleInforme();
            informeAv.setTipoInforme(DetalleInforme.TipoInforme.AVANZADO);
            informeAv.setInforme(informe);
            informeAv.setInformeMedico(dto.getInformetext());
            FachadaInterna.getInstancia().guardar(informeAv);
            FachadaInterna.getInstancia().guardar(informe);
                return true;
        } 
        return false;

    }
    
}
