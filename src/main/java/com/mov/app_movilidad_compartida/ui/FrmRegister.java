package com.mov.app_movilidad_compartida.ui;

import java.awt.Color;

public class FrmRegister extends javax.swing.JFrame {
    

    public FrmRegister() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFrase1 = new javax.swing.JLabel();
        lblFrase2 = new javax.swing.JLabel();
        btnLoginE = new javax.swing.JButton();
        btnLoginC = new javax.swing.JButton();
        btnPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblFrase1.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase1.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase1.setText("Registro de");

        lblFrase2.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase2.setForeground(new java.awt.Color(106, 171, 193));
        lblFrase2.setText("Usuario");

        btnLoginE.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        btnLoginE.setText("Estudiante");
        btnLoginE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginEActionPerformed(evt);
            }
        });

        btnLoginC.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        btnLoginC.setText("Conductor");
        btnLoginC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginCActionPerformed(evt);
            }
        });

        btnPrincipal.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N
        btnPrincipal.setText("Regresar");
        btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLoginE, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnLoginC, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblFrase1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblFrase2)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnPrincipal)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrase1)
                    .addComponent(lblFrase2))
                .addGap(18, 18, 18)
                .addComponent(btnLoginE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoginC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPrincipalActionPerformed

    private void btnLoginEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginEActionPerformed
        FrmRegisterE frmRegisterE = new FrmRegisterE();
        frmRegisterE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginEActionPerformed

    private void btnLoginCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginCActionPerformed
        FrmRegisterC frmRegisterC = new FrmRegisterC();
        frmRegisterC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginC;
    private javax.swing.JButton btnLoginE;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JLabel lblFrase1;
    private javax.swing.JLabel lblFrase2;
    // End of variables declaration//GEN-END:variables
}
