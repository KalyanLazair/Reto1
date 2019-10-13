/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Marta
 */

     

public class Conexiones {
    
    Connection conn;

    
    //Le vamos a pasar los parámetros de usuario, contraseña y la URL como parámetros de entrada en el constructor
    public Conexiones(String url1, String user, String password){
        
        conn=null;
        
        try {
           
           //La clase DiverManager tiene un método getConnection que nos va a establecer la conexión
           //cuando le pasamos los parámetros de entrada url, user y password.
           conn = (Connection) DriverManager.getConnection(url1, user, password);
           //Si la conexión se establece (es distinto de null), nos saca por consola el mensaje de que está conectada.
           //En caso contrario nos muestra por consola un mensaje de error.
             if (conn != null) {
               System.out.println("Conectado a deportes.");
     
             }
        } catch (SQLException ex) {
            System.out.println("ERROR: dirección o usuario/clave no válida");           
            ex.printStackTrace();
        }
    
    }
    
     //Cierre de conexión. Método que nos permite cerrar la conexión.
    public void cerrarConn(){
       try{
           conn.close();
       }catch(SQLException ex){
           System.out.println("Error al cerrar la conexión!");
           ex.printStackTrace();
       }
    
    }
    
    //Consultas SELECT sobre la tabla PERROS.
    //Select * de la tabla Perros, que nos va a mostrar por pantalla. Consulta no parametrizada.
    public DefaultTableModel consultaPerros(){
         //Creamos un objeto DefaultTableModel que nos va a permitir insertar los datos en el jTable.
         DefaultTableModel model = new DefaultTableModel(new String[]{"Chip", "Nombre", "Afijo", "Raza", "Sexo","Nacimiento", "Deporte", "Grado", "Propietario", "DNI"}, 0);
         
        try{
           //Creamos el statement para poder ejecutar la consulta. Es lo que envía comandos SQL a la base de datos.
           Statement sta = conn.createStatement();
           //Ejecutamos la consulta. Usamos el método executeQuery de Ststement y guardamos el resultado en el resultSet.
           ResultSet rs = sta.executeQuery("SELECT * FROM perro p, propietario pr WHERE p.propietario=pr.DNI;");

           //recorremos la tabla usando el método next de ResultSet, que se mueve a través de los registros almacenados en RS.
           //ResultSet es un conjunto ordenado de filas en una tabla.
           //Con los métodos get de ResultSet podemos obtener los valores de los distintos atributos y almacenarlos en variables
           //que luego vamos a procesar con el model para poder sacarlo por el jTable.
              while(rs.next()){
                String chip=String.valueOf(rs.getInt("chip"));
                String nombreP=rs.getString("p.nombre");
                String afijo=rs.getString("afijo");
                String raza=rs.getString("raza");
                String sexo=rs.getString("sexo");
                String nac=String.valueOf(rs.getObject("nacimiento"));
                String deporte=rs.getString("deporte");
                String grado=rs.getString("grado");
                String prop= rs.getString("pr.nombre") + " " + rs.getString("pr.apellidos");
                String dni=rs.getString("DNI");
                //insertamos los datos en el model que nos va a devolver, creando una tupla.
                 model.addRow(new Object[]{chip, nombreP, afijo,raza,sexo,nac,deporte,grado,prop, dni});
              }
            //Cerramos el statement y el resultset para evitar errores.
            rs.close();
            sta.close();
              
        }catch(SQLException ex){
          System.out.println("ERROR:al consultar");
          ex.printStackTrace();
        }
        //Devolvemos el model.
        return model;
  
     }
    
     //Consulta con preparedStatement al que le vamos a pasar parámetros de entrada.   
    public DefaultTableModel consultaPerroPS(String consulta, String parametro){
         //Creamos un objeto DefaultTableModel que nos va a permitir insertar los datos en el jTable.
         DefaultTableModel model = new DefaultTableModel(new String[]{"Chip", "Nombre", "Afijo", "Raza", "Sexo", "Nacimiento","Deporte", "Grado", "Propietario", "DNI"}, 0);
         
        try{
           //Creamos un objeto PreparedStatement para ejecutar la consulta. Se precompila la consulta para dejarla preparada
           //para recibir los valores de los parámetros.
            PreparedStatement pst = conn.prepareStatement(consulta);
            //Le pasamos los parámetros a la consulta.
            pst.setString(1,parametro);
            //Ejecutamos la consulta y guardamos el resultado en el ResultSet.
            ResultSet rs = pst.executeQuery();
            
            //recorremos la tabla usando el método next de ResultSet, que se mueve a través de los registros almacenados en RS.
           //ResultSet es un conjunto ordenado de filas en una tabla.
           //Con los métodos get de ResultSet podemos obtener los valores de los distintos atributos y almacenarlos en variables
           //que luego vamos a procesar con el model para poder sacarlo por el jTable.
              while(rs.next()){
                String chip=String.valueOf(rs.getInt("chip"));
                String nombreP=rs.getString("p.nombre");
                String afijo=rs.getString("afijo");
                String raza=rs.getString("raza");
                String sexo=rs.getString("sexo");
                String nac=String.valueOf(rs.getObject("nacimiento"));
                String deporte=rs.getString("deporte");
                String grado=rs.getString("grado");
                String prop= rs.getString("pr.nombre") + " " + rs.getString("pr.apellidos");
                String dni=rs.getString("DNI");
                //insertamos los datos en el model que nos va a devolver, creando una tupla.
                 model.addRow(new Object[]{chip, nombreP, afijo,raza,sexo,nac,deporte,grado,prop, dni});
              }
              //Cerramos el prepares statement y el resultset.
              rs.close();
              pst.close();
              
            
        }catch(SQLException ex){
          System.out.println("ERROR:al consultar");
          ex.printStackTrace();
        }
        //Devolvemos el model.
        return model;
  
     }
    
}
