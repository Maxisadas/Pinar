/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Persistencia;

import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Lorenzo
 */
public class HibernateUtil{

    private static SessionFactory sessionFactory;
    private static HibernateUtil instancia;
    
    public static HibernateUtil getInstancia(){
        if(instancia==null){
            instancia = new HibernateUtil();
        }
        return instancia;
    }
    
    static{
        try{
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }catch (HibernateException ex){
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
   
    public HibernateUtil (){}

    private static SessionFactory buildSessionFactory (){
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory (){
        if (sessionFactory == null || sessionFactory.isClosed()){
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession (){
        if (sessionFactory == null || sessionFactory.isClosed()){
            sessionFactory = getSessionFactory();
        }
        try{
            return sessionFactory.getCurrentSession();
        }catch (NullPointerException e){
            return sessionFactory.openSession();
        }
    }
}
