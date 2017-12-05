/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOEstadoConsulta;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ExpertoEstadoConsulta {
    public boolean iniciarAlta(String nombreEstadoConsulta){
        
        EstadoConsulta estadoExistente = (EstadoConsulta) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoConsulta e WHERE e.nombre = :nombreEstadoConsulta").setParameter("nombreEstadoConsulta", nombreEstadoConsulta).uniqueResult();
        if(estadoExistente == null){
            EstadoConsulta estado=new EstadoConsulta();
            estado.setNombre(nombreEstadoConsulta);
            FachadaInterna.getInstancia().guardar(estado);
            return true;
        }else{
            
            return false;
        }
        
        
    }
    
    public boolean iniciarModificacion(Long idEstado,String nombreEstadoConsulta){
        EstadoConsulta estadoExistente = (EstadoConsulta) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoConsulta e WHERE e.nombre = :nombreEstadoConsulta").setParameter("nombreEstadoConsulta", nombreEstadoConsulta).uniqueResult();
        if(estadoExistente == null){
            EstadoConsulta estadoEncontrado = (EstadoConsulta) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoConsulta e WHERE id= :id").setParameter("id", idEstado).uniqueResult();
            estadoEncontrado.setNombre(nombreEstadoConsulta);
            FachadaInterna.getInstancia().guardar(estadoEncontrado);
            return true;
        }else{
            return false;
            
        }
        
     
    }
    
    public boolean iniciarBaja(Long idEstado){
        Consulta consulta= (Consulta) HibernateUtil.getSession().createQuery("SELECT c FROM Consulta c WHERE c.estadoConsulta.id=:id").setParameter("id",idEstado).uniqueResult();
        
        if(consulta == null){
        EstadoConsulta estadoEncontrado = (EstadoConsulta) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoConsulta e WHERE e.id=:id ").setParameter("id", idEstado).uniqueResult();    
        FachadaInterna.getInstancia().eliminar(estadoEncontrado);
        return true;
        }else{
            
            return false;
        }
        
    }
    
    public List<DTOEstadoConsulta> buscar(){
        List<Object> lista = HibernateUtil.getSession().createQuery("SELECT e FROM EstadoConsulta e").list();
        List<DTOEstadoConsulta> listadtoestado = new ArrayList<>();
        for(Object estado : lista){
            EstadoConsulta estadoencontrado = (EstadoConsulta) estado;
            DTOEstadoConsulta dto=new DTOEstadoConsulta();
            dto.setNombre(estadoencontrado.getNombre());
            dto.setIdEstado(estadoencontrado.getId());
            listadtoestado.add(dto);
        }
        
        return listadtoestado;
    }
}
