/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.VentanaBuscar;
import clases.conecbd;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeferzon
 */
public class pedido_ventas extends javax.swing.JDialog {

    conecbd con;
    ResultSet rs, rs1, rs2, rs3;
    int ban = 0;
    String empleado = "", fecha_pedido = "", subtotal = "0";
    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
    String strfecha = "";
    Date fecha;

    /**
     * Creates new form pedido_ventas
     */
    public pedido_ventas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pack();
        con = new conecbd();
        con.conectar();
        empleado = "1";
        //empleado = acceso.obtenerEmpleado();
        String campos[] = new String[]{"Codigo", "Descripción", "Cantidad", "Precio", "Subtotal", "Deposito"};
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        grilla.setModel(modelo);
        vart_cod.setVisible(false);
    }

    public void obtener_fecha() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(vped_fecha.getDate());
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
        fecha_pedido = cal.get(Calendar.YEAR) + "-" + sMes + "-" + sDia;

    }

    public void habilitar(int estado) {
        switch (estado) {
            case 0:
                btnagregar.setEnabled(false);
                btnanular.setEnabled(false);
                btncancelar.setEnabled(true);
                btngrabar.setEnabled(false);
                btnsalir.setEnabled(false);
                break;
            case 1:
                btnagregar.setEnabled(true);
                btnanular.setEnabled(true);
                btncancelar.setEnabled(false);
                btngrabar.setEnabled(false);
                btnsalir.setEnabled(true);
                break;
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
        vped_cod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vcliente = new javax.swing.JTextField();
        vcli_cod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        vempleado = new javax.swing.JTextField();
        vped_fecha = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        vdep_cod = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        vart_descri = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        vart_cod = new javax.swing.JTextField();
        vcant = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grilla = new javax.swing.JTable();
        vtotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        btnanular = new javax.swing.JButton();
        btngrabar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("PEDIDO N°:");

        vped_cod.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        vped_cod.setEnabled(false);
        vped_cod.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("FECHA:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("CLIENTE:");

        vcliente.setEditable(false);
        vcliente.setOpaque(false);
        vcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vclienteKeyPressed(evt);
            }
        });

        vcli_cod.setEnabled(false);
        vcli_cod.setOpaque(false);
        vcli_cod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vcli_codKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("EMPLEADO:");

        vempleado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        vempleado.setEnabled(false);
        vempleado.setOpaque(false);

        vped_fecha.setEnabled(false);
        vped_fecha.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("F3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vempleado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vped_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(vcli_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vped_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(vcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(vped_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(vped_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(vcli_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(vempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        vdep_cod.setEnabled(false);
        vdep_cod.setOpaque(false);
        vdep_cod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vdep_codKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vdep_codKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("DEPOSITO");

        vart_descri.setEnabled(false);
        vart_descri.setOpaque(false);
        vart_descri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vart_descriKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("ARTICULO");

        vart_cod.setEnabled(false);

        vcant.setEnabled(false);
        vcant.setOpaque(false);
        vcant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vcantKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("CANTIDAD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(vdep_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5)))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(vart_descri, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vart_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(vcant, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vdep_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vart_descri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vart_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vcant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
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

        vtotal.setEditable(false);
        vtotal.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        vtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        vtotal.setText("0");
        vtotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnagregar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnagregar.setText("AGREGAR");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnanular.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnanular.setText("ANULAR");
        btnanular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanularActionPerformed(evt);
            }
        });

        btngrabar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btngrabar.setText("GRABAR");
        btngrabar.setEnabled(false);
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.setEnabled(false);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        btnsalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnsalirKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnanular, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnanular, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btngrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vtotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vtotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void llenar_combo() {
        rs = con.listar_datos("select (dep_cod||'-'||dep_descri) as dep from deposito");
        try {
            while (rs.next()) {
                vdep_cod.addItem(rs.getString("dep"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pedido_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        habilitar(0);
        ban = 1;//agregar
        llenar_combo();
        rs1 = con.listar_datos("select coalesce(max(ped_cod),0)+1 as ultimo,"
                + "current_date as fecha from pedido_cabventa");
        rs2 = con.listar_datos("select (emp_nombre||' '||emp_apellido) as nombres "
                + "from empleado where emp_cod=" + empleado);
        try {
            if (rs1.isBeforeFirst()) {
                rs1.next();
                vped_cod.setText(rs1.getString("ultimo"));
                strfecha = rs1.getString("fecha");
                fecha = formatofecha.parse(strfecha);
                vped_fecha.setDate(fecha);
                rs1.close();
                rs2.next();
                vempleado.setText(rs2.getString("nombres"));
                rs2.close();
                vcli_cod.setEnabled(true);
                vcli_cod.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(pedido_ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(pedido_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void vcli_codKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vcli_codKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            JTextField[] resul = new JTextField[3];
            resul[0] = this.vcli_cod;
            resul[2] = this.vcliente;

            VentanaBuscar buscliente = new VentanaBuscar("select cli_cod,cli_ruc,"
                    + "(cli_nombre ||' '||cli_apellido) as cliente,cli_tel,cli_direccion "
                    + "from cliente where (cli_cod||cli_nombre||cli_apellido) ilike ",
                    new String[]{"CODIGO", "CI", "NOMBRES/APELLIDOS", "TELEFONO", "DIRECCION"}, 5, resul);
            buscliente.setTitle("Buscador de CLIENTE");
            buscliente.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!vcli_cod.getText().equals("")) {
                vdep_cod.setEnabled(true);
                vdep_cod.requestFocus();
            } else {
                vcliente.setText("Seleccione con la tecla F3 un cliente para continuar...");
                vcli_cod.setText("");
                vcli_cod.requestFocus();
            }
        }
    }//GEN-LAST:event_vcli_codKeyPressed

    private void vdep_codKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vdep_codKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vart_descri.setEnabled(true);
            vart_descri.requestFocus();
        }
    }//GEN-LAST:event_vdep_codKeyPressed

    private void vart_descriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vart_descriKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            JTextField[] resul = new JTextField[3];

            resul[0] = this.vart_cod;
            resul[1] = this.vart_descri;

            VentanaBuscar busart = new VentanaBuscar("select a.art_cod,(b.art_descri||' '||c.mar_descri)as producto,"
                    + "b.art_preciov,a.stoc_cant "
                    + "from stock a "
                    + "join articulo b on a.art_cod = b.art_cod "
                    + "join marca c on b.mar_cod = c.mar_cod "
                    + "and dep_cod = split_part('" + vdep_cod.getSelectedItem() + "','-',1)::integer and (a.art_cod||b.art_descri||c.mar_descri) ilike ",
                    new String[]{"CODIGO", "DESCRIPCION", "PRECIO VENTA", "EXISTENCIA"}, 4, resul);
            busart.setTitle("Buscador Articulo");
            busart.setVisible(true);

        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!vart_cod.getText().trim().equals("")) {
                vcant.setEnabled(true);
                vcant.requestFocus();
            } else {
                vart_descri.setText("Seleccione con la tecla F3 un articulo para continuar");
                vart_descri.selectAll();
                vart_descri.requestFocus();
            }
        }
    }//GEN-LAST:event_vart_descriKeyPressed
    public void total_pedido() {
        subtotal = "0";
        if (grilla.getRowCount() == 0) {
            btngrabar.setEnabled(false);
            vtotal.setText("0");
        } else {
            for (int i = 0; i < grilla.getRowCount(); i++) {
                subtotal = String.valueOf(Integer.parseInt(subtotal)
                        + Integer.parseInt((String) grilla.getValueAt(i, 4)));
                vtotal.setText(subtotal);
                btngrabar.setEnabled(true);
            }
        }
    }
    private void vcantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vcantKeyPressed
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) grilla.getModel();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!vcant.getText().trim().equals("")) {
                if (Integer.parseInt(vcant.getText().trim()) > 0) {
                    rs2 = con.listar_datos("select * from v_articulo where art_cod=" + vart_cod.getText());
                    try {
                        if (rs2.isBeforeFirst()) {
                            if (grilla.getRowCount() == 0) {
                                //esta vacio
                                rs2.next();
                                String[] datosdetalle = new String[]{rs2.getString("art_cod"),
                                    rs2.getString("art_descri") + " " + rs2.getString("mar_descri"),
                                    vcant.getText(), rs2.getString("art_preciov"),
                                    String.valueOf(Integer.parseInt(vcant.getText())
                                    * Integer.parseInt(rs2.getString("art_preciov"))),
                                    vdep_cod.getSelectedItem().toString()};
                                modelo.addRow(datosdetalle);
                                rs2.close();
                                total_pedido();
                                btnagregar.setEnabled(true);
                            } else {
                                //validar si existe el detalle
                                int lugar = 0;
                                String valor = "";
                                boolean encontro = false;
                                for (int i = 0; i < grilla.getRowCount(); i++) {
                                    if (vart_cod.getText().trim().equals(grilla.getValueAt(i, 0))
                                            && vdep_cod.getSelectedItem().toString().equals(grilla.getValueAt(i, 5))) {
                                        lugar = i;
                                        valor = String.valueOf(grilla.getValueAt(i, 2));
                                        encontro = true;
                                    }
                                }
                                if (encontro) {
                                    modelo.removeRow(lugar);
                                    rs2.next();
                                    String[] datosdetalle = new String[]{rs2.getString("art_cod"),
                                        rs2.getString("art_descri") + " " + rs2.getString("mar_descri"),
                                        String.valueOf(Integer.parseInt(vcant.getText())+Integer.parseInt(valor))
                                            , rs2.getString("art_preciov"),
                                        String.valueOf(Integer.parseInt(vcant.getText())
                                        * Integer.parseInt(rs2.getString("art_preciov"))),
                                        vdep_cod.getSelectedItem().toString()};
                                    modelo.addRow(datosdetalle);
                                    rs2.close();
                                    total_pedido();
                                } else {
                                    rs2.next();
                                    String[] datosdetalle = new String[]{rs2.getString("art_cod"),
                                        rs2.getString("art_descri") + " " + rs2.getString("mar_descri"),
                                        vcant.getText(), rs2.getString("art_preciov"),
                                        String.valueOf(Integer.parseInt(vcant.getText())
                                        * Integer.parseInt(rs2.getString("art_preciov"))),
                                        vdep_cod.getSelectedItem().toString()};
                                    modelo.addRow(datosdetalle);
                                    rs2.close();
                                    total_pedido();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontraron registros coincidentes", "Atención", JOptionPane.INFORMATION_MESSAGE);
                            vcant.setText("");
                            vcant.requestFocus();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(pedido_ventas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Este campo debe ser mayor a cero", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    vcant.setText("");
                    vcant.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este campo no puede estar vacio", "Atención", JOptionPane.INFORMATION_MESSAGE);
                vcant.setText("");
                vcant.requestFocus();
            }
            vart_descri.setText("");
            vart_cod.setText("");
            vcant.setText("");
            vdep_cod.requestFocus();
        }
    }//GEN-LAST:event_vcantKeyPressed

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(null,"Desea grabar el pedido de venta?","Atención",JOptionPane.YES_NO_OPTION);
        if (mensaje==JOptionPane.YES_OPTION) {
            if (ban==1) {
                obtener_fecha();
                con.insertar_datos("pedido_cabventa", "ped_cod, ped_fecha, emp_cod, cli_cod, estado",
                        vped_cod.getText()+",'"+fecha_pedido+"',"+empleado+","+vcli_cod.getText()+",'P'", 0);
                for (int i = 0; i < grilla.getRowCount(); i++) {
                    con.insertar_datos("detalle_pedventa", "ped_cod, dep_cod, art_cod, ped_cant, ped_precio",
                            vped_cod.getText()+",split_part('"+grilla.getValueAt(i, 5)+"','-',1)::integer,"
                             +grilla.getValueAt(i, 0)+","+grilla.getValueAt(i, 2)+","+grilla.getValueAt(i, 3),1);
                }
                btncancelar.doClick();
            }
        }else{
            btncancelar.doClick();
        }
    }//GEN-LAST:event_btngrabarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        habilitar(1);
        ban =0;
        vped_cod.setText("");
        vped_cod.setEnabled(false);
        vcli_cod.setText("");
        vcli_cod.setEnabled(false);
        vcliente.setText("");
        vcliente.setEditable(false);
        vempleado.setText("");
        vempleado.setEnabled(false);
        vdep_cod.removeAllItems();
        vdep_cod.setEnabled(false);
        vart_cod.setText("");
        vart_cod.setEnabled(false);
        vart_descri.setText("");
        vart_descri.setEnabled(false);
        vcant.setText("");
        vcant.setEnabled(false);
        vtotal.setText("0");
        for (int i = grilla.getRowCount()-1; i >= 0; i--) {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) grilla.getModel();
            modelo.removeRow(i);
        }
    }//GEN-LAST:event_btncancelarActionPerformed

    private void vclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vclienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_vclienteKeyPressed

    private void vdep_codKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vdep_codKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_vdep_codKeyReleased

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
    dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnsalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnsalirKeyPressed
        dispose();
    
   
    }//GEN-LAST:event_btnsalirKeyPressed

    private void btnanularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanularActionPerformed
        dispose();
        new gestion_pedidos(null, false).setVisible(true);       
    }//GEN-LAST:event_btnanularActionPerformed

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
            java.util.logging.Logger.getLogger(pedido_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pedido_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pedido_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pedido_ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pedido_ventas dialog = new pedido_ventas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnanular;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btngrabar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JTable grilla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField vart_cod;
    private javax.swing.JTextField vart_descri;
    private javax.swing.JTextField vcant;
    private javax.swing.JTextField vcli_cod;
    private javax.swing.JTextField vcliente;
    private javax.swing.JComboBox<String> vdep_cod;
    private javax.swing.JTextField vempleado;
    private javax.swing.JTextField vped_cod;
    private com.toedter.calendar.JDateChooser vped_fecha;
    private javax.swing.JTextField vtotal;
    // End of variables declaration//GEN-END:variables
}
