/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTODetalleInforme;
import Controlador.Persistencia.HibernateUtil;
import Modelo.DetalleInforme.TipoInforme;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ExpertoHistorialClinico {
    public List<DTODetalleInforme> buscarHistorialPorPaciente(Long idPaciente,TipoInforme tipoInforme){
        HistorialClinico historialClinico=(HistorialClinico) HibernateUtil.getSession().createQuery("SELECT h FROM HistorialClinico h WHERE "
                + "h.paciente.id=:idPaciente ").setParameter("idPaciente", idPaciente).uniqueResult();
        String hql= "SELECT i.id FROM Informe i WHERE i.paciente.id=:id AND i.historialClinico.id=:idHistorial";
        List<Long> listaIds= (List<Long>)HibernateUtil.getSession().createQuery(hql).setParameter("id", idPaciente).setParameter("idHistorial", historialClinico.getId()).list();
        
        List<DetalleInforme> listaDetalle=(List<DetalleInforme>)HibernateUtil.getSession().createQuery("SELECT de FROM DetalleInforme de"
                + " WHERE de.tipoInforme=:tipo AND de.informe.id IN :ids").setParameter("tipo",tipoInforme).setParameterList("ids",listaIds).list();
        List<DTODetalleInforme> listaDto= new ArrayList<>();
        for(DetalleInforme detalle:listaDetalle){
            listaDto.add(DetalleInforme.buildDTODetalleInforme(detalle));        
        }
        return listaDto;
    }
}
