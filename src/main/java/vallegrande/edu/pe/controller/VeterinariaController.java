package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Mascota;
import vallegrande.edu.pe.model.Perro;
import vallegrande.edu.pe.model.Gato;
import vallegrande.edu.pe.model.Ave;
import vallegrande.edu.pe.view.VeterinariaView;

import javax.swing.*;
import java.util.ArrayList;

public class VeterinariaController {

    private final VeterinariaView view;  // Instancia de la vista donde se manejan los componentes gráficos
    private final ArrayList<Mascota> mascotas = new ArrayList<>();  // Lista para almacenar las mascotas registradas

    // Constructor que recibe la vista y establece los eventos de los botones
    public VeterinariaController(VeterinariaView view) {
        this.view = view;

        // Asignación de eventos a los botones de la vista
        view.getBtnRegistrar().addActionListener(e -> registrarMascota());  // Botón para registrar una mascota
        view.getBtnVacunar().addActionListener(e -> aplicarVacuna());  // Botón para vacunar a una mascota
        view.getBtnHistorial().addActionListener(e -> verHistorial());  // Botón para ver el historial (en construcción)
        view.getBtnBuscar().addActionListener(e -> buscar());  // Botón para buscar una mascota
        view.getBtnLimpiarBusqueda().addActionListener(e -> limpiarBusqueda());  // Botón para limpiar la búsqueda
    }

    // --- Acciones ---

    // Método para registrar una nueva mascota
    private void registrarMascota() {
        // Obtener los valores ingresados en los campos de texto
        String nombre = view.getTxtNombre().getText().trim();
        String edadStr = view.getTxtEdad().getText().trim();
        String especie = (String) view.getCbEspecie().getSelectedItem();  // Obtener la especie seleccionada

        // Validación de campos vacíos
        if (nombre.isEmpty() || edadStr.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Complete Nombre y Edad.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;  // Salir del método si los campos son inválidos
        }

        // Validación de la edad (debe ser un número entero no negativo)
        int edad;
        try {
            edad = Integer.parseInt(edadStr);
            if (edad < 0) throw new NumberFormatException();  // Edad no puede ser negativa
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Edad debe ser un entero ≥ 0.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;  // Salir si la edad no es válida
        }

        // Inicialización de la mascota a registrar
        Mascota m = null;
        String detalle = "";

        // Crear la mascota de acuerdo a la especie seleccionada
        switch (especie) {
            case "Perro" -> {
                // Obtener los detalles específicos para perros
                String raza = view.getTxtRazaPerro().getText().trim();
                String tam = (String) view.getCbTamanoPerro().getSelectedItem();
                String act = (String) view.getCbActividadPerro().getSelectedItem();
                if (raza.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Ingrese la raza del perro.", "Validación", JOptionPane.WARNING_MESSAGE);
                    return;  // Validación de la raza
                }
                // Crear el objeto Perro
                m = new Perro(nombre, edad, raza, tam, act);
                detalle = "Raza: " + raza + ", Tamaño: " + tam + ", Actividad: " + act;
            }
            case "Gato" -> {
                // Obtener los detalles específicos para gatos
                String color = view.getTxtColorGato().getText().trim();
                String pelo = (String) view.getCbPeloGato().getSelectedItem();
                String temp = (String) view.getCbTemperamentoGato().getSelectedItem();
                if (color.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Ingrese el color del gato.", "Validación", JOptionPane.WARNING_MESSAGE);
                    return;  // Validación del color
                }
                // Crear el objeto Gato
                m = new Gato(nombre, edad, color, pelo, temp);
                detalle = "Color: " + color + ", Pelo: " + pelo + ", Temperamento: " + temp;
            }
            case "Ave" -> {
                // Obtener los detalles específicos para aves
                String envStr = view.getTxtEnvergaduraAve().getText().trim();
                String canto = (String) view.getCbCantoAve().getSelectedItem();
                String dieta = (String) view.getCbDietaAve().getSelectedItem();
                double envergadura;
                try {
                    envergadura = Double.parseDouble(envStr);
                    if (envergadura <= 0) throw new NumberFormatException();  // Envergadura debe ser mayor que 0
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Envergadura debe ser numérica > 0.", "Validación", JOptionPane.WARNING_MESSAGE);
                    return;  // Salir si la envergadura no es válida
                }
                // Crear el objeto Ave
                m = new Ave(nombre, edad, envergadura, canto, dieta);
                detalle = "Enverg: " + envergadura + " cm, Canto: " + canto + ", Dieta: " + dieta;
            }
        }

        // Si se ha creado la mascota, añadirla a la lista y actualizar la vista
        if (m != null) {
            mascotas.add(m);  // Añadir la mascota al array de mascotas
            view.getModeloTabla().addRow(new Object[]{
                    m.getNombre(),  // Nombre de la mascota
                    m.getEdad(),    // Edad de la mascota
                    m.getEspecie(), // Especie de la mascota
                    "No",           // Estado de vacunación (inicialmente No)
                    detalle         // Detalles específicos según la especie
            });
            limpiarFormulario();  // Limpiar los campos del formulario después de registrar
        }
    }

