package carritopelis;
/**
 *
 * @author Omar Ulises Hernández Cervantes, Oswaldo Josue Hernández Juárez
 */
public class Pelicula {
    /**
     *  codigoBarras la instancia del codifgo de barrass.
     */
    private String codigoBarras;
    /**
     *  titulo la instancia del ttulo de la pelicula.
     */
    private String titulo;
    /**
     *  actor la instancia del actor de la pelicula.
     */
    private String actor;
    /**
     *  titulo la instancia del genero de la pelicula.
     */
    private String genero;
    /**
     *  precio la instancia del precio de la pelicula.
     */
    private String precio;
    /**
     *  peliculasExistentes la instancia de cuantas pelicualas en stock.
     */
    private String peliculasExistentes;
    /**
     *
     * @param codigoBarras que almacena del ID de la película
     * @param titulo Cadena que almacena el nombre de la película
     * @param actor Cadena que almacena el nombre del actor principal de la
     *              película
     * @param genero Cadena que almacena el género al que pertenece 
     *               la película
     * @param precio Cadena que almacena el precio de venta de la película
     * @param peliculasExistentes es la cantidad de peliculas en Stock
     */
    public Pelicula(String codigoBarras, String titulo, String actor,
                    String genero, String precio,String peliculasExistentes) {
        this.codigoBarras = codigoBarras;
        this.titulo = titulo;
        this.actor = actor;
        this.genero = genero;
        this.precio = precio;
        this.peliculasExistentes = peliculasExistentes;
    }
    /**
     * Getter.
     * @return el codigo de barras.
    */
    public final String getCodigoBarras() {
        return codigoBarras;
    }
    /**
     * Getter.
     * @return el titulo de la pelicula.
    */
    public final String getTitulo() {
        return titulo;
    }
    /**
     * Getter.
     * @return el actor de la pelicula.
    */
    public final String getActor() {
        return actor;
    }
    /**
     * Getter.
     * @return el genero de la pelicula.
    */
    public final String getGenero() {
        return genero;
    }
    /**
     * Getter.
     * @return el precio de la pelicula.
    */
    public final String getPrecio() {
        return precio;
    }
    /**
     * Getter.
     * @return la peliculas en Stock.
    */
    public final String getPeliculasExistentes() {
        return  this.peliculasExistentes;
    }
}