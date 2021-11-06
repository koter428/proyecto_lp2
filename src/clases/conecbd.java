//Clase de Conexion y metedos ABM y Consultas
package clases;

import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Antonio Portillo
 */
public class conecbd {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    String serv = "localhost";
    String db = "lp2";
    String user = "postgres";
    String clave = "admin";
    String local;
    String puerto;

    public Connection conectar() {
        try {

            //Class.forName("com.mysql.jdbc.Driver"); //para mysql
            //con = DriverManager.getConnection("jdbc:mysql://" + serv + "/" + db, user, clave);//para mysql
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://" + serv + "/" + db, user, clave);

        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return con;
    }

    public ResultSet listar_datos(String consulta) {
        try {
            stmt = con.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            rs = stmt.executeQuery(consulta);
        } catch (Exception ex) {
            System.out.println(consulta);
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
    }

    public void insertar_datos(String tabla, String campos, String valores, int mensaje) {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("insert into " + tabla + " (" + campos + ") values(" + valores + ")");

            switch (mensaje) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Se ha grabado exitosamente", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1:
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Se ha grabado exitosamente", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("insert into " + tabla + " (" + campos + ") values(" + valores + ")");
            JOptionPane.showMessageDialog(null, "Error en la operaci�n", "ATENCION", JOptionPane.WARNING_MESSAGE);
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void actualizar_datos(String tabla, String camposAct, String codigo) {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("update " + tabla + " set " + camposAct + " where " + codigo);
            JOptionPane.showMessageDialog(null, "Se ha actualizado", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            System.out.println("update " + tabla + " set " + camposAct + " where " + codigo);
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la operaci�n", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void BorrarDatos(String tabla, String campoCodigo, String codigo) {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("delete from " + tabla + " where " + campoCodigo + "=" + codigo);
            JOptionPane.showMessageDialog(null, "Se ha borrado exitosamente", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("delete from " + tabla + " where " + campoCodigo + "=" + codigo);
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la operaci�n", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }
    }
    public boolean busqueda(String query) {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }
    public void cargarCombo(String sql, JComboBox combo) {
        ResultSet rs = null;
        int contar = 0;
        try {
            Statement s = con.createStatement();
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String columnas[] = new String[2];
                columnas[0] = rs.getString(1);
                columnas[1] = rs.getString(2);
                combo.addItem(columnas);
                System.out.println(rs.getString(1) + "-" + rs.getString(2));
                contar++;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error: " + e.toString(), "Atencion",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (contar > 0) {
            combo.setRenderer(new DefaultListCellRenderer() {

                public java.awt.Component getListCellRendererComponent(
                        JList l, Object o, int i, boolean s, boolean f) {
                    try {
                        return new JLabel(((String[]) o)[1]);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ocurrio Un error", "Atencion",
                                JOptionPane.INFORMATION_MESSAGE);
                        return null;
                    }
                }
            });
        }
        return;
    }
    public void generarreporte(String nombre) {

        HashMap parameters = new HashMap();


        try{
            URL urlMaestro = getClass().getClassLoader().getResource("reportes/"+nombre+".jasper");
            // Cargamos el reporte
            JasperReport masterReport = null;
            masterReport = (JasperReport) JRLoader.loadObject(urlMaestro);
            JasperPrint masterPrint = null;
            masterPrint = JasperFillManager.fillReport(masterReport, parameters,con);

            JasperViewer ventana = new JasperViewer(masterPrint,false);
            ventana.setTitle("Vista Previa");
            ventana.setVisible(true);

        }catch(JRException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio un error "+e.toString(),"ATENCION "
                    , JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //
    public String obtener_fecha(java.util.Date fecha) {
        String str = null;
        if (fecha != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(fecha);
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int mes = cal.get(Calendar.MONTH) + 1;
            String sDia = "";
            String sMes = "";
            if (dia < 10) {
                sDia = "0";
            }
            sDia += dia;
            if (mes < 10) {
                sMes = "0";
            }
            sMes += mes;
            //String fecha1 = sDia + "/" + sMes + "/" + cal.get(Calendar.YEAR);
            str = cal.get(Calendar.YEAR) + "-" + sMes + "-" + sDia;
        }
        return str;

    }

 /** Cierra la conexion con la base de datos */
    public void cierraConexion()
    {
        try
        {
            con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}