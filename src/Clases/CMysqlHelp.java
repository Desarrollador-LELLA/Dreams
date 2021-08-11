/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OError;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author TOULON-NOTE
 */
public class CMysqlHelp {
    //ATRIBUTOS
    private OError error = new OError();
    // Declaramos la conexion a mysql
    private Connection con = null;
    // Declaramos los datos de conexion a la bd
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String pass = "";
    private final String url = "jdbc:mysql://localhost:3306/dreamgifts";
    private final String TagCodigoClase = "CMYSQL - %s";
    
    //CONSTRUCTORES
    public CMysqlHelp() {
    }
    
    //PROPIEDADES
    public OError getError() {
        return error;
    }
    
    public Connection getCon(){
        return con;
    }
    
    //METODOS
    public OError Conectar(){
        // Reseteamos a null la conexion a la bd
        con = null;
        try{
            Class.forName(driver);
            // Nos conectamos a la bd
            con = (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa o no comprobamos la variable con si es null o contiene datos
            if (con != null){
                error = new OError(String.format(TagCodigoClase, 1), "Coneccion Exitosa", con, true);
                System.out.println("Coneccion Exitosa");
            }
            else{
                error = new OError(String.format(TagCodigoClase, 2), "Retorna null", con, false);
                System.out.println("Retorna null");
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion: " + e);
            error = new OError(String.format(TagCodigoClase, 3), String.format("<html>Error de conexion: %s (Codigo %s)</html>", e, String.format(TagCodigoClase, 3)), con, false);
        }
        return error;
    }
    
    //METODO EN CONSTRUCCION
    public OError Insertar(){
        if(Conectar().isConfirma()){
            try {
                PreparedStatement Preparando = con.prepareStatement("?", new String[]{ "" });
                Preparando.setString(1, "dato a ingresar");
                
                if(Preparando.execute()){
                    
                }
                else{
                    
                }
                
            } catch (SQLException ex) {
                System.out.println("Error de conexion: " + ex);
            }
        }
        return new OError();
    }
    
    //METODO EN CONSTRUCCION
    public OError Consulta(){
        if(Conectar().isConfirma()){
            try {
                PreparedStatement uno = con.prepareStatement("?", new String[]{ "" });
            } catch (SQLException ex) {
                System.out.println("Error de conexion: " + ex);
            }
        }
        return new OError();
    }
    
    public void Desconectar(){
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexion: " + ex);
        }
    }
}
