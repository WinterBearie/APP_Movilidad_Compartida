package com.mov.app_movilidad_compartida.ui;

import java.awt.Color;

import com.mov.app_movilidad_compartida.model.Conductor;
import com.mov.app_movilidad_compartida.service.ConductorService;

public class FrmLoginC extends javax.swing.JFrame {

    private ConductorService conductorService;
    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(FrmLoginC.class.getName());

    public FrmLoginC() {
        initComponents();
        setLocationRelativeTo(null);
        conductorService = ConductorService.getInstance();
        getContentPane().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFrase1 = new javax.swing.JLabel();
        lblFrase2 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        PswConductor = new javax.swing.JPasswordField();
        btnLoginC = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFrase1.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase1.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase1.setText("Login de");

        lblFrase2.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase2.setForeground(new java.awt.Color(106, 171, 193));
        lblFrase2.setText("Conductor");

        lblCorreo.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCorreo.setText("Correo:");

        txtCorreo.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N

        lblContraseña.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblContraseña.setText("Contraseña:");

        PswConductor.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N

        btnLoginC.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        btnLoginC.setText("Login");
        btnLoginC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginCActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PswConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCorreo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFrase1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblFrase2))
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnLoginC, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnRegresar)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrase1)
                    .addComponent(lblFrase2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PswConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContraseña))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoginC)
                    .addComponent(btnRegresar))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginCActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLoginCActionPerformed
        String correo = txtCorreo.getText();
        String contrasena = new String(PswConductor.getPassword());

        Conductor conductor = ConductorService.getInstance().iniciarSesionConductor(correo, contrasena);

        if (conductor != null) {
            FrmMenuConductor frmMenuC = new FrmMenuConductor(conductor);
            frmMenuC.setVisible(true);
            this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos");
        }
    }// GEN-LAST:event_btnLoginCActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRegresarActionPerformed
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PswConductor;
    private javax.swing.JButton btnLoginC;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFrase1;
    private javax.swing.JLabel lblFrase2;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
