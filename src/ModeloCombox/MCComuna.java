/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloCombox;

import Objetos.OComuna;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author TOULON-NOTE
 */
public class MCComuna implements ComboBoxModel {
    
    private final List<OComuna> Comunas;
    private String Nombre = "Seleccione Comuna";

    public MCComuna(List<OComuna> Comunas) {
        this.Comunas = Comunas;
    }

    public List<OComuna> getComunas() {
        return Comunas;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        Nombre = String.valueOf(anItem);
    }

    @Override
    public Object getSelectedItem() {
        return Nombre;
    }

    @Override
    public int getSize() {
        return Comunas.size();
    }
    
    @Override
    public Object getElementAt(int index) {
        return Comunas.get(index).getNombre();
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
