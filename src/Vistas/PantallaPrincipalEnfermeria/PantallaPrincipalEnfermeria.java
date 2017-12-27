/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.PantallaPrincipalEnfermeria;

import Controlador.ControladorAbuelo.ControladorAbuelo;
import Controlador.ControladorCalendario.ControladorCalendario;
import Controlador.ControladorConsultarSugerencia.ControladorConsultarSugerencia;
import Controlador.DTO.DTOConsulta;
import static Modelo.Consulta_.personal;
import Modelo.Evento;
import Modelo.Personal;
import Modelo.Usuario;
import Vistas.Login;
import Vistas.PantallaPrincipal.Background;
import Vistas.PantallaPrincipal.Informes;
import Vistas.PantallaPrincipal.MostrarEvento;
import Vistas.PantallaPrincipal.OrganizarEvento;
import Vistas.PantallaPrincipal.SeleccionarAbuelo;
import Vistas.PantallaPrincipal.Sugerencia;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Maxi
 */
public class PantallaPrincipalEnfermeria extends javax.swing.JFrame {
ControladorConsultarSugerencia controlador;
ControladorCalendario controladorEventos;
Personal personal;
Usuario usuario;
Timer timer;
    /**
     * Creates new form PantallaPrincipalEnfermeria
     * @param usuario
     */
    public PantallaPrincipalEnfermeria(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        controladorEventos = new ControladorCalendario();
        personal = usuario.getPersonal();
        controlador = new ControladorConsultarSugerencia();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        textodeBienvenida2.setText("Bienvenido " + usuario.getPersonal().getNombre() + " " + usuario.getPersonal().getApellido() + " Al area " + usuario.getPersonal().getArea().getNombreArea());
        start();
    }
    
        public void start(){
        timer = new Timer(2000, new ActionListener(){

            public void actionPerformed(ActionEvent e) {
            refrescar();    
            }
        });
        
        timer.start();
        
    }
    
        public void refrescar(){
         System.gc();
         
        jPanel9.removeAll();
        jPanel9.setSize(908, 215);
        jPanel5.removeAll();
        jPanel5.setSize(288, 387);
        int y = 0;
        int i = 0;
        int contador = 0;
        List<DTOConsulta> listdto = controlador.verificarSugerencias(personal);
        for(DTOConsulta dto :listdto){
            if(dto.getIdAbuelo() != null){
            Notifiacion sugerencia = new Notifiacion(dto,controlador);
            sugerencia.setVisible(true);
            sugerencia.setBounds(0, y, 870, 91);
            jPanel9.add(sugerencia);
            y = y + 92;
            if(contador >= 2){
            jPanel9.setSize(jPanel9.getWidth(), jPanel9.getHeight() + 93);    
            }
            }else{
                Sugerencia sugerencia = new Sugerencia(dto,controlador);
            sugerencia.setVisible(true);
            sugerencia.setBounds(0, i, 285, 105);
            jPanel5.add(sugerencia);
            i = i + 106;
            if(contador >= 3){
            jPanel5.setSize(jPanel5.getWidth(), jPanel5.getHeight() + 106);    
            }
                
            }

            
            contador++;
           
            
        }
        jPanel9.setPreferredSize(jPanel9.getSize());
        jPanel9.validate();
        jPanel5.setPreferredSize(jPanel5.getSize());
        jPanel5.validate();
        refrescarCalendario();
    }
        
         public void stop(){
        timer.stop();
    }
         
         public void refrescarCalendario(){
        Date fechaHoy = new Date();
        Calendar cal = Calendar.getInstance();
        JPanel jpanel = jCalendar1.getDayChooser().getDayPanel();
        Component component[] = jpanel.getComponents();
        
        List<Evento> listaEventos = controladorEventos.consultarEvento();
        Date fechaMarcada = jCalendar1.getDate();
        for(Evento evento : listaEventos){
         cal.setTime(evento.getFechaAsignada());   
        int mes = evento.getFechaAsignada().getMonth();
        int año =  evento.getFechaAsignada().getYear()+1900;
            if(fechaMarcada.getMonth() == mes && fechaMarcada.getYear()+1900 == año){
        cal.set(Calendar.DAY_OF_MONTH,1);
        int offset = cal.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println(offset);
        
        int dia = offset + evento.getFechaAsignada().getDate() + 6;
        System.out.println(dia);
        
        component[dia].setBackground(Color.red);
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

        jPanel8 = new Background("/Vistas/imagenes/fondoPantallaPrincipal.jpg");
        jLabel11 = new javax.swing.JLabel();
        textodeBienvenida2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel9 = new Background("/Vistas/imagenes/fondoPantallaPrincipaljpanel2.jpg");
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new Background("/Vistas/imagenes/fondoPantallaPrincipaljpanel2.jpg");
        jLabel7 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setPreferredSize(new java.awt.Dimension(1280, 800));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("sistema interno");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1450, 40));

        textodeBienvenida2.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        textodeBienvenida2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel8.add(textodeBienvenida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 1436, 19));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Lista de avisos de pacientes a revisar");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 910, -1));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setPreferredSize(new java.awt.Dimension(908, 195));

        jPanel9.setPreferredSize(new java.awt.Dimension(908, 215));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanel9);

        jPanel8.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, -1, 210));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Menu principal");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 95, 800, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Realizar reporte de enfermeria");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 308, -1));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Consultar historial clinico del paciente");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 310, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/imagenes/informe.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 308, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/imagenes/historialclinico.jpg"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 310, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista de sugerencias");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1142, 95, 294, -1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel5);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1146, 118, -1, 380));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Calendario");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 520, 410, -1));

        jCalendar1.setMaximumSize(new java.awt.Dimension(184, 157));
        jCalendar1.setMinimumSize(new java.awt.Dimension(1, 1));
        jPanel8.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 550, 400, 222));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton7.setText("Consultar evento");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(918, 616, -1, 75));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/imagenes/organizarEnfermeria.jpg"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 320, 310));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Organizar Evento en calendario.");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 480, 320, -1));

        jMenu1.setText("Menu");

        jMenuItem7.setText("Cerrar Sesion");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1446, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
   
        SeleccionarAbuelo i = new SeleccionarAbuelo(this,true,usuario);
        i.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Login i = new Login();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       Informes i = new Informes(this,true);
        i.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Date fechaelejida = jCalendar1.getDate();
        Evento evento = controladorEventos.buscarEvento(fechaelejida);
        if(evento != null){
            MostrarEvento i = new MostrarEvento(this,true,evento);
            i.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro ningun evento registrado", "Error", 0);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        OrganizarEvento i = new OrganizarEvento(this,true);
        i.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipalEnfermeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipalEnfermeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipalEnfermeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipalEnfermeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel textodeBienvenida2;
    // End of variables declaration//GEN-END:variables
}
