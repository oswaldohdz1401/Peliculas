package carritopelis;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Omar Ulises Hernández Cervantes, Oswaldo Josue Hernández Juárez
 */
public class VentanaPeliculas extends javax.swing.JFrame {

    private double total;//Declaración de las variables globales que
                         //realizarán los cálculos de la cuenta
    private int contadorPeli = 1;
    private ArrayList<Pelicula> lista = new ArrayList<>();
    private DefaultTableModel modelo = new DefaultTableModel(); 
             /*
            *   Declaración del objeto de tipo DefaultTableModel 
            *   el cual mediante sus métodos permitirá agregar 
            *   filas a una tabla.
            */
    private archivos a = new archivos();
    public VentanaPeliculas() {
        initComponents();
        importarArchivo();
        desavilitaBotones();
        //creaArchivo();
        
    }
     public void conexionBD() {
        String cadena = "jdbc:postgresql://localhost:5432/prueba";
        String user = "postgres";
        String pass = "123";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(cadena, user, pass);
            java.sql.Statement st = conex.createStatement();
            String sql = "SELECT codigo_id, peli_nom, actor_nom,"
                         +"genero, precio, peli_exis FROM peliculas ";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                String id = result.getString("codigo_id");
                String peli = result.getString("peli_nom");
                String nombre = result.getString("actor_nom");
                String genero = result.getString("genero");
                String precio = result.getString("precio");
                String peli_exis = result.getString("peli_exis");
                Pelicula pelicula = new Pelicula(id, peli,nombre, genero, precio,
                                                 peli_exis);
                lista.add(pelicula);    
                /*Se añade al ArrayList los datos de 
                 *  los atributos del objeto pelicula.
                */
                construirCatalogo();
            }
            result.close();
            st.close();
            conex.close();
        } catch (Exception e) {
            System.out.println("Error con la conexión a la base de datos.");
        }
    }

    public void guardarBD(Pelicula pelicula) {
        String cadena = "jdbc:postgresql://localhost:5432/prueba";
        String user = "postgres";
        String pass = "123";
        try {
            Class.forName("org.postgresql.Driver");
             //Conectar a la base de datos
            Connection conex = (Connection)
                                    DriverManager.getConnection(cadena, user,
                                                                pass);
            /*No agarra sin añadir la linea java.sql*/
            java.sql.Statement st = conex.createStatement();
                                        
            String sql = "INSERT INTO peliculas "
                    +"(codigo_id, peli_nom, actor_nom, genero, precio, "
                    + "peli_exis) VALUES ('" + pelicula.getCodigoBarras() + 
                    "', '" + pelicula.getTitulo() + "', '" + pelicula.getActor()
                    + "', '" + pelicula.getGenero() + "', '" 
                    + pelicula.getPrecio() + "', '" 
                    + pelicula.getPeliculasExistentes() + "')";
            st.executeUpdate(sql);  //Actualiza la base de datos
            st.close();
            conex.close();
        } catch (Exception e) {
            System.out.println("Error agregar película.");
        }
    }
    
    public void desavilitaBotones(){
        
        eliminarPelicula.setEnabled(false);
        if(catalogo.getRowCount() == 0){
            agregarPelicula.setEnabled(false);
            btnGuardar.setEnabled(false);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        catalogo = new javax.swing.JTable();
        añadirPelicula = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        carritoCompras = new javax.swing.JTable();
        agregarPelicula = new javax.swing.JButton();
        eliminarPelicula = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        totalCuenta = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        contadorPeliculas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Mongolian Baiti", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Carrito de peliculas");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 0, 10), java.awt.Color.white)); // NOI18N

        catalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de Barras", "Titulo", "Actor Principal", "Género", "Precio", "Peliculas existentes"
            }
        ));
        jScrollPane2.setViewportView(catalogo);

        añadirPelicula.setText("Añadir Pelicula");
        añadirPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirPeliculaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Catálogo de películas");

        btnGuardar.setText("Guardar Tabla");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(638, 638, 638)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(añadirPelicula)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(añadirPelicula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(51, 51, 51))))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 0, 10), new java.awt.Color(255, 255, 255))); // NOI18N

        carritoCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de Barras", "Titulo", "Precio", "Cantidad de peliculas", "SubTotal"
            }
        ));
        jScrollPane1.setViewportView(carritoCompras);

        agregarPelicula.setText("Agregar pelicula a carrito");
        agregarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPeliculaActionPerformed(evt);
            }
        });

        eliminarPelicula.setText("Devolver pelicula a tienda");
        eliminarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPeliculaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total de peliculas en carrito: ");

        totalCuenta.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        totalCuenta.setForeground(new java.awt.Color(255, 255, 255));
        totalCuenta.setText("0");

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Carrito de compras");

        jLabel8.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total de la compra:");

        contadorPeliculas.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        contadorPeliculas.setForeground(new java.awt.Color(255, 255, 255));
        contadorPeliculas.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(agregarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(eliminarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(contadorPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contadorPeliculas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarPelicula)
                            .addComponent(eliminarPelicula)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/pelis.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añadirPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirPeliculaActionPerformed
        //Declaración del objeto de la clase CapturaDatos
        CapturaDatos cd = new CapturaDatos();   
        try{
            Pelicula pelicula;
            //Se mandan los atributos al constructor de la clase
            //Peliculas para la creación del objeto.
            pelicula = new Pelicula(verificaCofigoBarras(), cd.pedirTitulo(),
                                    cd.pedirActor(), cd.pedirGenero(),
                                    cd.pedirPrecio(), 
                                    cd.predirPeliculasEnexistencia());
            //Se añade al ArrayList los datos de los 
            //atributos del objeto pelicula.
            lista.add(pelicula);
            //Se invoca al método construccionCatalogo
            construirCatalogo();
            agregarPelicula.setEnabled(true);
            btnGuardar.setEnabled(true);
            guardarBD(pelicula);
        }catch (Exception e) {
            System.out.println("Error construcción del catálogo");
        }
    }//GEN-LAST:event_añadirPeliculaActionPerformed
    private String verificaCofigoBarras(){
        CapturaDatos cd = new CapturaDatos();
        String c;
        int i;
        c = cd.pedirCodigoBarras();
        boolean bandera = true;
        for(i = 0; i< catalogo.getRowCount(); i++){
            if(c.equals(catalogo.getValueAt(i, 0).toString())){
                bandera = false;
            }       
        }
        if(bandera){
            return c;
        }
        JOptionPane.showMessageDialog(null,"Codigo de barras ya existente "
                                      +"introduce diferente", "ERROR", 
                                      JOptionPane.WARNING_MESSAGE);
        return verificaCofigoBarras();
    }
    
    private void eliminarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPeliculaActionPerformed
        try {
        int c = 0;
        String precio,subTotalPelicula;
        double precioDouble,subTotalPeliculaDouble,subtotal;
        int peliculaSeleccionada, cantidadPeliculas;
        peliculaSeleccionada = carritoCompras.getSelectedRow(); 
        actualizaTablaCatalgo(carritoCompras.getValueAt(
                              peliculaSeleccionada, 0).toString());
        //contadorPeliculas.setText(Integer.toString(contadorPeli--));
        String cantidadPelicula = carritoCompras.getValueAt(
                                  peliculaSeleccionada,3).toString();
        cantidadPeliculas = Integer.parseInt(cantidadPelicula);
        String co = contadorPeliculas.getText().toString();
        c = Integer.parseInt(co);
        if(cantidadPeliculas > 1 && c >1){
            cantidadPeliculas--;
            carritoCompras.setValueAt(cantidadPeliculas, peliculaSeleccionada, 
                                      3);    
            precio = carritoCompras.getValueAt(peliculaSeleccionada, 2).
                                               toString();
            //Función que recibe una cadena y regresa una 
            //variable de tipo double.
            precioDouble = Double.parseDouble(precio); 
            subTotalPelicula = carritoCompras.getValueAt(peliculaSeleccionada,
                                                         4).toString();
            subTotalPeliculaDouble = Double.parseDouble(subTotalPelicula); 
            subTotalPeliculaDouble = subTotalPeliculaDouble - precioDouble;
            carritoCompras.setValueAt(subTotalPeliculaDouble,
                                      peliculaSeleccionada, 4);
            total = total - precioDouble;
            //Muestra en la ventana el total de la compra.
            totalCuenta.setText("" + total);
        }else{
            if(cantidadPeliculas == 1){
                precio = carritoCompras.getValueAt(peliculaSeleccionada,
                                                   2).toString();
                //Función que recibe una cadena y 
                //regresa una variable de tipo double.
                subtotal = Double.parseDouble(precio);  
                DefaultTableModel modelo = (DefaultTableModel)
                                            carritoCompras.getModel();
                //Remueve la fila que se eligió de la tabla carritoCompras.
                modelo.removeRow(peliculaSeleccionada);
                //Cálculo que resta de la cuenta 
                //total la pelicula que se eliminó.
                total = total - subtotal;
                //Muestra en la ventana el total de la compra.
                totalCuenta.setText("" + total);
                eliminarPelicula.setEnabled(false);
            }
        }
        c--;
        System.out.println(""+c);
        contadorPeliculas.setText(Integer.toString(c));    
        System.out.println(""+total);    
        } catch (Exception e) {
            //Mensaje en caso que no se haya seleccionado alguna fila.
            JOptionPane.showMessageDialog(null, 
                    "Selecciona una película del carrito", 
                    "Error", 
                    JOptionPane.WARNING_MESSAGE);
        }   
    }//GEN-LAST:event_eliminarPeliculaActionPerformed
    public void actualizaTablaCatalgo(String codigoBarras){
        int i;
        for(i=0;i<carritoCompras.getRowCount();i++){
            if(codigoBarras.equals(catalogo.getValueAt(i, 0).toString())){
                 catalogo.setValueAt(Integer.parseInt(catalogo.getValueAt(i, 5)
                                                      .toString())+1,i,5);
            }
        }
    }
    private void agregarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPeliculaActionPerformed
        int contadorPeli = Integer.parseInt(contadorPeliculas.getText().
                                            toString()) + 1;
        System.out.println(""+contadorPeli);
        int peliculaSeleccionada,peliculaExistenciaInt;
        int i;
        String subT,contadorP;
        double subTPeli,subtotal;
        boolean bandera = false;
        peliculaSeleccionada = catalogo.getSelectedRow();
        String existenciaPelicula = catalogo.getValueAt(peliculaSeleccionada, 
                                                        5).toString();
        peliculaExistenciaInt = Integer.parseInt(existenciaPelicula);
        if(peliculaExistenciaInt > 0){
            try {
            String titulo, precio , codigoBarras;
            modelo = (DefaultTableModel) catalogo.getModel();
            codigoBarras = catalogo.getValueAt(peliculaSeleccionada,
                                               0).toString();
            titulo = catalogo.getValueAt(peliculaSeleccionada, 1).toString();
            precio = catalogo.getValueAt(peliculaSeleccionada, 4).toString();
            //Convierte el valor de precio de tipo String a double en subtotal.
            subtotal = Double.parseDouble(precio);
            for(i = 0; i < carritoCompras.getRowCount(); i++){
                if(catalogo.getValueAt(peliculaSeleccionada, 0).toString() 
                                        == carritoCompras.getValueAt(i,0)){
                    contadorP = carritoCompras.getValueAt(i,3).toString();
                    subT = carritoCompras.getValueAt(i,4).toString();
                    subTPeli = Double.parseDouble(subT);
                    subTPeli = subTPeli + subtotal;
                    total = total + subtotal;
                    carritoCompras.setValueAt((Integer.parseInt(contadorP)+1), 
                                               i, 3);
                    carritoCompras.setValueAt(subTPeli, i, 4);
                    bandera = true;
                }
            }
            if(!bandera){
                modelo = (DefaultTableModel) carritoCompras.getModel();
                String filaelemento[] = {codigoBarras,titulo,
                                         precio,"1",precio};
                total = total + subtotal;
                modelo.addRow(filaelemento);    //El método
            }
            
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Selecciona una película del catálogo", 
                        "", JOptionPane.WARNING_MESSAGE);
            }
            System.out.println(""+total);
            totalCuenta.setText("" + total);
            contadorPeliculas.setText(Integer.toString(contadorPeli++));
            peliculaExistenciaInt--;
            catalogo.setValueAt(peliculaExistenciaInt,peliculaSeleccionada,5);
            eliminarPelicula.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,
                    "Ya no hay en existencia la pelicula seleccionada", 
                    "No hay peliculas",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_agregarPeliculaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        a.guardaTabla(catalogo,"archivo.txt");
    }//GEN-LAST:event_btnGuardarActionPerformed
    public void importarArchivo(){
        int i;
        try {
            FileReader fr = new FileReader("archivo.txt");
            BufferedReader bf = new BufferedReader(fr);
            String sCadena;
            String codigoBarras;
            String titulo;
            String actorPrincipal;
            String genero;
            String precio;
            String pelExistentes;
            String[] parts;
            while ((sCadena = bf.readLine())!=null) {
                parts = sCadena.split(",");
                codigoBarras = parts[0];
                titulo = parts[1];
                actorPrincipal = parts[2];
                genero = parts[3];
                precio = parts[4];
                pelExistentes = parts[5];
                /*-------------------------------------------------*/
                CapturaDatos cd = new CapturaDatos();
                try{
                    Pelicula pelicula = new Pelicula(codigoBarras, titulo, 
                                                     actorPrincipal, genero,
                                                     precio, pelExistentes);
                    lista.add(pelicula);
                    construirCatalogo();
                    agregarPelicula.setEnabled(true);
                    btnGuardar.setEnabled(true);
                }catch (Exception e) {

                }
             }
        } catch (Exception e) {
        }
    }
    public void construirCatalogo() {
        String matriz[][] = new String[lista.size()][6];
        for (int i = 0; i < lista.size(); i++) {
            matriz[i][0] = lista.get(i).getCodigoBarras();
            matriz[i][1] = lista.get(i).getTitulo();
            matriz[i][2] = lista.get(i).getActor();
            matriz[i][3] = lista.get(i).getGenero();
            matriz[i][4] = lista.get(i).getPrecio();
            matriz[i][5] = lista.get(i).getPeliculasExistentes();
        }
        catalogo.setModel(new javax.swing.table.DefaultTableModel
                         (matriz, new String[]{
                                                "Codigo de Barras",
                                                "Titulo",
                                                "Actor Principal",
                                                "Género", "Precio",
                                                "Peliculas Existentes"}));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarPelicula;
    private javax.swing.JButton añadirPelicula;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JTable carritoCompras;
    private javax.swing.JTable catalogo;
    private javax.swing.JLabel contadorPeliculas;
    private javax.swing.JButton eliminarPelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel totalCuenta;
    // End of variables declaration//GEN-END:variables
}
