package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Mascota;
import vallegrande.edu.pe.model.Perro;
import vallegrande.edu.pe.model.Gato;
import vallegrande.edu.pe.model.Ave;
import vallegrande.edu.pe.view.VeterinariaView;

import javax.swing.*;
import java.util.ArrayList;

public class VeterinariaController {

    private final VeterinariaView view;
    private final ArrayList<Mascota> mascotas = new ArrayList<>();

    public VeterinariaController(VeterinariaView view) {
        this.view = view;

        view.getBtnRegistrar().addActionListener(e -> registrarMascota());
        view.getBtnVacunar().addActionListener(e -> aplicarVacuna());
        view.getBtnHistorial().addActionListener(e -> verHistorial());
        view.getBtnBuscar().addActionListener(e -> buscar());
        view.getBtnLimpiarBusqueda().addActionListener(e -> limpiarBusqueda());
    }


    private void registrarMascota() {
        String nombre = view.getTxtNombre().getText().trim();
        String edadStr = view.getTxtEdad().getText().trim();
        String especie = (String) view.getCbEspecie().getSelectedItem();

        if (nombre.isEmpty() || edadStr.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Complete Nombre y Edad.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadStr);
            if (edad < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Edad debe ser un entero ≥ 0.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Mascota m = null;
        String detalle = "";

        switch (especie) {
            case "Perro" -> {
                String raza = view.getTxtRazaPerro().getText().trim();
                String tam = (String) view.getCbTamanoPerro().getSelectedItem();
                String act = (String) view.getCbActividadPerro().getSelectedItem();
                if (raza.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Ingrese la raza del perro.", "Validación", JOptionPane.WARNING_MESSAGE);
                    return; 
                }
                // Crear el objeto Perro
                m = new Perro(nombre, edad, raza, tam, act);
                detalle = "Raza: " + raza + ", Tamaño: " + tam + ", Actividad: " + act;
            }
            case "Gato" -> {