package carritopelis;
/**
 *
 * @author Omar Ulises Hernández Cervantes, Oswaldo Josue Hernández Juárez
 */
public class Pelicula {

    private String codigoBarras;
    private String titulo;
    private String actor;
    private String genero;
    private String precio;
    private String peliculasExistentes;
    /**
     *
     * @param codigoBarras que almacena del ID de la película
     * @param titulo Cadena que almacena el nombre de la película
     * @param actor Cadena que almacena el nombre del actor principal de la
     * película
     * @param genero Cadena que almacena el género al que pertenece la película
     * @param precio Cadena que almacena el precio de venta de la película
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

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public String getPeliculasExistentes(){
       return  this.peliculasExistentes;
    }
    public void setPeliculasExistentes(String pExitentte){
        this.peliculasExistentes = pExitentte;
    }
}
