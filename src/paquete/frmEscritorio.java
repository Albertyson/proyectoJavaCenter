/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.awt.Color;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class frmEscritorio extends javax.swing.JFrame {

    /**
     * Creates new form frmEscritorio
     */
    public frmEscritorio() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }
    
    public frmEscritorio(Usuario u, ArrayList<Usuario> usuarios) {
        initComponents();
        usuarioActual = u;
        if (usuarioActual.getTipo().equals(TipoUsuario.Estandar)) {
            mnuCrearCuenta.setVisible(false);
        }
        this.usuarios = usuarios;
        this.setExtendedState(this.MAXIMIZED_BOTH);
        //
        //llenar el combo box de eliminar
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) cmbUsuarios.getModel();
        for (int i = 0; i < usuarios.size(); i++) {
            modelo.addElement(usuarios.get(i).getNombre());
        }
        cmbUsuarios.setModel(modelo);
        //Revisar eventos y tareas pendientes
        areventos = new File("./" + u.getNombre() + "/Calendario/Eventos.bin");
        artareas = new File("./" + u.getNombre() + "/Calendario/Tareas.bin");
        heventos = new ArrayList();
        htareas = new ArrayList();
        
        
        if (areventos.exists()) {
            ArrayList<Evento> eventos = new ArrayList();
            //llenar el arraylist de eventos
            try {
                FileInputStream entrada = new FileInputStream(areventos);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    Evento temp;
                    while ((temp = (Evento) objeto.readObject()) != null) {
                        eventos.add(temp);
                    }
                } catch (EOFException e) {
                } finally {
                    objeto.close();
                    entrada.close();
                }
            } catch (Exception e) {
            }
            //eliminar del arraylist los eventos que ya pasaron
            for (int i = 0; i < eventos.size(); i++) {
                Date hsistema = new Date();
                if (eventos.get(i).getHinicio().before(hsistema)) {
                    eventos.remove(i);
                }
            }
            //eliminar el archivo de eventos
            areventos.delete();
            //crear el archivo nuevamente con los eventos que no han pasado
            try {
                FileOutputStream salida = new FileOutputStream(areventos);
                ObjectOutputStream objeto2 = new ObjectOutputStream(salida);
                for (Evento ev : eventos) {
                    objeto2.writeObject(ev);
                }
                objeto2.flush();
                objeto2.close();
                salida.close();
                areventos.createNewFile();
            } catch (Exception e) {
            }
            //levantar los hilos de los eventos no obsoletos
            for (int i = 0; i < eventos.size(); i++) {
                HiloEvento Heventos = new HiloEvento(eventos.get(i).getRecordatorio(),
                        eventos.get(i).getTitulo(),
                        eventos.get(i).getHinicio(),
                        areventos, eventos.get(i));
                heventos.add(Heventos);
                Heventos.start();
            }
        }//fin del if si existe el archivo eventos

        if (artareas.exists()) {
            ArrayList<Tarea> tareas = new ArrayList();
            //llenar el arraylist de tareas
            try {
                FileInputStream entrada = new FileInputStream(artareas);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    Tarea temp;
                    while ((temp = (Tarea) objeto.readObject()) != null) {
                        tareas.add(temp);
                    }
                } catch (EOFException e) {
                } finally {
                    objeto.close();
                    entrada.close();
                }
            } catch (Exception e) {
            }
            //eliminar del arraylist los eventos que ya pasaron
            for (int i = 0; i < tareas.size(); i++) {
                Date hsistema = new Date();
                if (tareas.get(i).getInicio().before(hsistema)) {
                    tareas.remove(i);
                }
            }
            //eliminar el archivo de eventos
            artareas.delete();
            //crear el archivo nuevamente con los eventos que no han pasado
            try {
                FileOutputStream salida = new FileOutputStream(artareas);
                ObjectOutputStream objeto2 = new ObjectOutputStream(salida);
                for (Tarea ta : tareas) {
                    objeto2.writeObject(ta);
                }
                objeto2.flush();
                objeto2.close();
                salida.close();
                artareas.createNewFile();
            } catch (Exception e) {
            }
            //levantar los hilos de las tareas no obsoletas
            for (int i = 0; i < tareas.size(); i++) {
                HiloTarea Htareas = new HiloTarea(tareas.get(i).getRecordatorio(),
                        tareas.get(i).getTitulo(),
                        tareas.get(i).getInicio(),
                        artareas, tareas.get(i));
                htareas.add(Htareas);
                Htareas.start();
            }
        }//fin del if si existe el archivo de tareas

        
    }
    
    public void ExceptionRegistroVacios() throws Exceptions {
        if (txtPassReg.getText().equals("") || txtNomReg.getText().equals("") || tipoUser.equals(TipoUsuario.No)) {
            throw new Exceptions("Debe llenar todos los campos");
        }
    }
    
    public void ExceptionRegistroRepetido(String nombre) throws Exceptions {
        if (nombre.equals(txtNomReg.getText())) {
            throw new Exceptions("Ya existe un usuario con el mismo nombre");
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

        dlgAdministrar = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dlgRegistrar = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNomReg = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        opcAdmin = new javax.swing.JRadioButton();
        opcRegular = new javax.swing.JRadioButton();
        txtPassReg = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        fcFondo = new javax.swing.JFileChooser();
        dlgEliminar = new javax.swing.JDialog();
        cmbUsuarios = new javax.swing.JComboBox();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuCalendario = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuCrearCuenta = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        dlgAdministrar.setMinimumSize(new java.awt.Dimension(640, 480));
        dlgAdministrar.setResizable(false);
        dlgAdministrar.getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        jLabel2.setText("Administrar cuenta");
        dlgAdministrar.getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 20, 170, 20);

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel9.setText("Cambiar contraseña");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        dlgAdministrar.getContentPane().add(jLabel9);
        jLabel9.setBounds(50, 120, 220, 20);

        jLabel11.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel11.setText("Eliminar cuenta");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        dlgAdministrar.getContentPane().add(jLabel11);
        jLabel11.setBounds(50, 200, 200, 20);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios.png"))); // NOI18N
        jLabel12.setMaximumSize(new java.awt.Dimension(640, 480));
        jLabel12.setMinimumSize(new java.awt.Dimension(6480, 480));
        jLabel12.setPreferredSize(new java.awt.Dimension(640, 480));
        dlgAdministrar.getContentPane().add(jLabel12);
        jLabel12.setBounds(370, 70, 270, 220);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inicio.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setMaximumSize(new java.awt.Dimension(640, 480));
        jLabel3.setMinimumSize(new java.awt.Dimension(640, 480));
        jLabel3.setPreferredSize(new java.awt.Dimension(640, 480));
        dlgAdministrar.getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 640, 480);

        dlgRegistrar.setMinimumSize(new java.awt.Dimension(640, 480));
        dlgRegistrar.setResizable(false);
        dlgRegistrar.getContentPane().setLayout(null);

        jLabel6.setText("Nombre de usuario");
        dlgRegistrar.getContentPane().add(jLabel6);
        jLabel6.setBounds(180, 160, 130, 14);

        jLabel7.setText("Contraseña de usuario");
        dlgRegistrar.getContentPane().add(jLabel7);
        jLabel7.setBounds(180, 190, 140, 14);
        dlgRegistrar.getContentPane().add(txtNomReg);
        txtNomReg.setBounds(340, 140, 121, 30);

        jButton2.setText("Crear Usuario");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        dlgRegistrar.getContentPane().add(jButton2);
        jButton2.setBounds(260, 260, 150, 23);

        buttonGroup1.add(opcAdmin);
        opcAdmin.setText("Administrador");
        opcAdmin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                opcAdminStateChanged(evt);
            }
        });
        dlgRegistrar.getContentPane().add(opcAdmin);
        opcAdmin.setBounds(190, 220, 120, 23);

        buttonGroup1.add(opcRegular);
        opcRegular.setText("Estandar");
        opcRegular.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                opcRegularStateChanged(evt);
            }
        });
        dlgRegistrar.getContentPane().add(opcRegular);
        opcRegular.setBounds(340, 220, 120, 23);
        dlgRegistrar.getContentPane().add(txtPassReg);
        txtPassReg.setBounds(340, 180, 121, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inicio.jpg"))); // NOI18N
        jLabel8.setText("jLabel7");
        dlgRegistrar.getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 1958, 1200);

        fcFondo.setControlButtonsAreShown(false);
        fcFondo.setDialogTitle("Seleccione una imagen de fondo...");
        fcFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        dlgEliminar.setMinimumSize(new java.awt.Dimension(260, 180));
        dlgEliminar.setResizable(false);
        dlgEliminar.getContentPane().setLayout(null);

        cmbUsuarios.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        cmbUsuarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbUsuariosItemStateChanged(evt);
            }
        });
        dlgEliminar.getContentPane().add(cmbUsuarios);
        cmbUsuarios.setBounds(50, 30, 190, 30);

        btnEliminar.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        btnEliminar.setText("Eliminar cuenta");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        dlgEliminar.getContentPane().add(btnEliminar);
        btnEliminar.setBounds(70, 70, 140, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inicio.jpg"))); // NOI18N
        jLabel4.setText("jLabel3");
        jLabel4.setMaximumSize(new java.awt.Dimension(640, 480));
        jLabel4.setMinimumSize(new java.awt.Dimension(640, 480));
        jLabel4.setPreferredSize(new java.awt.Dimension(640, 480));
        dlgEliminar.getContentPane().add(jLabel4);
        jLabel4.setBounds(-340, 0, 1000, 400);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/w1.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jMenuBar1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        jMenu1.setText("Tareas");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        mnuCalendario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mnuCalendario.setText("Agenda");
        mnuCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCalendarioActionPerformed(evt);
            }
        });
        jMenu1.add(mnuCalendario);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText("Consola");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Editor de texto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Enviar correo electrónico");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setText("Enviar mensaje a un usuario");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Explorador");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Reproductor de música");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Visor de imagenes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem9.setText("Salir del sistema");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cuenta");

        mnuCrearCuenta.setText("Crear Cuenta");
        mnuCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCrearCuentaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCrearCuenta);

        jMenuItem7.setText("Cerrar Sesion");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Administrar cuenta");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        fcorre = new frmCorreos(usuarioActual.getNombre());
        fcorre.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked
    
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        frep = new frmReproductor(usuarioActual.getNombre());
        frep.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        fed = new frmEditorTexto(usuarioActual.getNombre());
        fed.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        fvisor = new frmVisorImagenes(usuarioActual);
        fvisor.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        fcons = new FrmConsola();
        fcons.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            // TODO add your handling code here:
            ExceptionRegistroVacios();
            usuarios.add(new Usuario(txtNomReg.getText(), txtPassReg.getText(), tipoUser));
            Usuario u = new Usuario(txtNomReg.getText(), txtPassReg.getText(), tipoUser);
            File archivo = new File("./Usuarios.bin");
            //Agregar
            FileInputStream entrada = new FileInputStream(archivo);
            ObjectInputStream objeto = new ObjectInputStream(entrada);
            Usuario temp;
            ArrayList<Usuario> usrs = new ArrayList();
            try {
                while ((temp = (Usuario) objeto.readObject()) != null) {
                    ExceptionRegistroRepetido(temp.getNombre());
                    usrs.add(temp);
                }
            } catch (EOFException r) {
            } finally {
                entrada.close();
                objeto.close();
            }
            usrs.add(u);
            //sobreescribir el archivo
            FileOutputStream salida = new FileOutputStream(archivo);
            ObjectOutputStream objeto2 = new ObjectOutputStream(salida);
            for (Usuario per : usrs) {
                objeto2.writeObject(per);
            }
            objeto2.flush();
            objeto2.close();
            salida.close();
            File nuevoUsuario = new File("C:/" + txtNomReg.getText() + "/");
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
            txtNomReg.setText("");
            txtPassReg.setText("");
            JOptionPane.showMessageDialog(this.getFrames()[0], "El usuario fue ingresado con exito");
            dlgRegistrar.dispose();
        } catch (Exceptions ex) {
            JOptionPane.showMessageDialog(this.getFrames()[0], ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getFrames()[0], "Ocurrio un error");
        }
    }//GEN-LAST:event_jButton2MouseClicked
    
    private void opcAdminStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcAdminStateChanged
        // TODO add your handling code here:
        if (opcAdmin.isSelected()) {
            tipoUser = TipoUsuario.Administrador;
        }
    }//GEN-LAST:event_opcAdminStateChanged
    
    private void opcRegularStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcRegularStateChanged
        // TODO add your handling code here:
        if (opcRegular.isSelected()) {
            tipoUser = TipoUsuario.Estandar;
        }
    }//GEN-LAST:event_opcRegularStateChanged
    
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        dlgAdministrar.setModal(true);
        dlgAdministrar.pack();
        dlgAdministrar.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed
    
    private void mnuCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCrearCuentaActionPerformed
        // TODO add your handling code here:.
        dlgRegistrar.setModal(true);
        dlgRegistrar.pack();
        dlgRegistrar.setVisible(true);
    }//GEN-LAST:event_mnuCrearCuentaActionPerformed
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        fex = new frmExplorador(usuarioActual.getNombre() + "/");
        fex.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed
    
    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        jLabel9.setForeground(Color.green);
    }//GEN-LAST:event_jLabel9MouseEntered
    
    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        jLabel9.setForeground(Color.black);
    }//GEN-LAST:event_jLabel9MouseExited
    
    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        // TODO add your handling code here:
        jLabel11.setForeground(Color.black);
    }//GEN-LAST:event_jLabel11MouseExited
    
    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        // TODO add your handling code here:
        jLabel11.setForeground(Color.green);
    }//GEN-LAST:event_jLabel11MouseEntered
    
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        //cerrar todos los procesos actuales
        try {
            fcons.dispose();
        } catch (Exception e) {
        }
        try {
            fagen.dispose();
        } catch (Exception e) {
        }
        try {
            fcorre.dispose();
        } catch (Exception e) {
        }
        try {
            fed.dispose();
        } catch (Exception e) {
        }
        try {
            fex.dispose();
        } catch (Exception e) {
        }
        try {
            fmens.dispose();
        } catch (Exception e) {
        }
        try {
            frep.dispose();
            frep.getMi_reproductor().Stop();
        } catch (Exception e) {
        }
        try {
            fvisor.dispose();
        } catch (Exception e) {
        }
        
        
        this.dispose();
        //parar los hilos de tareas y eventos
        for (int i = 0; i < heventos.size(); i++) {
            heventos.get(i).setVive(false);
        }
        for (int i = 0; i < htareas.size(); i++) {
            htareas.get(i).setVive(false);
        }
        frmInicioSesion i = new frmInicioSesion();
        i.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem9ActionPerformed
    
    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        fmens = new frmMensajero(usuarioActual);
        fmens.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed
    
    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        users = new File("./Usuarios.bin");
        //cuando es un administrador
        if (usuarioActual.getTipo().equals(TipoUsuario.Administrador)) {
            dlgEliminar.setModal(true);
            dlgEliminar.pack();
            dlgEliminar.setVisible(true);
            btnEliminar.setVisible(false);
            
        } else {//cuando es cuenta estandar
            if (JOptionPane.showConfirmDialog(getFrames()[1], "Seguro que desea eliminar su cuenta") == JOptionPane.YES_OPTION) {
                File archs = new File("./" + usuarioActual.getNombre() + "/");
                borrarDirectorio(archs);
                archs.delete();
                usuarios.remove(usuarioActual);
                try {
                    FileOutputStream salida = new FileOutputStream(users);
                    ObjectOutputStream objeto = new ObjectOutputStream(salida);
                    for (int i = 0; i < usuarios.size(); i++) {
                        Usuario p = new Usuario(
                                usuarios.get(i).getNombre(),
                                usuarios.get(i).getPassword(),
                                usuarios.get(i).getTipo());
                        objeto.writeObject(p);
                        objeto.flush();
                    }
                    
                    objeto.close();
                    salida.close();
                    users.createNewFile();
                    JOptionPane.showMessageDialog(this.getFrames()[1], "Su cuenta ha sido eliminada");
                    dlgAdministrar.dispose();
                    
                } catch (Exception ex) {
                }
            }
        }
    }//GEN-LAST:event_jLabel11MouseClicked
    
    private void mnuCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCalendarioActionPerformed
        // TODO add your handling code here:
        fagen = new frmAgenda(usuarioActual, this);
        fagen.setVisible(true);
        
    }//GEN-LAST:event_mnuCalendarioActionPerformed
    
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        String pas;
        do {
            pas = JOptionPane.showInputDialog("Ingrese su contraseña actual");
        } while (pas == null);
        if (pas.equals(usuarioActual.getPassword())) {
            String nuevoPass;
            do {
                nuevoPass = JOptionPane.showInputDialog("Ingrese la nueva contraseña: ");
            } while (nuevoPass == null);
            users = new File("./usuarios.bin");
            Usuario p = new Usuario(usuarioActual.getNombre(), nuevoPass, usuarioActual.getTipo());
            try {
                int ind = 0;
                for (int i = 0; i < usuarios.size(); i++) {
                    if (usuarios.get(i).getNombre().equals(usuarioActual.getNombre())) {
                        ind = i;
                        break;
                    }
                }
                usuarios.set(ind, p);
                //sobreescribir el archivo
                FileOutputStream salida = new FileOutputStream(users);
                ObjectOutputStream objeto2 = new ObjectOutputStream(salida);
                for (Usuario usr : usuarios) {
                    objeto2.writeObject(usr);
                }
                objeto2.flush();
                objeto2.close();
                salida.close();
                users.createNewFile();
                usuarioActual = usuarios.get(ind);
                JOptionPane.showMessageDialog(this.getFrames()[0], "Se ha cambiado su contraseña");
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(this.getFrames()[0], "Contraseña Incorrecta");
        }
        
    }//GEN-LAST:event_jLabel9MouseClicked
    
    private void cmbUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUsuariosItemStateChanged
        // TODO add your handling code here:
        if (cmbUsuarios.getSelectedItem().equals(usuarioActual.getNombre()) && usuarioActual.getTipo().equals(TipoUsuario.Administrador)) {
            btnEliminar.setVisible(false);
        } else {
            btnEliminar.setVisible(true);
        }
    }//GEN-LAST:event_cmbUsuariosItemStateChanged
    
    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(getFrames()[1], "Seguro que desea eliminar esta cuenta") == JOptionPane.YES_OPTION) {
            File archs = new File("C:\\" + cmbUsuarios.getSelectedItem() + "\\");
            borrarDirectorio(archs);//metodo para eliminar carpetas y archivos dentro carpetas
            archs.delete();//borrar la carpeta vacía
            int ind = 0;//variable para el indice del combobox
            for (int i = 0; i < usuarios.size(); i++) {//ciclo para encontrar el indice del usuario eliminado
                if (usuarios.get(i).getNombre().equals(cmbUsuarios.getSelectedItem())) {
                    ind = i;
                    break;
                }
            }
            usuarios.remove(usuarios.get(ind));//eliminar al usuario del ArrayList de usuarios
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            for (int i = 0; i < usuarios.size(); i++) {
                modelo.addElement(usuarios.get(i).getNombre());
            }
            cmbUsuarios.setModel(modelo);
            //eliminar del archivo binario al usuario
            try {
                FileOutputStream salida = new FileOutputStream(users);
                ObjectOutputStream objeto = new ObjectOutputStream(salida);
                for (int i = 0; i < usuarios.size(); i++) {
                    Usuario p = new Usuario(
                            usuarios.get(i).getNombre(),
                            usuarios.get(i).getPassword(),
                            usuarios.get(i).getTipo());
                    objeto.writeObject(p);
                    objeto.flush();
                }
                
                objeto.close();
                salida.close();
                users.createNewFile();
                JOptionPane.showMessageDialog(this.getFrames()[1], "La cuenta ha sido eliminada");
                dlgEliminar.dispose();
                btnEliminar.setVisible(false);
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

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
            java.util.logging.Logger.getLogger(frmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEscritorio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbUsuarios;
    private javax.swing.JDialog dlgAdministrar;
    private javax.swing.JDialog dlgEliminar;
    private javax.swing.JDialog dlgRegistrar;
    private javax.swing.JFileChooser fcFondo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem mnuCalendario;
    private javax.swing.JMenuItem mnuCrearCuenta;
    private javax.swing.JRadioButton opcAdmin;
    private javax.swing.JRadioButton opcRegular;
    private javax.swing.JTextField txtNomReg;
    private javax.swing.JPasswordField txtPassReg;
    // End of variables declaration//GEN-END:variables
    private TipoUsuario tipoUser = TipoUsuario.No;
    ArrayList<Usuario> usuarios = new ArrayList();
    Usuario usuarioActual;
    File users;
    File areventos;
    File artareas;
    ArrayList<HiloEvento> heventos;
    ArrayList<HiloTarea> htareas;
    frmCorreos fcorre;
    FrmConsola fcons;
    frmAgenda fagen;
    frmEditorTexto fed;
    frmExplorador fex;
    frmMensajero fmens;
    frmReproductor frep;
    frmVisorImagenes fvisor;
    
    public void borrarDirectorio(File directorio) {
        File[] ficheros = directorio.listFiles();
        for (int x = 0; x < ficheros.length; x++) {
            if (ficheros[x].isDirectory()) {
                borrarDirectorio(ficheros[x]);
            }
            ficheros[x].delete();
        }
    }
    
    public void setHeventos(HiloEvento heventos) {
        this.heventos.add(heventos);
    }
    
    public void setHtareas(HiloTarea htareas) {
        this.htareas.add(htareas);
    }
}
