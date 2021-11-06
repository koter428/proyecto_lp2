/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.conecbd;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
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
public class gestion_ventas extends javax.swing.JDialog {

    conecbd con;
    ResultSet rs, rs1, rs2, rs3, rs4, rs5;
    String ultimo = "", dato = "", total = "", letra = "";
    private int l, filsel;

    /**
     * Creates new form gestion_pedidos
     */
    public gestion_ventas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pack();
        con = new conecbd();
        con.conectar();

        String camposcab[] = new String[]{"Venta Nro.", "Fecha", "Total Venta", "Estado"};
        String camposdet[] = new String[]{"Codigo", "Descripción", "Cantidad", "Precio", "Subtotal","IVA"};
        DefaultTableModel modelocab = new DefaultTableModel(null, camposcab);
        DefaultTableModel modelodet = new DefaultTableModel(null, camposdet);
        grilla_cab.setModel(modelocab);
        grilla_det.setModel(modelodet);
        llenar_grilla();
    }

    public void llenar_grilla() {
        rs = con.listar_datos("select * from vven_cab order by ven_cod");
        rs1 = con.listar_datos("select max(ven_cod) as maximo,count(*) as cant from ventas");

        DefaultTableModel modelocab = (DefaultTableModel) grilla_cab.getModel();
        try {
            while (rs.next()) {
                String datoscab[] = new String[]{rs.getString("ven_cod"), rs.getString("ven_fecha"), rs.getString("ven_total"),
                    rs.getString("ven_estado")};
                modelocab.addRow(datoscab);
            }
            rs1.next();
            ultimo = rs1.getString("maximo");
            filsel = Integer.parseInt(rs1.getString("cant")) - 1;
            rs1.close();
            rs2 = con.listar_datos("select * from ventas_det where ven_cod=" + ultimo);
            DefaultTableModel modelodet = (DefaultTableModel) grilla_det.getModel();
            while (rs2.next()) {
                String[] datosdet = new String[]{rs2.getString("art_cod"), rs2.getString("art_descri") + " " + rs2.getString("mar_descri"),
                    rs2.getString("ven_cant"), rs2.getString("ven_precio"), rs2.getString("subtotal"), rs2.getString("tipo_descri")};
                modelodet.addRow(datosdet);
            }
            grilla_cab.changeSelection(filsel, 0, true, false);
            llenar_det();
        } catch (SQLException ex) {
            Logger.getLogger(gestion_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenar_det() {
        DefaultTableModel modelodet = (DefaultTableModel) grilla_det.getModel();
        for (int i = grilla_det.getRowCount() - 1; i >= 0; i--) {
            modelodet.removeRow(i);
        }
        l = grilla_cab.getSelectedRow();
        dato = String.valueOf(this.grilla_cab.getValueAt(l, 0));
        rs4 = con.listar_datos("select * from vven_cab where ven_cod =" + dato);
        rs5 = con.listar_datos("select * from ventas_det where ven_cod=" + dato);

        try {
            rs4.next();
            vempleado.setText(rs4.getString("empleado"));
            vcliente.setText(rs4.getString("cliente"));
            vfecha.setText(rs4.getString("ven_fecha"));
            vestado.setText(rs4.getString("ven_estado"));
            rs4.close();
            while (rs5.next()) {
                String[] datosdet = new String[]{rs5.getString("art_cod"), rs5.getString("art_descri") + " " + rs5.getString("mar_descri"),
                    rs5.getString("ven_cant"), rs5.getString("ven_precio"), rs5.getString("subtotal"), rs5.getString("tipo_descri")};
                modelodet.addRow(datosdet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(gestion_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        vempleado = new javax.swing.JTextField();
        vcliente = new javax.swing.JTextField();
        vestado = new javax.swing.JTextField();
        vfecha = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnanular = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();
        btnanular2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        grilla_cab = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        grilla_det = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        vempleado.setEditable(false);
        vempleado.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleado"));

        vcliente.setEditable(false);
        vcliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente o Razón Social"));

        vestado.setEditable(false);
        vestado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado del Pedido"));

        vfecha.setEditable(false);
        vfecha.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vestado, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnanular.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnanular.setText("Anular");
        btnanular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanularActionPerformed(evt);
            }
        });

        btnimprimir.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        btnanular2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnanular2.setText("Salir");
        btnanular2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanular2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnanular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnimprimir)
                .addGap(18, 18, 18)
                .addComponent(btnanular2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnimprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(btnanular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnanular2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        grilla_cab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        grilla_cab.setSelectionBackground(new java.awt.Color(204, 204, 0));
        grilla_cab.setSelectionForeground(new java.awt.Color(0, 0, 0));
        grilla_cab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grilla_cabMouseClicked(evt);
            }
        });
        grilla_cab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                grilla_cabKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(grilla_cab);

        grilla_det.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(grilla_det);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(552, 552, 552)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void grilla_cabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grilla_cabMouseClicked
        llenar_det();
    }//GEN-LAST:event_grilla_cabMouseClicked

    private void grilla_cabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grilla_cabKeyPressed
        llenar_det();
    }//GEN-LAST:event_grilla_cabKeyPressed

    private void btnanular2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanular2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnanular2ActionPerformed

    private void btnanularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanularActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(null, "Desea anular la venta N°" + dato, "Atención", JOptionPane.YES_OPTION);
        if (mensaje == JOptionPane.YES_OPTION) {
            con.actualizar_datos("ventas", "ven_estado = 'A'", "ven_cod=" + dato);
            DefaultTableModel modelocab = (DefaultTableModel) grilla_cab.getModel();
            DefaultTableModel modelodet = (DefaultTableModel) grilla_det.getModel();
            for (int i = grilla_cab.getRowCount() - 1; i >= 0; i--) {
                modelocab.removeRow(i);
            }
            for (int i = grilla_det.getRowCount() - 1; i >= 0; i--) {
                modelodet.removeRow(i);
            }            
            llenar_grilla();
        }
    }//GEN-LAST:event_btnanularActionPerformed
public void generarreporte() {
        
        HashMap parameters = new HashMap();
        Integer vencod = Integer.valueOf(dato);
        parameters.put("vven_cod", vencod);

        try{
            URL urlMaestro = getClass().getClassLoader().getResource("reportes/venta.jasper");
            // Cargamos el reporte
            JasperReport masterReport = null;
            masterReport = (JasperReport) JRLoader.loadObject(urlMaestro);
            JasperPrint masterPrint = null;
            masterPrint = JasperFillManager.fillReport(masterReport, parameters,con.conectar());

            JasperViewer ventana = new JasperViewer(masterPrint,false);
            ventana.setTitle("Vista Previa");
            ventana.setVisible(true);

        }catch(JRException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio un error "+e.toString(),"ATENCION "
                    , JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
generarreporte();
    }//GEN-LAST:event_btnimprimirActionPerformed

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
            java.util.logging.Logger.getLogger(gestion_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestion_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestion_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestion_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gestion_ventas dialog = new gestion_ventas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnanular;
    private javax.swing.JButton btnanular2;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JTable grilla_cab;
    private javax.swing.JTable grilla_det;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField vcliente;
    private javax.swing.JTextField vempleado;
    private javax.swing.JTextField vestado;
    private javax.swing.JTextField vfecha;
    // End of variables declaration//GEN-END:variables
}
