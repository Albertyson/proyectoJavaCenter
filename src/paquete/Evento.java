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
public class Evento extends Actividad implements Serializable {

    private Date hinicio;
    private Date hfin;
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Evento() {
        super();
    }

    public Evento(Date hinicio, Date hfin, GregorianCalendar fecha, String titulo, int recordatorio) {
        super(fecha, titulo, recordatorio);
        this.hinicio = hinicio;
        this.hfin = hfin;
        this.fecha=fecha;
        this.titulo=titulo;
        this.recordatorio=recordatorio;
    }

    public Date getHfin() {
        return hfin;
    }

    public void setHfin(Date hfin) {
        this.hfin = hfin;
    }

    public Date getHinicio() {
        return hinicio;
    }

    public void setHinicio(Date hinicio) {
        this.hinicio = hinicio;
    }

    @Override
    public String toString() {
        return "Evento:" + super.getTitulo() + ", Hora de inicio: " + hinicio + ", Hora en que finaliza: " + hfin;
    }
}
