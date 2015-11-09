/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import com.toedter.calendar.JDateChooser;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alberto
 */
public class frmAgenda extends javax.swing.JFrame {

    public frmAgenda() {
        initComponents();
    }

    public frmAgenda(Usuario u, frmEscritorio f) {
        initComponents();
        this.u = u;
        this.f = f;
    }

    public void ExceptionFecha(Date hinicio, Date hfin) throws Exceptions {
        if (hinicio.after(hfin)) {
            throw new Exceptions("Verifique la fecha de inicio y la fecha de fin");
        }
        Date hsistema = new Date();
        if (hinicio.before(hsistema)) {
            throw new Exceptions("Esa hora ya pasó, cambie la hora de inicio");
        }
    }

    public void ExceptionFecha(Date fecha) throws Exceptions {
        Date hsistema = new Date();
        if (fecha.before(hsistema)) {
            throw new Exceptions("Esa hora ya pasó, cambie la hora");
        }
    }

    public void ExceptionVacios(JDateChooser dc1, JTextField ti1, JSpinner record) throws Exceptions {
        if (dc1 == null || ti1 == null || record.getValue() == 0 || ti1.getText().equals("")) {
            throw new Exceptions("Llene todos los campos");
        }
    }

    public void ExceptionVacios(JDateChooser dc2, JTextField ti1, JSpinner record2, String contenido, String notas) throws Exceptions {
        if (dc1 == null || ti1 == null || record2.getValue() == 0 || ti1.getText().equals("")) {
            throw new Exceptions("Llene todos los campos");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgEventos = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaEventos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        dlgTareas = new javax.swing.JDialog();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaTareas = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ti1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        record1 = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        hrsinicio1 = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        mininicio1 = new javax.swing.JSpinner();
        minfin1 = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        hrsfin1 = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        dc1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        content = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notas = new javax.swing.JTextArea();
        ti2 = new javax.swing.JTextField();
        record2 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        hora2 = new javax.swing.JSpinner();
        min2 = new javax.swing.JSpinner();
        dc2 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        dlgEventos.setResizable(false);

        TablaEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Evento", "Fecha", "Inicio", "Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaEventos);

        jLabel8.setFont(new java.awt.Font("Consolas", 3, 24)); // NOI18N
        jLabel8.setText("Eventos");

        javax.swing.GroupLayout dlgEventosLayout = new javax.swing.GroupLayout(dlgEventos.getContentPane());
        dlgEventos.getContentPane().setLayout(dlgEventosLayout);
        dlgEventosLayout.setHorizontalGroup(
            dlgEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(dlgEventosLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        dlgEventosLayout.setVerticalGroup(
            dlgEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgEventosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dlgTareas.setResizable(false);

        jLabel22.setFont(new java.awt.Font("Consolas", 3, 24)); // NOI18N
        jLabel22.setText("Tareas");

        TablaTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tarea", "Fecha", "Contenido", "Notas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TablaTareas);

        javax.swing.GroupLayout dlgTareasLayout = new javax.swing.GroupLayout(dlgTareas.getContentPane());
        dlgTareas.getContentPane().setLayout(dlgTareasLayout);
        dlgTareasLayout.setHorizontalGroup(
            dlgTareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(dlgTareasLayout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel22)
                .addContainerGap())
        );
        dlgTareasLayout.setVerticalGroup(
            dlgTareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgTareasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agenda");

        jTabbedPane1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel9.setText("Título");

        ti1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ti1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel10.setText("Recordatorio");

        jLabel11.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel11.setText("Cada");

        jLabel12.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel12.setText("Minutos");

        jLabel13.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel13.setText("Hora de inicio");

        jLabel14.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel14.setText("Hora de fin");

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel15.setText("Hora");

        hrsinicio1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        jLabel16.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel16.setText("Min");

        mininicio1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        minfin1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jLabel17.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel17.setText("Min");

        hrsfin1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        jLabel18.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel18.setText("Hora");

        jButton1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jButton1.setText("Agregar evento al calendario");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel21.setText("Fecha");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(record1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hrsinicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mininicio1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hrsfin1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minfin1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ti1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(dc1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)))))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(dc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(record1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(hrsinicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(mininicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(hrsfin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(minfin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eventos", jPanel2);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel1.setText("Título");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel2.setText("Recordatorio");

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel3.setText("Fecha");

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel4.setText("Contenido");

        content.setColumns(20);
        content.setRows(5);
        jScrollPane1.setViewportView(content);

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel5.setText("Notas");

        notas.setColumns(20);
        notas.setRows(5);
        jScrollPane2.setViewportView(notas);

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel6.setText("Minutos");

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel7.setText("En");

        jLabel19.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel19.setText("Hora");

        jLabel20.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jLabel20.setText("Minutos");

        hora2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        min2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));

        jButton2.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jButton2.setText("Agregar tarea al calendario");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dc2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hora2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(min2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(record2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(ti2)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(hora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)
                                .addComponent(min2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dc2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ti2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(record2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tareas", jPanel1);

        jMenu1.setText("Actividades pendientes");
        jMenu1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem1.setText("Tareas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem2.setText("Eventos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ti1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ti1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ti1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            Date hinicio = new Date();
            Date hfin = new Date();
            Date hfecha = new Date();
            GregorianCalendar fecha = new GregorianCalendar();
            hfecha.setSeconds(0);
            hfecha.setMinutes((Integer) mininicio1.getValue());
            hfecha.setHours((Integer) hrsinicio1.getValue());
            hfecha.setDate(dc1.getDate().getDate());
            hfecha.setMonth(dc1.getDate().getMonth());
            hfecha.setYear(dc1.getDate().getYear());
            hinicio.setSeconds(0);
            hinicio.setMinutes((Integer) mininicio1.getValue());
            hinicio.setHours((Integer) hrsinicio1.getValue());
            hinicio.setDate(dc1.getDate().getDate());
            hinicio.setMonth(dc1.getDate().getMonth());
            hinicio.setYear(dc1.getDate().getYear());
            hfin.setSeconds(0);
            hfin.setMinutes((Integer) minfin1.getValue());
            hfin.setHours((Integer) hrsfin1.getValue());
            hfin.setDate(dc1.getDate().getDate());
            hfin.setMonth(dc1.getDate().getMonth());
            hfin.setYear(dc1.getDate().getYear());
            fecha.setTime(hfecha);
            ExceptionVacios(dc1, ti1, record1);
            ExceptionFecha(hinicio, hfin);//validar las fechas            
            File archivo = new File("C:/" + u.getNombre() + "/Calendario/Eventos.bin");
            evento = new Evento(hinicio, hfin, fecha, ti1.getText(), (Integer) record1.getValue());
            if (!archivo.exists()) {
                FileOutputStream salida = new FileOutputStream(archivo);
                ObjectOutputStream objeto = new ObjectOutputStream(salida);
                objeto.writeObject(evento);
                objeto.flush();
                objeto.close();
                salida.close();
                archivo.createNewFile();

            } else {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                Evento temp;
                ArrayList<Evento> eventos = new ArrayList();
                try {
                    while ((temp = (Evento) objeto.readObject()) != null) {
                        eventos.add(temp);
                    }
                } catch (EOFException r) {
                } finally {
                    entrada.close();
                    objeto.close();
                }
                eventos.add(evento);
                //sobreescribir el archivo
                FileOutputStream salida = new FileOutputStream(archivo);
                ObjectOutputStream objeto2 = new ObjectOutputStream(salida);
                for (Evento ev : eventos) {
                    objeto2.writeObject(ev);
                }
                objeto2.flush();
                objeto2.close();
                salida.close();
            }
            String hr = "" + hinicio.getHours(), mi = "" + hinicio.getMinutes();
            if (hinicio.getHours() < 10) {
                hr = "0" + hinicio.getHours();
            }
            if (hinicio.getMinutes() < 10) {
                mi = "0" + hinicio.getMinutes();
            }
            hiloevento = new HiloEvento((Integer) record1.getValue(),
                    ti1.getText() + "\n a las: " + hr + ":" + mi, hinicio, archivo, evento);
            hiloevento.start();
            f.setHeventos(hiloevento);
        } catch (Exceptions e) {
            JOptionPane.showMessageDialog(this.getFrames()[0], e.getMessage(), "Error", 2);
        } catch (Exception ex) {
        }

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:        
        DefaultTableModel modelo = (DefaultTableModel) TablaEventos.getModel();
        try {
            if (modelo.getRowCount() > 0) {//para limpiar la tabla
                int filas = modelo.getRowCount();
                for (int j = 0; j < filas; j++) {
                    modelo.removeRow(0);
                }
            }
        } catch (IllegalArgumentException iarex) {
        }
        File areventos = new File("C:/" + u.getNombre() + "/Calendario/Eventos.bin");
        if (areventos.exists()) {
            ArrayList<Evento> evs = new ArrayList();
            try {
                FileInputStream entrada = new FileInputStream(areventos);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    Evento temp;
                    while ((temp = (Evento) objeto.readObject()) != null) {
                        evs.add(temp);
                    }
                } catch (EOFException e) {
                } finally {
                    objeto.close();
                    entrada.close();
                }
            } catch (Exception e) {
            }
            for (int i = 0; i < evs.size(); i++) {
                int anio = evs.get(i).getHinicio().getYear() + 1900;
                int mes=evs.get(i).getHinicio().getMonth()+1;
                String fe = evs.get(i).getHinicio().getDate() + "/" + mes + "/" + anio;
                int hr1 = evs.get(i).getHinicio().getHours();
                int mi1 = evs.get(i).getHinicio().getMinutes();
                int hr2 = evs.get(i).getHfin().getHours();
                int mi2 = evs.get(i).getHfin().getMinutes();
                String hor1 = "" + hr1, min1 = "" + mi1, hor2 = "" + hr2, minu2 = "" + mi2;
                if (hr1 < 10) {
                    hor1 = "0" + hr1;
                }
                if (mi1 < 10) {
                    min1 = "0" + mi1;
                }
                if (hr2 < 10) {
                    hor2 = "0" + hr2;
                }
                if (mi2 < 10) {
                    minu2 = "0" + mi2;
                }
                Object[] o = {evs.get(i).getTitulo(), fe, hor1 + ":" + min1, hor2 + ":" + minu2};
                modelo.addRow(o);
            }
            TablaEventos.setModel(modelo);
        }
        dlgEventos.setModal(true);
        dlgEventos.pack();
        dlgEventos.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) TablaTareas.getModel();
        try {
            if (modelo.getRowCount() > 0) {//para limpiar la tabla
                int filas = modelo.getRowCount();
                for (int j = 0; j < filas; j++) {
                    modelo.removeRow(0);
                }
            }
        } catch (IllegalArgumentException iarex) {
        }
        File areventos = new File("C:/" + u.getNombre() + "/Calendario/Tareas.bin");
        if (areventos.exists()) {
            ArrayList<Tarea> tars = new ArrayList();
            try {
                FileInputStream entrada = new FileInputStream(areventos);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    Tarea temp;
                    while ((temp = (Tarea) objeto.readObject()) != null) {
                        tars.add(temp);
                    }
                } catch (EOFException e) {
                } finally {
                    objeto.close();
                    entrada.close();
                }
            } catch (Exception e) {
            }
            for (int i = 0; i < tars.size(); i++) {
                int hr = tars.get(i).getInicio().getHours(), mi = tars.get(i).getInicio().getMinutes(), anio = tars.get(i).getInicio().getYear();
                String fe, hor = hr + "", minu = mi + "";
                if (hr < 10) {
                    hor = "0" + hr;
                }
                if (mi < 10) {
                    minu = "0" + mi;
                }
                int mes=tars.get(i).getInicio().getMonth()+1;
                fe = tars.get(i).getInicio().getDate() + "/" + mes + "/" + anio + " - " + hor + ":" + minu;
                Object[] o = {tars.get(i).getTitulo(), fe, tars.get(i).getContenido(), tars.get(i).getNotas()};
                modelo.addRow(o);
            }
            TablaTareas.setModel(modelo);
            
        }
        dlgTareas.setModal(true);
        dlgTareas.pack();
        dlgTareas.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        try {
            Date hfecha = new Date();
            GregorianCalendar fecha = new GregorianCalendar();
            hfecha.setSeconds(0);
            hfecha.setMinutes((Integer) min2.getValue());
            hfecha.setHours((Integer) hora2.getValue());
            hfecha.setDate(dc2.getDate().getDate());
            hfecha.setMonth(dc2.getDate().getMonth());
            hfecha.setYear(dc2.getDate().getYear());
            fecha.setTime(hfecha);
            ExceptionVacios(dc2, ti2, record2, content.getText(), notas.getText());
            ExceptionFecha(hfecha);//validar las fechas            
            File archivo = new File("C:/" + u.getNombre() + "/Calendario/Tareas.bin");
            tarea = new Tarea(content.getText(), notas.getText(), hfecha, fecha, ti2.getText(), (Integer) record2.getValue());
            if (!archivo.exists()) {
                FileOutputStream salida = new FileOutputStream(archivo);
                ObjectOutputStream objeto = new ObjectOutputStream(salida);
                objeto.writeObject(tarea);
                objeto.flush();
                objeto.close();
                salida.close();
                archivo.createNewFile();

            } else {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                Tarea temp;
                ArrayList<Tarea> tareas = new ArrayList();
                try {
                    while ((temp = (Tarea) objeto.readObject()) != null) {
                        tareas.add(temp);
                    }
                } catch (EOFException r) {
                } finally {
                    entrada.close();
                    objeto.close();
                }
                tareas.add(tarea);
                //sobreescribir el archivo
                FileOutputStream salida = new FileOutputStream(archivo);
                ObjectOutputStream objeto2 = new ObjectOutputStream(salida);
                for (Tarea ta : tareas) {
                    objeto2.writeObject(ta);
                }
                objeto2.flush();
                objeto2.close();
                salida.close();
            }
            String hr = "" + hfecha.getHours(), mi = "" + hfecha.getMinutes();
            int anio = hfecha.getYear() + 1900;
            int mes= hfecha.getMonth()+1;
            if (hfecha.getHours() < 10) {
                hr = "0" + hfecha.getHours();
            }
            if (hfecha.getMinutes() < 10) {
                mi = "0" + hfecha.getMinutes();
            }
            hilotarea = new HiloTarea((Integer) record2.getValue(),
                    ti2.getText() + "\nel: " + hfecha.getDate() + "/" + mes + "/" + anio
                    + "\n a las: " + hr + ":" + mi + "\n" + content.getText(), hfecha, archivo, tarea);
            hilotarea.start();
            f.setHtareas(hilotarea);
        } catch (Exceptions e) {
            JOptionPane.showMessageDialog(this.getFrames()[0], e.getMessage(), "Error", 2);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgenda().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEventos;
    private javax.swing.JTable TablaTareas;
    private javax.swing.JTextArea content;
    private com.toedter.calendar.JDateChooser dc1;
    private com.toedter.calendar.JDateChooser dc2;
    private javax.swing.JDialog dlgEventos;
    private javax.swing.JDialog dlgTareas;
    private javax.swing.JSpinner hora2;
    private javax.swing.JSpinner hrsfin1;
    private javax.swing.JSpinner hrsinicio1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner min2;
    private javax.swing.JSpinner minfin1;
    private javax.swing.JSpinner mininicio1;
    private javax.swing.JTextArea notas;
    private javax.swing.JSpinner record1;
    private javax.swing.JSpinner record2;
    private javax.swing.JTextField ti1;
    private javax.swing.JTextField ti2;
    // End of variables declaration//GEN-END:variables
    private Tarea tarea;
    private Evento evento;
    private Usuario u;
    frmEscritorio f;
    HiloEvento hiloevento;
    HiloTarea hilotarea;
}
