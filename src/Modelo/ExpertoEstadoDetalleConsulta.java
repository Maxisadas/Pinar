/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOEstadoDetalleConsulta;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ExpertoEstadoDetalleConsulta {
    public boolean iniciarAlta(String nombreEstado){
        
        EstadoDetalleConsulta estadoExistente = (EstadoDetalleConsulta) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoDetalleConsulta e WHERE e.nombre = :nombreEstado").setParameter("nombreEstado", nombreEstado).uniqueResult();
        if(estadoExistente == null){
            EstadoDetalleConsulta estado=new EstadoDetalleConsulta();
            estado.setNombre(nombreEstado);
            FachadaInterna.getInstancia().guardar(estado);
            return true;
        }else{
            
            return false;
        }
        
        
    }
    
    public boolean iniciarModificacion(Long idEstado,String nombreEstado){
        EstadoDetalleConsulta estadoExistente = (EstadoDetalleConsulta) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoDetalleConsulta e WHERE e.nombre = :nombreEstado").setParameter("nombreEstado", nombreEstado).uniqueResult();
        if(estadoExistente == null){
            EstadoDetalleConsulta estadoEncontrado = (EstadoDetalleConsulta) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoDetalleConsulta e WHERE e.id= :id").setParameter("id", idEstado).uniqueResult();
            estadoEncontrado.setNombre(nombreEstado);
            FachadaInterna.getInstancia().guardar(estadoEncontrado);
            return true;
        }else{
            return false;
            
        }
        
     
    }
    
    public boolean iniciarBaja(Long idEstado){
        DetalleConsultaEstado detalle= (DetalleConsultaEstado) HibernateUtil.getSession().createQuery("SELECT c FROM DetalleConsultaEstado c WHERE c.estadoDetalleConsulta.id=:id").setParameter("id",idEstado).uniqueResult();
        
        if(detalle == null){
        EstadoDetalleConsulta estadoEncontrado = (EstadoDetalleConsulta) HibernateUtil.getSession().createQuery("SELECT e FROM EstadoDetalleConsulta e WHERE e.id=:id ").setParameter("id", idEstado).uniqueResult();    
        FachadaInterna.getInstancia().eliminar(estadoEncontrado);
        return true;
        }else{
            
            return false;
        }
        
    }
    
    public List<DTOEstadoDetalleConsulta> buscar(){
        List<Object> lista = HibernateUtil.getSession().createQuery("SELECT e FROM EstadoDetalleConsulta e").list();
        List<DTOEstadoDetalleConsulta> listadtoestado = new ArrayList<>();
        for(Object estado : lista){
            EstadoDetalleConsulta estadoencontrado = (EstadoDetalleConsulta) estado;
            DTOEstadoDetalleConsulta dto=new DTOEstadoDetalleConsulta();
            dto.setNombre(estadoencontrado.getNombre());
            dto.setId(estadoencontrado.getId());
            listadtoestado.add(dto);
        }
        
        return listadtoestado;
    }
}
