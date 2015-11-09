/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author Alberto
 */
public class frmEditorTexto extends javax.swing.JFrame {

    public frmEditorTexto(File archivo, String usr) {
        //constructor que se utiliza para abrir un archivo desde el explorador
        initComponents();
        this.usr = usr;
        this.archivo = archivo;
        FileReader fr = null;
        BufferedReader br = null;
        txtArea.setContentType("text/html");
        txtArea.setText("<html>\n<head>\n</head>\n<body><p style=\"margin-top: 0\"></p></body>\n</html>");
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea, texto = "";
            while ((linea = br.readLine()) != null) {
                texto += linea + "\n";
            }
            txtArea.setText(texto);
        } catch (Exception e) {
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
            }
        }
        mfonts = new DefaultListModel();
        listFonts.setModel(mfonts);
        String[] fonts;
        fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            mfonts.addElement(fonts[i]);
        }
        listFonts.setModel(mfonts);
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    /**
     * Creates new form frmEditorTexto
     */
    public frmEditorTexto() {
        initComponents();
        txtArea.setContentType("text/html");
        txtArea.setText("<html>\n<head>\n</head>\n<body><p style=\"margin-top: 0\"></p></body>\n</html>");
        mfonts = new DefaultListModel();
        fuente = "Consolas";
        listFonts.setModel(mfonts);
        String[] fonts;
        fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            mfonts.addElement(fonts[i]);
        }
        listFonts.setModel(mfonts);
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    public frmEditorTexto(String usr) {
        initComponents();
        this.usr = usr;
        txtArea.setContentType("text/html");
        txtArea.setText("<html>\n<head>\n</head>\n<body><p style=\"margin-top: 0\"></p></body>\n</html>");
        mfonts = new DefaultListModel();
        listFonts.setModel(mfonts);
        String[] fonts;
        fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            mfonts.addElement(fonts[i]);
        }
        listFonts.setModel(mfonts);
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgFonts = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFonts = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fchooserTexto = new javax.swing.JFileChooser();
        dlgTamano = new javax.swing.JDialog();
        slTamano = new javax.swing.JSlider();
        lblTamano = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        listFonts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listFontsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listFonts);

        jButton1.setText("Aceptar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dlgFontsLayout = new javax.swing.GroupLayout(dlgFonts.getContentPane());
        dlgFonts.getContentPane().setLayout(dlgFontsLayout);
        dlgFontsLayout.setHorizontalGroup(
            dlgFontsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFontsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgFontsLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(77, 77, 77))
        );
        dlgFontsLayout.setVerticalGroup(
            dlgFontsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFontsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(dlgFontsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        dlgTamano.setMinimumSize(new java.awt.Dimension(300, 72));
        dlgTamano.setResizable(false);

        slTamano.setMaximum(6);
        slTamano.setMinimum(1);
        slTamano.setValue(3);
        slTamano.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slTamanoStateChanged(evt);
            }
        });

        jButton3.setText("Aplicar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        Aceptar.setText("Aceptar");
        Aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AceptarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dlgTamanoLayout = new javax.swing.GroupLayout(dlgTamano.getContentPane());
        dlgTamano.getContentPane().setLayout(dlgTamanoLayout);
        dlgTamanoLayout.setHorizontalGroup(
            dlgTamanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slTamano, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(dlgTamanoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Aceptar)
                .addContainerGap())
        );
        dlgTamanoLayout.setVerticalGroup(
            dlgTamanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgTamanoLayout.createSequentialGroup()
                .addComponent(slTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dlgTamanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(Aceptar))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de texto");
        setPreferredSize(new java.awt.Dimension(200, 100));

        txtArea.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAreaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtAreaMouseEntered(evt);
            }
        });
        txtArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtAreaCaretUpdate(evt);
            }
        });
        txtArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAreaKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(txtArea);

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane2.setViewportView(ta1);

        jToolBar1.setRollover(true);

        jButton4.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButton4.setText("Negrita");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setFont(new java.awt.Font("Consolas", 2, 11)); // NOI18N
        jButton5.setText("Cursiva");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton6.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jButton6.setText("Subrayado");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jButton7.setText("Color");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jToolBar1.add(jButton7);

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem7.setText("Abrir...");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem8.setText("Guardar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);
        jMenu1.add(jSeparator1);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem12.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem12.setText("Salir");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Formato");
        jMenu3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem11.setText("Cambiar tipo de letra...");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem4.setText("Tamaño de letra");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem9.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem9.setText("Color de letra");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem13.setText("Quitar formatos");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        File fichero = null;
        FileReader fr = null;
        BufferedReader br = null;
        String contenido = "";
        try {
//            JFileChooser jfc=new JFileChooser();
//            int seleccion=jfc.showOpenDialog(getFrames()[0]);
            File root = new File("C:/" + usr + "/Documentos/");
            FileSystemView fsv = new SingleRootFileSystemView(root);
            JFileChooser jfc = new JFileChooser(fsv);
            FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                    "Archivos de texto", "txt");
            jfc.setFileFilter(filtro);
            int seleccion = jfc.showOpenDialog(getFrames()[0]);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fichero = jfc.getSelectedFile();
                fr = new FileReader(fichero);
                br = new BufferedReader(fr);
                path = fichero.getPath();
                String linea;
                while ((linea = br.readLine()) != null) {
                    contenido += linea + "\n";
                }
                txtArea.setText(contenido);
            }
        } catch (Exception e) {
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here
        dlgFonts.setModal(true);
        dlgFonts.pack();
        dlgFonts.setVisible(true);

    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        fchooserTexto.setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        ponerFont();
        dlgFonts.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        dlgFonts.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void listFontsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFontsValueChanged
        // TODO add your handling code here:
        fuente = (String) listFonts.getSelectedValue();
    }//GEN-LAST:event_listFontsValueChanged

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        quitarFormato();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void slTamanoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slTamanoStateChanged
        // TODO add your handling code here:
        lblTamano.setText(slTamano.getValue() + "");
    }//GEN-LAST:event_slTamanoStateChanged

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        dlgTamano.setModal(true);
        dlgTamano.pack();
        dlgTamano.setVisible(true);
        lblTamano.setText(slTamano.getValue() + "");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        try {
            String primero, segundo, todo;
            todo = txtArea.getText();
            String seleccion = txtArea.getSelectedText();
            String pies = "</body>\n</html>";
            String verdadero = todo.substring(44, todo.indexOf(pies));//es el verdadero texto
            primero = verdadero.substring(0, verdadero.indexOf(seleccion));
            segundo = verdadero.substring(primero.length() + seleccion.length(), verdadero.length() - 3);
            seleccion = "<font size=\"" + slTamano.getValue() + "\">" + seleccion + "</font>";
            txtArea.setText(txtArea.getText().substring(0, txtArea.getText().indexOf(verdadero)) + primero + seleccion + segundo + pies);
            txtArea.setSelectionStart(txtArea.getText().indexOf(seleccion));
            txtArea.setSelectionEnd(txtArea.getText().indexOf(seleccion) + seleccion.length());
        } catch (Exception e) {
            dlgTamano.dispose();
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void AceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AceptarMouseClicked
        // TODO add your handling code here:
        try {
            String primero, segundo, todo;
            todo = txtArea.getText();
            String seleccion = txtArea.getSelectedText();
            String pies = "</body>\n</html>";
            String verdadero = todo.substring(44, todo.indexOf(pies));//es el verdadero texto
            primero = verdadero.substring(0, verdadero.indexOf(seleccion));
            segundo = verdadero.substring(primero.length() + seleccion.length(), verdadero.length() - 3);
            seleccion = "<font size=\"" + slTamano.getValue() + "\">" + seleccion + "</font>";
            txtArea.setText(txtArea.getText().substring(0, txtArea.getText().indexOf(verdadero)) + primero + seleccion + segundo + pies);
            txtArea.setSelectionStart(txtArea.getText().indexOf(seleccion));
            txtArea.setSelectionEnd(txtArea.getText().indexOf(seleccion) + seleccion.length());
            dlgTamano.dispose();
        } catch (Exception e) {
            dlgTamano.dispose();
        }
    }//GEN-LAST:event_AceptarMouseClicked

    private void txtAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaKeyPressed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        File root = new File("C:/" + usr + "/Documentos/");
        FileSystemView fsv = new SingleRootFileSystemView(root);
        JFileChooser jfc = new JFileChooser(fsv);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "Archivos de texto", "txt");
        jfc.setFileFilter(filtro);
        int seleccion = jfc.showSaveDialog(getFrames()[0]);
        FileWriter fw = null;
        BufferedWriter bw = null;

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                File fichero = jfc.getSelectedFile();
                String filePath = fichero.getPath();
                if (!filePath.toLowerCase().endsWith(".txt")) {
                    fichero = new File(filePath + ".txt");
                }
                fw = new FileWriter(fichero);
                bw = new BufferedWriter(fw);
                String text = ta1.getText();
                int totalLines = ta1.getLineCount();
                for (int i = 0; i < totalLines; i++) {
                    int inicio = ta1.getLineStartOffset(i);
                    int fin = ta1.getLineEndOffset(i);
                    String linea = text.substring(inicio, fin);
                    bw.write(linea);
                    bw.newLine();
                    bw.flush();
                }
                bw.flush();
            } catch (Exception e) {
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                }
            }
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void txtAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAreaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaMouseClicked

    private void txtAreaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAreaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaMouseEntered

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        try {
            JColorChooser jcc = new JColorChooser(Color.BLACK);
            color = JColorChooser.showDialog(this.getFrames()[0], "Elija un color", Color.black);
            String azul, verde, rojo;
            azul = Integer.toHexString(color.getBlue());
            if (color.getBlue() < 10) {
                azul = "0" + Integer.toHexString(color.getBlue());
            }
            verde = Integer.toHexString(color.getGreen());
            if (color.getGreen() < 10) {
                verde = "0" + Integer.toHexString(color.getGreen());
            }
            rojo = Integer.toHexString(color.getRed());
            if (color.getRed() < 10) {
                rojo = "0" + Integer.toHexString(color.getRed());
            }
            String rgb = rojo + "" + verde + "" + azul;
            String primero, segundo, todo;
            todo = txtArea.getText();
            String seleccion = txtArea.getSelectedText();
            String pies = "</body>\n</html>";
            String verdadero = todo.substring(44, todo.indexOf(pies));//es el verdadero texto
            primero = verdadero.substring(0, verdadero.indexOf(seleccion));
            segundo = verdadero.substring(primero.length() + seleccion.length(), verdadero.length() - 3);
            seleccion = "<font color=\"" + rgb + "\">" + seleccion + "</font>";
            txtArea.setText(txtArea.getText().substring(0, txtArea.getText().indexOf(verdadero)) + primero + seleccion + segundo + pies);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void txtAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtAreaCaretUpdate
        // TODO add your handling code here:
        ta1.setText(txtArea.getText());
    }//GEN-LAST:event_txtAreaCaretUpdate

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            ponerCursiva();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        try {
            ponerNegrita();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            ponerSubrayado();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        try {
            JColorChooser jcc = new JColorChooser(Color.BLACK);
            color = JColorChooser.showDialog(this.getFrames()[0], "Elija un color", Color.black);
            String azul, verde, rojo;
            azul = Integer.toHexString(color.getBlue());
            if (color.getBlue() < 10) {
                azul = "0" + Integer.toHexString(color.getBlue());
            }
            verde = Integer.toHexString(color.getGreen());
            if (color.getGreen() < 10) {
                verde = "0" + Integer.toHexString(color.getGreen());
            }
            rojo = Integer.toHexString(color.getRed());
            if (color.getRed() < 10) {
                rojo = "0" + Integer.toHexString(color.getRed());
            }
            String rgb = rojo + "" + verde + "" + azul;
            String primero, segundo, todo;
            todo = txtArea.getText();
            String seleccion = txtArea.getSelectedText();
            String pies = "</body>\n</html>";
            String verdadero = todo.substring(44, todo.indexOf(pies));//es el verdadero texto
            primero = verdadero.substring(0, verdadero.indexOf(seleccion));
            segundo = verdadero.substring(primero.length() + seleccion.length(), verdadero.length() - 3);
            seleccion = "<font color=\"" + rgb + "\">" + seleccion + "</font>";
            txtArea.setText(txtArea.getText().substring(0, txtArea.getText().indexOf(verdadero)) + primero + seleccion + segundo + pies);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton7MouseClicked

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        txtArea.setText("\"<html>\\n<head>\\n</head>\\n<body><p style=\\\"margin-top: 0\\\"></p></body>\\n</html>\"");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmEditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEditorTexto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JDialog dlgFonts;
    private javax.swing.JDialog dlgTamano;
    private javax.swing.JFileChooser fchooserTexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblTamano;
    private javax.swing.JList listFonts;
    private javax.swing.JSlider slTamano;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTextPane txtArea;
    // End of variables declaration//GEN-END:variables
    private String temp, fuente;
    DefaultListModel mfonts;
    private MutableAttributeSet atrfont = new SimpleAttributeSet();
    private StyledDocument doc;
    private String path;
    private HTMLEditorKit kit = new HTMLEditorKit();
    private HTMLDocument dc = new HTMLDocument();
    private File archivo;
    Color color;
    String usr;

    public String seleccionado(String m) {

        return "";
    }

    public void ponerNegrita() {
        String primero, segundo, todo;
        todo = txtArea.getText();
        String seleccion = txtArea.getSelectedText();
        String pies = "</body>\n</html>";
        String verdadero = todo.substring(44, todo.indexOf(pies));//es el verdadero texto
        primero = verdadero.substring(0, verdadero.indexOf(seleccion));
        segundo = verdadero.substring(primero.length() + seleccion.length(), verdadero.length() - 3);
        seleccion = "<b>" + seleccion + "</b>";
        txtArea.setText(txtArea.getText().substring(0, txtArea.getText().indexOf(verdadero)) + primero + seleccion + segundo + pies);
    }

    public void ponerCursiva() {

        String primero, segundo, todo;
        todo = txtArea.getText();
        String seleccion = txtArea.getSelectedText();
        String pies = "</body>\n</html>";
        String verdadero = todo.substring(44, todo.indexOf(pies));//es el verdadero texto
        primero = verdadero.substring(0, verdadero.indexOf(seleccion));
        segundo = verdadero.substring(primero.length() + seleccion.length(), verdadero.length() - 3);
        seleccion = "<i>" + seleccion + "</i>";
        txtArea.setText(txtArea.getText().substring(0, txtArea.getText().indexOf(verdadero)) + primero + seleccion + segundo + pies);
    }

    public void ponerSubrayado() {
        String primero, segundo, todo;
        todo = txtArea.getText();
        String seleccion = txtArea.getSelectedText();
        String pies = "</body>\n</html>";
        String verdadero = todo.substring(44, todo.indexOf(pies));//es el verdadero texto
        primero = verdadero.substring(0, verdadero.indexOf(seleccion));
        segundo = verdadero.substring(primero.length() + seleccion.length(), verdadero.length() - 3);
        seleccion = "<u>" + seleccion + "</u>";
        txtArea.setText(txtArea.getText().substring(0, txtArea.getText().indexOf(verdadero)) + primero + seleccion + segundo + pies);
    }

    public void ponerFont() {
        String primero, segundo, todo;
        todo = txtArea.getText();
        String seleccion = txtArea.getSelectedText();
        String pies = "</body>\n</html>";
        String verdadero = todo.substring(44, todo.indexOf(pies));//es el verdadero texto
        primero = verdadero.substring(0, verdadero.indexOf(seleccion));
        segundo = verdadero.substring(primero.length() + seleccion.length(), verdadero.length() - 3);
        seleccion = "<font face =\"" + fuente + "\">" + seleccion + "</font>";
        txtArea.setText(txtArea.getText().substring(0, txtArea.getText().indexOf(verdadero)) + primero + seleccion + segundo + pies);
    }

    public void quitarFormato() {
        String primero, segundo, todo;
        todo = txtArea.getText();
        String seleccion = txtArea.getSelectedText();
        String pies = "</body>\n</html>";
        String verdadero = todo.substring(44, todo.indexOf(pies));//es el verdadero texto
        verdadero = verdadero.replaceAll("<b>", "");
        verdadero = verdadero.replaceAll("</b>", "");
        verdadero = verdadero.replaceAll("<i>", "");
        verdadero = verdadero.replaceAll("</i>", "");
        verdadero = verdadero.replaceAll("<u>", "");
        verdadero = verdadero.replaceAll("</u>", "");
        String cabeza = "<html>\n<head>\n</head>\n<body>";
        txtArea.setText(cabeza + verdadero + pies);
    }

    public void quitarNCS() {
        String primero, segundo, todo;
        todo = txtArea.getText();
        String seleccion = txtArea.getSelectedText();
        String pies = "</body>\n</html>";
        String verdadero = todo.substring(44, todo.indexOf(pies));//es el verdadero texto
        primero = verdadero.substring(0, verdadero.indexOf(seleccion) - 3);
        segundo = verdadero.substring(primero.length() + seleccion.length() + 3, verdadero.length() - 3);
        txtArea.setText(txtArea.getText().substring(0, txtArea.getText().indexOf(verdadero)) + primero + seleccion + segundo + pies);
    }
}
