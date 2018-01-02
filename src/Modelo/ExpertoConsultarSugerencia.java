/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOConsulta;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Maxi
 */
public class ExpertoConsultarSugerencia {
    
    public List<DTOConsulta> verificarSugerencias(Personal personal){
        try{
            List listaConsultasDetectada = HibernateUtil.getSession().createQuery("SELECT c FROM Consulta c INNER JOIN c.personal AS personal WHERE personal.id=" + personal.getId()).list();
            List<DTOConsulta> listdto = new ArrayList<>();
        for(Object o : listaConsultasDetectada){
            Consulta consulta = (Consulta) o;
            DTOConsulta dto = new DTOConsulta();
            dto.setDetalleConsulta(consulta.getDetalleConsulta().getDetalleConsulta());
            dto.setNombreArea(consulta.getAreaEnviada());
            dto.setNombreProfesional(consulta.getNombrePersonalEnvia());
            dto.setNumeroConsulta(consulta.getId());
            dto.setPrioridad(consulta.getDetalleConsulta().getTipoPrioridad().getNombre());
            dto.setVisto(consulta.isVisto());
            dto.setFechaCreacion(consulta.getFechaElaboracionConsulta());
            if(consulta.getPaciente() != null){
                dto.setIdAbuelo(consulta.getPaciente().getId());
                dto.setFoto(consulta.getPaciente().getFotoPaciente());
                
            }
            if(consulta.getNombreabuelo() != null){
                dto.setNombreAbuelo(consulta.getNombreabuelo());
            }
            
            listdto.add(dto);
        }
        
        
        return listdto;
        }catch(Exception e){
            System.out.println(e);
            return null;

        }
        
        

    }
    
    public void visto(DTOConsulta dto){
        Consulta consulta = (Consulta) HibernateUtil.getSession().createQuery("SELECT c FROM Consulta c WHERE c.id="+dto.getNumeroConsulta()).uniqueResult();
        consulta.setVisto(true);
        FachadaInterna.getInstancia().guardar(consulta);
    }
    
    
}
