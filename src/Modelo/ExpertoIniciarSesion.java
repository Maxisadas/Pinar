/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Persistencia.HibernateUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;

/**
 *
 * @author Maxi
 */
public class ExpertoIniciarSesion {
    
    public static Long idLogueado;
    public boolean validarUsuario(String nombreUsuario, String password){
        String contraseñaEncriptada = DigestUtils.md5Hex(password);
        Query query = HibernateUtil.getSession().createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario= :nombreUsuario AND u.password= :password");
        query.setParameter("nombreUsuario", nombreUsuario);
        query.setParameter("password", contraseñaEncriptada);
        Usuario usuario = (Usuario) query.uniqueResult();
        if(usuario != null){
            return true;
        }else{
            return false;
        }
        
    }
    
    public Usuario loguear(String nombreUsuario){
        
        Usuario usuario = (Usuario) HibernateUtil.getSession().createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario").setParameter("nombreUsuario",nombreUsuario).uniqueResult();
        idLogueado=usuario.getId();
        return usuario;
    }
    
    public static Usuario getUsuarioLogueado(Long id){
        Usuario usuario = (Usuario) HibernateUtil.getSession().createQuery("SELECT u FROM Usuario u WHERE u.id = :id").setParameter("id",id).uniqueResult();
        return usuario;
    }
}
