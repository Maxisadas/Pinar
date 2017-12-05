/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOArea;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ExpertoABMArea {
    
     public boolean iniciarAlta(String nombreArea){
        
        Area areaExistente = (Area) HibernateUtil.getSession().createQuery("SELECT a FROM Area a WHERE a.nombreArea = :nombreArea").setParameter("nombreArea", nombreArea).uniqueResult();
        if(areaExistente == null){
            Area area = new Area();
            area.setNombreArea(nombreArea);
            FachadaInterna.getInstancia().guardar(area);
            return true;
        }else{
            
            return false;
        }
        
        
    }
    
    public boolean iniciarModificacion(Long idArea,String nombreArea){
       Area areaExistente = (Area) HibernateUtil.getSession().createQuery("SELECT a FROM Area a WHERE a.nombreArea = :nombreArea").setParameter("nombreArea", nombreArea).uniqueResult();
        if(areaExistente == null){
            Area area = (Area) HibernateUtil.getSession().createQuery("SELECT a FROM Area a WHERE id=" + idArea).uniqueResult();
            area.setNombreArea(nombreArea);
            FachadaInterna.getInstancia().guardar(area);
            return true;
        }else{
            return false;
            
        }
        
     
    }
    
    public boolean iniciarBaja(Long idArea){
        Personal persona = (Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.area.id=" + idArea).uniqueResult();
        
        if(persona == null){
        Area area = (Area) HibernateUtil.getSession().createQuery("SELECT a FROM Area a WHERE id=" + idArea).uniqueResult();    
        FachadaInterna.getInstancia().eliminar(area);
        return true;
        }else{
            
            return false;
        }
        
    }
    
    public List<DTOArea> buscar(){
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
    
}
