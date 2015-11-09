/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import org.kc7bfi.jflac.apps.ExtensionFileFilter;

/**
 *
 * @author Alberto
 */
public class frmReproductor extends javax.swing.JFrame {

    /**
     * Creates new form frmReproductor
     */
    public frmReproductor() {
        initComponents();

    }

    public frmReproductor(String usr) {
        initComponents();
        reproduciendo=true;
        this.usr = usr;
    }

    public frmReproductor(File archivo, String usr) {
        initComponents();
        try {
            reproduciendo=true;
            this.usr = usr;
            mi_reproductor.AbrirFichero(archivo.getPath());
            mi_reproductor.Play();
            lbPause.setEnabled(true);
            lbStop.setEnabled(true);
            lbPlay.setEnabled(false);
            String cancion;
            cancion = "" + archivo.getName();
            cancion = cancion.replaceAll(".mp3", "");
            txtCancion.setText(cancion);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.getFrames()[0], "No se pudo reproducir el archivo");
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

        jLabel1 = new javax.swing.JLabel();
        txtCancion = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        lbPlay = new javax.swing.JLabel();
        lbPause = new javax.swing.JLabel();
        lbStop = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Reproductor de música");
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Canción");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 140, 70, 20);

        txtCancion.setEnabled(false);
        getContentPane().add(txtCancion);
        txtCancion.setBounds(160, 130, 380, 30);

        btnSeleccionar.setText("Seleccionar una cancion");
        btnSeleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeleccionarMouseClicked(evt);
            }
        });
        getContentPane().add(btnSeleccionar);
        btnSeleccionar.setBounds(230, 170, 210, 23);

        lbPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/play.png"))); // NOI18N
        lbPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPlay.setEnabled(false);
        lbPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPlayMouseClicked(evt);
            }
        });
        getContentPane().add(lbPlay);
        lbPlay.setBounds(230, 200, 50, 48);

        lbPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pause.png"))); // NOI18N
        lbPause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPause.setEnabled(false);
        lbPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPauseMouseClicked(evt);
            }
        });
        getContentPane().add(lbPause);
        lbPause.setBounds(310, 200, 48, 48);

        lbStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/stop.png"))); // NOI18N
        lbStop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbStop.setEnabled(false);
        lbStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbStopMouseClicked(evt);
            }
        });
        getContentPane().add(lbStop);
        lbStop.setBounds(390, 200, 48, 48);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/repro.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 680, 480);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Canción");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 130, 70, 20);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Canción");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 140, 70, 14);

        jMenu1.setText("Reproductor");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeleccionarMouseClicked
        // TODO add your handling code here:
        String cancion;
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "Archivos de Musica", "mp3");
        File root = new File("C:/" + usr + "/Musica/");
        FileSystemView fsv = new SingleRootFileSystemView(root);
        JFileChooser jfc = new JFileChooser(fsv);
        jfc.setMultiSelectionEnabled(false);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setFileFilter(filtro);
        //Si seleccionamos algún archivo retornaremos su directorio
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            dirRepro = jfc.getCurrentDirectory() + "/" + jfc.getName(jfc.getSelectedFile());
            cancion = "" + jfc.getName(jfc.getSelectedFile());
            cancion = cancion.replaceAll(".mp3", "");
            dirRepro = dirRepro.replace((char) 92, '/');
            txtCancion.setText(cancion);
            lbPlay.setEnabled(true);
            lbPause.setEnabled(false);
            lbStop.setEnabled(false);
            //Si no seleccionamos nada retornaremos No seleccion
        } else {
        }
    }//GEN-LAST:event_btnSeleccionarMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            // TODO add your handling code here:
            mi_reproductor.Stop();
        } catch (Exception ex) {
        }
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void lbPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPlayMouseClicked
        // TODO add your handling code here:
        if(lbPlay.isEnabled()){
        try {
            mi_reproductor.AbrirFichero(dirRepro);
            mi_reproductor.Play();
            lbPause.setEnabled(true);
            lbPause.setIcon(new ImageIcon("./src/Iconos/pause.png"));
            lbStop.setEnabled(true);
            lbPlay.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.getFrames()[0], "No se pudo reproducir el archivo");
        }}
    }//GEN-LAST:event_lbPlayMouseClicked

    private void lbPauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPauseMouseClicked
        // TODO add your handling code here:
        if(lbPause.isEnabled()){
            try {
            if (reproduciendo) {
                reproduciendo = false;
                mi_reproductor.Pausa();
                lbPause.setIcon(new ImageIcon("./src/Iconos/play.png"));
            }else{
                reproduciendo=true;
                mi_reproductor.Continuar();
                lbPause.setIcon(new ImageIcon("./src/Iconos/pause.png"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.getFrames()[0], "ocurrio un error");
        }
        }
    }//GEN-LAST:event_lbPauseMouseClicked

    private void lbStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStopMouseClicked
        // TODO add your handling code here:
        if(lbStop.isEnabled()){
            try {
            mi_reproductor.Stop();
            lbStop.setEnabled(false);
            lbPlay.setEnabled(true);
            lbPause.setEnabled(false);
            lbPause.setIcon(new ImageIcon("./src/Iconos/pause.png"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.getFrames()[0], "Error al detener");
        }
        }
    }//GEN-LAST:event_lbStopMouseClicked

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
            java.util.logging.Logger.getLogger(frmReproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReproductor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lbPause;
    private javax.swing.JLabel lbPlay;
    private javax.swing.JLabel lbStop;
    private javax.swing.JTextField txtCancion;
    // End of variables declaration//GEN-END:variables
    Reproductor mi_reproductor = new Reproductor();
    private String dirRepro;
    String usr;
    boolean reproduciendo;

    public Reproductor getMi_reproductor() {
        return mi_reproductor;
    }
    
}
