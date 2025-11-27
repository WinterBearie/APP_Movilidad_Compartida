package com.mov.app_movilidad_compartida.ui;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mov.app_movilidad_compartida.model.Conductor;
import com.mov.app_movilidad_compartida.model.Vehiculo;
import com.mov.app_movilidad_compartida.model.Ruta;
import com.mov.app_movilidad_compartida.service.*;
import com.mov.app_movilidad_compartida.util.GestorArchivos;
import java.util.List;

public class FrmMenuConductor extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(FrmMenuConductor.class.getName());

    private Conductor conductor;
    private VehiculoService vehiculoService;
    private ConductorService conductorService;
    private RutaService rutaService;
    private Vehiculo vehiculo;
    private GestorArchivos gestor = new GestorArchivos();


    public FrmMenuConductor() {
        initComponents();
        tblRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRutaMouseClicked(evt);
            }
        });
        getContentPane().setBackground(Color.WHITE);
        this.vehiculoService = VehiculoService.getInstance();
        this.rutaService = RutaService.getInstance();
        this.conductorService = ConductorService.getInstance();
        conductorService.cargar(vehiculoService);
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
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblFrase1.setFont(new java.awt.Font("Xingkai TC", 1, 36)); // NOI18N
        lblFrase1.setForeground(new java.awt.Color(0, 102, 153));
        lblFrase1.setText("Bienvenid@,");

        lblUsername.setFont(new java.awt.Font("Xingkai TC", 1, 36)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(106, 171, 193));
        lblUsername.setText("Nombre");

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

        tblRuta.setFont(new java.awt.Font("K2D", 0, 12)); // NOI18N
        tblRuta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ruta", "Costo", "Partida", "Destino", "Salida", "Pasajeros", "Acciones", "Placa", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRuta);
        if (tblRuta.getColumnModel().getColumnCount() > 0) {
            tblRuta.getColumnModel().getColumn(6).setHeaderValue("Acciones");
        }

        lblCodigo.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCodigo.setText("Modelo:");

        lblCodigo1.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCodigo1.setText("Placa (Ejm: ABC-123):");

        txtModelo.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N

        txtPlaca.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N

        lblCodigo2.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCodigo2.setText("Total de Rutas");

        lblTotal.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N
        lblTotal.setText("XX");

        lblCodigo3.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        lblCodigo3.setText("Tipo (Auto, Camioneta, Van,...):");

        txtTipo.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N

        btnLogout.setFont(new java.awt.Font("K2D", 1, 14)); // NOI18N
        btnLogout.setText("Cerrar Sesion");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblCodigo2)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCodigo3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCodigo)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(lblCodigo1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btnVehiculo)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(lblFrase1)
                        .addGap(18, 18, 18)
                        .addComponent(lblUsername)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrase1)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo1))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo3))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo2)
                    .addComponent(lblTotal))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose(); 
        new FrmPrincipal().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnVehiculoActionPerformed(java.awt.event.ActionEvent evt) {
        String modelo = txtModelo.getText().trim();
        String placa = txtPlaca.getText().trim();
        String tipo = txtTipo.getText().trim();

        if (modelo.isEmpty() || placa.isEmpty() || tipo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        Vehiculo vehiculoExistente = vehiculoService.buscarPorPlaca(placa);
        if (vehiculoExistente != null) {
            Conductor conductorAsociado = conductorService.buscarPorPlacaVehiculo(placa);
            if (!conductorAsociado.getDni().equals(conductor.getDni())) {
                JOptionPane.showMessageDialog(this, "La placa ya está asociada a otro conductor", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                
                vehiculoExistente.setModelo(modelo);
                vehiculoExistente.setTipo(tipo);
                vehiculoService.guardar();
                JOptionPane.showMessageDialog(this, "Vehículo actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        
        String error = vehiculoService.registrarVehiculo(modelo, tipo, placa);
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Vehiculo nuevoVehiculo = vehiculoService.buscarPorPlaca(placa);
        if (nuevoVehiculo != null) {
            conductorService.asociarVehiculoAConductor(conductor, nuevoVehiculo);
            JOptionPane.showMessageDialog(this, "Vehículo registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }

        
        txtModelo.setText("");
        txtPlaca.setText("");
        txtTipo.setText("");
    }


    private void btnRutaActionPerformed(java.awt.event.ActionEvent evt) {
        if (vehiculo == null) {
            JOptionPane.showMessageDialog(this, "Debe registrar un vehículo antes de crear una ruta", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        FrmRegisterRuta frmRegisterRuta = new FrmRegisterRuta(conductor, vehiculoService, rutaService);
        frmRegisterRuta.refrescarVehiculos();
        frmRegisterRuta.setVisible(true);
        
        if (conductor == null) {
            JOptionPane.showMessageDialog(this, "Error: No hay conductor asociado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

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
    }

    private void tblRutaMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblRuta.getSelectedRow();
        if (row < 0) return;
        int col = tblRuta.getSelectedColumn();
        if (col == 6) {
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
    
    
    private void cargarRutas() {
        DefaultTableModel model = (DefaultTableModel) tblRuta.getModel();
        model.setRowCount(0);

        if (conductor == null) return;

        List<Ruta> rutas = rutaService.getRutasPorConductor(conductor);
        for (Ruta r : rutas) {
            Vehiculo vehiculoRuta = null;
            if (r.getConductor() != null) {
                List<Vehiculo> vehiculos = conductorService.getVehiculosPorConductor(r.getConductor(), vehiculoService);
                if (!vehiculos.isEmpty()) {
                    vehiculoRuta = vehiculos.get(0); 
                }
            }
            Object[] row = {
                r.getIdRuta(),
                r.getCosto(),
                r.getPuntoPartida(),
                r.getDestino(),
                r.getHoraSalida(),
                r.getEstudiantes().size(),
                "Ver Pasajeros",
                vehiculoRuta != null ? vehiculoRuta.getPlaca() : "",
                vehiculoRuta != null ? vehiculoRuta.getTipo() : ""
            };
            model.addRow(row);
        }

        lblTotal.setText(String.valueOf(rutas.size()));
    }
    private void cargarVehiculo() {
        if (conductor == null) return;

        List<Vehiculo> vehiculos = conductorService.getVehiculosPorConductor(conductor, vehiculoService);
        if (!vehiculos.isEmpty()) {
            vehiculo = vehiculos.get(0);
            txtModelo.setText(vehiculo.getModelo());
            txtPlaca.setText(vehiculo.getPlaca());
            txtTipo.setText(vehiculo.getTipo());
        } else {
            txtModelo.setText("");
            txtPlaca.setText("");
            txtTipo.setText("");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
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
