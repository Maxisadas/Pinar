/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ExpertoCalendario {
    
    public boolean organizarEvento(String mensaje, Date fechaElejida){
        Date fechaHoy = new Date();
       if(fechaElejida.getYear() > fechaHoy.getYear()){
        Evento evento = new Evento();
        evento.setFechaAsignada(fechaElejida);
        evento.setMensaje(mensaje);
        FachadaInterna.getInstancia().guardar(evento);
        return true;
           
       }else{
         if(fechaElejida.getYear()== fechaHoy.getYear()){
             if(fechaElejida.getMonth()> fechaHoy.getMonth()){
               Evento evento = new Evento();
               evento.setFechaAsignada(fechaElejida);
               evento.setMensaje(mensaje);
               FachadaInterna.getInstancia().guardar(evento);
               return true;
                 
             }else{
                if(fechaElejida.getMonth()== fechaHoy.getMonth()){
                  if(fechaElejida.getDate() >= fechaHoy.getDate()){
                      Evento evento = new Evento();
                      evento.setFechaAsignada(fechaElejida);
                      evento.setMensaje(mensaje);
                      FachadaInterna.getInstancia().guardar(evento);
                      return true;
                  }else{
                      return false;
                  }  
                    
                }else{
                 return false;
                } 
                 
             }
             
         }
             
         return false; 
    
       }
    }
    
    public List<Evento> consultarEvento(){
       
        List listaEventos = HibernateUtil.getSession().createQuery("SELECT e FROM Evento e").list();
        List<Evento> lista = new ArrayList<>();
        for(Object o : listaEventos){
        Evento evento = (Evento) o;
        lista.add(evento);
        }
        return lista;
    }
    
}
