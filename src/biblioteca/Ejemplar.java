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
    public Libro libro;
    
    
    static {
        siguienteNumeroEjemplar = 1;
    }

    public Ejemplar(Libro libro) {
        this.numeroEjemplar = siguienteNumeroEjemplar++;
        this.disponible = true;
        this.libro = libro;
    }

    
//    public Libro getLibro(){
//        for (int i = 0; i < Biblioteca.libros.size(); i++) {
//           Libro libro_i = (Libro) Biblioteca.libros.get(i);
//            for (int j = 0; j < libro_i.ejemplares.size(); j++) {
//                Ejemplar ejemplar_j = (Ejemplar) libro_i.ejemplares.get(j);
//                if (ejemplar_j.numeroEjemplar == this.numeroEjemplar) {
//                    return libro_i;
//                }
//            }
//        }
//        return null;
//    }
//    
}
