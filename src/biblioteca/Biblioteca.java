/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static ArrayList libros = new ArrayList();
    public static ArrayList personas = new ArrayList();
    public static ArrayList prestamos = new ArrayList();
    public static ArrayList tiposLibro = new ArrayList();
    public static TipoLibro t1 = new TipoLibro("fantasia", "libro de fantasia");
    public static TipoLibro t2 = new TipoLibro("romance", "libro de romance");
    public static TipoLibro t3 = new TipoLibro("terror", "libro de terror");

    public static void main(String[] args) {
        Libro libro1 = new Libro("Luciano  Toledo", "Primer Libro", 1998);
        Libro libro2 = new Libro("Luciano Toledo", "Segundo Libro", 1998);
        libros.add(libro1);
        libros.add(libro2);
        Persona personaNueva = new Persona("Flor", "Carabelli", 21);
        Biblioteca.personas.add(personaNueva);
        tiposLibro.add(t1);
        tiposLibro.add(t2);
        tiposLibro.add(t3);

        String mensaje = " *** Biblioteca *** \n Seleccione una opción \n"
                + "1. Registro de libros \n"
                + "2. Registro de ejemplares \n"
                + "3. Registro de Persona \n"
                + "4. Registro de préstamo de un ejemplar \n"
                + "5. Devolución de un ejemplar \n"
                + "6. Consultar Ejemplares prestados a una persona \n"
                + "7. Consultar ejemplares disponibles por libros \n"
                + "8. Listar prestamos \n"
                + "9. Agregar Tipo Libro\n"
                + "10. Salir ";

        while (true) {

            String opcion = JOptionPane.showInputDialog(mensaje);
            if (opcion == null) {
                break;
                //Salir desde el menu principal
            }
            switch (opcion) {
                case "1":

                    //registrarNuevoLibro();
                    RegistrarLibro registerBook = new RegistrarLibro(null, true);
                    registerBook.setVisible(true);
                    break;
                case "2":
                    //registrarEjemplar();
                    InterfazdeEjemplares E = new InterfazdeEjemplares(null, true);
                    E.setVisible(true);
                    break;
                case "3":
                    // registrarPersona();
                    AltaPersona ap = new AltaPersona(null, true);
                    ap.setVisible(true);

                    break;
                case "4":
                    GuiPrestamo p = new GuiPrestamo(null, true);
                    p.setVisible(true);
//                    registrarPrestamoEjemplar();
//                    registrarPrestamoEjemplar();
                    break;
                case "5":
                    //devolucionPrestamoEjemplar();
                    DevolucionEjemplar de = new DevolucionEjemplar(null, true);
                    de.setVisible(true);
                    break;
                case "6":
                    //consultarEjemplaresPersonas();
                    ConsultaEjemplaresPrestados Ce = new ConsultaEjemplaresPrestados(null, true);
                    Ce.setVisible(true);
                    break;
                case "7":
                    ejeplaresDisponiblesPorLibros();
                    break;
                case "8":
                    //listarPrestamos();

                    ListadoPrestamos list = new ListadoPrestamos(null, true);
                    list.setVisible(true);
                    break;
                case "9":
                    GUITipoLibro tp = new GUITipoLibro(null, true);
                    tp.setVisible(true);
                    break;
                case "10":
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar la aplicación");

                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opción válida para continuar");

            }

        }

    }

    private static void registrarNuevoLibro() {

        //"Registro de un nuevo Libro
        String titulo = JOptionPane.showInputDialog("Ingrese Titulo");
        if (titulo != null) {
            String autor = JOptionPane.showInputDialog("Ingrese Autor");
            if (autor != null) {

                String anioText = JOptionPane.showInputDialog("Ingrese Año");

                if (anioText != null) {
                    int anio = Integer.parseInt(anioText);

                    String opcLibroElegido = "Seleccione Tipo de Libro";

                    for (int i = 0; i < tiposLibro.size(); i++) {
                        TipoLibro tipoAux = (TipoLibro) tiposLibro.get(i);
                        opcLibroElegido += " \n Opción: " + i + " - " + tipoAux.getNombre();

                    }

                    String textoLibroElegido = JOptionPane.showInputDialog(opcLibroElegido);
                    int idLibroElegido = Integer.parseInt(textoLibroElegido);
                    TipoLibro tl = (TipoLibro) tiposLibro.get(idLibroElegido);

                    Libro nuevoLibro = new Libro(autor, titulo, anio, tl);

                    //Almaceno el cliente en mi lista de clientes 
                    libros.add(nuevoLibro);

                    JOptionPane.showMessageDialog(null, "Nuevo Libro Registrado Correctamente " + nuevoLibro.titulo);
                }

            }
        }

    }

    private static void registrarEjemplar() {

        String mensajeLibroElegido = "Seleccione Libro a para registrar ejemplares";

        for (int i = 0; i < libros.size(); i++) {
            Libro libro_i = (Libro) libros.get(i);
            mensajeLibroElegido += " \n Opción: " + i + " - " + libro_i.titulo;
        }

        String opcionLibroEjemplar = JOptionPane.showInputDialog(mensajeLibroElegido);

        if (opcionLibroEjemplar != null) {
            int opcionCV = Integer.parseInt(opcionLibroEjemplar);
            if (opcionCV >= 0 && opcionCV < libros.size()) {
                Libro lelegido = (Libro) libros.get(opcionCV);
                String cantidadLibrosText = JOptionPane.showInputDialog("Ingrese la cantidad de ejemplares a agregar");
                if (cantidadLibrosText != null) {
                    int cantidad = Integer.parseInt(cantidadLibrosText);
                    boolean agregados = lelegido.agregarEjemplares(cantidad);
                    if (agregados) {
                        JOptionPane.showMessageDialog(null, "Se agregaron correctamente " + cantidad + " de ejemplares nuevos");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se agregaron ejemplares nuevos. Verifique los datos ingresados");
                    }
                }
            }
        }
    }

    private static void registrarPersona() {

        String apellido = JOptionPane.showInputDialog("Ingrese apellido");
        if (apellido != null) {
            String nombre = JOptionPane.showInputDialog("Ingrese nombre");
            if (nombre != null) {
                String dniText = JOptionPane.showInputDialog("Ingrese número de documento");
                if (dniText != null) {
                    int dni = Integer.parseInt(dniText);
                    Persona nuevaPersona = new Persona(nombre, apellido, dni);
                    //Almaceno el cliente en mi lista de personas 
                    personas.add(nuevaPersona);
                    JOptionPane.showMessageDialog(null, "Nueva Persona Registrada Correctamente " + nuevaPersona.getApellido());
                }

            }
        }
    }

