package vallegrande.edu.pe;

import com.formdev.flatlaf.FlatLightLaf;
import vallegrande.edu.pe.controller.VeterinariaController;
import vallegrande.edu.pe.view.VeterinariaView;

public class VeterinariaApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                FlatLightLaf.setup();
            } catch (Exception ex) {
                System.err.println("Error al aplicar FlatLaf: " + ex.getMessage());
                ex.printStackTrace();

            VeterinariaView view = new VeterinariaView();

            new VeterinariaController(view);

            view.setVisible(true);
        });
    }
}





