/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author Diego
 */
public class Ejemplar {
    
    public static int siguienteNumeroEjemplar;
    
    public int numeroEjemplar;
    public boolean disponible;
    
    
    
    static {
        siguienteNumeroEjemplar = 1;
    }

    public Ejemplar() {
        this.numeroEjemplar = siguienteNumeroEjemplar++;
        this.disponible = true;
    }
    
    
}
