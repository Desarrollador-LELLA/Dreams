/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OBanco;
import Objetos.OError;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CBanco extends OBanco {

    private OError Error = new OError();
    private String TagCodigoClase = "CBanco - %s";

    public CBanco() {
        super();
    }

    public CBanco(int id, String nombre, Boolean estado) {
        super(id, nombre, estado);
    }

    //METODOS
    public OError Agregar() {
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                Preparando = Sql.getCon().prepareStatement("INSERT INTO Bancos(BAN_DESCRIPCION, BAN_ESTADO) VALUES(?,?)");
                Preparando.setString(1, this.getNombre());
                Preparando.setBoolean(2, this.getEstado());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 1), "Banco Agregado Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 2), "El Banco no fue Agregado", null, false);
                }
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 3), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 3)), null, false);
            } finally {
                Sql.Desconectar();
            }
        }
        return Error;
    }

    public OError Editar() {
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                Preparando = Sql.getCon().prepareStatement("UPDATE Bancos SET BAN_DESCRIPCION = ? WHERE BAN_ID_BANCO = ?");
                Preparando.setString(1, this.getNombre());
                Preparando.setInt(2, this.getId());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 4), "Banco Editado Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 5), "El Banco no fue Editado", null, false);
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

    //Utiliizada con botón DESACTIVAR
    public OError Eliminar() {
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {

            try {
                Preparando = Sql.getCon().prepareStatement("UPDATE Bancos SET BAN_ESTADO = ? WHERE BAN_ID_BANCO = ?");
                Preparando.setBoolean(1, this.getEstado());
                Preparando.setInt(2, this.getId());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 1), "Banco Desactivada Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 2), "Banco no fue Agregado", null, false);
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

    public List<OBanco> Listar() {
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OBanco> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM Bancos");
                Resultado = Preparando.executeQuery();

                while (Resultado.next()) {
                    Listado.add(new OBanco(Resultado.getInt(1), Resultado.getString(2), Resultado.getBoolean(3)));
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
}
