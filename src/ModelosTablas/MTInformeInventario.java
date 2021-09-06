/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;

import Objetos.OArticulos;
import Objetos.OInformeInventario;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author rodka
 */
public class MTInformeInventario implements TableModel {
    
      private final List<OArticulos> Articulo;
    
    public MTInformeInventario(List<OArticulos> articulo){
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
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch(columnIndex){
            /* case 0:
            NombreColumna = "ID";
            break;*/
            case 0:
                NombreColumna = "Codigo";
                break;
            case 1:
                NombreColumna = "Nombre";
                break;
            case 2:
                NombreColumna = "Stock";
                break;
            case 3:
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
                Valor = String.valueOf(Articulo.get(rowIndex).getId());
                break;
            case 1:
                Valor = Articulo.get(rowIndex).getDescripcion(); //Problemas con Int, no se puede convertir a String
                break;
            case 2:
                Valor = String.valueOf(Articulo.get(rowIndex).getStock());
                break;  
            case 3:
                Valor = String.valueOf(Articulo.get(rowIndex).getCategoria().getNombre()); //Problemas con Int, no se puede convertir a String
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

}
