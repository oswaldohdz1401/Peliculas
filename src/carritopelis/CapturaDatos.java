package carritopelis;
import javax.swing.JOptionPane;
/**
 *
 * @author Omar Ulises Hernández Cervantes, Oswaldo Josue Hernández Juárez
 */
public class CapturaDatos {
    String pedirCodigoBarras() {
    String codigoBarras;
        do {
            codigoBarras = JOptionPane.
                           showInputDialog(null, 
                           "Escribe el Codigo "
                           +"Barras de la película:", 
                           "Carrito Peliculas",
                           JOptionPane.QUESTION_MESSAGE);
            if(codigoBarras.length() < 9){
                JOptionPane.showMessageDialog(null,
                                              "El codigo de barras tiene "
                                              +"que ser"
                                              +"igual a nueve dígitos",
                                              "ERROR",
                                              JOptionPane.WARNING_MESSAGE);
            }
        } while (codigoBarras.length() < 9);
        return codigoBarras;
    }
    String pedirTitulo() {
        String tituloPelicula;
        do {
            tituloPelicula = JOptionPane.
                             showInputDialog(null,
                                             "Escribe el Titulo de "
                                             +"la película:",
                                             "Carrito Peliculas",
                                             JOptionPane.QUESTION_MESSAGE);
            if (tituloPelicula.length() == 0) {
                JOptionPane.showMessageDialog(null,
                                              "Introduce al menos un titulo",
                                              "ERROR",
                                              JOptionPane.WARNING_MESSAGE);
            }
        } while (tituloPelicula.length() == 0);
        return tituloPelicula;
    }
    String pedirActor() {
        String actorPelicula;
        do {
            actorPelicula = JOptionPane.
                            showInputDialog(null,
                                            "Escribe el nombre del Actor "
                                            +"principal de la película:",
                                            "Carrito Peliculas",
                                            JOptionPane.QUESTION_MESSAGE
            );
            if (actorPelicula.length() == 0) {
                JOptionPane.showMessageDialog(null,
                                              "Introduce el actor",
                                              "ERROR",
                                              JOptionPane.WARNING_MESSAGE);
            }
        } while (actorPelicula.length() == 0);
        return actorPelicula;
    }
    String pedirGenero() {
        String generoPelicla;
        do{
            generoPelicla = JOptionPane.
                            showInputDialog(null,
                                            "Escribe el género de "
                                            +"la película:",
                                            "Carrito Peliculas",
                                            JOptionPane.QUESTION_MESSAGE
            );
            if (generoPelicla.length() == 0) {
                JOptionPane.showMessageDialog(null,
                                              "Introduce el genero del "
                                              +"la pelicula",
                                              "ERROR",
                                              JOptionPane.WARNING_MESSAGE);
            }
        } while (generoPelicla.length() == 0);
        return generoPelicla;
    }
    String pedirPrecio() {
        String precio;
        int x;
        do {
            precio = JOptionPane.
                     showInputDialog("Escribe el precio de la película:");
            x = Integer.parseInt(precio);
            if (x < 10 || x > 500) {
                JOptionPane.
                showMessageDialog(null,
                                  "Ingresa un precio dentro del rango "
                                  +"establecido "
                                  +"($10 - $500)",
                                  "Error",
                                  JOptionPane.WARNING_MESSAGE);
            }
        } while (x < 10 || x > 500);
        return precio;
    }
    public String predirPeliculasEnexistencia(){
        String pExistencia;
        int p;
        do {
            pExistencia = JOptionPane.showInputDialog("Introduce cuantas "
                                                      +"peliculas quieres "
                                                      +"tener en existencia:");
            p = Integer.parseInt(pExistencia);
            if (p<= 0) {
                JOptionPane.showMessageDialog(null,"Las peliculas en "
                                                   +"existencia tienen que ser "
                                                   +"mayor a cero",
                                                   "Error",
                                                   JOptionPane.WARNING_MESSAGE);
            }
        } while(p<=0);
        return pExistencia;
    }
}