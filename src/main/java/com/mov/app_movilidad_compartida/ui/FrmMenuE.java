package com.mov.app_movilidad_compartida.ui;

import java.util.List;
import javax.swing.JOptionPane;
import com.mov.app_movilidad_compartida.model.Estudiante;
import com.mov.app_movilidad_compartida.model.Ruta;
import com.mov.app_movilidad_compartida.service.RutaService;
import com.mov.app_movilidad_compartida.service.EstudianteService;
import java.awt.Color;


public class FrmMenuE extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmMenuE.class.getName());
    private Estudiante estudiante;
    
    public FrmMenuE(Estudiante e) {
        this.estudiante = e;
        initComponents();
        setLocationRelativeTo(null);
        lblNombre.setText(e.getNombre());
        cargarRutas();
        cargarRutasRegistradas();
        getContentPane().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        lblFrase = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        comboRutas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrarseR = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRutasIns = new javax.swing.JTextArea();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFrase.setFont(new java.awt.Font("Xingkai TC", 1, 36)); // NOI18N
        lblFrase.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase.setText("Bienvenid@,");

        lblNombre.setFont(new java.awt.Font("Xingkai TC", 1, 36)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(106, 171, 193));
        lblNombre.setText("Nombre");

        btnLogout.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N
        btnLogout.setText("Cerrar Sesión");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(216, 232, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rutas Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("K2D", 1, 14))); // NOI18N
        jPanel1.setToolTipText("");
        jPanel1.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N

        comboRutas.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N
        comboRutas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRutasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        jLabel1.setText("Rutas:");

        btnRegistrarseR.setText("Registrarse");
        btnRegistrarseR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(btnRegistrarseR)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarseR)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(197, 220, 220));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rutas Registradas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("K2D", 1, 14))); // NOI18N

        txtRutasIns.setEditable(false);
        txtRutasIns.setColumns(20);
        txtRutasIns.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N
        txtRutasIns.setRows(5);
        jScrollPane1.setViewportView(txtRutasIns);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(lblFrase)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(btnLogout)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrase)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void comboRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRutasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRutasActionPerformed

    private void btnRegistrarseRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseRActionPerformed
    
        String seleccion = (String) comboRutas.getSelectedItem();
        if (seleccion == null || seleccion.equals("No hay rutas disponibles")) {
            JOptionPane.showMessageDialog(this, "No hay rutas seleccionadas");
            return;
        }

        String idRuta = seleccion.split(" - ")[0];
        Ruta ruta = RutaService.getInstance().buscarRutaPorId(idRuta);

        if (ruta == null) {
            JOptionPane.showMessageDialog(this, "Ruta no encontrada");
            return;
        }

        if (!ruta.estaDisponible()) {
            JOptionPane.showMessageDialog(this, "Ruta sin disponibilidad");
            return;
        }

        boolean exito = ruta.agregarEstudiante(estudiante);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Te has registrado en la ruta correctamente");
            cargarRutas();
            cargarRutasRegistradas();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible registrarse en la ruta");
        }
    }//GEN-LAST:event_btnRegistrarseRActionPerformed
    
    private void cargarRutas() {
        comboRutas.removeAllItems();
        List<Ruta> rutas = RutaService.getInstance().getRutasDisponibles();
        if (rutas.isEmpty()) {
            comboRutas.addItem("No hay rutas disponibles");
        } else {
            for (Ruta r : rutas) {
                comboRutas.addItem(r.getIdRuta() + " - " 
                    + r.getPuntoPartida() + " → " + r.getDestino() 
                    + " (" + r.getHoraSalida() + ") - S/." + r.getCosto() 
                    + " - " + r.getVehiculo().getPlaca() + " " + r.getVehiculo().getModelo());

            }
        }
    }
    
    private void cargarRutasRegistradas() {
        List<Ruta> misRutas = RutaService.getInstance().getRutasPorEstudiante(estudiante);
        txtRutasIns.setText("");

        if (misRutas.isEmpty()) {
            txtRutasIns.setText("No estás inscrito en ninguna ruta");
        } else {
            for (Ruta r : misRutas) {
                String vehiculoStr = "Sin vehículo";
                if (r.getVehiculo() != null) {
                    vehiculoStr = r.getVehiculo().getPlaca() + " " + r.getVehiculo().getModelo();
                }

                txtRutasIns.append(
                    r.getIdRuta() + " - " 
                    + r.getPuntoPartida() + " → " + r.getDestino() 
                    + " (" + r.getHoraSalida() + ") - S/." + r.getCosto() 
                    + " - " + vehiculoStr + "\n"
                );
            }
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRegistrarseR;
    private javax.swing.JComboBox<String> comboRutas;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFrase;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextArea txtRutasIns;
    // End of variables declaration//GEN-END:variables
}
