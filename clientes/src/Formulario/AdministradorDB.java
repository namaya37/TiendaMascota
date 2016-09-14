
package Formulario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class AdministradorDB {
    Connection conexion = null;
    Statement sentencia = null;
    
    String cadena = "org.sqlite.JDBC";
    String url = "jdbc:sqlite:colegio.sqlite";
    
    public void crearTabla(){
        try{
            Class.forName(cadena);
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement();
            
            String sql = "CREATE TABLE cliente" +
                         "(cod_cli DOUBLE PRIMARY KEY NOT NULL, nom_cli TEXT NOT NULL, ape_cli TEXT NOT NULL, tel DOUBLE)";
            sentencia.executeUpdate(sql);
            
            String sql1 = "CREATE TABLE paciente" +
                         "(idmascota DOUBLE PRIMARY KEY NOT NULL, aliasmascota TEXT NOT NULL, raza TEXT NOT NULL, colorpelo TEXT NOT NULL)";
            sentencia.executeUpdate(sql1);
            
            sentencia.close();
            conexion.close();
        }
        catch(Exception e){
            System.err.println("Error:" + e.getMessage()); //esto es para los errores
            System.exit(0);
        }
        System.out.println("TABLAS CREADAS CORRECTAMENTE");
    }
    
    //INSERTAR DATOS CLIENTE
    public void insertarDatosCliente(double cod, String nom, String ape, double tel){
        try{
            Class.forName(cadena);
            conexion = DriverManager.getConnection(url);
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String sql = "INSERT INTO cliente(cod_cli, nom_cli, ape_cli, tel)" +
                         "VALUES('"+cod+"','"+nom+"','"+ape+"','"+tel+"' );";
            
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.commit(); //?
            conexion.close();
            
            //trabajan juntas
            //conexion.setAutoCommit(false);
            //conexion.commit();
        }
        catch(Exception e){
            System.err.println("Error:" + e.getMessage()); //esto es para los errores
            System.exit(0);
        }
        System.out.println("DATOS DEL CLIENTE INGRESADO CORRECTAMENTE");
    }
    
    // INSERTAR DATOS MASCOTA
     public void insertarDatosPaciente(double idmas, String aliasmas, String raza, String color){
        try{
            Class.forName(cadena);
            conexion = DriverManager.getConnection(url);
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String sql = "INSERT INTO paciente(idmascota, aliasmascota, raza, colorpelo)" +
                         "VALUES('"+idmas+"','"+aliasmas+"','"+raza+"','"+color+"' );";
            
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.commit(); //?
            conexion.close();
            
            //trabajan juntas
            //conexion.setAutoCommit(false);
            //conexion.commit();
        }
        catch(Exception e){
            System.err.println("Error:" + e.getMessage()); //esto es para los errores
            System.exit(0);
        }
        System.out.println("DATOS DEL PACIENTE INGRESADO CORRECTAMENTE");
    }
     
     
    //MOSTRAR DATOS
    public void mostrarDatos(){
        try{
            Class.forName(cadena);
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement();
            
            String sql = "SELECT * FROM CLIENTE"; 
            ResultSet resultados = sentencia.executeQuery(sql);
            
            while(resultados.next()){
                int id = resultados.getInt("cod_cli");
                String nombre = resultados.getString("nom_cli");
                String apellido = resultados.getString("ape_cli");
                int edad = resultados.getInt("edad");
            
                System.out.println(id + " " + nombre + " " + apellido + " " + edad);
            }
            
            resultados.close();
            sentencia.close();
            conexion.close();
        }
        catch(Exception e){
            System.err.println("Error:" + e.getMessage()); //esto es para los errores
            System.exit(0);
        }
        System.out.println("datos mostrados");
    }
    
    public void actualizarDatos(){
        try{
            Class.forName(cadena);
            conexion = DriverManager.getConnection(url);
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String sql = "UPDATE cliente SET nom_cli = 'juan' WHERE cod_cli=1;";
            
            sentencia.executeUpdate(sql);
            conexion.commit(); //?
            
            sentencia.close();
            conexion.close();
        }
        catch(Exception e){
            System.err.println("Error:" + e.getMessage()); //esto es para los errores
            System.exit(0);
        }
        System.out.println("datos actualizados");
    }
}


