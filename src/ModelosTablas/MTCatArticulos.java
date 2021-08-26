/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;

import Objetos.OCatArticulos;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Usuario
 */
public class MTCatArticulos implements TableModel {
    
    private List<OCatArticulos> Categoria;

    public MTCatArticulos(List<OCatArticulos> Categoria) {
        this.Categoria = Categoria;
    }

    public List<OCatArticulos> getCategoria() {
        return Categoria;
    }
    
    
    
    @Override
    public int getRowCount() {
        return Categoria.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch(columnIndex){
            case 0:
                NombreColumna = "Categoría Artículo";
                break;
            case 1:
                NombreColumna = "Estado";
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
            case 0:
                Valor = Categoria.get(rowIndex).getNombre();
                break;
            case 1:
                Valor = Categoria.get(rowIndex).getEstado() ? "Activado" : "Desactivado";
                break;
        }
        return Valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
    
}
