/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OError;
import Objetos.OIVentaPack;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOULON-NOTE
 */
public class CIVentaPack extends OIVentaPack {
    private final String TagCodigoClase = "CIVentaPack - %s";
    private OError Error = new OError();

    public CIVentaPack() {
        super();
    }

    public CIVentaPack(String nombre, int cantidad, int valor) {
        super(nombre, cantidad, valor);
    }

    public OError getError() {
        return Error;
    }
    
    public List<OIVentaPack> Listar(String Inicio, String Final){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OIVentaPack> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT P.PCK_NOMBRE, SUM(V.VTA_CANTIDAD), SUM(V.VTA_TOTAL) FROM venta V INNER JOIN pack P "
                        + "ON V.PCK_ID_PACK = P.PCK_ID_PACK WHERE V.VTA_FECHA_VENTA BETWEEN CAST(? AS DATE) AND CAST(? AS DATE) GROUP BY P.PCK_NOMBRE");
                Preparando.setString(1, Inicio);
                Preparando.setString(2, Final);
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    Listado.add(new OIVentaPack(Resultado.getString(1), Resultado.getInt(2), Resultado.getInt(3)));
                }
                Error = new OError(String.format(TagCodigoClase, 10), "Consulta Realizada Correctamente", null, true);
                
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
