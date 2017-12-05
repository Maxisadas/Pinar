/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Persistencia;

import DTO.DTOCriterio;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cyntia
 */
public class PruebaGenerarTablas {

    public static void main(String[] args) {

        //Con esto solamente refresco el modelo
        HibernateUtil.getSessionFactory().openSession();

        try {
            HibernateUtil.getSession().beginTransaction();
            
      
            

            
            
            
       
            
            HibernateUtil.getSession().getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al guardar empresa "+e.getMessage());
            
        }

    }
}
