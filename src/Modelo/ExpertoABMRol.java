/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTORol;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ExpertoABMRol {
    
    public boolean iniciarAlta(String nombreRol){
        
        Rol rolexistente = (Rol) HibernateUtil.getSession().createQuery("SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol").setParameter("nombreRol", nombreRol).uniqueResult();
        if(rolexistente == null){
            Rol rol = new Rol();
            rol.setNombreRol(nombreRol);
            FachadaInterna.getInstancia().guardar(rol);
            return true;
        }else{
            
            return false;
        }
        
        
    }
    
    public boolean iniciarModificacion(Long idRol,String nombreRol){
        Rol rolexistente = (Rol) HibernateUtil.getSession().createQuery("SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol").setParameter("nombreRol", nombreRol).uniqueResult();
        if(rolexistente == null){
            Rol rolEncontrado = (Rol) HibernateUtil.getSession().createQuery("SELECT r FROM Rol r WHERE id=" + idRol).uniqueResult();
            rolEncontrado.setNombreRol(nombreRol);
            FachadaInterna.getInstancia().guardar(rolEncontrado);
            return true;
        }else{
            return false;
            
        }
        
     
    }
    
    public boolean iniciarBaja(Long idRol){
        Personal persona = (Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE p.rol.id=" + idRol).uniqueResult();
        
        if(persona == null){
        Rol rolEncontrado = (Rol) HibernateUtil.getSession().createQuery("SELECT r FROM Rol r WHERE id=" + idRol).uniqueResult();    
        FachadaInterna.getInstancia().eliminar(rolEncontrado);
        return true;
        }else{
            
            return false;
        }
        
    }
    
    public List<DTORol> buscar(){
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
    
}
