/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class frmInicioSesion extends javax.swing.JFrame {

    /**
     * Creates new form frmInicioSesion
     */
    public frmInicioSesion() {
        this.setExtendedState(this.MAXIMIZED_BOTH);
        initComponents();
        archUsuarios = new File("./Usuarios.bin");
        cargarUsuarios();
    }

    public void ExceptionRegistroVacios() throws Exceptions {
        if (txtPassReg.getText().equals("") || txtNomReg.getText().equals("")) {
            throw new Exceptions("Debe llenar todos los campos");
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

        dlgRegistrar = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNomReg = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtPassReg = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        txtPassUser = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        cmbNomUser = new javax.swing.JComboBox();
        lblApagar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        dlgRegistrar.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dlgRegistrar.setMinimumSize(new java.awt.Dimension(640, 480));
        dlgRegistrar.setResizable(false);
        dlgRegistrar.getContentPane().setLayout(null);

        jLabel7.setText("Nombre de usuario");
        dlgRegistrar.getContentPane().add(jLabel7);
        jLabel7.setBounds(180, 160, 130, 14);

        jLabel8.setText("Contraseña de usuario");
        dlgRegistrar.getContentPane().add(jLabel8);
        jLabel8.setBounds(180, 190, 140, 14);
        dlgRegistrar.getContentPane().add(txtNomReg);
        txtNomReg.setBounds(340, 140, 121, 30);

        jButton2.setText("Crear Usuario");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        dlgRegistrar.getContentPane().add(jButton2);
        jButton2.setBounds(260, 230, 150, 23);
        dlgRegistrar.getContentPane().add(txtPassReg);
        txtPassReg.setBounds(340, 180, 121, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inicio.jpg"))); // NOI18N
        jLabel9.setText("jLabel7");
        dlgRegistrar.getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 1958, 1200);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel1.setText("Nombre de Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(400, 220, 210, 17);

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(430, 250, 180, 17);

        btnIngresar.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(640, 300, 130, 25);
        getContentPane().add(txtPassUser);
        txtPassUser.setBounds(630, 250, 154, 30);

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/logojava.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 50, 500, 130);

        getContentPane().add(cmbNomUser);
        cmbNomUser.setBounds(630, 210, 150, 30);

        lblApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/apagar.png"))); // NOI18N
        lblApagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblApagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblApagarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblApagarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblApagarMouseExited(evt);
            }
        });
        getContentPane().add(lblApagar);
        lblApagar.setBounds(830, 220, 44, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/w3.jpg"))); // NOI18N
        jLabel6.setMaximumSize(null);
        jLabel6.setMinimumSize(null);
        jLabel6.setPreferredSize(null);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1600, 1000);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        // TODO add your handling code here:
        boolean encontro = false;
        Usuario u = null;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equals((String) cmbNomUser.getSelectedItem())
                    && usuarios.get(i).getPassword().equals(txtPassUser.getText())) {
                encontro = true;
                u = usuarios.get(i);
                break;
            } else {
                encontro = false;
            }
        }
        if (encontro) {
            //Ingresar al sistema
            frmEscritorio f = new frmEscritorio(u, usuarios);
            f.setExtendedState(f.MAXIMIZED_BOTH);
            f.setVisible(true);
            frmInicioSesion.this.dispose();
        } else {
            JOptionPane.showMessageDialog(this.getFrames()[0], "Su contraseña es incorrecta");
        }
    }//GEN-LAST:event_btnIngresarMouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void lblApagarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApagarMouseEntered
        // TODO add your handling code here:
        lblApagar.setIcon(new ImageIcon(".\\src\\Iconos\\apagar2.png"));
    }//GEN-LAST:event_lblApagarMouseEntered

    private void lblApagarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApagarMouseExited
        // TODO add your handling code here:
        lblApagar.setIcon(new ImageIcon(".\\src\\Iconos\\apagar.png"));
    }//GEN-LAST:event_lblApagarMouseExited

    private void lblApagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApagarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblApagarMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            // TODO add your handling code here:
            ExceptionRegistroVacios();
            Usuario p = new Usuario(txtNomReg.getText(), txtPassReg.getText(), TipoUsuario.Administrador);
            FileOutputStream salida = new FileOutputStream(archUsuarios);
            ObjectOutputStream objeto = new ObjectOutputStream(salida);
            objeto.writeObject(p);
            objeto.flush();
            objeto.close();
            salida.close();
            crearCarpetas(txtNomReg.getText());
            archUsuarios.createNewFile();
            JOptionPane.showMessageDialog(this.getFrames()[0], "El usuario fue ingresado con exito");
            dlgRegistrar.dispose();
        } catch (Exceptions ex) {
            JOptionPane.showMessageDialog(this.getFrames()[0], ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getFrames()[0], "Ocurrio un error");
            
        }
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(frmInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicioSesion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox cmbNomUser;
    private javax.swing.JDialog dlgRegistrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblApagar;
    private javax.swing.JTextField txtNomReg;
    private javax.swing.JPasswordField txtPassReg;
    private javax.swing.JPasswordField txtPassUser;
    // End of variables declaration//GEN-END:variables
    ArrayList<Usuario> usuarios = new ArrayList();
    File archUsuarios;

    public boolean hayUsuarios() {
        boolean hay = false;
        try {
            FileInputStream entrada = new FileInputStream(archUsuarios);
            ObjectInputStream objeto = new ObjectInputStream(entrada);
            Usuario temp;
            ArrayList<Tarea> tareas = new ArrayList();
            try {
                if ((Usuario) objeto.readObject() == null) {
                    hay = false;
                } else {
                    hay = true;
                }
            } catch (EOFException eofex) {
            } finally {
                entrada.close();
                objeto.close();
            }
        } catch (Exception ex) {
        }
        return hay;
    }

    public void cargarUsuarios() {
        try {
            if ((!archUsuarios.exists()) || (!hayUsuarios())) {
                String nom = null, pass = null;
                JOptionPane.showMessageDialog(null, "Bienvenido al Java Center MiniOS");
                dlgRegistrar.setModal(true);
                dlgRegistrar.pack();
                dlgRegistrar.setVisible(true);
            }
        } catch (Exception e) {
        }
        Usuario temp;
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) cmbNomUser.getModel();
        try {
            FileInputStream entrada = new FileInputStream(archUsuarios);
            ObjectInputStream objeto = new ObjectInputStream(entrada);
            try {
                while ((temp = (Usuario) objeto.readObject()) != null) {
                    usuarios.add(temp);
                    modelo.addElement(temp.getNombre());
                }
            } catch (EOFException e) {
                //encontró final del archivo
            } finally {
                objeto.close();
                entrada.close();
            }
        } catch (Exception e) {
        }
        cmbNomUser.setModel(modelo);
    }

    public void crearCarpetas(String nom) {
        File nuevoUsuario = new File("C:\\" + nom + "\\");
        nuevoUsuario.mkdir();

        File documentos, imagenes, musica, correo, calendario, mensajes;
        documentos = new File(nuevoUsuario.getPath() + "/Documentos/");
        documentos.mkdir();
        imagenes = new File(nuevoUsuario.getPath() + "/Imagenes/");
        imagenes.mkdir();
        musica = new File(nuevoUsuario.getPath() + "/Musica/");
        musica.mkdir();
        correo = new File(nuevoUsuario.getPath() + "/Correo/");
        correo.mkdir();
        calendario = new File(nuevoUsuario.getPath() + "/Calendario/");
        calendario.mkdir();
        mensajes = new File(nuevoUsuario.getPath() + "/Mensajes/");
        mensajes.mkdir();
    }
}