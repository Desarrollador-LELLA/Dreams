/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;

import Objetos.OUsuario;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author TOULON-NOTE
 */
public class MTUsuarios implements TableModel {
    
    private List<OUsuario> Usuarios;
    
    public MTUsuarios(List<OUsuario> usuarios){
        Usuarios = usuarios;
    }

    public List<OUsuario> getUsuarios() {
        return Usuarios;
    }
    
    @Override
    public int getRowCount() {
        return Usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch(columnIndex){
            case 0:
                NombreColumna = "Nombre";
                break;
            case 1:
                NombreColumna = "Apellidos";
                break;
            case 2:
                NombreColumna = "Username";
                break;
            case 3:
                NombreColumna = "Estado";
                break;
        }
        
        return NombreColumna;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        /**Class Tipo = null;
        switch(columnIndex){
            case 0:
                Tipo = String.class;
                break;
            case 1:
                Tipo = String.class;
                break;
            case 2:
                Tipo = String.class;
                break;
            case 3:
                Tipo = Boolean.class;
                break;
        }**/
        
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
                Valor = Usuarios.get(rowIndex).getNombre();
                break;
            case 1:
                Valor = Usuarios.get(rowIndex).getApellidos();
                break;
            case 2:
                Valor = Usuarios.get(rowIndex).getUsername();
                break;
            case 3:
                Valor = Usuarios.get(rowIndex).isEstado() ? "Activado" : "Desactivado";
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
