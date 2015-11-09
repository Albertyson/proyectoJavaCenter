/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Alberto
 */
public class Actividad implements Serializable {

    protected GregorianCalendar fecha;
    protected String titulo;
    protected int recordatorio;
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Actividad() {
    }

    public Actividad(GregorianCalendar fecha, String titulo, int recordatorio) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.recordatorio = recordatorio;
    }

    public int getRecordatorio() {
        return recordatorio;
    }

    public void setRecordatorio(int recordatorio) {
        this.recordatorio = recordatorio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
}
