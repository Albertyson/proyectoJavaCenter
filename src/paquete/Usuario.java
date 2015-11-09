/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.Serializable;

/**
 *
 * @author Alberto
 */
public class Usuario implements Serializable {

    private String nombre;
    private String password;
    private TipoUsuario tipo;
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Usuario() {
    }

    public Usuario(String nombre, String password, TipoUsuario tipo) {
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
