package com.mov.app_movilidad_compartida.ui;

import java.awt.Color;
import javax.swing.JOptionPane;
import com.mov.app_movilidad_compartida.model.Conductor;
import com.mov.app_movilidad_compartida.model.Vehiculo;
import com.mov.app_movilidad_compartida.model.Ruta;
import com.mov.app_movilidad_compartida.service.ConductorService;
import com.mov.app_movilidad_compartida.service.RutaService;
import com.mov.app_movilidad_compartida.service.VehiculoService;
import java.util.ArrayList;
import java.util.List;


public class FrmRegisterRuta extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmRegisterRuta.class.getName());

    private Conductor conductor;
    private Vehiculo vehiculo;
    private RutaService rutaService;

    public FrmRegisterRuta() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
    }

    private VehiculoService vehiculoService;

    public FrmRegisterRuta(Conductor conductor, VehiculoService vehiculoService, RutaService rutaService) {
        this();
        this.conductor = conductor;
        this.vehiculoService = vehiculoService;
        this.rutaService = rutaService;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        cargarVehiculos();
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
        txtSalida = new javax.swing.JTextField();
        lblCorreo2 = new javax.swing.JLabel();
        lblFrase2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboVehiculos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblFrase1.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase1.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase1.setText("Registro de");

        lblCodigo.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCodigo.setText("Ruta (ID):");

        txtRuta.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N
        txtRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblNombre.setText("Punto de Partida:");

        txtPartida.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N
        txtPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPartidaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        jLabel1.setText("Destino:");

        txtDestino.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N
        txtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoActionPerformed(evt);
            }
        });

        lblCorreo.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCorreo.setText("Aforo Maximo:");

        txtAforo.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N
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
        lblCorreo1.setText("Costo (Ejm. 5):");

        txtCosto.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        txtSalida.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N
        txtSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalidaActionPerformed(evt);
            }
        });

        lblCorreo2.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCorreo2.setText("Horario (HH:MM):");

        lblFrase2.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase2.setForeground(new java.awt.Color(106, 171, 193));
        lblFrase2.setText("Nueva Ruta");

        jLabel2.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        jLabel2.setText("Vehículo:");

        ComboVehiculos.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N
        ComboVehiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboVehiculosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblCorreo1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(txtPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblCorreo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtAforo))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(ComboVehiculos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCorreo2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(lblFrase1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFrase2)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrase1)
                    .addComponent(lblFrase2))
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
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo2)
                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        String idRuta = txtRuta.getText().trim();
        String puntoPartida = txtPartida.getText().trim();
        String destino = txtDestino.getText().trim();
        String aforoStr = txtAforo.getText().trim();
        String costoStr = txtCosto.getText().trim();
        String horaSalida = txtSalida.getText().trim();

        if (idRuta.isEmpty() || puntoPartida.isEmpty() || destino.isEmpty() || aforoStr.isEmpty() || costoStr.isEmpty() || horaSalida.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int aforo;
        double costo;
        try {
            aforo = Integer.parseInt(aforoStr);
            if (aforo <= 0) {
                JOptionPane.showMessageDialog(this, "El aforo debe ser mayor a 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El aforo debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            costo = Double.parseDouble(costoStr);
            if (costo < 0) {
                JOptionPane.showMessageDialog(this, "El costo no puede ser negativo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El costo debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        if (!horaSalida.matches("^([01]?\\d|2[0-3]):[0-5]\\d$")) {
            JOptionPane.showMessageDialog(this, "El horario debe tener el formato HH:MM", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        if (conductor == null || vehiculo == null) {
            JOptionPane.showMessageDialog(this, "Error: Conductor o vehículo no válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        if (rutaService.buscarRutaPorId(idRuta) != null) {
            JOptionPane.showMessageDialog(this, "Ya existe una ruta con este ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Ruta ruta = new Ruta(idRuta, puntoPartida, destino, horaSalida, aforo, costo, conductor, vehiculo);
        rutaService.registrarRuta(ruta);

        JOptionPane.showMessageDialog(this, "Ruta registrada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        txtRuta.setText("");
        txtPartida.setText("");
        txtDestino.setText("");
        txtAforo.setText("");
        txtCosto.setText("");

        this.dispose();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
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

    private void txtSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalidaActionPerformed

    private void ComboVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboVehiculosActionPerformed
        int index = ComboVehiculos.getSelectedIndex();
        if (index >= 0 && index < vehiculosConductor.size()) {
            vehiculo = vehiculosConductor.get(index);
        }
    }//GEN-LAST:event_ComboVehiculosActionPerformed
    
    private List<Vehiculo> vehiculosConductor = new ArrayList<>();
    
    private void cargarVehiculos() {
        ComboVehiculos.removeAllItems();

        if (conductor == null) {
            ComboVehiculos.addItem("No hay conductor asignado");
            ComboVehiculos.setEnabled(false);
            return;
        }

        ConductorService conductorService = ConductorService.getInstance();
        vehiculosConductor = conductorService.getVehiculosPorConductor(conductor, vehiculoService);

        if (vehiculosConductor.isEmpty()) {
            ComboVehiculos.addItem("No hay vehículos registrados");
            ComboVehiculos.setEnabled(false);
            vehiculo = null;
            return;
        }

        ComboVehiculos.setEnabled(true);
        for (Vehiculo v : vehiculosConductor) {
            ComboVehiculos.addItem(v.getPlaca() + " - " + v.getModelo() + " (" + v.getTipo() + ")");
        }
        
        ComboVehiculos.setSelectedIndex(0);
        if (conductor.getVehiculos().isEmpty()) return;

        vehiculo = conductor.getVehiculos().get(0);
    }

    public void refrescarVehiculos() {
        cargarVehiculos();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboVehiculos;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCorreo1;
    private javax.swing.JLabel lblCorreo2;
    private javax.swing.JLabel lblFrase1;
    private javax.swing.JLabel lblFrase2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtAforo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtPartida;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtSalida;
    // End of variables declaration//GEN-END:variables
}
