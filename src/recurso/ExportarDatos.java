package recurso;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author david
 */
public class ExportarDatos {

    private static final Logger LOGGER = Logger.getLogger("mx.com.hash.newexcel.ExcelOOXML");

    public void ExportarInformacion() throws ClassNotFoundException{
        
        
        String driver="com.mysql.cj.jdbc.Driver";
        String db="soportesdb";
        String usr="";
        String pass="";
        String url="jdbc:mysql://localhost/"+db;
        ResultSet rs=null;
        List<List<String>> l = new ArrayList<List<String>>();
        int aux=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion=DriverManager.getConnection(url,"root","");
            Statement st=conexion.createStatement();
            rs=st.executeQuery("select TecIdentificacion,TecNombres,TecApellidos,descripcionSoporte,soporteFecha from soportes inner join tecnicos on TecIdentificacion=tecnologoSoporteFK");
            while (rs.next()) {
                l.add(new ArrayList<String>());
                l.get(aux).add(rs.getString("TecIdentificacion"));
                l.get(aux).add(rs.getString("TecNombres"));
                l.get(aux).add(rs.getString("TecApellidos"));
                l.get(aux).add(rs.getString("descripcionSoporte"));
                l.get(aux).add(rs.getString("soporteFecha"));
                aux++;
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        
        String[] titulos = {"Identificacion tecnico", "Nombres",
            "Apellidos", "Descripcion Soporte","Fecha"};
        
        
        
        // Creamos el archivo donde almacenaremos la hoja
        // de calculo, recuerde usar la extension correcta,
        // en este caso .xlsx
        
        Calendar fec=new GregorianCalendar();
        int y=fec.get(Calendar.YEAR);
        int d=fec.get(Calendar.DAY_OF_MONTH);
        int m=fec.get(Calendar.MONTH);
        //String nom=System.getProperty("user.home")+"/Documentos/"+"reporteGestionSoportes"+d+"-"+m+"-"+y+".xlsx";
        String nom="D:\\julian\\proyectoJava\\"+"reporteGestionSoportes"+d+"-"+m+"-"+y+".xlsx";
        File archivo = new File(nom);

        // Creamos el libro de trabajo de Excel formato OOXML
        Workbook workbook = new XSSFWorkbook();

        // La hoja donde pondremos los datos
        Sheet pagina = workbook.createSheet("Reporte de productos");

        // Creamos el estilo paga las celdas del encabezado
        CellStyle style = workbook.createCellStyle();
        // Indicamos que tendra un fondo azul aqua
        // con patron solido del color indicado
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Creamos una fila en la hoja en la posicion 0
        Row fila = pagina.createRow(0);

        // Creamos el encabezado
        for (int i = 0; i < titulos.length; i++) {
            // Creamos una celda en esa fila, en la posicion 
            // indicada por el contador del ciclo
            Cell celda = fila.createCell(i);

            // Indicamos el estilo que deseamos 
            // usar en la celda, en este caso el unico 
            // que hemos creado
            celda.setCellStyle(style);
            celda.setCellValue(titulos[i]);
        }
        int a=1;
        // Ahora creamos una fila en la posicion 1

        // Y colocamos los datos en esa fila
        
        Cell celda = fila.createCell(5);
        fila=pagina.createRow(1);
        for (int i = 0; i < l.size(); i++) {
            a=a+1;
            // Creamos una celda en esa fila, en la
            // posicion indicada por el contador del ciclo
            celda = fila.createCell(0);
            celda.setCellValue(l.get(i).get(0));
            celda = fila.createCell(1);
            celda.setCellValue(l.get(i).get(1));
            celda = fila.createCell(2);
            celda.setCellValue(l.get(i).get(2));
            celda = fila.createCell(3);
            celda.setCellValue(l.get(i).get(3));
            celda = fila.createCell(4);
            celda.setCellValue(l.get(i).get(4));
            fila=pagina.createRow(a);
            
        }

        // Ahora guardaremos el archivo
        try {
            // Creamos el flujo de salida de datos,
            // apuntando al archivo donde queremos 
            // almacenar el libro de Excel
            FileOutputStream salida = new FileOutputStream(archivo);

            // Almacenamos el libro de 
            // Excel via ese 
            // flujo de datos
            workbook.write(salida);

            // Cerramos el libro para concluir operaciones
            workbook.close();

            LOGGER.log(Level.INFO, "Archivo creado existosamente en {0}", archivo.getAbsolutePath());
            JOptionPane.showMessageDialog(null, "Archivo creado exitosamente en: "+nom);

        } catch (FileNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Archivo no localizable en sistema de archivos");
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error de entrada/salida");
        }
    }

}