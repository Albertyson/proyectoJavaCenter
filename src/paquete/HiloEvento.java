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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class HiloEvento extends Thread {

    private boolean vive;
    private boolean avanzar;
    private int recordatorio;
    private String actividad;
    private Date hinicio;
    private File archivo;
    private Evento evento;

    public HiloEvento(int recordatorio, String actividad, Date hinicio,File archivo,Evento evento) {
        this.recordatorio = recordatorio;
        this.actividad = actividad;
        this.hinicio = hinicio;
        this.archivo=archivo;
        this.vive = true;
        this.avanzar = true;
        this.evento=evento;
        vive=true;
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
                if (hsistema.before(hinicio)) {
                    try {
                        Thread.sleep(recordatorio * 60000);
                        JOptionPane.showMessageDialog(null, "Recordatorio de: " + actividad, "Aviso", 1);
                    } catch (Exception ex) {
                    }
                } else {
                    vive = false;
                    //eliminar la actividad del archivo
                    try {
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
                        eventos.remove(evento);
                        archivo.delete();
                        //crear nuevamente el archivo
                        FileOutputStream salida = new FileOutputStream(archivo);
                        ObjectOutputStream objeto2 = new ObjectOutputStream(salida);
                        for (Evento ev : eventos) {
                            objeto2.writeObject(ev);
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
