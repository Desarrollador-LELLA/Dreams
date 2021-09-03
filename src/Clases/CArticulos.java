/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//TESTER DE TESTER DE LOS TESTER
package Clases;

import Objetos.OArticulos;
import Objetos.OCatArticulos;
import Objetos.OError;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CArticulos extends OArticulos {
    
    private final String TagCodigoClase = "CArticulos - %s";
    private OError Error = new OError();

    public CArticulos() {
        super();
    }
    
    public CArticulos(int id, String descripcion, int stock, String fecha, boolean estado, OCatArticulos categoria) {
        super(id, descripcion, stock, fecha, estado, categoria);
    }
    
    public List<OArticulos> Listar(){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OArticulos> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        OError Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM Articulo A inner join Categoria C on A.CAT_ID_CATEGORIA = C.CAT_ID_CATEGORIA");
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    OCatArticulos cat = new OCatArticulos(Resultado.getInt(7),Resultado.getString(8),Resultado.getBoolean(9));
                    Listado.add(new OArticulos(Resultado.getInt(1), Resultado.getString(2), Resultado.getInt(3),Resultado.getString(4), Resultado.getBoolean(5), cat));
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
                Preparando = Sql.getCon().prepareStatement("UPDATE Articulo SET ART_DESCRIPCION = ?, ART_STOCK = ?, ART_FECHA_VENCIMIENTO = ?, ART_ESTADO = ?, CAT_ID_CATEGORIA = ? WHERE ART_ID_ARTICULOS = ?");
                Preparando.setString(1, this.getDescripcion());
                Preparando.setInt(2, this.getStock());
                Preparando.setString(3, this.getFecha());
                Preparando.setBoolean(4, this.isEstado());
                Preparando.setInt(5,this.getCategoria().getId());
                Preparando.setInt(6, this.getId());
                
 

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 4), "Articulo Editado Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 5), "El Articulo no fue Editado", null, false);
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
                Preparando = Sql.getCon().prepareStatement("INSERT INTO Articulo(ART_DESCRIPCION, ART_STOCK, ART_FECHA_VENCIMIENTO, ART_ESTADO, CAT_ID_CATEGORIA) VALUES(?,?,?,?,?)");
                Preparando.setString(1, this.getDescripcion());
                Preparando.setInt(2, this.getStock());
                Preparando.setDate(3, Date.valueOf(this.getFecha()));
                Preparando.setBoolean(4, this.isEstado());
                Preparando.setInt(5, this.getCategoria().getId());
                     
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Articulo Agregado Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "El Articulo no fue Agregado", null, false);
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
                Preparando = Sql.getCon().prepareStatement("UPDATE Articulo SET ART_ESTADO = ? WHERE ART_ID_ARTICULO = ?");
                Preparando.setBoolean (1,this.isEstado());
                Preparando.setInt(2, this.getId());
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Articulo Desactivada Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "La Articulo no fue Agregado", null, false);
                }
                Preparando.close();
           
            }catch(SQLException e){
                System.out.println("error"+ e);
                Error = new OError(String.format(TagCodigoClase, 3), String.format("<html>%s (Codigo %s)</html>", e, String.format(TagCodigoClase, 3)), null, false);
      
            }finally{  
                Sql.Desconectar();
            }    
        }
        return Error;
    }
    
     public List<OArticulos> Buscar(int datoBusqueda, int tipo){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OArticulos> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        OError Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                //Preparando = Sql.getCon().prepareStatement("SELECT * FROM Articulo A inner join Categoria C on A.CAT_ID_CATEGORIA = C.CAT_ID_CATEGORIA" );
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM Articulo A inner join Categoria C on A.CAT_ID_CATEGORIA = C.CAT_ID_CATEGORIA WHERE (ART_STOCK >=" + datoBusqueda + " AND C.CAT_ID_CATEGORIA = " + (tipo+1) +")");
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    OCatArticulos cat = new OCatArticulos(Resultado.getInt(7),Resultado.getString(8),Resultado.getBoolean(9));
                    Listado.add(new OArticulos(Resultado.getInt(1), Resultado.getString(2), Resultado.getInt(3),Resultado.getString(4), Resultado.getBoolean(5), cat));
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
