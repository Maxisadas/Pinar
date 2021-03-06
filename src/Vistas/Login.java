/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;


import Controlador.ControladorIniciarSesion.ControladorIniciarSesion;
import Modelo.Usuario;
import Vistas.PantallaPrincipal.InterfazPantallaPrincipal;
import Vistas.PantallaPrincipalEnfermeria.PantallaPrincipalEnfermeria;
import Vistas.RegistrarUsuario.InterfazRegistrarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxi
 */
public class Login extends javax.swing.JFrame {
ControladorIniciarSesion controlador;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        controlador = new ControladorIniciarSesion();
    }
    
    public void IngresarSistema(){
        
            if(controlador.validarUsuario(textNombreUsuario.getText(), textContraseña.getText())){
            Usuario usuario = controlador.loguear(textNombreUsuario.getText());
            if("Enfermeria".equals(usuario.getPersonal().getArea().getNombreArea())){
                
            PantallaPrincipalEnfermeria i = new PantallaPrincipalEnfermeria(usuario);
            i.setVisible(true);
            this.setVisible(false);
            this.dispose();
            
                
            }else{
            InterfazPantallaPrincipal i = new InterfazPantallaPrincipal(usuario);
            i.setVisible(true);
            this.setVisible(false);
            this.dispose();
            
                
            }
            

            
        }else{
            
            JOptionPane.showMessageDialog(null, "El nombre de usuario o contraseña son incorrecto, ingrese nuevamente", "Error", 0);
            textNombreUsuario.setText("");
            textContraseña.setText("");
            
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textNombreUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        botonIngresarSistema = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        textContraseña = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("   Bienvenido al Sistema Interno Medico");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 470, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/imagenes/logo web-01.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 290, 150));

        jLabel4.setText("Por favor inicie sesion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        jLabel5.setText("Nombre Usuario: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, 20));
        getContentPane().add(textNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 150, -1));

        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, 20));

        botonIngresarSistema.setText("Ingresar al sistema");
        botonIngresarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarSistemaActionPerformed(evt);
            }
        });
        getContentPane().add(botonIngresarSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 330, 140, -1));

        botonRegistrar.setText("Registrarse en el sistema");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        botonSalir.setBackground(new java.awt.Color(255, 255, 51));
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, -1));

        textContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textContraseñaActionPerformed(evt);
            }
        });
        textContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textContraseñaKeyPressed(evt);
            }
        });
        getContentPane().add(textContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 150, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/imagenes/background-1591227_960_720.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 490, 424));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarSistemaActionPerformed
        
      IngresarSistema();
      

        
    }//GEN-LAST:event_botonIngresarSistemaActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        InterfazRegistrarUsuario i = new InterfazRegistrarUsuario();
        this.setVisible(false);
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void textContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textContraseñaActionPerformed
        
    }//GEN-LAST:event_textContraseñaActionPerformed

    private void textContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textContraseñaKeyPressed
                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
              
                IngresarSistema();
                 
                }
             
    }//GEN-LAST:event_textContraseñaKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    new Login().setVisible(true);
                }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion con la base de datos, por favor revise su conexion de RED e inicie la aplicacion nuevamente", "Error", 0);
                 System.exit(0);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresarSistema;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField textContraseña;
    private javax.swing.JTextField textNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
