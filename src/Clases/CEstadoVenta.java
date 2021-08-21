/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OError;
import Objetos.OEstadoVenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodka
 */
public class CEstadoVenta extends OEstadoVenta {
    
    private final String TagCodigoClase = "CComuna - %s";
    private OError Error = new OError();

    public CEstadoVenta() {
        super();
    }

    public CEstadoVenta(int id, String nombre, boolean estado) {
        super(id, nombre, estado);
    }
    
    
    public List<OEstadoVenta> Listar(){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OEstadoVenta> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        OError Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM comuna");
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    Listado.add(new OEstadoVenta(Resultado.getInt(1), Resultado.getString(2), Resultado.getBoolean(3)));
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
