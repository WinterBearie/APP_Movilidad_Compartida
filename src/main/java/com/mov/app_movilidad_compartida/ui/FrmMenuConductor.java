package com.mov.app_movilidad_compartida.ui;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mov.app_movilidad_compartida.model.Conductor;
import com.mov.app_movilidad_compartida.model.Vehiculo;
import com.mov.app_movilidad_compartida.model.Ruta;
import com.mov.app_movilidad_compartida.service.*;
import java.util.List;

public class FrmMenuConductor extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(FrmMenuConductor.class.getName());

    private Conductor conductor;
    private Vehiculo vehiculo;
    private VehiculoService vehiculoService;
    private ConductorService conductorService;
    private RutaService rutaService;

    public FrmMenuConductor() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.vehiculoService = VehiculoService.getInstance();
        this.rutaService = RutaService.getInstance();
        this.conductorService = ConductorService.getInstance();
    }

    public FrmMenuConductor(Conductor conductor) {
        this();
        this.conductor = conductor;
        if (conductor == null) {
            logger.severe("Conductor es nulo al iniciar FrmMenuConductor");
            JOptionPane.showMessageDialog(this, "Error: No hay conductor asociado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        lblUsername.setText(conductor.getNombre());
        cargarVehiculo();
        cargarRutas();
    }

    private void cargarVehiculo() {
        vehiculo = conductor.getVehiculo();

        if (vehiculo == null)
            return;

        txtModelo.setText(vehiculo.getModelo());
        txtPlaca.setText(vehiculo.getPlaca());
    }

    private void cargarRutas() {
        DefaultTableModel model = (DefaultTableModel) tblRuta.getModel();
        model.setRowCount(0);

        if (conductor == null)
            return;

        List<Ruta> rutas = rutaService.getRutasPorConductor(conductor);
        for (Ruta r : rutas) {
            Object[] row = {
                    r.getIdRuta(),
                    r.getCosto(),
                    r.getPuntoPartida(),
                    r.getDestino(),
                    r.getHoraSalida(),
                    r.getEstudiantes().size(),
                    "Ver Pasajeros"
            };
            model.addRow(row);
        }

        lblTotal.setText(String.valueOf(rutas.size()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFrase1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        btnVehiculo = new javax.swing.JButton();
        btnRuta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRuta = new javax.swing.JTable();
        lblCodigo = new javax.swing.JLabel();
        lblCodigo1 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        lblCodigo2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblCodigo3 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblFrase1.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblFrase1.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase1.setText("Hola,");

        lblUsername.setFont(new java.awt.Font("Xingkai TC", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(106, 171, 193));
        lblUsername.setText("USERNAME");

        btnVehiculo.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        btnVehiculo.setText("Registrar / Editar Vehiculo");
        btnVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculoActionPerformed(evt);
            }
        });

        btnRuta.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        btnRuta.setText("Registrar Ruta");
        btnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutaActionPerformed(evt);
            }
        });

        tblRuta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ruta", "Costo", "Partida", "Destino", "Salida", "Pasajeros", "Acciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRuta);

        lblCodigo.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCodigo.setText("Modelo");

        lblCodigo1.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCodigo1.setText("Placa");

        txtModelo.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N

        txtPlaca.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N

        lblCodigo2.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCodigo2.setText("Total");

        lblTotal.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblTotal.setText("XX");

        lblCodigo3.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCodigo3.setText("Tipo");

        txtTipo.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCodigo2)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVehiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(txtModelo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFrase1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUsername)))
                        .addGap(18, 18, 18)
                        .addComponent(lblCodigo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCodigo1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrase1)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo1)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo3)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo2)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVehiculoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVehiculoActionPerformed
        // Get vehicle details from user
        String modelo = txtModelo.getText().trim();
        String placa = txtPlaca.getText().trim();
        String tipo = txtTipo.getText().trim();

        if (placa != null && !placa.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe completar todos los campos", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (modelo != null && !modelo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe completar todos los campos", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (tipo != null && !tipo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe completar todos los campos", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (vehiculo == null) {
            String error = vehiculoService.registrarVehiculo(modelo, tipo, placa);
            if (!error.isEmpty()) {
                JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            conductorService.asociarVehiculoAConductor(conductor, vehiculoService.buscarPorPlaca(placa));
        } else {
            // Check if the placa esta asociado a otro conductor
            Conductor conductorAsociado = conductorService.buscarPorPlacaVehiculo(placa);
            if (conductorAsociado != null && !conductorAsociado.getDni().equals(conductor.getDni())) {
                JOptionPane.showMessageDialog(this,
                        "La placa ya está asociada a otro conductor", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            vehiculo.setModelo(modelo);
            vehiculo.setTipo(tipo);
            vehiculo.setPlaca(placa);
            vehiculoService.guardar();
            conductorService.guardar();
        }
    }// GEN-LAST:event_btnVehiculoActionPerformed

    private void btnRutaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRutaActionPerformed
        if (vehiculo == null) {
            JOptionPane.showMessageDialog(this, "Debe registrar un vehículo antes de crear una ruta", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (conductor == null) {
            JOptionPane.showMessageDialog(this, "Error: No hay conductor asociado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        FrmRegisterRuta frmRegisterRuta = new FrmRegisterRuta(conductor, vehiculo, rutaService);
        this.setVisible(false);
        frmRegisterRuta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                FrmMenuConductor.this.setVisible(true);
                cargarRutas();
            }

            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                FrmMenuConductor.this.setVisible(true);
                cargarRutas();
            }
        });
        frmRegisterRuta.setVisible(true);
    }// GEN-LAST:event_btnRutaActionPerformed

    private void tblRutaMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblRuta.getSelectedRow();
        if (row < 0)
            return;

        int col = tblRuta.getSelectedColumn();
        // If clicked on "Acciones" column (index 6) or anywhere in the row
        if (col == 6 || col >= 0) {
            String idRuta = (String) tblRuta.getValueAt(row, 0);
            if (idRuta != null && conductor != null) {
                Ruta ruta = rutaService.buscarRutaPorId(idRuta);
                if (ruta != null && ruta.getConductor() != null && ruta.getConductor().equals(conductor)) {
                    FrmPasajeroList frmPasajeroList = new FrmPasajeroList(ruta);
                    frmPasajeroList.setVisible(true);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRuta;
    private javax.swing.JButton btnVehiculo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblCodigo3;
    private javax.swing.JLabel lblFrase1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblRuta;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
