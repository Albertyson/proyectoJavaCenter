/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frmVisorImagenes extends javax.swing.JFrame {

    public frmVisorImagenes() {
        initComponents();
        this.pack();

    }

    public frmVisorImagenes(Usuario u) {
        initComponents();
        this.pack();
        File carpetaimagenes = new File("C:/" + u.getNombre() + "/Imagenes/");
        File[] archivos = carpetaimagenes.listFiles();
        for (int i = 0; i < archivos.length; i++) {
            if (archivos[i].getName().endsWith("jpg")
                    || archivos[i].getName().endsWith("png")
                    || archivos[i].getName().endsWith("gif")
                    || archivos[i].getName().endsWith("jpeg")
                    || archivos[i].getName().endsWith("bmp")) {
                imagenes.add(archivos[i]);
            }
        }
        if (imagenes.size() >= 1) {
            indice = 0;
            Image img1 = Toolkit.getDefaultToolkit().createImage(
                    imagenes.get(indice).getPath()).getScaledInstance(lbImagen.getWidth(), lbImagen.getHeight(), 0);
            lbImagen.setIcon(new ImageIcon(img1));

            wi = lbImagen.getWidth();
            he = lbImagen.getHeight();
            w = lbImagen.getWidth();
            h = lbImagen.getHeight();
            actual = (ImageIcon) lbImagen.getIcon();
        } else {
            JOptionPane.showMessageDialog(getFrames()[1], "No se encontraron archivos", "Aviso", 2);
        }

    }

    public frmVisorImagenes(File[] imagenes, File[] archivos, int indice) {
        initComponents();
        this.imagenes.addAll(Arrays.asList(imagenes));
        this.indice = indice;
        Image img = Toolkit.getDefaultToolkit().createImage(
                archivos[indice].getPath()).getScaledInstance(lbImagen.getWidth(), lbImagen.getHeight(), 0);
        lbImagen.setIcon(new ImageIcon(img));
        wi = lbImagen.getWidth();
        he = lbImagen.getHeight();
        w = lbImagen.getWidth();
        h = lbImagen.getHeight();
        actual = (ImageIcon) lbImagen.getIcon();
        this.setTitle(imagenes[indice].getName());
        try {
            for (int i = 0; i < archivos.length; i++) {
                if (archivos[i].getName().equals(imagenes[i].getName())) {
                    indice = i;
                    break;
                }
            }
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbImagen = new javax.swing.JLabel();
        zoom = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visor de imagenes");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(680, 480));
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnAnterior.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btnSiguiente.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setText("Zoom");

        lbImagen.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jScrollPane1.setViewportView(lbImagen);

        zoom.setMaximum(250);
        zoom.setMinimum(-250);
        zoom.setValue(0);
        zoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                zoomStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(zoom, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(174, 174, 174)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        try {
            if (indice < 0) {
            } else {
                indice--;
                Image img = Toolkit.getDefaultToolkit().createImage(
                        imagenes.get(indice).getPath()).getScaledInstance(wi, he, 0);
                lbImagen.setIcon(new ImageIcon(img));
                actual = (ImageIcon) lbImagen.getIcon();
                this.setTitle(imagenes.get(indice).getName());
                zoom.setValue(0);
            }
        } catch (Exception e) {
            indice++;
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        try {
            if (indice >= imagenes.size() - 1) {
            } else {
                indice++;
                Image img = Toolkit.getDefaultToolkit().createImage(
                        imagenes.get(indice).getPath()).getScaledInstance(wi, he, 0);
                lbImagen.setIcon(new ImageIcon(img));
                actual = (ImageIcon) lbImagen.getIcon();
                this.setTitle(imagenes.get(indice).getName());
                zoom.setValue(0);
            }
        } catch (Exception e) {
            indice--;
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void zoomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_zoomStateChanged
        // TODO add your handling code here:
        if (zoom.getValue() == 0) {
            ImageIcon img = actual;
            Image img2;
            img2 = img.getImage().getScaledInstance(
                    wi,
                    he,
                    0);
            ImageIcon imico = new ImageIcon(img2);
            lbImagen.setIcon(imico);
        } else {
            ImageIcon img = actual;
            Image img2;
            img2 = img.getImage().getScaledInstance(
                    w + (zoom.getValue()),
                    h + (zoom.getValue()),
                    0);
            ImageIcon imico = new ImageIcon(img2);
            lbImagen.setIcon(imico);
        }
    }//GEN-LAST:event_zoomStateChanged

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
            java.util.logging.Logger.getLogger(frmVisorImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVisorImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVisorImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVisorImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVisorImagenes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JSlider zoom;
    // End of variables declaration//GEN-END:variables
    private ArrayList<File> imagenes = new ArrayList();
    private int indice;
    int w, h, wi, he;
    ImageIcon actual;
}
