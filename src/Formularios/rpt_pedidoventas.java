/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.conectbd;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jeferzon
 */
public class rpt_pedidoventas extends javax.swing.JDialog {
    conectbd con;
    ResultSet rs;
    boolean reporte = false;
    /**
     * Creates new form NewJDialog
     */
    public rpt_pedidoventas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        con = new conectbd();
        con.conectar();
        con.cargarCombo("select a.art_cod, a.art_descri from articulo a", varticulo);
        con.cargarCombo("select b.emp_cod, (b.emp_nombre||' '||b.emp_apellido) AS empleado "
                + "from empleado b", vempleado);
        con.cargarCombo("select c.cli_cod, (cli_nombre||' '||c.cli_apellido) AS clientes "
                + "from clientes c", vcliente);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoopciones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        opc1 = new javax.swing.JRadioButton();
        opc2 = new javax.swing.JRadioButton();
        opc3 = new javax.swing.JRadioButton();
        opc4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        vdesde = new com.toedter.calendar.JDateChooser();
        vhasta = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        vempleado = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        vcliente = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        varticulo = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnimprimir = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        grupoopciones.add(opc1);
        opc1.setText("Por Fecha");
        opc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opc1ActionPerformed(evt);
            }
        });

        grupoopciones.add(opc2);
        opc2.setText("Por Empleado");
        opc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opc2ActionPerformed(evt);
            }
        });

        grupoopciones.add(opc3);
        opc3.setText("Por Cliente");
        opc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opc3ActionPerformed(evt);
            }
        });

        grupoopciones.add(opc4);
        opc4.setText("Por Articulo");
        opc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opc4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opc2)
                    .addComponent(opc3)
                    .addComponent(opc4)
                    .addComponent(opc1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opc1)
                .addGap(18, 18, 18)
                .addComponent(opc2)
                .addGap(18, 18, 18)
                .addComponent(opc3)
                .addGap(18, 18, 18)
                .addComponent(opc4)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REPORTE DE PEDIDOS");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Por Fecha"));

        vdesde.setBorder(javax.swing.BorderFactory.createTitledBorder("Desde"));
        vdesde.setEnabled(false);

        vhasta.setBorder(javax.swing.BorderFactory.createTitledBorder("Hasta"));
        vhasta.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(vdesde, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vhasta, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vdesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vhasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Por Empleado"));

        vempleado.setEnabled(false);
        vempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vempleadoActionPerformed(evt);
            }
        });
        vempleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vempleadoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(vempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Por Cliente"));

        vcliente.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(vcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Por Articulo"));

        varticulo.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(varticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(varticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/Gris&GlowV1.5 Icon 20-002.png"))); // NOI18N
        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/exit.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnimprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnimprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void opc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opc4ActionPerformed
        varticulo.setEnabled(true);
        varticulo.requestFocus();
        vdesde.setEnabled(false);
        vhasta.setEnabled(false);
        vempleado.setEnabled(false);
        vcliente.setEnabled(false);
    }//GEN-LAST:event_opc4ActionPerformed

    private void vempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vempleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vempleadoActionPerformed

    private void opc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opc1ActionPerformed
        vdesde.setEnabled(true);
        vhasta.setEnabled(true);
        vdesde.requestFocus();
        vempleado.setEnabled(false);
        vcliente.setEnabled(false);
        varticulo.setEnabled(false);
    }//GEN-LAST:event_opc1ActionPerformed

    private void opc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opc2ActionPerformed
        vempleado.setEnabled(true);
        vempleado.requestFocus();
        vdesde.setEnabled(false);
        vhasta.setEnabled(false);
        vcliente.setEnabled(false);
        varticulo.setEnabled(false);
    }//GEN-LAST:event_opc2ActionPerformed

    private void opc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opc3ActionPerformed
        vcliente.setEnabled(true);
        vcliente.requestFocus();
        vdesde.setEnabled(false);
        vhasta.setEnabled(false);
        vempleado.setEnabled(false);
        varticulo.setEnabled(false);
    }//GEN-LAST:event_opc3ActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        if (opc1.isSelected()) {
//se compara si la fechadesde es mayor que la fecha hasta
            if (con.obtener_fecha(vdesde.getDate()).compareTo(con.obtener_fecha(vhasta.getDate())) > 0) {
                //se emite un mensaje de validacion
                JOptionPane.showMessageDialog(null, "Desde fecha no puede ser mayor que Hasta Fecha", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
                reporte=false;

            } else {
                //se realiza la consulta comparando la fecha desde con la fecha hasta
                // para ello se utiliza el BETWEEN que permite la selecci�n de un rango
                rs = con.listar_datos("select * from vpedidos where (ped_fecha)::date "
                        + "BETWEEN '" + con.obtener_fecha(vdesde.getDate())
                        + "' and '" + con.obtener_fecha(vhasta.getDate()) + "'");
                try {
                    if (rs.isBeforeFirst()) {
                        reporte = true;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(rpt_pedidoventas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (opc2.isSelected()) {
            rs = con.listar_datos("select * from vpedidos "
                    + "where emp_cod=" + (((String[]) vempleado.getSelectedItem())[0]));
            try {
                if (rs.isBeforeFirst()) {
                    reporte = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(rpt_pedidoventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (opc3.isSelected()) {
            rs = con.listar_datos("select * from vpedidos "
                    + "where cli_cod=" + (((String[]) vcliente.getSelectedItem())[0]));
            try {
                if (rs.isBeforeFirst()) {
                    reporte = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(rpt_pedidoventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (opc4.isSelected()) {
            rs = con.listar_datos("select * from vpedidos "
                    + "where art_cod=" + (((String[]) varticulo.getSelectedItem())[0]));
            try {
                if (rs.isBeforeFirst()) {
                    reporte = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(rpt_pedidoventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//llamamos al reporte
        try {
            if (reporte) {
                //envia parametros
                Map parameters = new HashMap();
                //parametros vacio
                parameters.put("", new String(""));
                //se tira null
                JasperReport jr = null;
                //se coloca la ruta de nuestro reporte
                URL url = getClass().getClassLoader().getResource("reportes/pedidos.jasper");
                jr = (JasperReport) JRLoader.loadObject(url);
                //imprime en pantalla
                JasperPrint masterPrint = null;
                //conecta con la base de datos
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                masterPrint = JasperFillManager.fillReport(jr, parameters, jrRS);
                //muestra el reporte
                JasperViewer ventana = new JasperViewer(masterPrint, false);
                ventana.setTitle("Vista Previa");
                ventana.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "No se encontraron registros con el filtro indicado"
                        ,"Atencion",JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            Logger.getLogger(rpt_pedidoventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void vempleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vempleadoKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            btnimprimir.setEnabled(true);
            btnimprimir.requestFocus();
        }
    }//GEN-LAST:event_vempleadoKeyPressed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnsalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(rpt_pedidoventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rpt_pedidoventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rpt_pedidoventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rpt_pedidoventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                rpt_pedidoventas dialog = new rpt_pedidoventas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnsalir;
    private javax.swing.ButtonGroup grupoopciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton opc1;
    private javax.swing.JRadioButton opc2;
    private javax.swing.JRadioButton opc3;
    private javax.swing.JRadioButton opc4;
    private javax.swing.JComboBox<String> varticulo;
    private javax.swing.JComboBox<String> vcliente;
    private com.toedter.calendar.JDateChooser vdesde;
    private javax.swing.JComboBox<String> vempleado;
    private com.toedter.calendar.JDateChooser vhasta;
    // End of variables declaration//GEN-END:variables
}
