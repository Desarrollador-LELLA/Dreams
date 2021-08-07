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
public class CInicioSesion extends OUsuario {
    
    //ATRIBUTOS
    private OError Error = new OError();
    private final String TagCodigoClase = "CINICIOSESION - %s";

    //CONSTRUCTORES
    public CInicioSesion() {
        super();
    }

    public CInicioSesion(int id, String nombre, String apellidos, String username, String clave, boolean estado) {
        super(id, nombre, apellidos, username, clave, estado);
    }
    
    //METODOS
    public OError Iniciar(){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        OUsuario User = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM Usuarios WHERE USU_USERNAME = ?");
                Preparando.setString(1, getUsername());
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    User = new OUsuario(Resultado.getInt(1), Resultado.getString(2), Resultado.getString(3), Resultado.getString(4), Resultado.getString(5), Resultado.getBoolean(6));
                }
                
                if(User != null){
                    if(User.getClave().equals(getClave())){
                        if(User.isEstado()){
                            Error = new OError(String.format(TagCodigoClase, 1), "La Clave es la Correcta", User, true);
                        }
                        else{
                            Error = new OError(String.format(TagCodigoClase, 2), "El Usuario esta Desactivado", null, false);
                        }
                    }
                    else{
                        Error = new OError(String.format(TagCodigoClase, 3), "La Clave es Incorrecta", null, false);
                    }
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 4), "El Username NO Existe", null, false);
                }
                
                Resultado.close();
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 5), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 5)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Error;
    }   
}
