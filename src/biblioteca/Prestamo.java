/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class Prestamo {
    public Date fechaPrestamo;
    public Date fechaDevolucion;
    public Persona persona;
    public Ejemplar ejemplar;

    public Prestamo(Persona persona, Ejemplar ejemplar) {
        this.persona = persona;
        this.ejemplar = ejemplar;
       
    }

    public Prestamo() {
    }

    public void registrarDevolucion(){
        this.ejemplar.disponible = true;
        this.fechaDevolucion = new Date();
    }
    
    public void registrarPrestamo(){
        this.fechaPrestamo = new Date();
        this.ejemplar.disponible = false;
    }
    
    public boolean devuelto(){
        return this.fechaDevolucion != null;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "fechaPrestamo= " + fechaPrestamo + ", fechaDevolucion= " + ( fechaDevolucion != null ? fechaDevolucion :" Sin Devolucion") + ", persona=" + persona.apellido + ", ejemplar=" + ejemplar.numeroEjemplar + '}';
    }
    
    
    
}
