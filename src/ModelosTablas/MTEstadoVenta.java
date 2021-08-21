
package ModelosTablas;

import Objetos.OEstadoVenta;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author rodka
 */
public class MTEstadoVenta implements TableModel {
    
    private final List<OEstadoVenta> EstadoVenta;
    
    public MTEstadoVenta(List<OEstadoVenta> estadoVenta){
        EstadoVenta = estadoVenta;
    }

    public List<OEstadoVenta> getUsuarios() {
        return EstadoVenta;
    }
    
    @Override
    public int getRowCount() {
        return EstadoVenta.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch(columnIndex){
            /* case 0:
            NombreColumna = "ID";
            break;*/
            case 0:
                NombreColumna = "Nombre";
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
            /*case 0:
            Valor = Comuna.get(rowIndex).getId();
            break;*/
            case 0:
                Valor = EstadoVenta.get(rowIndex).getNombre();
                break;
            case 1:
                Valor = EstadoVenta.get(rowIndex).getEstado()? "Activado" : "Desactivado";
                break;
        }
        
        return Valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //Usuarios.set(rowIndex, (OUsuario)aValue);
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
