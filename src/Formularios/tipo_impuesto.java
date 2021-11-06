/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.Lp2;
import clases.VentanaBuscar;
import clases.conectbd;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
public class tipo_impuesto extends javax.swing.JDialog {
    conectbd con;
    ResultSet rs, rs1, rs2;
    int ban = 0;
    /**
     * Creates new form marca
     */
    public tipo_impuesto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        con = new conectbd();
        con.conectar();
        pack();
        llenar_grilla();
    }
    public void habilitar(int estado){
        switch(estado){
            case 0://deshabilitar los botones
                btnagregar.setEnabled(false);
                btneditar.setEnabled(false);
                btneliminar.setEnabled(false);
                btncancelar.setEnabled(true);
                btngrabar.setEnabled(false);
                btnsalir.setEnabled(false);
                btnimprimir.setEnabled(false);
                break;
            case 1: //habilitar los botones
                btnagregar.setEnabled(true);
                btneditar.setEnabled(true);
                btneliminar.setEnabled(true);
                btncancelar.setEnabled(false);
                btngrabar.setEnabled(false);
                btnsalir.setEnabled(true);
                btnimprimir.setEnabled(true);
                break;
            
        }
    }
    public void llenar_grilla(){
        
            String campos[] = new String[]{"CODIGO","DESCRIPCION","PORCENTAJE"};
            DefaultTableModel modelo = new DefaultTableModel(null,campos);
            grilla.setModel(modelo);
            rs1 = con.listar_datos("select * from tipo_impuesto order by tipo_cod");
        try {
            while(rs1.next()){
                String datos[] = new String[]{rs1.getString("tipo_cod"), rs1.getString("tipo_descri"),rs1.getString("tipo_porcen")};
                modelo.addRow(datos);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(tipo_impuesto.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        vtipo_cod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        vtipo_descri = new javax.swing.JTextField();
        btnimprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        vtipo_porcen = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btngrabar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grilla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana de Marca");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Codigo:");

        vtipo_cod.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        vtipo_cod.setEnabled(false);
        vtipo_cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vtipo_codActionPerformed(evt);
            }
        });
        vtipo_cod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vtipo_codKeyPressed(evt);
            }
        });

        jLabel2.setText("Descripcion:");

        vtipo_descri.setEnabled(false);
        vtipo_descri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vtipo_descriKeyPressed(evt);
            }
        });

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/Gris&GlowV1.5 Icon 20-002.png"))); // NOI18N
        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        jLabel3.setText("Porcentaje:");

        vtipo_porcen.setEnabled(false);
        vtipo_porcen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vtipo_porcenKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vtipo_descri, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(vtipo_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vtipo_porcen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(vtipo_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(vtipo_descri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(vtipo_porcen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/File.png"))); // NOI18N
        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/Notepad.png"))); // NOI18N
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/Bin 1 - Empty.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/cancel-24.gif"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setEnabled(false);
        btncancelar.setPreferredSize(new java.awt.Dimension(120, 56));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/exit.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.setPreferredSize(new java.awt.Dimension(120, 56));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btngrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/guardar1.png"))); // NOI18N
        btngrabar.setText("Grabar");
        btngrabar.setEnabled(false);
        btngrabar.setPreferredSize(new java.awt.Dimension(120, 56));
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btngrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        grilla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(grilla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
       
            habilitar(0);//llamo al metodo para deshabilitar los botones
            ban = 1;//agregar
            rs = con.listar_datos("select coalesce(max(tipo_cod),0)+1 as ultimo from tipo_impuesto");
        try {
            rs.next();
            vtipo_cod.setText(rs.getString("ultimo"));
            rs.close();
            vtipo_descri.setEnabled(true);
            vtipo_descri.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(tipo_impuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        habilitar(1);
        ban = 0;
        vtipo_cod.setText("");
        vtipo_cod.setEnabled(false);
        vtipo_descri.setText("");
        vtipo_descri.setEnabled(false);
        vtipo_porcen.setText("");
        vtipo_porcen.setEnabled(false);
        llenar_grilla();
        
        
    }//GEN-LAST:event_btncancelarActionPerformed

    private void vtipo_descriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vtipo_descriKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!vtipo_descri.getText().trim().equals("")){
                vtipo_porcen.setEnabled(true);
                vtipo_porcen.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null,"Este campo no puede estar vacio","Atencion",JOptionPane.INFORMATION_MESSAGE);
                vtipo_descri.setText("");
                vtipo_descri.requestFocus();
            }
        }
    }//GEN-LAST:event_vtipo_descriKeyPressed

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(null, "Desea Grabar los datos del tipo de impuesto?","Atencion", JOptionPane.YES_NO_OPTION);
        
        if(mensaje == 0){
            if(ban == 1){//agregar la accion del usuario
                con.insertar_datos("tipo_impuesto", "tipo_cod, tipo_descri,tipo_porcen", vtipo_cod.getText()+",'"+vtipo_descri.getText()+"',"+vtipo_porcen.getText(),0);
                btncancelar.doClick();
            }
            if(ban == 2){
                con.actualizar_datos("tipo_impuesto","tipo_descri='"+vtipo_descri.getText()+"',tipo_porcen ="+vtipo_porcen.getText(),"tipo_cod="+vtipo_cod.getText());
                btncancelar.doClick();
            }
        }else{
            btncancelar.doClick();
        }
        
    }//GEN-LAST:event_btngrabarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        habilitar(0);
        ban = 2;
        JTextField[] tfParam = new JTextField[3];
        tfParam[0] = this.vtipo_cod;
        tfParam[1] = this.vtipo_descri;
        tfParam[2] = this.vtipo_porcen;
        VentanaBuscar buscar = new VentanaBuscar("select tipo_cod, tipo_descri,tipo_porcen from tipo_impuesto"
                + " where (tipo_cod||''||tipo_descri||''||tipo_porcen) ilike ",
                new String[]{"CODIGO", "DESCRIPCION", "PORCENTAJE"}, 3, tfParam);

        buscar.setTitle("Buscador Tipo Impuesto");
        buscar.setVisible(true);
        vtipo_descri.setEnabled(true);
        vtipo_descri.requestFocus();
    }//GEN-LAST:event_btneditarActionPerformed

    private void vtipo_codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vtipo_codActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vtipo_codActionPerformed

    private void vtipo_codKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vtipo_codKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!vtipo_cod.getText().trim().equals("")){
                if(Integer.parseInt(vtipo_cod.getText().trim())>0){
                    try {
                        rs2 = con.listar_datos("select * from tipo_impuesto where tipo_cod ="+vtipo_cod.getText());
                        if(rs2.isBeforeFirst()){
                            rs2.next();
                            vtipo_descri.setText(rs2.getString("tipo_descri"));
                            vtipo_porcen.setText(rs2.getString("tipo_porcen"));
                            if(ban == 3){
                                int mensaje = JOptionPane.showConfirmDialog(null, "Desea Borrar los datos del tipo de impuesto?", "Atencion",JOptionPane.YES_NO_OPTION);
                                if(mensaje == 0){
                                    con.BorrarDatos("tipo_impuesto", "tipo_cod", vtipo_cod.getText());
                                    btncancelar.doClick();
                                }else{
                                    btncancelar.doClick();
                                }
                                    
                            }else{
                                vtipo_descri.setEnabled(true);
                                vtipo_descri.requestFocus();
                            }
                                
                        }else{
                            JOptionPane.showMessageDialog(null,"No se encontraron datos coincidentes","Atencion",JOptionPane.INFORMATION_MESSAGE);
                            vtipo_cod.setText("");
                            vtipo_cod.requestFocus();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(tipo_impuesto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Este campo debe ser mayor a cero","Atencion",JOptionPane.INFORMATION_MESSAGE);
                    vtipo_cod.setText("");
                    vtipo_cod.requestFocus();
                    
                }
                    
            }else{
                JOptionPane.showMessageDialog(null, "Este campo no puede estar vacio", "Atencion",JOptionPane.INFORMATION_MESSAGE);
                vtipo_cod.setText("");
                vtipo_cod.requestFocus();
            }
                
        }
    }//GEN-LAST:event_vtipo_codKeyPressed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
       habilitar(0);
       ban = 3;
JTextField[] tfParam = new JTextField[3];
        tfParam[0] = this.vtipo_cod;
        tfParam[1] = this.vtipo_descri;
        tfParam[2] = this.vtipo_porcen;
        VentanaBuscar buscar = new VentanaBuscar("select tipo_cod, tipo_descri,tipo_porcen from tipo_impuesto"
                + " where (tipo_cod||''||tipo_descri||''||tipo_porcen) ilike ",
                new String[]{"CODIGO", "DESCRIPCION", "PORCENTAJE"}, 3, tfParam);

        buscar.setTitle("Buscador Tipo Impuesto");
        buscar.setVisible(true);
        if (ban == 3) {
            int mensaje = JOptionPane.showConfirmDialog(null, "Desea Borrar los datos del impuesto?", "Atencion", JOptionPane.YES_NO_OPTION);
            if (mensaje == 0) {
                con.BorrarDatos("tipo_impuesto", "tipo_cod", vtipo_cod.getText());
                btncancelar.doClick();
            } else {
                btncancelar.doClick();
            }
        }
       
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        con.generarreporte("tipo_impuesto");        
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void vtipo_porcenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vtipo_porcenKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!vtipo_porcen.getText().trim().equals("")){
                if(Integer.parseInt(vtipo_porcen.getText())>=0){
                    boolean porcen = Lp2.esnumero(vtipo_porcen.getText());
                    if(porcen){
                        btngrabar.setEnabled(true);
                        btngrabar.requestFocus();
                    }else{
                        JOptionPane.showMessageDialog(null,"Este campo solo puede contener numeros","Atencion",JOptionPane.INFORMATION_MESSAGE);
                        vtipo_porcen.setText("");
                        vtipo_porcen.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Este campo no puede ser menor a cero","Atencion",JOptionPane.INFORMATION_MESSAGE);
                    vtipo_porcen.setText("");
                    vtipo_porcen.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null,"Este Campo no puede quedar vacio","Atencion",JOptionPane.INFORMATION_MESSAGE);
                vtipo_porcen.setText("");
                vtipo_porcen.requestFocus();
            }
            
        }
    }//GEN-LAST:event_vtipo_porcenKeyPressed

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
            java.util.logging.Logger.getLogger(tipo_impuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tipo_impuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tipo_impuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tipo_impuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tipo_impuesto dialog = new tipo_impuesto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btngrabar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnsalir;
    private javax.swing.JTable grilla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField vtipo_cod;
    private javax.swing.JTextField vtipo_descri;
    private javax.swing.JTextField vtipo_porcen;
    // End of variables declaration//GEN-END:variables
}