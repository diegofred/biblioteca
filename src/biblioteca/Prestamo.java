/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.Calendar;
/**
 *
 * @author Diego
 */
public class Prestamo {

public Date fechaPrestamo;
    public Date fechaDevolucion;
    public Date fechaLimiteDevolucion;
    public Persona persona;
    public Ejemplar ejemplar;

    public Prestamo(Persona persona, Ejemplar ejemplar) {
        this.persona = persona;
        this.ejemplar = ejemplar;
        this.fechaPrestamo = new Date();
        this.fechaLimiteDevolucion = agregarDias(this.fechaPrestamo, 15);
       
    }

    public Prestamo() {
    }

    public void registrarDevolucion() {
        this.ejemplar.disponible = true;
        this.fechaDevolucion = new Date();
    }

    public void registrarPrestamo() {
        this.fechaPrestamo = new Date();
        this.ejemplar.disponible = false;
    }

    public boolean devuelto() {
        return this.fechaDevolucion != null;
    }

      @Override
    public String toString() {
        return "Prestamo{" + "fechaPrestamo= " + fechaPrestamo + " Fecha Limite Devolucion= "+ this.fechaLimiteDevolucion + ", fechaDevolucion= " + ( fechaDevolucion != null ? fechaDevolucion :" Sin Devolucion") + ", persona=" + persona.getApellido() + ", ejemplar=" + ejemplar.numeroEjemplar + '}';
    }
    
    public Date agregarDias (Date fecha, int dias){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }
    
}
