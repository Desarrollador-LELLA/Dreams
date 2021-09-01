/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import Clases.CArticulos;
import Clases.CCatArticulos;
import ModeloCombox.MCCatArticulos;
import ModelosTablas.MTArticulos;
import ModelosTablas.MTCatArticulos;
import Objetos.OArticulos;
import Objetos.OError;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class PArticulos extends javax.swing.JPanel {

    /**
     * Creates new form PArticulos
     */
    public PArticulos() {
        initComponents();
        ListarArticulos();
        LlenarComboCatArticulos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreArticulo = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        txtStock = new java.awt.TextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodArticulo = new java.awt.TextField();
        CBoxCatArticulo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        butAgregar = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        butEditar = new javax.swing.JButton();
        butDesactivar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableArticulos = new javax.swing.JTable();
        ButCancelar = new javax.swing.JButton();
        jDateChooserFV = new com.toedter.calendar.JDateChooser("dd-MM-yyyy", "##/##/####", '_');

        setPreferredSize(new java.awt.Dimension(1000, 502));

        labTitulo.setBackground(new java.awt.Color(102, 102, 255));
        labTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitulo.setText("Articulos");
        labTitulo.setOpaque(true);

        jLabel1.setText("Nombre Articulo:");

        txtNombreArticulo.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreArticuloActionPerformed(evt);
            }
        });

        jLabel2.setText("Stock:");

        txtStock.setBackground(new java.awt.Color(255, 255, 255));
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        jLabel4.setText("Codigo Articulo:");

        txtCodArticulo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodArticulo.setEditable(false);
        txtCodArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodArticuloActionPerformed(evt);
            }
        });

        CBoxCatArticulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accesorios", "Bebestibles", "Comestibles" }));
        CBoxCatArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBoxCatArticuloActionPerformed(evt);
            }
        });

        jLabel5.setText("Categoria Articulo:");

        jLabel6.setText("Fecha de Vencimiento:");

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        butAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_agregar_32.png"))); // NOI18N
        butAgregar.setText("Agregar");
        butAgregar.setFocusable(false);
        butAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butAgregar.setMaximumSize(new java.awt.Dimension(69, 69));
        butAgregar.setMinimumSize(new java.awt.Dimension(69, 69));
        butAgregar.setName(""); // NOI18N
        butAgregar.setPreferredSize(new java.awt.Dimension(69, 69));
        butAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        butAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAgregarActionPerformed(evt);
            }
        });
        jToolBar1.add(butAgregar);

        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setRollover(true);

        butEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_editar_32.png"))); // NOI18N
        butEditar.setText("Editar");
        butEditar.setFocusable(false);
        butEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butEditar.setMaximumSize(new java.awt.Dimension(69, 69));
        butEditar.setMinimumSize(new java.awt.Dimension(69, 69));
        butEditar.setName(""); // NOI18N
        butEditar.setPreferredSize(new java.awt.Dimension(69, 69));
        butEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        butEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEditarActionPerformed(evt);
            }
        });
        jToolBar2.add(butEditar);

        butDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_desactivar_32.png"))); // NOI18N
        butDesactivar.setText("Desactivar");
        butDesactivar.setFocusable(false);
        butDesactivar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butDesactivar.setMaximumSize(new java.awt.Dimension(69, 69));
        butDesactivar.setMinimumSize(new java.awt.Dimension(69, 69));
        butDesactivar.setName(""); // NOI18N
        butDesactivar.setPreferredSize(new java.awt.Dimension(69, 69));
        butDesactivar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        butDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDesactivarActionPerformed(evt);
            }
        });
        jToolBar2.add(butDesactivar);

        JTableArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Stock", "F. Vencimiento", "Estado", "Categoria"
            }
        ));
        JTableArticulos.setFillsViewportHeight(true);
        JTableArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableArticulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableArticulos);

        ButCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_limpio_24.png"))); // NOI18N
        ButCancelar.setFocusable(false);
        ButCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(14, 14, 14)
                                .addComponent(txtCodArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CBoxCatArticulo, 0, 314, Short.MAX_VALUE)
                            .addComponent(jDateChooserFV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(labTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBoxCatArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jDateChooserFV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(ButCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreArticuloActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtCodArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodArticuloActionPerformed

    private void CBoxCatArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBoxCatArticuloActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CBoxCatArticuloActionPerformed
    
    private void LlenarComboCatArticulos(){
        CBoxCatArticulo.setModel(new MCCatArticulos(new CCatArticulos().Listar("Activos")));
    }
    
    private void butAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAgregarActionPerformed
        // TODO add your handling code here:
        //Agregar
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateChooserFV.getDate());
       CArticulos arti = new CArticulos(0, txtNombreArticulo.getText(), Integer.parseInt(txtStock.getText()), date, true, ((MCCatArticulos)CBoxCatArticulo.getModel()).getCatArticulos().get(CBoxCatArticulo.getSelectedIndex()));
        OError error = arti.Insertar();
        if (error.isConfirma()) {
            ListarArticulos();
            System.out.println(error.getMensaje());
            ButCancelarActionPerformed(null);

        } else {
            System.out.println(error.getMensaje());
        }
    }//GEN-LAST:event_butAgregarActionPerformed

    private void butEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEditarActionPerformed
        // TODO add your handling code here:
        //Editar
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateChooserFV.getDate());
       CArticulos arti = new CArticulos(Integer.valueOf(txtCodArticulo.getText().trim()), txtNombreArticulo.getText(), Integer.parseInt(txtStock.getText()), date, true, ((MCCatArticulos)CBoxCatArticulo.getModel()).getCatArticulos().get(CBoxCatArticulo.getSelectedIndex()));
        OError error1 = arti.Editar();
        if (error1.isConfirma()) {
            ListarArticulos();
            System.out.println(error1.getMensaje());
            ButCancelarActionPerformed(null);
        } else {
            System.out.println(error1.getMensaje());

        }
    }//GEN-LAST:event_butEditarActionPerformed

    private void butDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDesactivarActionPerformed
        //TODO add your handling code here:
        OArticulos bank = ((MTArticulos) JTableArticulos.getModel()).getArticulo().get(JTableArticulos.getSelectedRow());
        CArticulos Artic = new CArticulos();
        Artic.setId(bank.getId());
        Artic.setEstado(false);
        OError Error = Artic.Eliminar();
        if (Error.isConfirma()) {
            ListarArticulos();
            ButCancelarActionPerformed(null);
        } else {
            System.out.println(Error.getMensaje());
        }
    }//GEN-LAST:event_butDesactivarActionPerformed

    private void ButCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCancelarActionPerformed
        // TODO add your handling code here:
        txtNombreArticulo.setText("");
        txtStock.setText("");
        txtCodArticulo.setText("");
        LlenarComboCatArticulos();
        jDateChooserFV.setCalendar(null);
    }//GEN-LAST:event_ButCancelarActionPerformed

    private void JTableArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableArticulosMouseClicked
        // TODO add your handling code here:
        MTArticulos comuna = (MTArticulos)JTableArticulos.getModel();
        txtNombreArticulo.setText(comuna.getArticulo().get(JTableArticulos.getSelectedRow()).getDescripcion());
        txtStock.setText(String.valueOf(comuna.getArticulo().get(JTableArticulos.getSelectedRow()).getStock()));
        txtCodArticulo.setText(String.valueOf(comuna.getArticulo().get(JTableArticulos.getSelectedRow()).getId()));
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
      //Date fecha = formato.parse("23/11/2015");
      //jDateChooserFV.setDate(formato.parse("23/11/2015"));
        txtId.setText(String.valueOf(comuna.getUsuarios().get(datos.getSelectedRow()).getId()));
        txtNombre.setText(comuna.getUsuarios().get(datos.getSelectedRow()).getNombre());
        Combobox.setSelectedIndex(comuna.getUsuarios().get(datos.getSelectedRow()).isEstado() ? 1 : 0);
    }//GEN-LAST:event_JTableArticulosMouseClicked
    
       public void ListarArticulos() {
        MTArticulos ModeloBanco = new MTArticulos(new CArticulos().Listar());
        JTableArticulos.setModel(ModeloBanco);
       }
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButCancelar;
    private javax.swing.JComboBox<String> CBoxCatArticulo;
    private javax.swing.JTable JTableArticulos;
    private javax.swing.JButton butAgregar;
    private javax.swing.JButton butDesactivar;
    private javax.swing.JButton butEditar;
    private com.toedter.calendar.JDateChooser jDateChooserFV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel labTitulo;
    private java.awt.TextField txtCodArticulo;
    private java.awt.TextField txtNombreArticulo;
    private java.awt.TextField txtStock;
    // End of variables declaration//GEN-END:variables
}
