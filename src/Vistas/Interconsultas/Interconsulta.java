/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Interconsultas;

import Controlador.ControladorRealizarSugerencia.ControladorRealizarSugerencia;
import Controlador.DTO.DTOConsulta;
import Controlador.DTO.DTOPersonal;
import Modelo.TipoPrioridad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maxi
 */
public class Interconsulta extends javax.swing.JDialog {
DefaultTableModel modelo;
ControladorRealizarSugerencia controlador;
List<DTOPersonal> personalASeleccionar;
List<DTOPersonal> personalSeleccionado;
String nombrePersonalEnvia;
Long idPersonal;
String nombreArea;
    /**
     * Creates new form Interconsulta
     * @param parent
     * @param modal
     * @param idPersonal
     * @param nombrePersonalEnvia
     */
    public Interconsulta(java.awt.Frame parent, boolean modal,Long idPersonal,String nombrePersonalEnvia,String nombreArea) {
        super(parent, modal);
        this.nombreArea = nombreArea;
        this.idPersonal = idPersonal;
        controlador = new ControladorRealizarSugerencia();
        this.nombrePersonalEnvia = nombrePersonalEnvia;
        personalASeleccionar = new ArrayList<>();
        personalSeleccionado = new ArrayList<>();
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) jTable1.getModel();
        llenarCombos(idPersonal);
        
    }
    
    
    public void llenarCombos(Long idPersonal){
        List<DTOPersonal> listaPersonal = controlador.buscar(idPersonal);
        List<TipoPrioridad> listaPrioridad = controlador.buscarPrioridad();
        for(Object o : listaPrioridad){
        TipoPrioridad tp = (TipoPrioridad) o;   
        jComboBox2.addItem(tp.getNombre());    
        }
        for(Object o : listaPersonal){
            DTOPersonal personal = (DTOPersonal) o;
            personalASeleccionar.add(personal);
            jComboBox1.addItem(personal.getNombreRol() + ": " + personal.getNombrePersonal()+" "+personal.getApellidoPersonal()+" Area: "+personal.getNombreArea());
        }
        
        
    }
    
    public void llenarTabla(List<DTOPersonal> personalASeleccionar){
        modelo.setRowCount(0);
        for(Object o : personalASeleccionar){
            DTOPersonal personal = (DTOPersonal) o;
            modelo.addRow(new Object[]{personal.getNombrePersonal() + " " +personal.getApellidoPersonal(),personal.getNombreRol(),personal.getNombreArea()});
        }
 
        
                    
    }
    public boolean verificarigualdad(List<DTOPersonal> personalSeleccionado, DTOPersonal p){
        boolean exito = true;
        for(int i =0; i<personalSeleccionado.size();i++){
            if(personalSeleccionado.get(i).getDni().equals(p.getDni())){
            exito = false;
            }
        }
        
        return exito;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jComboBox2 = new JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Elaborar sugerencia");

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Escriba su mensaje:");

        jLabel3.setText("Elija al profesional/es que desea enviar esta sugerencia:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Establecer prioridad del mensaje:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Profesional", "Rol", "Area"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Este mensaje sera enviado a:");

        jLabel6.setText("Si desea quitar a un profesional, solo haga click en la fila del profesional y presione quitar.");

        jButton3.setText("Quitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel7.setText("Por favor rellene todos los campos:");

        jLabel8.setText("(Nota: Si establece la prioridad 1, el mensaje sera enviado a todo el personal medico)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(342, 342, 342))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(0, 646, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8))
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel7)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DTOPersonal p = personalASeleccionar.get(jComboBox1.getSelectedIndex());
        if(personalSeleccionado.size()>0){
            if(verificarigualdad(personalSeleccionado,p)){
            personalSeleccionado.add(p);
            llenarTabla(personalSeleccionado);    
            }else{
            JOptionPane.showMessageDialog(null, "Ya ingreso esa persona a la lista", "Error", 0);
            }
            
        }else{
        personalSeleccionado.add(p);
        llenarTabla(personalSeleccionado); 
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int i = jTable1.getSelectedRow();
        if(i>-1){  
        personalSeleccionado.remove(i);
        llenarTabla(personalSeleccionado);
        }        
        
    }//GEN-LAST:event_jButton3ActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if("1".equals(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()))){
        DTOConsulta dto = new DTOConsulta();
        dto.setPrioridad(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()));
        dto.setDetalleConsulta(jTextArea1.getText());
        if(controlador.realizarConsulta(dto,nombrePersonalEnvia,idPersonal,nombreArea)){
            JOptionPane.showMessageDialog(null, "Se envio con exito", "Exito", 1);
            this.dispose();
        }else{
            
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta, debido a una desconexion con la base de datos, verifique su conexion a la red o contacte con el administrador", "Error", 0);
        }
        
        }else{
        if(personalSeleccionado.size() > 0){
        List<DTOConsulta> list = new ArrayList<>();
        
        for(DTOPersonal personal : personalSeleccionado){
        DTOConsulta dto = new DTOConsulta();    
        dto.setDetalleConsulta(jTextArea1.getText());
        dto.setNombreArea(personal.getNombreArea());
        dto.setNombreProfesional(personal.getNombrePersonal());
        dto.setPrioridad(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()));
        list.add(dto);
        }
        
        if(controlador.realizarConsulta(list,nombrePersonalEnvia,nombreArea)){
            JOptionPane.showMessageDialog(null, "Se envio con exito", "Exito", 1);
            this.dispose();
        }else{
            
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta, debido a una desconexion con la base de datos, verifique su conexion a la red o contacte con el administrador", "Error", 0);
        }
            
        }else{
           JOptionPane.showMessageDialog(null, "Por favor seleccione un personal a enviar", "Error", 0);
 
            
        }
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        if("1".equals(jComboBox2.getSelectedItem().toString())){
            modelo.setRowCount(0);
            modelo.addRow(new Object[]{"Se enviara a todo el personal medico"});
            jLabel3.setVisible(false);
            jComboBox1.setVisible(false);
            jButton2.setVisible(false);
            jTable1.disable();
            
        }else{
            modelo.setRowCount(0);
            jLabel3.setVisible(true);
            jComboBox1.setVisible(true);
            jButton2.setVisible(true);
            jTable1.enable();
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interconsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interconsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interconsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interconsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Interconsulta dialog = new Interconsulta(new javax.swing.JFrame(), true, Long.parseLong("1"),"Diego","1");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
