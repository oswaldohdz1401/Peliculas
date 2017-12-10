package carritopelis;
import javax.swing.JOptionPane;
/**
 *
 * @author Omar Ulises Hernández Cervantes, Oswaldo Josue Hernández Juárez
 */
public class CapturaDatos {
    /**
     *  CODIGO_MAX es el codigo menimos del codigo de barras.
     */
    static final int CODIGO_MAX = 9;
    /**
     *  PRECIO_MAX es el precio maximo que se puede asignar a una pelicula.
     */
    static final int PRECIO_MAX = 500;
    /**
     *  PRECIO_MAX es el precio minimo que se puede asignar a una pelicula.
     */
    static final int PRECIO_MIN = 10;
     /**
     * Mada un mensaje para ingresar el codigo de barras.
     * @return el cofigo de barras ingresado por el usuario
     * @throws pedirCodigoBarras().
     */
    public final String pedirCodigoBarras() {
        String codigoBarras;
        do {
            codigoBarras = JOptionPane.
                           showInputDialog(null,
                           "Escribe el Codigo "
                                   +
                           "Barras de la película:",
                           "Carrito Peliculas",
                           JOptionPane.QUESTION_MESSAGE);
            if (codigoBarras.length() < CODIGO_MAX) {
                JOptionPane.showMessageDialog(null,
                                              "El codigo de barras tiene "
                                                      +
                                              "que ser"
                                                      +
                                              "igual a nueve dígitos",
                                              "ERROR",
                                              JOptionPane.WARNING_MESSAGE);
            }
        } while (codigoBarras.length() < CODIGO_MAX);
        return codigoBarras;
    }
    /**
     * Mada un mensaje para ingresar el titulo de la pelicula.
     * @return el titulo de barras ingresado por el usuario
     * @throws pedirTitulo().
     */
    public final String pedirTitulo() {
        String tituloPelicula;
        do {
            tituloPelicula = JOptionPane.
                             showInputDialog(null,
                                             "Escribe el Titulo de "
                                                    +
                                             "la película:",
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
    /**
     * Mada un mensaje para ingresar el actor de la pelicula.
     * @return el actor ingresado por el usuario
     * @throws pedirActor().
     */
    public final String pedirActor() {
        String actorPelicula;
        do {
            actorPelicula = JOptionPane.
                            showInputDialog(null,
                                             "Escribe el nombre del Actor "
                                                     +
                                            "principal de la película:",
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
    /**
     * Mada un mensaje para ingresar el genero de la pelicula.
     * @return el genero ingresado por el usuario
     * @throws pedirGenero().
     */
    public final String pedirGenero() {
        String generoPelicla;
        do {
            generoPelicla = JOptionPane.
                            showInputDialog(null,
                                            "Escribe el género de "
                                                    +
                                            "la película:",
                                            "Carrito Peliculas",
                                            JOptionPane.QUESTION_MESSAGE
            );
            if (generoPelicla.length() == 0) {
                JOptionPane.showMessageDialog(null,
                                              "Introduce el genero del "
                                                      +
                                              "la pelicula",
                                              "ERROR",
                                              JOptionPane.WARNING_MESSAGE);
            }
        } while (generoPelicla.length() == 0);
        return generoPelicla;
    }
    /**
     * Mada un mensaje para ingresar el genero de la pelicula.
     * @return el genero ingresado por el usuario
     * @throws pedirGenero().
     */
    public final String pedirPrecio() {
        String precio;
        int x;
        do {
            precio = JOptionPane.
                     showInputDialog("Escribe el precio de la película:");
            x = Integer.parseInt(precio);
            if (x < PRECIO_MIN || x > PRECIO_MAX) {
                JOptionPane.
                showMessageDialog(null,
                                  "Ingresa un precio dentro del rango "
                                          +
                                  "establecido "
                                          +
                                  "($10 - $500)",
                                  "Error",
                                  JOptionPane.WARNING_MESSAGE);
            }
        } while (x < PRECIO_MIN || x > PRECIO_MIN);
        return precio;
    }
    /**
     * Mada un mensaje para ingresar las peliculas en stock.
     * @return cantidad de peliculas en stock, ingresaddos por el usuario
     * @throws predirPeliculasEnexistencia().
     */
    public final String predirPeliculasEnexistencia() {
        String pExistencia;
        int p;
        do {
            pExistencia = JOptionPane.showInputDialog("Introduce cuantas "
                                                            +
                                                      "peliculas quieres "
                                                            +
                                                      "tener en existencia:");
            p = Integer.parseInt(pExistencia);
            if (p <= 0) {
                JOptionPane.showMessageDialog(null, "Las peliculas en "
                                                        +
                                              "existencia tienen que ser "
                                                        +
                                              "mayor a cero",
                                              "Error",
                                              JOptionPane.WARNING_MESSAGE);
            }
        } while(p <= 0);
        return pExistencia;
    }
}