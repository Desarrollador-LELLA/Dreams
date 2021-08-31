/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OCanales;
import Objetos.OError;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CCanal extends OCanales{
    private OError Error = new OError();
    private String TagCodigoClase = "CCanal - %s";

    public CCanal() {
    super();
    }

    public CCanal(int id, String nombre, Boolean estado) {
        super(id, nombre, estado);
    }

   

    
    public OError Agregar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("INSERT INTO Canal(CAN_NOMBRE, CAN_ESTADO) VALUES(?,?)");
                Preparando.setString(1, this.getNombre());
                Preparando.setBoolean(2, this.getEstado());
        
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Canal Agregado Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "El Canal no fue Agregado", null, false);
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
    public List<OCanales> Listar(String Tipo){ 
        String sql = "";
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OCanales> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                switch (Tipo) {
                    case "Activos":
                        sql = "SELECT * FROM Canal WHERE CAN_ESTADO = true";
                        break;
                    default:
                        sql = "SELECT * FROM Canal";
                        break;
                }
                Preparando = Sql.getCon().prepareStatement(sql);
                Resultado = Preparando.executeQuery();

                while (Resultado.next()) {
                    Listado.add(new OCanales(Resultado.getInt(1), Resultado.getString(2), Resultado.getBoolean(3)));
                }
                Error = new OError(String.format(TagCodigoClase, 10), "Operación Realizada Corectamente", null, true);

                Resultado.close();
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 11), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 11)), null, false);
            } finally {
                Sql.Desconectar();
            }
        }
        return Listado; 
    }
    public OError Editar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                Preparando = Sql.getCon().prepareStatement("UPDATE Canal SET CAN_NOMBRE = ?, CAN_ESTADO = ? WHERE CAN_ID_CANAL = ?");
                Preparando.setString(1, this.getNombre());
                Preparando.setBoolean(2, this.getEstado());  
                Preparando.setInt(3, this.getId());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 4), "Canal Editado Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 5), "El  no fue Editado", null, false);
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
    public OError Eliminar() {
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {

            try {
                Preparando = Sql.getCon().prepareStatement("UPDATE Canal SET CAN_ESTADO = ? WHERE CAN_ID_CANAL = ?");
                Preparando.setBoolean(1, this.getEstado());
                Preparando.setInt(2, this.getId());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 1), "Canal Desactivada Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 2), "Canal no fue Agregado", null, false);
                }
                Preparando.close();

            } catch (SQLException e) {
                System.out.println("error" + e);
                //Error = new OError(String.format(TagCodigoClase, 3), String.format("<html>%s (Codigo %s)</html>", e, String.format(TagCodigoClase, 3)), null, false);

            } finally {
                Sql.Desconectar();
            }

        }
        return Error;
    }
}

