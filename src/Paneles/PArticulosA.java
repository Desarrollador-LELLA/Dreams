/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import Clases.CArticulos;
import Clases.CCatArticulos;
import ModeloCombox.MCCatArticulos;
import ModeloCombox.Tester;
import ModelosTablas.MTArticulos;
import Objetos.OArticulos;
import Objetos.OCatArticulos;
import Objetos.OError;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TOULON
 */
public class PArticulosA extends javax.swing.JPanel {

    /**
     * Creates new form PArticulosA
     */
    public PArticulosA() {
        initComponents();
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
        jToolBarMenu = new javax.swing.JToolBar();
        butAgregar = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();
        butDesactivar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableArticulos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtCodArticulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreArticulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooserFV = new com.toedter.calendar.JDateChooser("dd-MM-yyyy", "##/##/####", '_');
        ButCancelar = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        labTitulo.setBackground(new java.awt.Color(102, 102, 255));
        labTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitulo.setText("Articulos");
        labTitulo.setOpaque(true);

        jToolBarMenu.setFloatable(false);
        jToolBarMenu.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBarMenu.setRollover(true);
        jToolBarMenu.setOpaque(false);

        butAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_agregar_32.png"))); // NOI18N
        butAgregar.setText("Agregar");
        butAgregar.setToolTipText("Agregar un Nuevo Usuario");
        butAgregar.setFocusable(false);
        butAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butAgregar.setMaximumSize(new java.awt.Dimension(69, 69));
        butAgregar.setMinimumSize(new java.awt.Dimension(69, 69));
        butAgregar.setPreferredSize(new java.awt.Dimension(69, 69));
        butAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        butAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAgregarActionPerformed(evt);
            }
        });
        jToolBarMenu.add(butAgregar);

        butEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_editar_32.png"))); // NOI18N
        butEditar.setText("Editar");
        butEditar.setToolTipText("Editar un Usuario Seleccionado");
        butEditar.setFocusable(false);
        butEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butEditar.setMaximumSize(new java.awt.Dimension(69, 69));
        butEditar.setMinimumSize(new java.awt.Dimension(69, 69));
        butEditar.setPreferredSize(new java.awt.Dimension(69, 69));
        butEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        butEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEditarActionPerformed(evt);
            }
        });
        jToolBarMenu.add(butEditar);

        butDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_desactivar_32.png"))); // NOI18N
        butDesactivar.setText("Desactivar");
        butDesactivar.setToolTipText("Desactivar un Usuario Seleccionado");
        butDesactivar.setFocusable(false);
        butDesactivar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butDesactivar.setMaximumSize(new java.awt.Dimension(69, 69));
        butDesactivar.setMinimumSize(new java.awt.Dimension(69, 69));
        butDesactivar.setPreferredSize(new java.awt.Dimension(69, 69));
        butDesactivar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        butDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDesactivarActionPerformed(evt);
            }
        });
        jToolBarMenu.add(butDesactivar);

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Articulo"));

        txtCodArticulo.setEditable(false);

        jLabel4.setText("Codigo Articulo:");

        jLabel1.setText("Nombre Articulo:");

        jLabel5.setText("Categoria Articulo:");

        jLabel2.setText("Stock:");

        jLabel6.setText("Fecha de Vencimiento:");

        ButCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_limpio_24.png"))); // NOI18N
        ButCancelar.setToolTipText("Limpiar Datos Cliente Solicitante");
        ButCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(txtCodArticulo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreArticulo)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBoxCatArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserFV, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBoxCatArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6))
                    .addComponent(jDateChooserFV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jToolBarMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTableArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableArticulosMouseClicked
        LlenarComboCatArticulos();
        MTArticulos comuna = (MTArticulos) JTableArticulos.getModel();
        txtCodArticulo.setText(comuna.getArticulo().get(JTableArticulos.getSelectedRow()).getDescripcion());
        txtStock.setText(String.valueOf(comuna.getArticulo().get(JTableArticulos.getSelectedRow()).getStock()));
        txtCodArticulo.setText(String.valueOf(comuna.getArticulo().get(JTableArticulos.getSelectedRow()).getId()));
        txtNombreArticulo.setText(String.valueOf(comuna.getArticulo().get(JTableArticulos.getSelectedRow()).getDescripcion()));
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
        jDateChooserFV.setDate(formato.parse(comuna.getArticulo().get(JTableArticulos.getSelectedRow()).getFecha()));
        } catch (ParseException ex) {
        Logger.getLogger(PArticulosA.class.getName()).log(Level.SEVERE, null, ex);
        }
        CBoxCatArticulo.setSelectedItem(comuna.getArticulo().get(JTableArticulos.getSelectedRow()).getCategoria().getNombre());
    }//GEN-LAST:event_JTableArticulosMouseClicked

    private void butAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAgregarActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateChooserFV.getDate());
        CArticulos arti = new CArticulos(0, txtNombreArticulo.getText(), Integer.parseInt(txtStock.getText()), date, true, ((MCCatArticulos) CBoxCatArticulo.getModel()).getCatArticulos().get(CBoxCatArticulo.getSelectedIndex()));
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateChooserFV.getDate());
        CArticulos arti = new CArticulos(Integer.valueOf(txtCodArticulo.getText().trim()), txtNombreArticulo.getText(), Integer.parseInt(txtStock.getText()), date, true, ((MCCatArticulos) CBoxCatArticulo.getModel()).getCatArticulos().get(CBoxCatArticulo.getSelectedIndex()));
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
        // TODO add your handling code here:
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

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
        ListarArticulos();
        LlenarComboCatArticulos();
    }//GEN-LAST:event_formAncestorAdded

    public void ListarArticulos() {
        MTArticulos ModeloBanco = new MTArticulos(new CArticulos().Listar());
        JTableArticulos.setModel(ModeloBanco);
    }

    private void LlenarComboCatArticulos() {
        MCCatArticulos ModeloCategoria = new MCCatArticulos(new CCatArticulos().Listar("Activos"));
        CBoxCatArticulo.setModel(ModeloCategoria);
        
        //CBoxCatArticulo.setModel(new Tester(new CCatArticulos().Listar("Activos")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButCancelar;
    private final javax.swing.JComboBox<OCatArticulos> CBoxCatArticulo = new javax.swing.JComboBox<>();
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBarMenu;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JTextField txtCodArticulo;
    private javax.swing.JTextField txtNombreArticulo;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
