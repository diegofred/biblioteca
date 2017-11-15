        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author Xerito
 */
public class TipoLibro {
    private String nombre;
    private String descripcionTipo;
    
    
    public TipoLibro() {
    }

    public TipoLibro(String nombre, String descripcionTipo) {
        this.nombre = nombre;
        this.descripcionTipo = descripcionTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    @Override
    public String toString() {
        return "TipoLibro{" + "nombre=" + nombre + ", descripcionTipo=" + descripcionTipo + '}';
    }
    
    
    
}
