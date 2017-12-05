/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import DTO.DTOCriterio;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;


/**
 *
 * @author Maxi
 */
public class ExpertoRegistrarUsuario {
    
    public boolean verificarPersonal(String dniPersonal){
        
        Personal personal =(Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE dni=" + dniPersonal).uniqueResult();
        
        if(personal != null){
        return true;    
            
            
        }else{
            return false;
        }
        
        
        
    }
    
        public boolean inciarAlta(String nombreUsuario, String password, String dniPersonal){
        
        String contraseñaEncriptada = DigestUtils.md5Hex(password);
        
        Usuario usuarioExistente = (Usuario) HibernateUtil.getSession().createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario").setParameter("nombreUsuario",nombreUsuario).uniqueResult();
        if(usuarioExistente != null){
            return false;
        }else{
            Personal personal =(Personal) HibernateUtil.getSession().createQuery("SELECT p FROM Personal p WHERE dni=" + dniPersonal).uniqueResult();
            Date fechaHoy = new Date();
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(nombreUsuario);
            usuario.setPassword(contraseñaEncriptada);
            usuario.setFechaAlta(fechaHoy);
            usuario.setFechaBaja(null);
            usuario.setPersonal(personal);
            FachadaInterna.getInstancia().guardar(usuario);
            return true;  
            
        }
        
        
        
        
        
        
        
      
    }
    
    
    
}
