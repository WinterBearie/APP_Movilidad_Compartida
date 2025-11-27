
package com.mov.app_movilidad_compartida.ui;

import java.awt.Color;


public class FrmLoginE extends javax.swing.JFrame {
    
    public FrmLoginE() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFrase1 = new javax.swing.JLabel();
        lblFrase2 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        PswEstudiante = new javax.swing.JPasswordField();
        lblContraseña = new javax.swing.JLabel();
        btnLoginE = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFrase1.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase1.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase1.setText("Login de");

        lblFrase2.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase2.setForeground(new java.awt.Color(106, 171, 193));
        lblFrase2.setText("Estudiante");

        lblCorreo.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCorreo.setText("Correo:");

        jTextField1.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N

        PswEstudiante.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N

        lblContraseña.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblContraseña.setText("Contraseña:");

        btnLoginE.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        btnLoginE.setText("Login");
        btnLoginE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginEActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFrase1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFrase2)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCorreo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PswEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnLoginE, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnRegresar)))
                .addContainerGap(76, Short.MAX_VALUE))
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
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PswEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContraseña))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoginE)
                    .addComponent(btnRegresar))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginEActionPerformed
        //Aca para que vaya al menuEstudiante
    }//GEN-LAST:event_btnLoginEActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PswEstudiante;
    private javax.swing.JButton btnLoginE;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFrase1;
    private javax.swing.JLabel lblFrase2;
    // End of variables declaration//GEN-END:variables
}