//    private static void registrarPrestamoEjemplar() {
//
//        String mensajeLibroElegido = "Seleccione Libro a para registrar Prestamo";
//
//        for (int i = 0; i < libros.size(); i++) {
//            Libro libro_i = (Libro) libros.get(i);
//            mensajeLibroElegido += " \n Opción: " + i + " - " + libro_i.titulo + ". Ejemplares diponibles " + libro_i.cantidadEjemplaresDisponibles();
//        }
//
//        String opcionLibroEjemplar = JOptionPane.showInputDialog(mensajeLibroElegido);
//
//        if (opcionLibroEjemplar != null) {
//            int opcionCV = Integer.parseInt(opcionLibroEjemplar);
//            if (opcionCV >= 0 && opcionCV < libros.size()) {
//                Libro lelegido = (Libro) libros.get(opcionCV);
//
//                if (lelegido.tieneEjemplaresDisponibles()) {
//                    Ejemplar ejemplar = lelegido.obtenerEjemplarDisponibe();
//                    String mensajePersonaElegida = "Seleccione Persona a para registrar Prestamo";
//
//                    for (int i = 0; i < personas.size(); i++) {
//                        Persona presona_i = (Persona) personas.get(i);
//                        mensajePersonaElegida += " \n Opción: " + i + " - " + presona_i.getApellido() + ". Ejemplares diponibles ";
//                    }
//
//                    String opcionPersonaElegida = JOptionPane.showInputDialog(mensajePersonaElegida);
//                    if (opcionPersonaElegida != null) {
//                        int opcionP = Integer.parseInt(opcionPersonaElegida);
//                        if (opcionP >= 0 && opcionP < personas.size()) {
//                            Persona pelegida = (Persona) personas.get(opcionP);
//                            Prestamo p = new Prestamo(pelegida, ejemplar);
//                            p.registrarPrestamo();
//                            prestamos.add(p);
//                            JOptionPane.showMessageDialog(null, "Prestamo Registrado Correctamente");
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Seleccione una persona correcta");
//                        }
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "El libro ingresado no tiene ejemplares disponibles");
//                }
//
//            }
//        }
//
//    }
    private static void devolucionPrestamoEjemplar() {
        String mensajePrestamoElegido = "Seleccione Prestamo";

        //Para mostrar solo los prestamos vigentes creo una nueva lista asi no tengo problemas con las opciones
        ArrayList prestamosVigentes = new ArrayList();

        for (int i = 0; i < prestamos.size(); i++) {
            Prestamo prestamo_i = (Prestamo) prestamos.get(i);
            if (!prestamo_i.devuelto()) {
                prestamosVigentes.add(prestamo_i);
                mensajePrestamoElegido += " \n Opción: " + (prestamosVigentes.size() - 1) + " - " + prestamo_i;
            }
        }

        String opcionPrestamo = JOptionPane.showInputDialog(mensajePrestamoElegido);

        if (opcionPrestamo != null) {
            int opcionCV = Integer.parseInt(opcionPrestamo);
            if (opcionCV >= 0 && opcionCV < prestamosVigentes.size()) {
                Prestamo ps = (Prestamo) prestamosVigentes.get(opcionCV);
                ps.registrarDevolucion();
                JOptionPane.showMessageDialog(null, "Se devolvió correctamente el prestamos " + ps);
            } else {
                JOptionPane.showMessageDialog(null, "Prestamo ingresado incorrecto");
            }
        }
    }

    private static void consultarEjemplaresPersonas() {
        String mensajePersonaElegida = "Seleccione Persona a para consultar sus prestamos";

        for (int i = 0; i < personas.size(); i++) {
            Persona presona_i = (Persona) personas.get(i);
            mensajePersonaElegida += " \n Opción: " + i + " - " + presona_i.getApellido() + ". Ejemplares diponibles ";
        }

        String opcionPersonaElegida = JOptionPane.showInputDialog(mensajePersonaElegida);
        if (opcionPersonaElegida != null) {
            int opcionP = Integer.parseInt(opcionPersonaElegida);
            if (opcionP >= 0 && opcionP < personas.size()) {
                Persona pelegida = (Persona) personas.get(opcionP);
                String listaPrestamosText = "";
                for (int i = 0; i < prestamos.size(); i++) {
                    Prestamo p_i = (Prestamo) prestamos.get(i);
                    //Prestamo de la persona elegida
                    if (p_i.persona.equals(pelegida)) {
                        listaPrestamosText += "\n " + p_i;
                    }
                }
                if (listaPrestamosText.equals("")) {
                    JOptionPane.showMessageDialog(null, "No hay prestamos registrados para la persona ingresada");

                } else {
                    JOptionPane.showMessageDialog(null, listaPrestamosText);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Persona ingresada incorrecta");
            }
        }
    }

    private static void ejeplaresDisponiblesPorLibros() {
        String mensajeLibroElegido = "Ejemplares Disponible por libro";

        for (int i = 0; i < libros.size(); i++) {
            Libro libro_i = (Libro) libros.get(i);
            mensajeLibroElegido += " \n Libro: " + libro_i.titulo + ". Ejemplares diponibles " + libro_i.cantidadEjemplaresDisponibles();
        }

        JOptionPane.showMessageDialog(null, mensajeLibroElegido);
    }

    private static void listarPrestamos() {

        String mensajePrestamoElegido = ":::Prestamos:::";
        if (prestamos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se han registrado prestamos");
        } else {
            for (int i = 0; i < prestamos.size(); i++) {
                Prestamo prestamo_i = (Prestamo) prestamos.get(i);
                mensajePrestamoElegido += " \n Prestamo: " + " - " + prestamo_i;
            }

            JOptionPane.showMessageDialog(null, mensajePrestamoElegido);
        }

    }

}
