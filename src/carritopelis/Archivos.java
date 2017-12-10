package carritopelis;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
/**
 *
 * @author Omar Ulises Hernández Cervantes, Oswaldo Josue Hernández Juárez
 */
public class Archivos {
    /**
     * Guarda la tabla que esta en el catalgo de la tienda en un archivo .txt .
     * @param catalogo es la tabla que se encuntra en la vista.
     * @param tiendaPeliculas es la direccion fichero donde se gurdara la tabla
     * @throws guardaTabla().
     */
    public final void guardaTabla(JTable catalogo, String tiendaPeliculas) {
        int i;
        int j;
        try {
            File fichero = new File(tiendaPeliculas);
            if (fichero.exists()) {
                fichero.delete();
            }
            BufferedWriter bfw;
            bfw = new BufferedWriter(new FileWriter(tiendaPeliculas));
            for (i = 0; i < catalogo.getRowCount(); i++) {
                for (j = 0; j < catalogo.getColumnCount(); j++) {
                    bfw.write(catalogo.getValueAt(i, j).toString());
                    if (j < catalogo.getColumnCount() - 1) {
                        /*agrega separador ","
                         *si no es el ultimo elemento de la fila.
                        */
                        bfw.write(",");
                    }
                }
                bfw.newLine(); //inserta nueva linea.
            }
            bfw.close(); //cierra archivo!
            System.out.println("El archivo fue salvado correctamente!");
        } catch (IOException e) {
            System.out.println("ERROR: "
                               +
                               "Ocurrio un problema al salvar el archivo!"
                               +
                               e.getMessage());
        }
    }
}
