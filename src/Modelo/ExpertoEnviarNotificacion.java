/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOAbuelo;
import Controlador.DTO.DTOConsulta;
import Controlador.DTO.DTOEspecializacion;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ExpertoEnviarNotificacion {
    
        public List<DTOAbuelo> buscar(){
        List<Object> listaAbuelo = HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.fechaBaja=" + null).list();
        List<DTOAbuelo> listadtoAbuelo = new ArrayList<>();
        for(Object abuelo : listaAbuelo){
            Paciente abueloencontrado = (Paciente) abuelo;
            DTOAbuelo dto = Paciente.buildDTO(abueloencontrado);
            listadtoAbuelo.add(dto);
            
        }
        
        return listadtoAbuelo;
    }
        
            public List<TipoPrioridad> buscarPrioridad(){
        List<Object> listaPrioridadEncontrada = HibernateUtil.getSession().createQuery("SELECT p FROM TipoPrioridad p ORDER BY p.nombre DESC").list();
        List<TipoPrioridad> listaPrioridad = new ArrayList<>();
        for(Object o : listaPrioridadEncontrada){
            TipoPrioridad tp = (TipoPrioridad) o;
            listaPrioridad.add(tp);
            
        }
        
        return listaPrioridad;
        
        
    }
    
     public boolean realizarConsulta(DTOConsulta dto,String nombrePersonalEnvia,Long idPersonal,String areaEnviada){
        try{
        
        Date fechaHoy = new Date();
        DetalleConsulta detalle = new DetalleConsulta();
        TipoPrioridad tipoPrioridad = (TipoPrioridad) HibernateUtil.getSession().createQuery("SELECT t FROM TipoPrioridad t WHERE t.nombre=:nombre").setParameter("nombre", dto.getPrioridad()).uniqueResult();
        List<Object> listPersonal = HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.id <>" +idPersonal).list();
        Paciente paciente = (Paciente) HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.id = :id").setParameter("id", dto.getIdAbuelo()).uniqueResult();
        for(Object x : listPersonal){
        Personal personal = (Personal) x;   
        Consulta consulta = new Consulta();
        detalle.setTipoPrioridad(tipoPrioridad);
        detalle.setDetalleConsulta(dto.getDetalleConsulta());
        consulta.setDetalleConsulta(detalle);
        consulta.setFechaElaboracionConsulta(fechaHoy);
        consulta.setVisto(false);
        consulta.setPersonal(personal);
        consulta.setAreaEnviada(areaEnviada);
        consulta.setNombrePersonalEnvia(nombrePersonalEnvia);
        consulta.setNombreabuelo(paciente.getNombre() + " " + paciente.getApellido());
        consulta.setPaciente(paciente);
        FachadaInterna.getInstancia().guardar(detalle);  
        FachadaInterna.getInstancia().guardar(consulta);
        }
            

        return true;
        }catch(Exception e){
           return false; 
        }
        
        
        
        
    }
    
    
}
