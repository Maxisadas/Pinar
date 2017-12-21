/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOConsulta;
import Controlador.DTO.DTOEspecializacion;
import Controlador.DTO.DTOPersonal;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ExpertoRealizarSugerencia {
    
    
    public List<DTOPersonal> buscar(Long idPersonal){
        List<Object> listaPersonal = HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.id <> :id AND p.fechaBaja=" + null).setParameter("id", idPersonal).list();
        List<DTOPersonal> listadtoPersonal = new ArrayList<>();
        for(Object personal : listaPersonal){
            Personal personalencontrado = (Personal) personal;
            DTOPersonal dtoPersonal = new DTOPersonal();
            dtoPersonal.setId(personalencontrado.getId());
            dtoPersonal.setApellidoPersonal(personalencontrado.getApellido());
            dtoPersonal.setNombrePersonal(personalencontrado.getNombre());
            dtoPersonal.setDni(personalencontrado.getDni());
            dtoPersonal.setFechaAlta(personalencontrado.getFechaAlta());
            dtoPersonal.setFechaBaja(personalencontrado.getFechaBaja());
            dtoPersonal.setNombreArea(personalencontrado.getArea().getNombreArea());
            dtoPersonal.setNombreRol(personalencontrado.getRol().getNombreRol());
            
            List<DTOEspecializacion> listadtoEspecialidad = new ArrayList<>();
            for(Especialidad especialidad:personalencontrado.getEspecialidad()){
                DTOEspecializacion dtoespe = new DTOEspecializacion();
                dtoespe.setIdEspecializacion(especialidad.getId());
                dtoespe.setNombreEspecializacion(especialidad.getNombreEspecialidad());
                listadtoEspecialidad.add(dtoespe);
            }
            dtoPersonal.setListaEspecialidad(listadtoEspecialidad);
            listadtoPersonal.add(dtoPersonal);
        }
        
        return listadtoPersonal;
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
    
    
    public boolean realizarConsulta(List<DTOConsulta> listdto,String nombrePersonalEnvia,String areaEnviada){
        try{
        for(Object o : listdto){
        DTOConsulta dto = (DTOConsulta) o;    
        Date fechaHoy = new Date();
        Consulta consulta = new Consulta();
        DetalleConsulta detalle = new DetalleConsulta();
        TipoPrioridad tipoPrioridad = (TipoPrioridad) HibernateUtil.getSession().createQuery("SELECT t FROM TipoPrioridad t WHERE t.nombre=:nombre").setParameter("nombre", dto.getPrioridad()).uniqueResult();
        Personal personal = (Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.nombre=:nombre").setParameter("nombre", dto.getNombreProfesional()).uniqueResult();
        detalle.setTipoPrioridad(tipoPrioridad);
        detalle.setDetalleConsulta(dto.getDetalleConsulta());
        consulta.setDetalleConsulta(detalle);
        consulta.setFechaElaboracionConsulta(fechaHoy);
        consulta.setVisto(false);
        consulta.setPersonal(personal);
        consulta.setAreaEnviada(areaEnviada);
        consulta.setNombrePersonalEnvia(nombrePersonalEnvia);
        FachadaInterna.getInstancia().guardar(detalle);  
        FachadaInterna.getInstancia().guardar(consulta);    
        }    

        return true;
        }catch(Exception e){
           return false; 
        }
        
        
        
        
    }
    
        public boolean realizarConsulta(DTOConsulta dto,String nombrePersonalEnvia,Long idPersonal,String areaEnviada){
        try{
        
        Date fechaHoy = new Date();
        DetalleConsulta detalle = new DetalleConsulta();
        TipoPrioridad tipoPrioridad = (TipoPrioridad) HibernateUtil.getSession().createQuery("SELECT t FROM TipoPrioridad t WHERE t.nombre=:nombre").setParameter("nombre", dto.getPrioridad()).uniqueResult();
        List<Object> listPersonal = HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.id <>" +idPersonal).list();
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
        FachadaInterna.getInstancia().guardar(detalle);  
        FachadaInterna.getInstancia().guardar(consulta);
        }
            

        return true;
        }catch(Exception e){
           return false; 
        }
        
        
        
        
    }
    
}
