/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;

import Objetos.OInformeInventario;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author rodka
 */
public class MTInformeInventario implements TableModel {
    
    private final List<OInformeInventario> InformeInventario;
    
    public MTInformeInventario(List<OInformeInventario> informeInventario){
        InformeInventario = informeInventario;
    }
    
      public List<OInformeInventario> getArticulo() {
        return InformeInventario;
    }
      
    @Override
    public int getRowCount() {
        return InformeInventario.size();
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
                NombreColumna = "Codigo Articulo";
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
                Valor = String.valueOf(InformeInventario.get(rowIndex).getArticulo().getId());
                break;
            case 1:
                Valor = InformeInventario.get(rowIndex).getArticulo().getDescripcion();
                break;
            case 2:
                Valor = String.valueOf(InformeInventario.get(rowIndex).getArticulo().getStock());
                break;
            case 3:
                Valor = InformeInventario.get(rowIndex).getCategoria().getNombre();
                break;    
        }
        
        return Valor;
    }

   

    @Override
    public void setValueAt(Object o, int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
