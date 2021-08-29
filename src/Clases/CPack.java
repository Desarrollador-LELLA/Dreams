/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OError;
import Objetos.OPack;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CPack extends OPack {
    
    private final String TagCodigoClase = "CPack - %s";
    private OError Error = new OError();

    public CPack() {
        super();
    }
    

    public CPack (int id, String nombre, String costo, int stock, boolean estado){
        super(id ,nombre ,costo ,stock , estado);
    }
                 
    
    public List<OPack> Listar(){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OPack> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        OError Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM Pack");
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    Listado.add(new OPack(Resultado.getInt(1), Resultado.getString(2), Resultado.getString(3),Resultado.getInt(4), Resultado.getBoolean(5)));
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
    
    public OError Editar() {
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                Preparando = Sql.getCon().prepareStatement("UPDATE Pack SET PCK_NOMBRE = ?, PCK_COSTO = ?, PCK_STOCK = ?, PCK_ESTADO = ? WHERE PCK_ID_PACK = ?");
                Preparando.setString(1, this.getNombre());
                Preparando.setString(2, this.getCosto());
                Preparando.setInt(3, this.getStock());
                Preparando.setBoolean(4, this.isEstado());
                Preparando.setInt(5, this.getId());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 4), "Pack editado Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 5), "Pack no Editado", null, false);
                }
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 6), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 6)), null, false);
            } finally {
                Sql.Desconectar();
            }
        }
        return Error;
    }
    
    public OError Insertar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("INSERT INTO Pack(PCK_NOMBRE, PCK_COSTO, PCK_STOCK, PCK_ESTADO) VALUES(?,?,?,?)");
                Preparando.setString(1, this.getNombre());
                Preparando.setString(2, this.getCosto());
                Preparando.setInt(3, this.getStock());
                Preparando.setBoolean(4, this.isEstado());
                     
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Pack Agregado Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "Pack no Agregado", null, false);
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
    
    public OError Eliminar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
        
            try{
                Preparando = Sql.getCon().prepareStatement("UPDATE Pack SET PCK_ESTADO = ? WHERE PCK_ID_PACK = ?");
                Preparando.setBoolean (1,this.isEstado());
                Preparando.setInt(2, this.getId());
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Pack Desactivado Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "Pack no Agregado", null, false);
                }
                Preparando.close();
           
            }catch(SQLException e){
                System.out.println("error"+ e);
                //Error = new OError(String.format(TagCodigoClase, 3), String.format("<html>%s (Codigo %s)</html>", e, String.format(TagCodigoClase, 3)), null, false);
      
            }finally{  
                Sql.Desconectar();
            }    
        }
        return Error;
    }

}

