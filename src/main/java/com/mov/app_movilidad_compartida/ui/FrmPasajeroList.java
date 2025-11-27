package com.mov.app_movilidad_compartida.ui;

import com.mov.app_movilidad_compartida.model.Ruta;
import com.mov.app_movilidad_compartida.model.Estudiante;
import javax.swing.DefaultListModel;
import java.util.List;


public class FrmPasajeroList extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmPasajeroList.class.getName());
    
    private Ruta ruta;

    public FrmPasajeroList() {
        initComponents();
    }
    
    public FrmPasajeroList(Ruta ruta) {
        this();
        this.ruta = ruta;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        cargarDatos();
    }
    
    private void cargarDatos() {
        if (ruta == null) return;
        
        
        lblFrase3.setText(ruta.getIdRuta());
        
        
        DefaultListModel<String> model = new DefaultListModel<>();
        List<Estudiante> estudiantes = ruta.getEstudiantes();
        
        for (Estudiante e : estudiantes) {
            model.addElement(e.getNombre() + " - " + e.getCodigo() + " (" + e.getCorreo() + ")");
        }
        
        jList1.setModel(model);
        
        
        lblFrase5.setText(String.valueOf(estudiantes.size()));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFrase2 = new javax.swing.JLabel();
        lblFrase1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        lblFrase3 = new javax.swing.JLabel();
        lblFrase4 = new javax.swing.JLabel();
        lblFrase5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        lblFrase2.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase2.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase2.setText("RUTANAME");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFrase1.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase1.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase1.setText("Ruta");

        jList1.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        lblFrase3.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase3.setForeground(new java.awt.Color(106, 171, 193));
        lblFrase3.setText("RutaName");

        lblFrase4.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblFrase4.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase4.setText("Total:");

        lblFrase5.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblFrase5.setForeground(new java.awt.Color(106, 171, 193));
        lblFrase5.setText("#");

        jLabel1.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Pasajeros");

        jButton1.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFrase4)
                                .addGap(14, 14, 14)
                                .addComponent(lblFrase5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButton1)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblFrase1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFrase3)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrase1)
                    .addComponent(lblFrase3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrase4)
                    .addComponent(lblFrase5)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFrase1;
    private javax.swing.JLabel lblFrase2;
    private javax.swing.JLabel lblFrase3;
    private javax.swing.JLabel lblFrase4;
    private javax.swing.JLabel lblFrase5;
    // End of variables declaration//GEN-END:variables
}
