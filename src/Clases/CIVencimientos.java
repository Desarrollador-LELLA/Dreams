
package Clases;

import Objetos.OArticulos;
import Objetos.OCatArticulos;
import Objetos.OError;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CIVencimientos extends OArticulos{
 private final String TagCodigoClase = "CArticulos - %s";
    private OError Error = new OError();

    public CIVencimientos() {
        super(); 
    }
    
    public CIVencimientos(int id, String descripcion, int stock, String fecha, boolean estado, OCatArticulos categoria) {
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
    
}



