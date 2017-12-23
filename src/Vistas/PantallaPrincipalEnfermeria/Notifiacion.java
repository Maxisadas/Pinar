/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.PantallaPrincipalEnfermeria;

import Controlador.ControladorConsultarSugerencia.ControladorConsultarSugerencia;
import Controlador.DTO.DTOConsulta;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;

/**
 *
 * @author Maxi
 */
public class Notifiacion extends javax.swing.JPanel {
ControladorConsultarSugerencia controlador;
DTOConsulta dto;
    /**
     * Creates new form Sugerencia
     */
    public Notifiacion(DTOConsulta dto,ControladorConsultarSugerencia controlador) {
        initComponents();
        this.controlador = controlador;
        this.dto = dto;
        jLabel1.setVisible(false);
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        fecha.setText(formateador.format(dto.getFechaCreacion()));
        nombreArea.setText(dto.getNombreArea());
        nombreMedico.setText(dto.getNombreProfesional());
        if(Integer.parseInt(dto.getPrioridad()) == 1){
          Font fuente = new Font("Tahoma",Font.BOLD,14);
          Color color = new Color(255,0,0);
          jLabel1.setVisible(true);
          jLabel1.setFont(fuente);
          jLabel1.setForeground(color);
          nombrePrioridad.setText(dto.getPrioridad());
          nombrePrioridad.setFont(fuente);
          nombrePrioridad.setForeground(color);
        }else{
          if(Integer.parseInt(dto.getPrioridad()) == 2 || Integer.parseInt(dto.getPrioridad()) == 3 ){
          Font fuente = new Font("Tahoma",Font.BOLD,14);
          
          Color color = new Color(255,102,51);
          
          nombrePrioridad.setText(dto.getPrioridad());
          nombrePrioridad.setFont(fuente);
          nombrePrioridad.setForeground(color);
              
              
          }else{
          Font fuente = new Font("Tahoma",Font.PLAIN,12);
          Color color = new Color(0,255,0);
          
          nombrePrioridad.setText(dto.getPrioridad());
          nombrePrioridad.setFont(fuente);
          nombrePrioridad.setForeground(color);
              
          }  
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SugerenciaNueva = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombreMedico = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        nombrePrioridad = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nombreArea = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(378, 105));

        SugerenciaNueva.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        SugerenciaNueva.setPreferredSize(new java.awt.Dimension(900, 91));
        SugerenciaNueva.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nueva notificacion");
        SugerenciaNueva.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 20));

        jLabel7.setText("De:");
        SugerenciaNueva.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        nombreMedico.setText("jLabel8");
        SugerenciaNueva.add(nombreMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 143, -1));

        jButton4.setText("Revisar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        SugerenciaNueva.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        jLabel9.setText("Prioridad");
        SugerenciaNueva.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, -1));

        nombrePrioridad.setText("jLabel10");
        SugerenciaNueva.add(nombrePrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, -1));

        jLabel11.setText("Area:");
        SugerenciaNueva.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        nombreArea.setText("jLabel12");
        SugerenciaNueva.add(nombreArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Fecha enviada:");
        SugerenciaNueva.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fecha.setText("jLabel14");
        SugerenciaNueva.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel1.setText("¡URGENTE!");
        SugerenciaNueva.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SugerenciaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SugerenciaNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        verNotificacion i = new verNotificacion(null,true,controlador,dto);
        i.setVisible(true);
        
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SugerenciaNueva;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel nombreArea;
    private javax.swing.JLabel nombreMedico;
    private javax.swing.JLabel nombrePrioridad;
    // End of variables declaration//GEN-END:variables
}
