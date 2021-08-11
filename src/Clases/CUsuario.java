/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OError;
import Objetos.OUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOULON-NOTE
 */
public class CUsuario extends OUsuario {
    //ATRIBUTOS
    private OError Error = new OError();
    private final String TagCodigoClase = "CUSUARIO - %s";
    
    //CONSTRUCTORES
    public CUsuario() {
        super();
    }

    public CUsuario(int id, String nombre, String apellidos, String username, String clave, boolean estado) {
        super(id, nombre, apellidos, username, clave, estado);
    }
    
    //PROPIEDADES
    public OError getError() {
        return Error;
    }
    
    //METODOS
    public OError Agregar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("INSERT INTO Usuarios(USU_NOMBRE, USU_APELLIDO, USU_USERNAME, USU_CLAVE, USU_ESTADO) VALUES(?, ?, ?, ?, ?)");
                Preparando.setString(1, this.getNombre());
                Preparando.setString(2, this.getApellidos());
                Preparando.setString(3, this.getUsername());
                Preparando.setString(4, this.getClave());
                Preparando.setBoolean(5, this.isEstado());
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Usuario Agregado Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "El Usuario no fue Agregado", null, false);
                }
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 3), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 3)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Error;
    }
    
    //ADITANDO
    public OError Editar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("UPDATE Usuarios SET USU_NOMBRE = ?, USU_APELLIDO = ?, USU_USERNAME = ?, USU_CLAVE = ?, USU_ESTADO = ? WHERE USU_ID_USUARIO = ?");
                Preparando.setString(1, this.getNombre());
                Preparando.setString(2, this.getApellidos());
                Preparando.setString(3, this.getUsername());
                Preparando.setString(4, this.getClave());
                Preparando.setBoolean(5, this.isEstado());
                Preparando.setInt(6, this.getId());
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 4), "Usuario Editado Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 5), "El Usuario no fue Editado", null, false);
                }
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 6), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 6)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Error;
    }
    
    //EDITANDO
    public OError Desactivar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("UPDATE Usuarios SET USU_ESTADO = ? WHERE USU_ID_USUARIO = ?");
                Preparando.setBoolean(1, this.isEstado());
                Preparando.setInt(2, this.getId());
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 7), "Usuario Desactivado Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 8), "El Usuario no fue Desactivado", null, false);
                }
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 9), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 9)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Error;
    }
    
    public List<OUsuario> Listar(){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OUsuario> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM Usuarios");
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    Listado.add(new OUsuario(Resultado.getInt(1), Resultado.getString(2), Resultado.getString(3), Resultado.getString(4), Resultado.getString(5), Resultado.getBoolean(6)));
                }
                Error = new OError(String.format(TagCodigoClase, 10), "Consulta Realizada Corectamente", null, true);
                
                Resultado.close();
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 11), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 11)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Listado;
    }
    
    public OError ExisteUsername(){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT COUNT(1) FROM Usuarios WHERE USU_USERNAME = ?");
                Preparando.setString(1, this.getUsername());
                Resultado = Preparando.executeQuery();
                int contador = 0;
                while(Resultado.next()){
                    contador = Resultado.getInt(1);
                }
                if(contador == 0){
                    Error = new OError(String.format(TagCodigoClase, 12), String.format("El Username (%s) no esta siendo Utilizado", this.getUsername()), null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 13), String.format("El Username (%s) ya esta siendo Utilizado", this.getUsername()), null, false);
                }
                Resultado.close();
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 14), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 14)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Error;
    }
    
    public OError ExisteUsernameDiferente(){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT COUNT(1) FROM Usuarios WHERE USU_USERNAME = ? AND USU_ID_USUARIO != ?");
                Preparando.setString(1, this.getUsername());
                Preparando.setInt(2, this.getId());
                Resultado = Preparando.executeQuery();
                int contador = 0;
                while(Resultado.next()){
                    contador = Resultado.getInt(1);
                }
                if(contador == 0){
                    Error = new OError(String.format(TagCodigoClase, 15), String.format("El Username (%s) no esta siendo Utilizado", this.getUsername()), null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 16), String.format("El Username (%s) ya esta siendo Utilizado", this.getUsername()), null, false);
                }
                Resultado.close();
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 17), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 17)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Error;
    }
    
    public List<OUsuario> Busqueda(String datoBusqueda, int tipo){
        //USU_NOMBRE = ?, USU_APELLIDO = ?, USU_USERNAME
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OUsuario> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                String atributo = "";
                switch(tipo){
                    case 0:
                        atributo = "USU_NOMBRE";
                        break;
                    case 1:
                        atributo = "USU_APELLIDO";
                        break;
                    case 2:
                        atributo = "USU_USERNAME";
                        break;
                }
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM Usuarios WHERE " + atributo + " LIKE ?");
                Preparando.setString(1, "%" + datoBusqueda + "%");
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    Listado.add(new OUsuario(Resultado.getInt(1), Resultado.getString(2), Resultado.getString(3), Resultado.getString(4), Resultado.getString(5), Resultado.getBoolean(6)));
                }
                Error = new OError(String.format(TagCodigoClase, 10), "Consulta Realizada Corectamente", null, true);
                
                Resultado.close();
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 11), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 11)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Listado;
    }
}
