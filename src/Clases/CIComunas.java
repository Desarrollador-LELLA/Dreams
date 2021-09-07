/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OError;
import Objetos.OIComunas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CIComunas extends OIComunas{
    private final String TagCodigoClase = "CComuna - %s";
    private OError Error = new OError();

    public CIComunas() {
        super();
    }    

    public CIComunas(String nombre, String pack, int cantidad, int valor) {
        super(nombre, pack, cantidad, valor);
    }

    public OError getError() {
        return Error;
    }
    
    public List<OIComunas> Listar(int Tipo, String desde, String hasta){
        String sql = "";
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OIComunas> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        OError Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                if(Tipo==0){
                    Preparando = Sql.getCon().prepareStatement("SELECT C.COM_NOMBRE,P.PCK_NOMBRE,SUM(V.VTA_CANTIDAD),SUM(V.VTA_TOTAL) FROM Venta V inner join Comuna C on V.COM_ID_COMUNA = C.COM_ID inner join Pack P on V.PCK_ID_PACK = P.PCK_ID_PACK WHERE V.VTA_FECHA_VENTA BETWEEN CAST(? AS DATE) AND CAST(? AS DATE) GROUP BY C.COM_NOMBRE");
                    Preparando.setString(1,desde);
                    Preparando.setString(2,hasta);
                }else{
                    Preparando = Sql.getCon().prepareStatement("SELECT C.COM_NOMBRE,P.PCK_NOMBRE,SUM(V.VTA_CANTIDAD),SUM(V.VTA_TOTAL) FROM Venta V inner join Comuna C on V.COM_ID_COMUNA = C.COM_ID inner join Pack P on V.PCK_ID_PACK = P.PCK_ID_PACK WHERE V.VTA_FECHA_VENTA BETWEEN CAST(? AS DATE) AND CAST(? AS DATE) AND C.COM_ID = ? GROUP BY C.COM_NOMBRE");
                    Preparando.setString(1,desde);
                    Preparando.setString(2,hasta);
                    Preparando.setInt(3, Tipo);
                }
                
                
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    Listado.add(new OIComunas( Resultado.getString(1), Resultado.getString(2), Resultado.getInt(3) , Resultado.getInt(4)));
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
