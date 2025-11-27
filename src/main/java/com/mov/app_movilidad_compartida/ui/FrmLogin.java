package com.mov.app_movilidad_compartida.ui;

import java.awt.Color;

public class FrmLogin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmLogin.class.getName());

    public FrmLogin() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFrase2 = new javax.swing.JLabel();
        lblFrase1 = new javax.swing.JLabel();
        btnLoginE = new javax.swing.JButton();
        btnLoginC = new javax.swing.JButton();
        btnPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFrase2.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase2.setForeground(new java.awt.Color(106, 171, 193));
        lblFrase2.setText("Usuario");

        lblFrase1.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase1.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase1.setText("Login de");

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
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnLoginE, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLoginC, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblFrase1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblFrase2)
                            .addGap(13, 13, 13)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnPrincipal)))
                .addContainerGap(97, Short.MAX_VALUE))
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
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginEActionPerformed
        FrmLoginE frmLoginE = new FrmLoginE();
        frmLoginE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginEActionPerformed

    private void btnLoginCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginCActionPerformed
        FrmLoginC frmLoginC = new FrmLoginC();
        frmLoginC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginCActionPerformed

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPrincipalActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmLogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginC;
    private javax.swing.JButton btnLoginE;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JLabel lblFrase1;
    private javax.swing.JLabel lblFrase2;
    // End of variables declaration//GEN-END:variables
}
