package Clases;

import Objetos.OError;
import Objetos.OVerificar;
import Paneles.PProveedor;
import static java.awt.Color.red;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.JTable;
import org.apache.poi.hssf.util.CellRangeAddress;
import static org.apache.poi.hssf.util.HSSFColor.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
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
    public void Imprimir(JTable tabla, String Titulo) {
        
        String ruta = System.getProperties().getProperty("user.dir");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet hoja = workbook.createSheet();
        XSSFCellStyle styleT = workbook.createCellStyle();
        XSSFCellStyle styleE = workbook.createCellStyle();
        XSSFCellStyle styleC = workbook.createCellStyle();
        XSSFCellStyle styleC2 = workbook.createCellStyle();
        XSSFFont fuente = workbook.createFont();
        XSSFFont fuenteT = workbook.createFont();
        
       //Titulo
       Header encabezado = hoja.getHeader();  
       //encabezado.setCenter("Center Header"); 
       Row row = hoja.createRow(0); 
       Cell cell = row.createCell(0);            
       cell=row.createCell(0);   
       CellRangeAddress region=new CellRangeAddress(0, 1, 0, 4);
       hoja.addMergedRegion(region);
       cell.setCellValue(Titulo); 
       encabezado.setCenter("Center Header");
       cell.setCellStyle(styleT);
       
       //estilo de fuente Titulo
        fuenteT.setFontHeightInPoints((short) 20);
        fuenteT.setColor(IndexedColors.BLACK.getIndex());
        fuenteT.setBold(true);
       
        //estilo titulo
        //color
        styleT.setAlignment(HorizontalAlignment.CENTER);
        styleT.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        styleT.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
        //asignar a estilo la fuente
        styleT.setFont(fuenteT);
        //bordes
        styleT.setBorderTop (BorderStyle.MEDIUM);
        styleT.setBorderBottom (BorderStyle.MEDIUM);
        styleT.setBorderLeft (BorderStyle.MEDIUM);
        styleT.setBorderRight (BorderStyle.MEDIUM);
        
             
        
        //estilo de fuente encabezado
        fuente.setFontHeightInPoints((short) 15);
        fuente.setColor(IndexedColors.BLACK.getIndex());
        fuente.setBold(true);
       
        //estilo encabezado
        //color
        styleE.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        styleE.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        //asignar a estilo la fuente
        styleE.setFont(fuente);
        //bordes
        styleE.setBorderTop (BorderStyle.MEDIUM);
        styleE.setBorderBottom (BorderStyle.MEDIUM);
        styleE.setBorderLeft (BorderStyle.MEDIUM);
        styleE.setBorderRight (BorderStyle.MEDIUM);
        //estilo cuerpo
        //bordes
        styleC.setBorderTop (BorderStyle.MEDIUM);
        styleC.setBorderBottom (BorderStyle.MEDIUM);
        styleC.setBorderLeft (BorderStyle.MEDIUM);
        styleC.setBorderRight (BorderStyle.MEDIUM);
        styleC2.setBorderTop (BorderStyle.MEDIUM);
        styleC2.setBorderBottom (BorderStyle.MEDIUM);
        styleC2.setBorderLeft (BorderStyle.MEDIUM);
        styleC2.setBorderRight (BorderStyle.MEDIUM);
        //color
        styleC.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        styleC2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        styleC.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());  
        styleC2.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex()); 
        //oddRowStyle  = createStyle(contentFont, XSSFCellStyle.ALIGN_LEFT,   XXSSFColor.GREY_25_PERCENT.index, true, XSSFColor.GREY_80_PERCENT.index);

        
        XSSFCell celdaE = null;
        XSSFCell celdaC = null;
        
        
        XSSFRow fila = hoja.createRow(2);
        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
            
            fila.createCell(i).setCellValue(tabla.getColumnName(i));
            //cambiar celdas con variable del diseno
            celdaE = fila.createCell(i);
            celdaE.setCellValue(tabla.getColumnName(i));
            celdaE.setCellStyle(styleE);  
            
        }

        XSSFRow filas;
        Rectangle rect;
        
        for (int i = 0; i < tabla.getRowCount(); i++) {
            
       
            rect = tabla.getCellRect(i, 0, true);
            
            try {
                tabla.scrollRectToVisible(rect);
                tabla.setRowSelectionInterval(i, i);

                filas = hoja.createRow((i + 3));
                for (int e = 0; e < tabla.getColumnModel().getColumnCount(); e++) {

                    filas.createCell(e).setCellValue(tabla.getValueAt(i, e).toString());  
                    //autozise
                    hoja.autoSizeColumn(e);  
                    //cambiar celdas con variable del diseno
                    celdaE = filas.createCell(e);
                    celdaE.setCellValue(tabla.getValueAt(i, e).toString());
                    celdaE.setCellStyle(styleC);
                    /*if(i %  2 == 0){
                    celdaE.setCellStyle(styleC);
                    }else{
                    celdaE.setCellStyle(styleC2);
                    }*/
                    celdaE.setCellStyle( i  % 2 == 0 ? styleC2 : styleC );
                   
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

