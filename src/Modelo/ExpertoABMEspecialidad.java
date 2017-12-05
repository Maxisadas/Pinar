/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOEspecializacion;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ExpertoABMEspecialidad {
    
    
    public boolean iniciarAlta(String nombreEspecialidad){
        
        Especialidad especialidadExistente = (Especialidad) HibernateUtil.getSession().createQuery("SELECT e FROM Especialidad e WHERE e.nombreEspecialidad = :nombreEspecialidad").setParameter("nombreEspecialidad", nombreEspecialidad).uniqueResult();
        if(especialidadExistente == null){
            Especialidad especialidad = new Especialidad();
            especialidad.setNombreEspecialidad(nombreEspecialidad);
            FachadaInterna.getInstancia().guardar(especialidad);
            return true;
        }else{
            
            return false;
        }
        
        
    }
    
    public boolean iniciarModificacion(Long idEspecialidad,String nombreEspecialidad){
        Especialidad especialidadExistente = (Especialidad) HibernateUtil.getSession().createQuery("SELECT e FROM Especialidad e WHERE e.nombreEspecialidad = :nombreEspecialidad").setParameter("nombreEspecialidad", nombreEspecialidad).uniqueResult();
        if(especialidadExistente == null){
            Especialidad especialidad = (Especialidad) HibernateUtil.getSession().createQuery("SELECT e FROM Especialidad e WHERE id=" + idEspecialidad).uniqueResult();
            especialidad.setNombreEspecialidad(nombreEspecialidad);
            FachadaInterna.getInstancia().guardar(especialidad);
            return true;
        }else{
            return false;
            
        }
        
     
    }
    
    public boolean iniciarBaja(Long idEspecialidad){
        Rol rol = (Rol) HibernateUtil.getSession().createQuery("SELECT r FROM Rol r JOIN r.listespecialidad e WHERE e.id=" + idEspecialidad).uniqueResult();
        
        if(rol == null){
        Especialidad especialidad = (Especialidad) HibernateUtil.getSession().createQuery("SELECT e FROM Especialidad e WHERE id=" + idEspecialidad).uniqueResult();    
        FachadaInterna.getInstancia().eliminar(especialidad);
        return true;
        }else{
            
            return false;
        }
        
    }
    
    public List<DTOEspecializacion> buscar(){
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
    
}
