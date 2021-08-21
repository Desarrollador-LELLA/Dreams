/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import Objetos.OCatArticulos;
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
public class CCatArticulos extends OCatArticulos {

    private OError Error = new OError();
    private String TagCodigoClase = "CCatArticulos - %s";

    public CCatArticulos() {
        super();
    }

    public CCatArticulos(int id, String nombre, Boolean estado) {
        super(id, nombre, estado);
    }

    //METODOS
    public OError Agregar() {
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                Preparando = Sql.getCon().prepareStatement("INSERT INTO Categoria(CAT_DESCRIPCION, CAT_ESTADO) VALUES(?,?)");
                Preparando.setString(1, this.getNombre());
                Preparando.setBoolean(2, this.getEstado());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 1), "Categoria Agregada Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 2), "Categoría no fue Agregada", null, false);
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
                Preparando = Sql.getCon().prepareStatement("UPDATE Categoria SET CAT_DESCRIPCION = ? WHERE CAT_ID_CATEGORIA = ?");
                Preparando.setString(1, this.getNombre());
                Preparando.setInt(2, this.getId());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 4), "Categoría Editada Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 5), "Error al editar Categoría", null, false);
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
                Preparando = Sql.getCon().prepareStatement("UPDATE Categoria SET CAT_ESTADO = ? WHERE CAT_ID_CATEGORIA = ?");
                Preparando.setBoolean(1, this.getEstado());
                Preparando.setInt(2, this.getId());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 1), "Categoría Desactivada Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 2), "Categoría no fue Agregada", null, false);
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

    public List<OCatArticulos> Listar() {
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OCatArticulos> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM Categoria");
                Resultado = Preparando.executeQuery();

                while (Resultado.next()) {
                    Listado.add(new OCatArticulos(Resultado.getInt(1), Resultado.getString(2), Resultado.getBoolean(3)));
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

