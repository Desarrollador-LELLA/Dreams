
package ModelosTablas;

import Objetos.OArticulos;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class MTIVencimientos implements TableModel {

    private final List<OArticulos> item;

    public MTIVencimientos(List<OArticulos> Item) {
        item = Item;
}

    public List<OArticulos> getArticulo() {
        return item;
    }

    @Override
    public int getRowCount() {
        return item.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch (columnIndex) {
            /* case 0:
            NombreColumna = "ID";
            break;*/
            case 0:
                NombreColumna = "Código Artículo";
                break;
            case 1:
                NombreColumna = "Nombre";
                break;
            case 2:
                NombreColumna = "Stock";
                break;
            case 3:
                NombreColumna = "Fecha de vencimiento";
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
        switch (columnIndex) {
            /*case 0:
            Valor = Comuna.get(rowIndex).getId();
            break;*/
            case 0:
                Valor = String.valueOf(item.get(rowIndex).getId());
                break;
            case 1:
                Valor = item.get(rowIndex).getDescripcion(); //Problemas con Int, no se puede convertir a String
                break;
            case 2:
                Valor = String.valueOf(item.get(rowIndex).getStock());
                break;
            case 3:
                Valor = item.get(rowIndex).getFecha();
                break;
            case 4:
                Valor = item.get(rowIndex).getCategoria().getNombre(); //Problemas con Int, no se puede convertir a String
                break;
        }

        return Valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}