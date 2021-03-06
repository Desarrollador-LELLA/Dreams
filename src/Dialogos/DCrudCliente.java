/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogos;

import Clases.CCanal;
import Clases.CCliente;
import ModeloCombox.MCCanal;
import Objetos.OAnimacion;
import Objetos.OCliente;

/**
 *
 * @author TOULON
 */
public class DCrudCliente extends javax.swing.JDialog {
    public boolean Actualizar = false;
    private OCliente cliente = new OCliente();
    
    private OAnimacion AnimacionRut = null;
    //private OAnimacion AnimacionFechaNacimiento = null;
    private OAnimacion AnimacionTelefono = null;
    private OAnimacion AnimacionNombre = null;
    private OAnimacion AnimacionApellido = null;
    private OAnimacion AnimacionDireccion = null;
    private OAnimacion AnimacionEmail = null;
    private OAnimacion AnimacionCanal = null;
    /**
     * Creates new form DCrudCliente
     */
    public DCrudCliente(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LlenarComboComuna();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        labRut = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        labFechaNacimiento = new javax.swing.JLabel();
        labEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        labTelefono = new javax.swing.JLabel();
        conboxCanal = new javax.swing.JComboBox<>();
        labCanal = new javax.swing.JLabel();
        jToggleButtonEstado = new javax.swing.JToggleButton();
        butGuardar = new javax.swing.JButton();
        dateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtTelefono = new javax.swing.JFormattedTextField();
        labDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Cliente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labNombre.setText("Nombre");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        labApellido.setText("Apellido");

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
        });

        labRut.setText("Rut");

        txtRut.setEditable(false);

        labFechaNacimiento.setText("Fecha Nacimiento");

        labEmail.setText("Email");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        labTelefono.setText("Telefono");

        conboxCanal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        conboxCanal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conboxCanalMouseClicked(evt);
            }
        });

        labCanal.setText("Canal");

        jToggleButtonEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_switchoff_32.png"))); // NOI18N
        jToggleButtonEstado.setSelected(true);
        jToggleButtonEstado.setText("Activado");
        jToggleButtonEstado.setIconTextGap(8);
        jToggleButtonEstado.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_switchon_32.png"))); // NOI18N
        jToggleButtonEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEstadoActionPerformed(evt);
            }
        });

        butGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/r_ico_guardar_32.png"))); // NOI18N
        butGuardar.setText("Guardar");
        butGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butGuardarActionPerformed(evt);
            }
        });

        dateFechaNacimiento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateFechaNacimiento.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                dateFechaNacimientoComponentShown(evt);
            }
        });

        txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("000000000"))));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });

        labDireccion.setText("Direccion");

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labRut)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labFechaNacimiento)
                            .addComponent(dateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labNombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labApellido)
                            .addComponent(txtApellido)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labEmail))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labCanal)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(conboxCanal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(labDireccion)
                    .addComponent(txtDireccion)
                    .addComponent(jToggleButtonEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labRut)
                    .addComponent(labFechaNacimiento)
                    .addComponent(labTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNombre)
                    .addComponent(labApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labEmail)
                    .addComponent(labCanal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conboxCanal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButtonEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void butGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butGuardarActionPerformed
        // TODO add your handling code here:
        Agregar();
    }//GEN-LAST:event_butGuardarActionPerformed

    private void jToggleButtonEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEstadoActionPerformed
        // TODO add your handling code here:
        if(jToggleButtonEstado.isSelected()){
            jToggleButtonEstado.setText("Activado");
        }
        else{
            jToggleButtonEstado.setText("Desactivado");
        }
    }//GEN-LAST:event_jToggleButtonEstadoActionPerformed

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        // TODO add your handling code here:
        if(AnimacionTelefono != null){
            AnimacionTelefono.DetenerTxt();
            AnimacionTelefono = null;
            txtTelefono.setToolTipText(null);
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        if(AnimacionNombre != null){
            AnimacionNombre.DetenerTxt();
            AnimacionNombre = null;
            txtNombre.setToolTipText(null);
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        // TODO add your handling code here:
        if(AnimacionApellido != null){
            AnimacionApellido.DetenerTxt();
            AnimacionApellido = null;
            txtApellido.setToolTipText(null);
        }
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        // TODO add your handling code here:
        if(AnimacionDireccion != null){
            AnimacionDireccion.DetenerTxt();
            AnimacionDireccion = null;
            txtDireccion.setToolTipText(null);
        }
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        // TODO add your handling code here:
        if(AnimacionEmail != null){
            AnimacionEmail.DetenerTxt();
            AnimacionEmail = null;
            txtEmail.setToolTipText(null);
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void conboxCanalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conboxCanalMouseClicked
        // TODO add your handling code here:
        if(AnimacionCanal != null){
            AnimacionCanal.DetenerCbox();
            AnimacionCanal = null;
            conboxCanal.setToolTipText(null);
        }
    }//GEN-LAST:event_conboxCanalMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        txtTelefonoKeyReleased(null);
        txtNombreKeyReleased(null);
        txtApellidoKeyReleased(null);
        txtDireccionKeyReleased(null);
        txtEmailKeyReleased(null);
        conboxCanalMouseClicked(null);
    }//GEN-LAST:event_formWindowClosing

    private void dateFechaNacimientoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_dateFechaNacimientoComponentShown
        // TODO add your handling code here:
        /*if(AnimacionFechaNacimiento != null){
            AnimacionFechaNacimiento.DetenerDateBox();
            AnimacionFechaNacimiento = null;
            dateFechaNacimiento.setToolTipText(null);
        }*/
    }//GEN-LAST:event_dateFechaNacimientoComponentShown

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
            java.util.logging.Logger.getLogger(DCrudCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCrudCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCrudCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCrudCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DCrudCliente dialog = new DCrudCliente(new javax.swing.JDialog(), true);
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
    
    private void LlenarComboComuna(){
        conboxCanal.setModel(new MCCanal(new CCanal().Listar("Activos")));
    }
    
    private void Agregar(){
        boolean Validacion = true;
        if(dateFechaNacimiento.getDate() == null){
            /*if(AnimacionFechaNacimiento == null){
                AnimacionFechaNacimiento = new OAnimacion(dateFechaNacimiento);
                AnimacionFechaNacimiento.EjecutarDateBox();
                dateFechaNacimiento.setToolTipText("La Fecha de Vencimiento es Obligatorio");
            }*/
            Validacion = false;
        }
        if(txtTelefono.getText().trim().isEmpty()){
            if(AnimacionTelefono == null){
                AnimacionTelefono = new OAnimacion(txtTelefono);
                AnimacionTelefono.EjecutarTxt();
                txtTelefono.setToolTipText("El Telefono es Obligatorio");
            }
            Validacion = false;
        }
        if(txtNombre.getText().trim().isEmpty()){
            if(AnimacionNombre == null){
                AnimacionNombre = new OAnimacion(txtNombre);
                AnimacionNombre.EjecutarTxt();
                txtNombre.setToolTipText("El Nombre es Obligatorio");
            }
            Validacion = false;
        }
        if(txtApellido.getText().trim().isEmpty()){
            if(AnimacionApellido == null){
                AnimacionApellido = new OAnimacion(txtApellido);
                AnimacionApellido.EjecutarTxt();
                txtApellido.setToolTipText("El Apellido es Obligatorio");
            }
            Validacion = false;
        }
        if(txtDireccion.getText().trim().isEmpty()){
            if(AnimacionDireccion == null){
                AnimacionDireccion = new OAnimacion(txtDireccion);
                AnimacionDireccion.EjecutarTxt();
                txtDireccion.setToolTipText("La Direccion es Obligatoria");
            }
            Validacion = false;
        }
        if(txtEmail.getText().trim().isEmpty()){
            if(AnimacionEmail == null){
                AnimacionEmail = new OAnimacion(txtEmail);
                AnimacionEmail.EjecutarTxt();
                txtEmail.setToolTipText("El Email es Obligatorio");
            }
            Validacion = false;
        }
        if(conboxCanal.getSelectedItem().equals("Seleccione Canal")){
            if(AnimacionCanal == null){
                AnimacionCanal = new OAnimacion(conboxCanal);
                AnimacionCanal.EjecutarCbox();
                conboxCanal.setToolTipText("Seleccione un Canal");
            }
            Validacion = false;
        }
        if(Validacion){
            CCliente Cliente = null;
            if(String.valueOf(this.getTitle()).equals("Agregar Cliente")){
                Cliente = new CCliente(0, txtRut.getText().trim(), txtNombre.getText().trim(), txtApellido.getText().trim()
                        , txtDireccion.getText().trim(), txtEmail.getText().trim(), Integer.valueOf(txtTelefono.getText().trim())
                        , jToggleButtonEstado.isSelected(), ((MCCanal)conboxCanal.getModel()).getCanales().get(conboxCanal.getSelectedIndex()));
                //if(Cliente.ExisteUsername().isConfirma()){
                    if(Cliente.Agregar().isConfirma()){
                        DCorrecto Mensaje = new DCorrecto(new javax.swing.JDialog(), true);
                        Mensaje.labMensaje.setText(Cliente.getError().getMensaje());
                        Mensaje.setVisible(true);
                        this.dispose();
                        Actualizar = true;
                    }
                    else{
                        DError Mensaje = new DError(new javax.swing.JDialog(), true);
                        Mensaje.labMensaje.setText(Cliente.getError().getMensaje());
                        Mensaje.setVisible(true);
                    }
                /*}
                else{
                    DError Mensaje = new DError(new javax.swing.JDialog(), true);
                    Mensaje.labMensaje.setText(Usuario.getError().getMensaje());
                    Mensaje.setVisible(true);
                }*/
            }
            else{
                /*Cliente = new CCliente(cliente.getId(), txtRut.getText().trim(), txtNombre.getText().trim(), txtApellido.getText().trim()
                        , txtDireccion.getText().trim(), txtEmail.getText().trim(), Integer.valueOf(txtTelefono.getText().trim())
                        , jToggleButtonEstado.isSelected(), ((MCCanal)conboxCanal.getModel()).getCanales().get(conboxCanal.getSelectedIndex()));
                if(Cliente.ExisteUsernameDiferente().isConfirma()){
                    if(Cliente.Editar().isConfirma()){
                        DCorrecto Mensaje = new DCorrecto(new javax.swing.JDialog(), true);
                        Mensaje.labMensaje.setText(Cliente.getError().getMensaje());
                        Mensaje.setVisible(true);
                        this.dispose();
                        Actualizar = true;
                    }
                    else{
                        DError Mensaje = new DError(new javax.swing.JDialog(), true);
                        Mensaje.labMensaje.setText(Cliente.getError().getMensaje());
                        Mensaje.setVisible(true);
                    }
                }
                else{
                    DError Mensaje = new DError(new javax.swing.JDialog(), true);
                    Mensaje.labMensaje.setText(Cliente.getError().getMensaje());
                    Mensaje.setVisible(true);
                }*/
            }                
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butGuardar;
    private javax.swing.JComboBox<String> conboxCanal;
    private com.toedter.calendar.JDateChooser dateFechaNacimiento;
    private javax.swing.JToggleButton jToggleButtonEstado;
    private javax.swing.JLabel labApellido;
    private javax.swing.JLabel labCanal;
    private javax.swing.JLabel labDireccion;
    private javax.swing.JLabel labEmail;
    private javax.swing.JLabel labFechaNacimiento;
    private javax.swing.JLabel labNombre;
    private javax.swing.JLabel labRut;
    private javax.swing.JLabel labTelefono;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtRut;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
