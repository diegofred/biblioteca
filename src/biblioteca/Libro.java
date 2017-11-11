/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Libro {

    public String autor;
    public String titulo;
    public int anio;

    public ArrayList ejemplares = new ArrayList();

    public Libro(String autor, String titulo, int anio) {
        this.autor = autor;
        this.titulo = titulo;
        this.anio = anio;
    }

    public Libro() {
    }

    /**
     *
     * @return la cantidad de ejemplares del libro con el estado de disponible
     * en true
     */
    public int cantidadEjemplaresDisponibles() {
        int cantidadEjemplaresDisponibles = 0;
        for (int i = 0; i < ejemplares.size(); i++) {
            Ejemplar e = (Ejemplar) ejemplares.get(i);
            cantidadEjemplaresDisponibles += (e.disponible ? 1 : 0);
        }
        return cantidadEjemplaresDisponibles;
    }

    /**
     * 
     * @return verdadero si existe al menos un ejemplar disponible
     */
    public boolean tieneEjemplaresDisponibles() {
        return cantidadEjemplaresDisponibles() > 0;
    }

    /**
     * 
     * @return un Ejemplar para efectuar un prestamo. Sino hay disponibles devuelve null
     */
    public Ejemplar obtenerEjemplarDisponibe() {
        //Sino hay ejemplares disponibles retorno la referencia a null
        Ejemplar proximoEjemplarDisponible = null;
        if (tieneEjemplaresDisponibles()) {
            for (int i = 0; i < ejemplares.size(); i++) {
                Ejemplar e = (Ejemplar) ejemplares.get(i);
                if (e.disponible) {
                    proximoEjemplarDisponible = e;
                    break;
                }
            }
        } 
        return proximoEjemplarDisponible;
        
    }
    
/**
 * 
 * @param cantidad de nuevos ejemplares a agregar del libro
 * @return boolean que especifica si se agregaron o no los ejemplares
 */
    public boolean agregarEjemplares (int cantidad){
        if (cantidad > 0) {
           for (int i = 0; i < cantidad; i++) {
             ejemplares.add(new Ejemplar());
           }
           return true;
        }else{
            //Cantidad de ejemplares incorrecta
            return false;
        }
    }
    
    
    
    
    
}
