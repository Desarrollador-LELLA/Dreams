package ModelosTablas;


import Objetos.OCliente;
import java.util.List;
import javax.swing.event.TableModelListener;
//import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;



public class MTCliente implements TableModel {

    private final List<OCliente> Cliente;

    public MTCliente(List<OCliente> cliente) {
        Cliente = cliente;
    }

    public List<OCliente> getUsuarios() {
        return Cliente;
    }

    @Override
    public int getRowCount() {
        return Cliente.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch (columnIndex) {
            case 0:
                NombreColumna = "Nombre"; //cabecera 
                break;
            case 1:
                NombreColumna = "Apellido";
                break;
            case 2:
                NombreColumna = "Rut";
                break;
            case 3:
                NombreColumna = "Direccion";
                break;
            case 4:
                NombreColumna = "Correo";
                break;
            case 5:
                NombreColumna = "Telefono";
                break;
            case 6:
                NombreColumna = "Estado";
                break;
        }

        return NombreColumna;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String Valor = null;
        switch (columnIndex) {
            case 0:
                Valor = Cliente.get(rowIndex).getNombre();
		break;
            case 1:
                Valor = Cliente.get(rowIndex).getApellido();
                break;
            case 2:
                Valor = Cliente.get(rowIndex).getRut();
                break;
            case 3:
                Valor = Cliente.get(rowIndex).getDireccion();
                break;
            case 4:
                Valor = Cliente.get(rowIndex).getCorreo();
                break;
       /*         case 5:
                Valor = Cliente.get(rowIndex).getTelefono();
                break; */
            case 6:
                Valor = Cliente.get(rowIndex).isEstado() ? "Activado" : "Desactivado";
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

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