    // Método para aplicar la vacuna a la mascota seleccionada
    private void aplicarVacuna() {
        int filaVista = view.getTablaMascotas().getSelectedRow();  // Obtener la fila seleccionada en la tabla
        if (filaVista == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione una mascota en la tabla.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;  // Si no se seleccionó ninguna mascota, mostrar un mensaje
        }
        // Marcar la mascota como vacunada en la tabla
        view.getModeloTabla().setValueAt("Sí", filaVista, 3);
        String nombre = view.getModeloTabla().getValueAt(filaVista, 0).toString();  // Obtener el nombre de la mascota
        JOptionPane.showMessageDialog(view, "Vacuna aplicada a " + nombre + ".", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para ver el historial de mascotas (en construcción)
    private void verHistorial() {
        JOptionPane.showMessageDialog(view, "Historial en construcción 🛠️", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para buscar una mascota por nombre o especie
    private void buscar() {
        String q = view.getTxtBuscar().getText().trim().toLowerCase();  // Obtener el texto de búsqueda en minúsculas
        if (q.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Ingrese texto para buscar (nombre o especie).", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            return;  // Salir si no se ingresó texto
        }
        int rows = view.getModeloTabla().getRowCount();  // Obtener el número de filas de la tabla
        for (int i = 0; i < rows; i++) {
            // Verificar si el nombre o la especie contienen el texto de búsqueda
            String nombre = view.getModeloTabla().getValueAt(i, 0).toString().toLowerCase();
            String especie = view.getModeloTabla().getValueAt(i, 2).toString().toLowerCase();
            if (nombre.contains(q) || especie.contains(q)) {
                view.getTablaMascotas().setRowSelectionInterval(i, i);  // Seleccionar la fila que coincide
                view.getTablaMascotas().scrollRectToVisible(view.getTablaMascotas().getCellRect(i, 0, true));  // Desplazar la vista hacia la fila
                return;
            }
        }
        JOptionPane.showMessageDialog(view, "Sin resultados.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);  // Mostrar mensaje si no se encontró nada
    }

    private void limpiarBusqueda() {
        view.getTxtBuscar().setText("");
        view.getTablaMascotas().clearSelection();
    }

    private void limpiarFormulario() {
        // Limpiar los campos de texto
        view.getTxtNombre().setText("");
        view.getTxtEdad().setText("");
        view.getCbEspecie().setSelectedIndex(0);
        view.getTxtRazaPerro().setText("");
        view.getCbTamanoPerro().setSelectedIndex(1);
        view.getCbActividadPerro().setSelectedIndex(1);

        view.getTxtColorGato().setText("");
        view.getCbPeloGato().setSelectedIndex(0);
        view.getCbTemperamentoGato().setSelectedIndex(0);

        view.getTxtEnvergaduraAve().setText("");
        view.getCbCantoAve().setSelectedIndex(0);
        view.getCbDietaAve().setSelectedIndex(0);
    }
}