/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author hfons
 */
public class Helpers {

    /**
     * Dar formato a las celdas de cualquier JTable
     * @param tabla 
     */
    public void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);
    }

    /**
     * Convierte de util.date a sql.date
     *
     * @param date
     * @return
     */
    public java.sql.Date convertDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * Obtener fecha actual de la maquina
     * @return @throws ParseException
     */
    public Date fechaActual() throws ParseException {
        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = Calendar.getInstance(TimeZone.getDefault());

        String dia = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(fecha.get(Calendar.MONTH) + 1);
        String año = String.valueOf(fecha.get(Calendar.YEAR));

        String fechaActual = dia + "/" + mes + "/" + año;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); // New Pattern
        java.util.Date date = format.parse(fechaActual); // Returns a Date format object with the pattern
        java.sql.Date sqlfechaActual = new java.sql.Date(date.getTime());

        return sqlfechaActual;
    }

    /**
     * Obtner hora actual de la maquina
     * @return
     * @throws ParseException 
     */
    public Date horaActual() throws ParseException {
        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = Calendar.getInstance();
        String hora = String.valueOf(fecha.get(Calendar.HOUR_OF_DAY));
        String minuto = String.valueOf(fecha.get(Calendar.MINUTE));

        String horaActual = hora + ":" + minuto;

        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault()); // New Pattern
        java.util.Date date = format.parse(horaActual); // Returns a Date format object with the pattern
        java.sql.Date sqlhoraActual = new java.sql.Date(date.getTime());

        return sqlhoraActual;
    }

    /**
     * Exportar data de un JTable a un archivo excel
     *
     * @param t
     * @param sheetName
     * @throws IOException
     */
   /* public void exportarExcel(JTable t, String sheetName) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet(sheetName);
                hoja.setDisplayGridlines(false);
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }

    /**
     * Abrir cualquier archivo externo
     * @param url
     */
  /*  public void abrirArchivo(String url) {
        try {
            String filePath = new File(url).getAbsolutePath();
            File path = new File(filePath);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
        }
    }
*/
}