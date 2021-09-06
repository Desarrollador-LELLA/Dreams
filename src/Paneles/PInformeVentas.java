/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

/**
 *
 * @author TOULON
 */
public class PInformeVentas extends javax.swing.JPanel {

    /**
     * Creates new form PInformeVentas
     */
    public PInformeVentas() {
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
        jPanelBusqueda = new javax.swing.JPanel();
        labDesde = new javax.swing.JLabel();
        jDateChooserDesde = new com.toedter.calendar.JDateChooser("dd-MM-yyyy", "##/##/####", '_');
        jDateChooserHasta = new com.toedter.calendar.JDateChooser("dd-MM-yyyy", "##/##/####", '_');
        labHasta = new javax.swing.JLabel();
        txtBusquedaCliente = new javax.swing.JTextField();
        labBusquedaCliente = new javax.swing.JLabel();
        butGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();
        jToolBarMenu = new javax.swing.JToolBar();
        butExportarXLSX = new javax.swing.JButton();
        labTotal = new javax.swing.JLabel();

        labTitulo.setBackground(new java.awt.Color(102, 102, 255));
        labTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitulo.setText("Informe de Ventas");
        labTitulo.setOpaque(true);

        jPanelBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda de Ventas"));

        labDesde.setText("Desde");

        jDateChooserDesde.setEnabled(false);

        jDateChooserHasta.setEnabled(false);

        labHasta.setText("Hasta");

        txtBusquedaCliente.setEnabled(false);

        labBusquedaCliente.setText("Busqueda por Cliente");

        butGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_buscar_32.png"))); // NOI18N
        butGuardar.setText("Buscar");
        butGuardar.setEnabled(false);

        javax.swing.GroupLayout jPanelBusquedaLayout = new javax.swing.GroupLayout(jPanelBusqueda);
        jPanelBusqueda.setLayout(jPanelBusquedaLayout);
        jPanelBusquedaLayout.setHorizontalGroup(
            jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                        .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labDesde))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labHasta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 430, Short.MAX_VALUE)
                        .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labBusquedaCliente)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBusquedaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(butGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelBusquedaLayout.setVerticalGroup(
            jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                        .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labDesde)
                            .addComponent(labHasta)
                            .addComponent(labBusquedaCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(butGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Pedido", "Nombre Cliente", "Nombre Pack", "Fecha Compra", "Fecha Entrega", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLista.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableLista.setRowHeight(30);
        jScrollPane1.setViewportView(jTableLista);
        if (jTableLista.getColumnModel().getColumnCount() > 0) {
            jTableLista.getColumnModel().getColumn(0).setResizable(false);
            jTableLista.getColumnModel().getColumn(0).setPreferredWidth(125);
            jTableLista.getColumnModel().getColumn(1).setResizable(false);
            jTableLista.getColumnModel().getColumn(1).setPreferredWidth(207);
            jTableLista.getColumnModel().getColumn(2).setResizable(false);
            jTableLista.getColumnModel().getColumn(2).setPreferredWidth(207);
            jTableLista.getColumnModel().getColumn(3).setResizable(false);
            jTableLista.getColumnModel().getColumn(3).setPreferredWidth(105);
            jTableLista.getColumnModel().getColumn(4).setResizable(false);
            jTableLista.getColumnModel().getColumn(4).setPreferredWidth(105);
            jTableLista.getColumnModel().getColumn(5).setResizable(false);
            jTableLista.getColumnModel().getColumn(5).setPreferredWidth(125);
        }

        jToolBarMenu.setFloatable(false);
        jToolBarMenu.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBarMenu.setRollover(true);
        jToolBarMenu.setOpaque(false);

        butExportarXLSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_excel_32.png"))); // NOI18N
        butExportarXLSX.setText("Exportar");
        butExportarXLSX.setToolTipText("Agregar un Nuevo Usuario");
        butExportarXLSX.setEnabled(false);
        butExportarXLSX.setFocusable(false);
        butExportarXLSX.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butExportarXLSX.setMaximumSize(new java.awt.Dimension(69, 69));
        butExportarXLSX.setMinimumSize(new java.awt.Dimension(69, 69));
        butExportarXLSX.setPreferredSize(new java.awt.Dimension(69, 69));
        butExportarXLSX.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBarMenu.add(butExportarXLSX);

        labTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labTotal.setText("Total $0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToolBarMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                .addContainerGap())
        );

        jToolBarMenu.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butExportarXLSX;
    private javax.swing.JButton butGuardar;
    private com.toedter.calendar.JDateChooser jDateChooserDesde;
    private com.toedter.calendar.JDateChooser jDateChooserHasta;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLista;
    private javax.swing.JToolBar jToolBarMenu;
    private javax.swing.JLabel labBusquedaCliente;
    private javax.swing.JLabel labDesde;
    private javax.swing.JLabel labHasta;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JLabel labTotal;
    private javax.swing.JTextField txtBusquedaCliente;
    // End of variables declaration//GEN-END:variables
}
