/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OError;
import Objetos.OProveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodka
 */
public class CProveedor extends OProveedor {
    
    private final String TagCodigoClase = "CProveedor - %s";
    private OError Error = new OError();

    public CProveedor() {
        super();
    }

    public CProveedor (int id, String rut, String rsocial, String nombre, int telefono, String correo, String direccion, boolean estado) {
        super(id, rut, rsocial, nombre, telefono, correo, direccion, estado);
    }
    
    
    public List<OProveedor> Listar(){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OProveedor> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        OError Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM Proveedor");
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    Listado.add(new OProveedor(Resultado.getInt(1), Resultado.getString(2), Resultado.getString(3),Resultado.getString(4), Resultado.getInt(5), Resultado.getNString(6), Resultado.getNString(7), Resultado.getBoolean(8)));
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
