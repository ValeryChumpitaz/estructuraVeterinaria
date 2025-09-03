package vallegrande.edu.pe;

import com.formdev.flatlaf.FlatLightLaf;  // Importamos el Look & Feel moderno de FlatLaf
import vallegrande.edu.pe.controller.VeterinariaController;  // Importamos el controlador
import vallegrande.edu.pe.view.VeterinariaView;  // Importamos la vista

public class VeterinariaApp {
    public static void main(String[] args) {
        // Ejecutamos la aplicación de manera segura en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                // Aplicamos el look & feel moderno FlatLightLaf
                // Esto cambia la apariencia de la interfaz gráfica a un diseño más limpio y minimalista
                FlatLightLaf.setup();
            } catch (Exception ex) {
                // Si ocurre un error al aplicar FlatLaf, lo mostramos en consola
                System.err.println("Error al aplicar FlatLaf: " + ex.getMessage());
                ex.printStackTrace();  // Imprimimos el stack trace completo para facilitar la depuración
            }

            // Creamos la vista principal de la veterinaria
            VeterinariaView view = new VeterinariaView();

            // Creamos el controlador y le pasamos la vista
            // El controlador se encarga de manejar la lógica de la aplicación y actualizar la vista
            new VeterinariaController(view);

            // Hacemos visible la vista, de esta manera la interfaz de usuario aparecerá en pantalla
            view.setVisible(true);
        });
    }
}



