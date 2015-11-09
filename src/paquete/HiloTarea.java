/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class HiloTarea extends Thread{
    private boolean vive;
    private boolean avanzar;
    private int recordatorio;
    private String content;
    private Date fecha;
    private File archivo;
    private Tarea tarea;

    public HiloTarea(int recordatorio, String content, Date fecha,File archivo,Tarea tarea) {
        this.recordatorio = recordatorio;
        this.content = content;
        this.fecha = fecha;
        this.archivo=archivo;
        this.vive = true;
        this.avanzar = true;
        this.tarea=tarea;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public void serAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    @Override
    public void run() {
        while (vive) {
            if (avanzar) {
                Date hsistema = new Date();//la hora del sistema
                if (hsistema.before(fecha)) {
                    try {
                        Thread.sleep(recordatorio * 60000);
                        JOptionPane.showMessageDialog(null, "Recordatorio de: " + content, "Aviso", 1);
                    } catch (InterruptedException ex) {
                    }
                } else {
                    vive = false;
                    //eliminar la actividad del archivo
                    try {
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
                        tareas.remove(tarea);
                        archivo.delete();
                        //crear nuevamente el archivo
                        FileOutputStream salida = new FileOutputStream(archivo);
                        ObjectOutputStream objeto2 = new ObjectOutputStream(salida);
                        for (Tarea ta : tareas) {
                            objeto2.writeObject(ta);
                        }
                        objeto2.flush();
                        objeto2.close();
                        salida.close();
                        archivo.createNewFile();
                    } catch (Exception ex) {
                    }

                }//fin del else

            }//fin del avanzar
        }//fin del while
}
}
