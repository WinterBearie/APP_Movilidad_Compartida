package com.mov.app_movilidad_compartida;

import com.mov.app_movilidad_compartida.service.ConductorService;
import com.mov.app_movilidad_compartida.service.EstudianteService;
import com.mov.app_movilidad_compartida.service.RutaService;
import com.mov.app_movilidad_compartida.service.VehiculoService;
import com.mov.app_movilidad_compartida.ui.FrmPrincipal;
import javax.swing.*;

public class APP_Movilidad_Compartida {
    public static void main(String[] args) {
        // Configurar Look and Feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cargar datos desde archivos al iniciar
        EstudianteService es = EstudianteService.getInstance();
        es.cargar();
        VehiculoService vs = VehiculoService.getInstance();
        vs.cargar();
        ConductorService cs = ConductorService.getInstance();
        cs.cargar(vs);
        RutaService.getInstance().cargar(cs, vs, es);

        // Iniciar formulario principal desde el paquete ui
        SwingUtilities.invokeLater(() -> {
            FrmPrincipal frame = new FrmPrincipal();
            frame.setVisible(true);
        });
    }
}
