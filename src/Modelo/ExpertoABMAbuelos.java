/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTO.DTOAbuelo;
import Controlador.DTO.DTOObraSocial;
import Controlador.Persistencia.FachadaInterna;
import Controlador.Persistencia.HibernateUtil;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.io.IOUtils;




/**
 *
 * @author Maxi
 */
public class ExpertoABMAbuelos {
    
    public boolean iniciarAlta(DTOAbuelo abuelo){
        Date fechaHoy = new Date();
        ObraSocial obra = new ObraSocial();
        Paciente paciente = new Paciente();
        
        if(abuelo.getDTOobraSocial() != null){
        obra.setCredencialDeAfiliacion(abuelo.getDTOobraSocial().getCredencialDeAfiliacion());
        obra.setDisposicionNro(abuelo.getDTOobraSocial().getDisposicionNro());
        obra.setDomicilio(abuelo.getDTOobraSocial().getDomicilio());
        obra.setEmitidoPor(abuelo.getDTOobraSocial().getEmitidoPor());
        obra.setExpedienteNro(abuelo.getDTOobraSocial().getExpedienteNro());
        obra.setFechaAltaCredencial(abuelo.getDTOobraSocial().getFechaAltaCredencial());
        obra.setFechaEmisionCredencial(abuelo.getDTOobraSocial().getFechaEmisionCredencial());
        obra.setFechaVencimientoCredencial(abuelo.getDTOobraSocial().getFechaVencimientoCredencial());
        obra.setFechaVigenciaCredencial(abuelo.getDTOobraSocial().getFechaVigenciaCredencial());
        obra.setFechaVigenciaMedico(abuelo.getDTOobraSocial().getFechaVigenciaMedico());
        obra.setFechaVigenciaModulo(abuelo.getDTOobraSocial().getFechaVigenciaModulo());
        obra.setGp(abuelo.getDTOobraSocial().getGp());
        obra.setLocalidad(abuelo.getDTOobraSocial().getLocalidad());
        obra.setModuloInternacion(abuelo.getDTOobraSocial().getModuloInternacion());
        obra.setNombreObraSocial(abuelo.getDTOobraSocial().getNombreObraSocial());
        obra.setNombremedicoCabecera(abuelo.getDTOobraSocial().getNombremedicoCabecera());
        obra.setNroModulo(abuelo.getDTOobraSocial().getNroModulo());
        obra.setNumeroBeneficio(abuelo.getDTOobraSocial().getNumeroBeneficio());
        obra.setNumeroMedicoCabecera(abuelo.getDTOobraSocial().getNumeroMedicoCabecera());
        paciente.setObraSocial(obra);
        FachadaInterna.getInstancia().guardar(obra);
            
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     HistorialClinico historial = new HistorialClinico();
     EstadoHistorialClinico estado = new EstadoHistorialClinico();
     HistorialClinicoEstado historialfecha = new HistorialClinicoEstado();
     estado.setNombre("Creado");
     historialfecha.setEstadoHistorialClinico(estado);
     historialfecha.setFechaEstado(fechaHoy);
     historial.setHistorial(historialfecha);
     historial.setPaciente(paciente);
     

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        
        Paciente abueloExistente =(Paciente) HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.dni= :dni AND p.fechaBaja="+null).setParameter("dni", abuelo.getDni()).uniqueResult();
        if(abueloExistente == null){
            
            paciente.setNombre(abuelo.getNombre());
            paciente.setApellido(abuelo.getApellido());
            paciente.setDni(abuelo.getDni());
            paciente.setFechaAlta(fechaHoy);
            paciente.setFechaBaja(null);
            paciente.setFechadeNacimiento(abuelo.getFechadeNacimiento());  
            paciente.setPeso(abuelo.getPeso());
            paciente.setTalla(abuelo.getTalla());
            paciente.setEdad(CalcularEdad(abuelo.getFechadeNacimiento()));
            
            if(!"".equals(abuelo.getRutafotoPaciente())){
             byte[] imagen = convertirStringAbyte(abuelo.getRutafotoPaciente());   
             paciente.setFotoPaciente(imagen);   
            }else{
                
             paciente.setFotoPaciente(abuelo.getFoto());   
            }
            FachadaInterna.getInstancia().guardar(estado);
            FachadaInterna.getInstancia().guardar(historialfecha);
            FachadaInterna.getInstancia().guardar(historial);
            FachadaInterna.getInstancia().guardar(paciente);
            return true;
            
        }else{
            return false;
        }
    }
    
    public int CalcularEdad(Date fechaNacimiento){
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String stringfechaNacimiento = sdf.format(fechaNacimiento);
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate ahora = LocalDate.now();
            LocalDate fechaNac = LocalDate.parse(stringfechaNacimiento,fmt);
            Period periodo = Period.between(fechaNac,ahora);
            return periodo.getYears();
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
    
    public List<DTOAbuelo> buscar(){
     List listaAbuelos = HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.fechaBaja=" + null).list();
     List<DTOAbuelo> listaDTOAbuelo = new ArrayList<>();
     for(Object a : listaAbuelos){
         Paciente paciente = (Paciente) a;
         DTOAbuelo dtoabuelo = new DTOAbuelo();
         dtoabuelo.setApellido(paciente.getApellido());
         dtoabuelo.setNombre(paciente.getNombre());
         dtoabuelo.setDni(paciente.getDni());
         dtoabuelo.setFechaAlta(paciente.getFechaAlta());
         dtoabuelo.setFechaBaja(paciente.getFechaBaja());
         dtoabuelo.setEdad(CalcularEdad(paciente.getFechadeNacimiento()));
         dtoabuelo.setFoto(paciente.getFotoPaciente());
         dtoabuelo.setPeso(paciente.getPeso());
         dtoabuelo.setTalla(paciente.getTalla());
         dtoabuelo.setId(paciente.getId());
         dtoabuelo.setFechadeNacimiento(paciente.getFechadeNacimiento());
         if(paciente.getObraSocial() != null){
         DTOObraSocial dto = new DTOObraSocial();
         dto.setCredencialDeAfiliacion(paciente.getObraSocial().getCredencialDeAfiliacion());
         dto.setDisposicionNro(paciente.getObraSocial().getDisposicionNro());
         dto.setDomicilio(paciente.getObraSocial().getDomicilio());
         dto.setEmitidoPor(paciente.getObraSocial().getEmitidoPor());
         dto.setExpedienteNro(paciente.getObraSocial().getExpedienteNro());
         dto.setFechaAltaCredencial(paciente.getObraSocial().getFechaAltaCredencial());
         dto.setFechaEmisionCredencial(paciente.getObraSocial().getFechaEmisionCredencial());
         dto.setFechaVencimientoCredencial(paciente.getObraSocial().getFechaVencimientoCredencial());
         dto.setFechaVigenciaCredencial(paciente.getObraSocial().getFechaVigenciaCredencial());
         dto.setFechaVigenciaMedico(paciente.getObraSocial().getFechaVigenciaMedico());
         dto.setFechaVigenciaModulo(paciente.getObraSocial().getFechaVigenciaModulo());
         dto.setGp(paciente.getObraSocial().getGp());
         dto.setLocalidad(paciente.getObraSocial().getLocalidad());
         dto.setModuloInternacion(paciente.getObraSocial().getModuloInternacion());
         dto.setNombreObraSocial(paciente.getObraSocial().getNombreObraSocial());
         dto.setNombremedicoCabecera(paciente.getObraSocial().getNombremedicoCabecera());
         dto.setNroModulo(paciente.getObraSocial().getNroModulo());
         dto.setNumeroBeneficio(paciente.getObraSocial().getNumeroBeneficio());
         dto.setNumeroMedicoCabecera(paciente.getObraSocial().getNumeroMedicoCabecera());
         dtoabuelo.setDTOobraSocial(dto);
         }
         listaDTOAbuelo.add(dtoabuelo);
     }
     
     return listaDTOAbuelo;
             
    }
    
        public DTOAbuelo buscar(Long idAbuelo){
     
 
         Paciente paciente = (Paciente) HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.id = :id").setParameter("id", idAbuelo).uniqueResult();
         DTOAbuelo dtoabuelo = new DTOAbuelo();
         dtoabuelo.setApellido(paciente.getApellido());
         dtoabuelo.setNombre(paciente.getNombre());
         dtoabuelo.setDni(paciente.getDni());
         dtoabuelo.setFechaAlta(paciente.getFechaAlta());
         dtoabuelo.setFechaBaja(paciente.getFechaBaja());
         dtoabuelo.setEdad(CalcularEdad(paciente.getFechadeNacimiento()));
         dtoabuelo.setFoto(paciente.getFotoPaciente());
         dtoabuelo.setPeso(paciente.getPeso());
         dtoabuelo.setTalla(paciente.getTalla());
         dtoabuelo.setId(paciente.getId());
         dtoabuelo.setFechadeNacimiento(paciente.getFechadeNacimiento());
         if(paciente.getObraSocial() != null){
         DTOObraSocial dto = new DTOObraSocial();
         dto.setCredencialDeAfiliacion(paciente.getObraSocial().getCredencialDeAfiliacion());
         dto.setDisposicionNro(paciente.getObraSocial().getDisposicionNro());
         dto.setDomicilio(paciente.getObraSocial().getDomicilio());
         dto.setEmitidoPor(paciente.getObraSocial().getEmitidoPor());
         dto.setExpedienteNro(paciente.getObraSocial().getExpedienteNro());
         dto.setFechaAltaCredencial(paciente.getObraSocial().getFechaAltaCredencial());
         dto.setFechaEmisionCredencial(paciente.getObraSocial().getFechaEmisionCredencial());
         dto.setFechaVencimientoCredencial(paciente.getObraSocial().getFechaVencimientoCredencial());
         dto.setFechaVigenciaCredencial(paciente.getObraSocial().getFechaVigenciaCredencial());
         dto.setFechaVigenciaMedico(paciente.getObraSocial().getFechaVigenciaMedico());
         dto.setFechaVigenciaModulo(paciente.getObraSocial().getFechaVigenciaModulo());
         dto.setGp(paciente.getObraSocial().getGp());
         dto.setLocalidad(paciente.getObraSocial().getLocalidad());
         dto.setModuloInternacion(paciente.getObraSocial().getModuloInternacion());
         dto.setNombreObraSocial(paciente.getObraSocial().getNombreObraSocial());
         dto.setNombremedicoCabecera(paciente.getObraSocial().getNombremedicoCabecera());
         dto.setNroModulo(paciente.getObraSocial().getNroModulo());
         dto.setNumeroBeneficio(paciente.getObraSocial().getNumeroBeneficio());
         dto.setNumeroMedicoCabecera(paciente.getObraSocial().getNumeroMedicoCabecera());
         dtoabuelo.setDTOobraSocial(dto);
         }
        
     
     
     return dtoabuelo;
             
    }
        
        
        public boolean iniciarModificar(DTOAbuelo abuelo,boolean obrasocialmodificada){
        try{
        Paciente paciente = (Paciente) HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.id="+abuelo.getId()).uniqueResult();    
        
        if(obrasocialmodificada){
            
        ObraSocial obra = paciente.getObraSocial();
        obra.setCredencialDeAfiliacion(abuelo.getDTOobraSocial().getCredencialDeAfiliacion());
        obra.setDisposicionNro(abuelo.getDTOobraSocial().getDisposicionNro());
        obra.setDomicilio(abuelo.getDTOobraSocial().getDomicilio());
        obra.setEmitidoPor(abuelo.getDTOobraSocial().getEmitidoPor());
        obra.setExpedienteNro(abuelo.getDTOobraSocial().getExpedienteNro());
        obra.setFechaAltaCredencial(abuelo.getDTOobraSocial().getFechaAltaCredencial());
        obra.setFechaEmisionCredencial(abuelo.getDTOobraSocial().getFechaEmisionCredencial());
        obra.setFechaVencimientoCredencial(abuelo.getDTOobraSocial().getFechaVencimientoCredencial());
        obra.setFechaVigenciaCredencial(abuelo.getDTOobraSocial().getFechaVigenciaCredencial());
        obra.setFechaVigenciaMedico(abuelo.getDTOobraSocial().getFechaVigenciaMedico());
        obra.setFechaVigenciaModulo(abuelo.getDTOobraSocial().getFechaVigenciaModulo());
        obra.setGp(abuelo.getDTOobraSocial().getGp());
        obra.setLocalidad(abuelo.getDTOobraSocial().getLocalidad());
        obra.setModuloInternacion(abuelo.getDTOobraSocial().getModuloInternacion());
        obra.setNombreObraSocial(abuelo.getDTOobraSocial().getNombreObraSocial());
        obra.setNombremedicoCabecera(abuelo.getDTOobraSocial().getNombremedicoCabecera());
        obra.setNroModulo(abuelo.getDTOobraSocial().getNroModulo());
        obra.setNumeroBeneficio(abuelo.getDTOobraSocial().getNumeroBeneficio());
        obra.setNumeroMedicoCabecera(abuelo.getDTOobraSocial().getNumeroMedicoCabecera());
        paciente.setObraSocial(obra);
        FachadaInterna.getInstancia().guardar(obra);
            
        }

        
       
        
            
            paciente.setNombre(abuelo.getNombre());
            paciente.setApellido(abuelo.getApellido());
            paciente.setDni(abuelo.getDni());
            paciente.setFechaBaja(null);
            paciente.setFechadeNacimiento(abuelo.getFechadeNacimiento());
            paciente.setPeso(abuelo.getPeso());
            paciente.setTalla(abuelo.getTalla());
            paciente.setEdad(CalcularEdad(abuelo.getFechadeNacimiento()));
            
            if(!"".equals(abuelo.getRutafotoPaciente())){
             byte[] imagen = convertirStringAbyte(abuelo.getRutafotoPaciente());   
             paciente.setFotoPaciente(imagen);   
            }else{
                
             paciente.setFotoPaciente(abuelo.getFoto());   
            }
            
            
            FachadaInterna.getInstancia().guardar(paciente);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
        
        public boolean iniciarBaja(Long idAbuelo,String motivoBaja){
            try{
            Date fechahoy = new Date();    
            Paciente paciente = (Paciente) HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.id="+idAbuelo).uniqueResult();    
            paciente.setFechaBaja(fechahoy);
            paciente.setMotivoBaja(motivoBaja);
            FachadaInterna.getInstancia().guardar(paciente);
            
            return true;
                    }catch(Exception e){
                        return false;
                    }
        }
        
        public List<DTOAbuelo> buscarbajas(){
     List listaAbuelos = HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.fechaBaja<>" + null).list();
     List<DTOAbuelo> listaDTOAbuelo = new ArrayList<>();
     for(Object a : listaAbuelos){
         Paciente paciente = (Paciente) a;
         DTOAbuelo dtoabuelo = new DTOAbuelo();
         dtoabuelo.setApellido(paciente.getApellido());
         dtoabuelo.setNombre(paciente.getNombre());
         dtoabuelo.setDni(paciente.getDni());
         dtoabuelo.setFechaAlta(paciente.getFechaAlta());
         dtoabuelo.setFechaBaja(paciente.getFechaBaja());
         dtoabuelo.setEdad(CalcularEdad(paciente.getFechadeNacimiento()));
         dtoabuelo.setFoto(paciente.getFotoPaciente());
         dtoabuelo.setPeso(paciente.getPeso());
         dtoabuelo.setTalla(paciente.getTalla());
         dtoabuelo.setId(paciente.getId());
         dtoabuelo.setFechadeNacimiento(paciente.getFechadeNacimiento());
         dtoabuelo.setMotivoBaja(paciente.getMotivoBaja());
         if(paciente.getObraSocial() != null){
         DTOObraSocial dto = new DTOObraSocial();
         dto.setCredencialDeAfiliacion(paciente.getObraSocial().getCredencialDeAfiliacion());
         dto.setDisposicionNro(paciente.getObraSocial().getDisposicionNro());
         dto.setDomicilio(paciente.getObraSocial().getDomicilio());
         dto.setEmitidoPor(paciente.getObraSocial().getEmitidoPor());
         dto.setExpedienteNro(paciente.getObraSocial().getExpedienteNro());
         dto.setFechaAltaCredencial(paciente.getObraSocial().getFechaAltaCredencial());
         dto.setFechaEmisionCredencial(paciente.getObraSocial().getFechaEmisionCredencial());
         dto.setFechaVencimientoCredencial(paciente.getObraSocial().getFechaVencimientoCredencial());
         dto.setFechaVigenciaCredencial(paciente.getObraSocial().getFechaVigenciaCredencial());
         dto.setFechaVigenciaMedico(paciente.getObraSocial().getFechaVigenciaMedico());
         dto.setFechaVigenciaModulo(paciente.getObraSocial().getFechaVigenciaModulo());
         dto.setGp(paciente.getObraSocial().getGp());
         dto.setLocalidad(paciente.getObraSocial().getLocalidad());
         dto.setModuloInternacion(paciente.getObraSocial().getModuloInternacion());
         dto.setNombreObraSocial(paciente.getObraSocial().getNombreObraSocial());
         dto.setNombremedicoCabecera(paciente.getObraSocial().getNombremedicoCabecera());
         dto.setNroModulo(paciente.getObraSocial().getNroModulo());
         dto.setNumeroBeneficio(paciente.getObraSocial().getNumeroBeneficio());
         dto.setNumeroMedicoCabecera(paciente.getObraSocial().getNumeroMedicoCabecera());
         dtoabuelo.setDTOobraSocial(dto);
         }
         listaDTOAbuelo.add(dtoabuelo);
     }
     
     return listaDTOAbuelo;
             
    }
        
        public void iniciarAltaNuevamente(Long idAbuelo){
          
            Date fechahoy = new Date();    
            Paciente paciente = (Paciente) HibernateUtil.getSession().createQuery("SELECT p FROM Paciente p WHERE p.id="+idAbuelo).uniqueResult();    
            paciente.setFechaBaja(null);
            paciente.setMotivoBaja(null);
            FachadaInterna.getInstancia().guardar(paciente);
            
           
        }

}
