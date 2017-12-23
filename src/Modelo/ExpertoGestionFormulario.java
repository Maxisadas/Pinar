/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import Modelo.DetalleInforme.TipoInforme;
import java.io.FileInputStream;
import java.util.Date;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author User
 */
public class ExpertoGestionFormulario {
    public boolean guardar(String nombreArea,String informeAvanzado, String informeBasico,String foto,String foto1,Long idPaciente){        
        if(!informeAvanzado.isEmpty()  || !informeBasico.isEmpty()){
            Usuario usuarioLogueado=ExpertoIniciarSesion.getUsuarioLogueado(ExpertoIniciarSesion.idLogueado);
            Paciente abuelo=(Paciente)HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.id=:id").setParameter("id", idPaciente).uniqueResult();
            HistorialClinico historial=(HistorialClinico)HibernateUtil.getSession().createQuery("SELECT h FROM HistorialClinico h WHERE h.paciente.id=:id").setParameter("id", idPaciente).uniqueResult();
            Informe informe=new Informe();
            informe.setFechaElaboracion(new Date());
            informe.setPaciente(abuelo);
            informe.setHistorialClinico(historial);
            informe.setPersonal(usuarioLogueado.getPersonal());
            DetalleInforme informeB= new DetalleInforme();
            informeB.setInformeMedico(informeBasico);
            informeB.setInforme(informe);
            informeB.setFotoPaciente(convertirStringAbyte(foto!=null?foto:"  "));
            informeB.setTipoInforme(TipoInforme.BASICO);
            DetalleInforme informeAv= new DetalleInforme();
            informeAv.setInforme(informe);
            informeAv.setInformeMedico(informeAvanzado);
            informeAv.setFotoPaciente(convertirStringAbyte(foto1!=null?foto:"  "));
            informeAv.setTipoInforme(TipoInforme.AVANZADO);
            FachadaInterna.getInstancia().guardar(informeB);
            FachadaInterna.getInstancia().guardar(informeAv);
            FachadaInterna.getInstancia().guardar(informe);
                return true;
        } 
        return false;
        
    }
    public byte[] convertirStringAbyte(String rutaFoto){
       try{
        FileInputStream archivofoto = new FileInputStream(rutaFoto);
        byte[] foto = IOUtils.toByteArray(archivofoto);
        return foto;    
       }catch(Exception e){
           System.out.println("No existe archivo");
           return null;
       }   
    }
}
