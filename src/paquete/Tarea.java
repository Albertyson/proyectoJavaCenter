package paquete;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Alberto
 */
public class Tarea extends Actividad implements Serializable{

    private String Contenido;
    private String Notas;
    private static final long serialVersionUID = 1L;
    private Date inicio;

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Tarea() {
        super();
    }

    public Tarea(String Contenido, String Notas, Date inicio, GregorianCalendar fecha, String titulo, int recordatorio) {
        super(fecha, titulo, recordatorio);
        this.Contenido = Contenido;
        this.Notas = Notas;
        this.inicio = inicio;
    }


    public String getNotas() {
        return Notas;
    }

    public void setNotas(String Notas) {
        this.Notas = Notas;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }
}