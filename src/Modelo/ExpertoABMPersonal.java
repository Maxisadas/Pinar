/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOArea;
import Controlador.DTO.DTOEspecializacion;
import Controlador.DTO.DTOPersonal;
import Controlador.DTO.DTORol;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ExpertoABMPersonal {
    
        public List<DTOPersonal> buscar(){
        List<Object> listaPersonal = HibernateUtil.getSession().createQuery("SELECT p FROM Personal p").list();
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
        public DTOPersonal buscar(Long idPersonal){
        Personal personalencontrado = (Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.id=:id").setParameter("id", idPersonal).uniqueResult();
        
        
            
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
            
        
        
        return dtoPersonal;
    }
        
        
            public List<DTORol> buscarRol(){
        List<Object> listaRol = HibernateUtil.getSession().createQuery("SELECT r FROM Rol r").list();
        List<DTORol> listadtorol = new ArrayList<>();
        for(Object rol : listaRol){
            Rol rolencontrado = (Rol) rol;
            DTORol dtoRol = new DTORol();
            dtoRol.setNombreRol(rolencontrado.getNombreRol());
            dtoRol.setIdRol(rolencontrado.getId());
            listadtorol.add(dtoRol);
        }
        
        return listadtorol;
    }
            
                public List<DTOEspecializacion> buscarEspecialidad(){
        List<Object> listaEspecialidad = HibernateUtil.getSession().createQuery("SELECT e FROM Especialidad e").list();
        List<DTOEspecializacion> listadtoEspecialidad = new ArrayList<>();
        for(Object especialidad : listaEspecialidad){
            Especialidad especialidadencontrado = (Especialidad) especialidad;
            DTOEspecializacion dtoEspecialidad = new DTOEspecializacion();
            dtoEspecialidad.setIdEspecializacion(especialidadencontrado.getId());
            dtoEspecialidad.setNombreEspecializacion(especialidadencontrado.getNombreEspecialidad());
            listadtoEspecialidad.add(dtoEspecialidad);
        }
        
        return listadtoEspecialidad;
    }
                
                    public List<DTOArea> buscarArea(){
        List<Object> listaArea = HibernateUtil.getSession().createQuery("SELECT a FROM Area a").list();
        List<DTOArea> listadtoArea = new ArrayList<>();
        for(Object area : listaArea){
            Area areaencontrado = (Area) area;
            DTOArea dtoArea = new DTOArea();
            dtoArea.setId(areaencontrado.getId());
            dtoArea.setNombreArea(areaencontrado.getNombreArea());
            listadtoArea.add(dtoArea);
        }
        
        return listadtoArea;
    }
                    
        public boolean iniciarAlta(DTOPersonal dtopersonal){
            Date fechaHoy = new Date();
             Personal personalExistente = (Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.dni = :dni").setParameter("dni", dtopersonal.getDni()).uniqueResult();
             if(personalExistente==null){
                 Personal personal = new Personal();
                 personal.setApellido(dtopersonal.getApellidoPersonal());
                 personal.setNombre(dtopersonal.getNombrePersonal());
                 personal.setDni(dtopersonal.getDni());
                 Area areaExistente = (Area) HibernateUtil.getSession().createQuery("SELECT a FROM Area a WHERE a.nombreArea = :nombreArea").setParameter("nombreArea", dtopersonal.getNombreArea()).uniqueResult();
                 personal.setArea(areaExistente);
                 Rol rolexistente = (Rol) HibernateUtil.getSession().createQuery("SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol").setParameter("nombreRol", dtopersonal.getNombreRol()).uniqueResult();
                 List<Especialidad> listaEspecialidad = new ArrayList<>();
                 for(DTOEspecializacion dtoespecialidad : dtopersonal.getListaEspecialidad()){
                     Especialidad especialidadExistente = (Especialidad) HibernateUtil.getSession().createQuery("SELECT e FROM Especialidad e WHERE e.nombreEspecialidad = :nombreEspecialidad").setParameter("nombreEspecialidad", dtoespecialidad.getNombreEspecializacion()).uniqueResult();
                     listaEspecialidad.add(especialidadExistente);
                 }
                 
                 personal.setEspecialidad(listaEspecialidad);
                 personal.setFechaAlta(fechaHoy);
                 personal.setFechaBaja(null);
                 personal.setRol(rolexistente);
                 FachadaInterna.getInstancia().guardar(personal);
                 
                 return true;
             }else{
                 
                 return false;
             }
            
            
            
        }
        
                public void iniciarModificar(DTOPersonal dtopersonal){
            Date fechaHoy = new Date();

                 Personal personal = (Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.id=" + dtopersonal.getId()).uniqueResult();
                 personal.setApellido(dtopersonal.getApellidoPersonal());
                 personal.setNombre(dtopersonal.getNombrePersonal());
                 personal.setDni(dtopersonal.getDni());
                 Area areaExistente = (Area) HibernateUtil.getSession().createQuery("SELECT a FROM Area a WHERE a.nombreArea = :nombreArea").setParameter("nombreArea", dtopersonal.getNombreArea()).uniqueResult();
                 personal.setArea(areaExistente);
                 Rol rolexistente = (Rol) HibernateUtil.getSession().createQuery("SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol").setParameter("nombreRol", dtopersonal.getNombreRol()).uniqueResult();
                 List<Especialidad> listaEspecialidad = new ArrayList<>();
                 for(DTOEspecializacion dtoespecialidad : dtopersonal.getListaEspecialidad()){
                     Especialidad especialidadExistente = (Especialidad) HibernateUtil.getSession().createQuery("SELECT e FROM Especialidad e WHERE e.nombreEspecialidad = :nombreEspecialidad").setParameter("nombreEspecialidad", dtoespecialidad.getNombreEspecializacion()).uniqueResult();
                     listaEspecialidad.add(especialidadExistente);
                 }
                 
                 personal.setEspecialidad(listaEspecialidad);
                 personal.setFechaAlta(fechaHoy);
                 personal.setFechaBaja(null);
                 personal.setRol(rolexistente);
                 FachadaInterna.getInstancia().guardar(personal);
                 
            
            
            
            
        }
        
            public boolean iniciarBaja(Long idPersonal){
                    try{
                     Date fechaHoy = new Date();
                     Personal persona = (Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.id=" + idPersonal).uniqueResult();
                     persona.setFechaBaja(fechaHoy);
                     FachadaInterna.getInstancia().guardar(persona);
                     return true;
                    }catch(Exception e){
                        return false;
                    }
           }
                 
                 
            public boolean darAltaNuevamente(Long idPersonal){
                try{
                     Date fechaHoy = new Date();
                     Personal persona = (Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.id=" + idPersonal).uniqueResult();
                     persona.setFechaAlta(fechaHoy);
                     persona.setFechaBaja(null);
                     FachadaInterna.getInstancia().guardar(persona);    
                    return true;
                    
                    
                }catch(Exception e){
                    
                    return false;
                }
                
                
            }
    
}
