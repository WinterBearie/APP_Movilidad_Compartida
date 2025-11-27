package com.mov.app_movilidad_compartida.ui;

import java.awt.Color;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import com.mov.app_movilidad_compartida.model.Estudiante;
import com.mov.app_movilidad_compartida.service.EstudianteService;


public class FrmRegisterRuta extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmRegisterRuta.class.getName());

    public FrmRegisterRuta() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFrase1 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtPartida = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtAforo = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblCorreo1 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblFrase1.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase1.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase1.setText("Registro de nueva ruta");

        lblCodigo.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCodigo.setText("Ruta");

        txtRuta.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N
        txtRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblNombre.setText("Punto de Partida");

        txtPartida.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N
        txtPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPartidaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        jLabel1.setText("Destino");

        txtDestino.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N
        txtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoActionPerformed(evt);
            }
        });

        lblCorreo.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCorreo.setText("Aforo Maximo");

        txtAforo.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N
        txtAforo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAforoActionPerformed(evt);
            }
        });

        btnCrear.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        btnCrear.setText("Registrar");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        btnRegresar.setText("Cancelar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblCorreo1.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCorreo1.setText("Costo");

        txtCosto.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblFrase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblCodigo)
                            .addComponent(jLabel1)
                            .addComponent(lblCorreo)
                            .addComponent(lblCorreo1))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegresar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCosto)
                                .addComponent(txtAforo)
                                .addComponent(txtDestino)
                                .addComponent(txtPartida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                .addComponent(txtRuta, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblFrase1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtAforo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo1)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String codigo = txtRuta.getText();
        String nombre = txtPartida.getText();
        String carrera = txtDestino.getText();
        String correo = txtAforo.getText();
        String clave = new String(PswContraseña.getPassword());

        if (codigo.isEmpty() || nombre.isEmpty() || correo.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos");
            return;
        }
        
        Estudiante e = new Estudiante(codigo, nombre, carrera, correo, clave);

        if (!e.validarIdentificacion()) {
            JOptionPane.showMessageDialog(this, "El correo no es institucional (@usil.pe o @usil.edu.pe)");
            return;
        }
        
        boolean exito = EstudianteService.getInstance().registrarEstudiante(e);

        if (!exito) {
            JOptionPane.showMessageDialog(this, "Ya existe un estudiante con este correo", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            
            JOptionPane.showMessageDialog(this, e.generarReporte(), "Reporte del Estudiante", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this, "Estudiante registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPartidaActionPerformed

    private void txtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinoActionPerformed

    private void txtAforoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAforoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAforoActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmRegisterRuta().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCorreo1;
    private javax.swing.JLabel lblFrase1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtAforo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtPartida;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
