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
 * @author rodka
 */
public class CInformeInventario {
    
     private final String TagCodigoClase = "CComuna - %s";
    private OError Error = new OError();

    public CInformeInventario() {
        super();
    }
    
    
    
    
    public List<OCatArticulos> Listar(String Tipo) {
        
        String sql = "";
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OCatArticulos> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                
                switch (Tipo) {
                    case "Activos":
                        sql = "SELECT * FROM Categoria WHERE CAT_ESTADO = true";
                        break;
                    default:
                        sql = "SELECT * FROM Categoria";
                        break;
                }
                Preparando = Sql.getCon().prepareStatement(sql);
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
