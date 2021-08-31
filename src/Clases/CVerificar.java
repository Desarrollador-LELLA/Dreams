
package Clases;

import Objetos.OError;
import Objetos.OVerificar;
import Paneles.PProveedor;
import static java.awt.Color.red;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.JTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author rodka
 */
public class CVerificar extends OVerificar{

    private OError Error = new OError();
    private String TagCodigoClase = "CVerificar - %s";
    private JTable tabla;

    public CVerificar() {
        super();
    }

    public CVerificar(String Rut) {
        super(Rut);
    }

    public CVerificar(JTable tabla) {
        this.tabla = tabla;
    }
    
    
    
    public OError Validar() {

        int Ult = this.getRut().length();
        int Largo = this.getRut().length() - 3;//19068257-4
        int Constante = 2;
        int Suma = 0;
        int Digito = 0;

        for (int i = Largo; i >= 0; i--) {

            Suma = Suma + Integer.parseInt(this.getRut().substring(i, i + 1)) * Constante;
            Constante = Constante + 1;
            if (Constante == 8) {
                Constante = 2;
            }
        }
        String Ultimo = this.getRut().substring(Ult - 1).toUpperCase();
        Digito = 11 - (Suma % 11);
        if (Digito == 10 && Ultimo.equals("K")) {
            Error = new OError(String.format(TagCodigoClase, 1), "Rut Correcto", null, true);
            
        } else {

            if (Digito == 11 && Ultimo.equals("0")) {
                Error = new OError(String.format(TagCodigoClase, 1), "Rut Correcto", null, true);
            } else {
                
                if (Digito == Integer.parseInt(Ultimo)) {
                   Error = new OError(String.format(TagCodigoClase, 1), "Rut Correcto", null, true);
                }else{
                    Error = new OError(String.format(TagCodigoClase, 1), "Rut incorrecto", null, false);
                }
            }
            
        }
        return Error;
    }
    
    /**
     *
     * @return
     */
    public void Imprimir() {
        String ruta = System.getProperties().getProperty("user.dir");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet hoja = workbook.createSheet();
        XSSFCellStyle styleE = workbook.createCellStyle();
        XSSFCellStyle styleC = workbook.createCellStyle();
        
        
        styleE.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        
        
        
        
    
        XSSFRow fila = hoja.createRow(0);
        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
         
            fila.createCell(i).setCellValue(tabla.getColumnName(i));
            
        }

        XSSFRow filas;
        Rectangle rect;
        
        for (int i = 0; i < tabla.getRowCount(); i++) {

            rect = tabla.getCellRect(i, 0, true);
            try {
                tabla.scrollRectToVisible(rect);
                tabla.setRowSelectionInterval(i, i);

                filas = hoja.createRow((i + 1));
                for (int e = 0; e < tabla.getColumnModel().getColumnCount(); e++) {

                    filas.createCell(e).setCellValue(tabla.getValueAt(i, e).toString());      

                }

            } catch (java.lang.ClassCastException e) {
                
            }
        }

        try {
            workbook.write(new FileOutputStream(new File(ruta + "//Excel.xlsx")));
            Desktop.getDesktop().open(new File(ruta + "//Excel.xlsx"));

        } catch (IOException ex) {
            Logger.getLogger(PProveedor.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }
    

    
}
