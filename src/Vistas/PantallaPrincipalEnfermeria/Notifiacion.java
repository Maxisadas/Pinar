/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.PantallaPrincipalEnfermeria;

import Controlador.ControladorConsultarSugerencia.ControladorConsultarSugerencia;
import Controlador.DTO.DTOConsulta;
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
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        fecha.setText(formateador.format(dto.getFechaCreacion()));
        nombreArea.setText(dto.getNombreArea());
        nombreMedico.setText(dto.getNombreProfesional());
        nombrePrioridad.setText(dto.getPrioridad());
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

        SugerenciaNueva.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nueva notificacion");

        jLabel7.setText("De:");

        nombreMedico.setText("jLabel8");

        jButton4.setText("Revisar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Prioridad:");

        nombrePrioridad.setText("jLabel10");

        jLabel11.setText("Area:");

        nombreArea.setText("jLabel12");

        jLabel13.setText("Fecha enviada:");

        fecha.setText("jLabel14");

        javax.swing.GroupLayout SugerenciaNuevaLayout = new javax.swing.GroupLayout(SugerenciaNueva);
        SugerenciaNueva.setLayout(SugerenciaNuevaLayout);
        SugerenciaNuevaLayout.setHorizontalGroup(
            SugerenciaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SugerenciaNuevaLayout.createSequentialGroup()
                .addGroup(SugerenciaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SugerenciaNuevaLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SugerenciaNuevaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(SugerenciaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(SugerenciaNuevaLayout.createSequentialGroup()
                                .addComponent(fecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(jLabel9)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SugerenciaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SugerenciaNuevaLayout.createSequentialGroup()
                        .addComponent(nombrePrioridad)
                        .addContainerGap())
                    .addGroup(SugerenciaNuevaLayout.createSequentialGroup()
                        .addComponent(nombreArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(nombreMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        SugerenciaNuevaLayout.setVerticalGroup(
            SugerenciaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SugerenciaNuevaLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SugerenciaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nombreMedico)
                    .addComponent(jLabel13))
                .addGroup(SugerenciaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SugerenciaNuevaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SugerenciaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(nombrePrioridad)))
                    .addGroup(SugerenciaNuevaLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(fecha)))
                .addGroup(SugerenciaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SugerenciaNuevaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(SugerenciaNuevaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SugerenciaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(nombreArea))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SugerenciaNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SugerenciaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        verNotificacion i = new verNotificacion(null,true,controlador);
        i.setVisible(true);
        
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SugerenciaNueva;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton jButton4;
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
