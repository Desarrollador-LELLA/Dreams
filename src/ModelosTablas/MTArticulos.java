/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;

import Objetos.OArticulos;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Usuario
 */
public class MTArticulos implements TableModel {
    
    private final List<OArticulos> Articulo;
    
    public MTArticulos(List<OArticulos> articulo){
        Articulo = articulo;
    }

    public List<OArticulos> getArticulo() {
        return Articulo;
    }
    
    @Override
    public int getRowCount() {
        return Articulo.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch(columnIndex){
            /* case 0:
            NombreColumna = "ID";
            break;*/
            case 0:
                NombreColumna = "Descripción";
                break;
            case 1:
                NombreColumna = "Stock";
                break;
            case 2:
                NombreColumna = "Fecha";
                break;
            case 3:
                NombreColumna = "Estado";
                break;
            case 4:
                NombreColumna = "Categoria";
                break;

        }
        
        return NombreColumna;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       
        
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String Valor = null;
        switch(columnIndex){
            /*case 0:
            Valor = Comuna.get(rowIndex).getId();
            break;*/
            case 0:
                Valor = Articulo.get(rowIndex).getDescripcion();
                break;
            case 1:
                Valor = toString(Articulo.get(rowIndex).getStock()); //Problemas con Int, no se puede convertir a String
                break;
            case 2:
                Valor = String.valueOf(Articulo.get(rowIndex).getFecha());
                break;
            case 3:
                Valor = Articulo.get(rowIndex).isEstado()? "Activado" : "Desactivado";
                break;    
            case 4:
                Valor = toString(Articulo.get(rowIndex).getCategoria()); //Problemas con Int, no se puede convertir a String
                break;
        }
        
        return Valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //To change body of generated methods, choose Tools | Templates.
    }

    private String toString(int stock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
