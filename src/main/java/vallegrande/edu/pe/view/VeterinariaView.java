package vallegrande.edu.pe.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VeterinariaView extends JFrame {

    // Campos comunes
    private JTextField txtNombre, txtEdad; // Campos para ingresar nombre y edad de la mascota

    // Especie
    private JComboBox<String> cbEspecie; // Combo box para elegir la especie (Perro, Gato, Ave)

    // Paneles específicos (CardLayout)
    private JPanel panelEspecificos; // Contendrá los panels para cada especie (Perro, Gato, Ave)

    // Perro
    private JTextField txtRazaPerro; // Campo para ingresar la raza del perro
    private JComboBox<String> cbTamanoPerro, cbActividadPerro; // Combo boxes para tamaño y nivel de actividad del perro

    // Gato
    private JTextField txtColorGato; // Campo para ingresar el color del gato
    private JComboBox<String> cbPeloGato, cbTemperamentoGato; // Combo boxes para el tipo de pelo y temperamento del gato

    // Ave
    private JTextField txtEnvergaduraAve; // Campo para ingresar la envergadura del ave
    private JComboBox<String> cbCantoAve, cbDietaAve; // Combo boxes para tipo de canto y dieta del ave

    // Acciones
    private JButton btnRegistrar, btnVacunar, btnHistorial, btnBuscar, btnLimpiarBusqueda; // Botones para diversas acciones
    private JTextField txtBuscar; // Campo de texto para realizar búsquedas

    // Tabla
    private JTable tablaMascotas; // Tabla para mostrar las mascotas registradas
    private DefaultTableModel modeloTabla; // Modelo para la tabla

    // Constructor de la clase
    public VeterinariaView() {
        setTitle("🐾 Sistema Veterinaria - Vallegrande"); // Título de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Acción al cerrar la ventana
        setSize(980, 640); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new BorderLayout(12, 12)); // Establece un BorderLayout con márgenes de 12 px

        // Agrega el formulario, la tabla y las acciones a la ventana
        add(construirFormulario(), BorderLayout.NORTH); // Agrega el formulario de registro al norte
        add(construirTabla(), BorderLayout.CENTER); // Agrega la tabla al centro
        add(construirAcciones(), BorderLayout.SOUTH); // Agrega los botones de acciones al sur

        // Estilos de la tabla
        tablaMascotas.setRowHeight(28); // Establece la altura de las filas de la tabla
        tablaMascotas.setShowGrid(true); // Muestra la cuadrícula de la tabla
        tablaMascotas.setIntercellSpacing(new Dimension(10, 5)); // Espaciado entre celdas
        tablaMascotas.setFillsViewportHeight(true); // Hace que la tabla ocupe todo el espacio vertical
        tablaMascotas.getTableHeader().setReorderingAllowed(false); // No permite reorganizar las columnas de la tabla

        // Renderer para colorear las filas de la tabla según el estado de vacunación
        tablaMascotas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                Object estado = table.getValueAt(row, 3); // Obtiene el valor de la columna "Vacunado"
                if (!isSelected) {
                    if (estado != null && estado.toString().startsWith("Sí")) { // Si la mascota está vacunada
                        c.setBackground(new Color(210, 245, 210)); // Verde claro
                    } else {
                        c.setBackground(Color.WHITE); // Si no está vacunada, blanco
                    }
                } else {
                    c.setBackground(new Color(180, 205, 255)); // Azul claro cuando la celda está seleccionada
                }
                return c; // Retorna el componente con el color adecuado
            }
        });
    }

    // --- Construcción de la UI ---

    private JPanel construirFormulario() {
        JPanel wrapper = new JPanel(new BorderLayout(10, 10)); // Panel principal con BorderLayout
        wrapper.setBorder(BorderFactory.createTitledBorder("Registro de Mascota")); // Título para el formulario

        // Fila 1 (comunes)
        JPanel fila1 = new JPanel(new GridLayout(2, 6, 8, 8)); // GridLayout con 2 filas y 6 columnas
        fila1.add(new JLabel("Nombre:")); // Label para el nombre
        txtNombre = new JTextField(); // Campo de texto para el nombre
        fila1.add(txtNombre);

        fila1.add(new JLabel("Edad (años):")); // Label para la edad
        txtEdad = new JTextField(); // Campo de texto para la edad
        fila1.add(txtEdad);

        fila1.add(new JLabel("Especie:")); // Label para la especie
        cbEspecie = new JComboBox<>(new String[]{"Perro", "Gato", "Ave"}); // Combo box para seleccionar la especie
        fila1.add(cbEspecie);

        // Panel específico por especie (CardLayout)
        panelEspecificos = new JPanel(new CardLayout()); // Panel con CardLayout para cambiar entre atributos de especies
        panelEspecificos.setBorder(BorderFactory.createTitledBorder("Atributos específicos")); // Título para los atributos

        panelEspecificos.add(panelPerro(), "Perro"); // Agrega el panel para Perro
        panelEspecificos.add(panelGato(), "Gato"); // Agrega el panel para Gato
        panelEspecificos.add(panelAve(), "Ave"); // Agrega el panel para Ave

        // Cambio de card al cambiar especie
        cbEspecie.addActionListener(e -> {
            CardLayout cl = (CardLayout) panelEspecificos.getLayout(); // Obtiene el layout de tipo CardLayout
            cl.show(panelEspecificos, (String) cbEspecie.getSelectedItem()); // Cambia al card correspondiente
        });

        wrapper.add(fila1, BorderLayout.NORTH); // Agrega la fila al panel principal
        wrapper.add(panelEspecificos, BorderLayout.CENTER); // Agrega el panel de especies al centro
        return wrapper; // Retorna el panel completo
    }

    // Métodos para construir los paneles específicos por especie

    private JPanel panelPerro() {
        JPanel p = new JPanel(new GridLayout(1, 6, 8, 8)); // Panel con GridLayout
        p.add(new JLabel("Raza:"));
        txtRazaPerro = new JTextField(); // Campo de texto para la raza del perro
        p.add(txtRazaPerro);

        p.add(new JLabel("Tamaño:"));
        cbTamanoPerro = new JComboBox<>(new String[]{"Pequeño", "Mediano", "Grande"}); // Combo box para el tamaño del perro
        p.add(cbTamanoPerro);

        p.add(new JLabel("Actividad:"));
        cbActividadPerro = new JComboBox<>(new String[]{"Bajo", "Medio", "Alto"}); // Combo box para el nivel de actividad del perro
        p.add(cbActividadPerro);
        return p; // Retorna el panel para el perro
    }

    private JPanel panelGato() {
        JPanel p = new JPanel(new GridLayout(1, 6, 8, 8)); // Panel con GridLayout
        p.add(new JLabel("Color:"));
        txtColorGato = new JTextField(); // Campo de texto para el color del gato
        p.add(txtColorGato);

        p.add(new JLabel("Tipo de pelo:"));
        cbPeloGato = new JComboBox<>(new String[]{"Corto", "Medio", "Largo"}); // Combo box para el tipo de pelo del gato
        p.add(cbPeloGato);

        p.add(new JLabel("Temperamento:"));
        cbTemperamentoGato = new JComboBox<>(new String[]{"Tranquilo", "Independiente", "Juguetón"}); // Combo box para el temperamento del gato
        p.add(cbTemperamentoGato);
        return p; // Retorna el panel para el gato
    }

    private JPanel panelAve() {
        JPanel p = new JPanel(new GridLayout(1, 6, 8, 8)); // Panel con GridLayout
        p.add(new JLabel("Envergadura (cm):"));
        txtEnvergaduraAve = new JTextField(); // Campo de texto para la envergadura del ave
        p.add(txtEnvergaduraAve);

        p.add(new JLabel("Tipo de canto:"));
        cbCantoAve = new JComboBox<>(new String[]{"Melódico", "Agudo", "Grave"}); // Combo box para el tipo de canto del ave
        p.add(cbCantoAve);

        p.add(new JLabel("Dieta:"));
        cbDietaAve = new JComboBox<>(new String[]{"Semillas", "Insectos", "Mixta"}); // Combo box para la dieta del ave
        p.add(cbDietaAve);
        return p;
    }

    private JScrollPane construirTabla() {
        modeloTabla = new DefaultTableModel(
                new Object[]{"Nombre", "Edad", "Especie", "Vacunado", "Detalle"}, 0
        ) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaMascotas = new JTable(modeloTabla);
        JScrollPane sp = new JScrollPane(tablaMascotas);

        sp.setBorder(BorderFactory.createTitledBorder("Mascotas Registradas"));
        return sp;
    }
    private JPanel construirAcciones() {
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 10));
        actions.setBorder(BorderFactory.createTitledBorder("Acciones:"));
        btnRegistrar = new JButton("Registrar");
        btnVacunar = new JButton("Vacunar");
        btnHistorial = new JButton("Ver Historial");
        txtBuscar = new JTextField(18);
        btnBuscar = new JButton("Buscar");

        btnLimpiarBusqueda = new JButton("Limpiar");

        actions.add(btnRegistrar);
        actions.add(btnVacunar);
        actions.add(btnHistorial);
        actions.add(new JLabel("Buscar(nombre/Especie)"));
        actions.add(btnBuscar);
        actions.add(btnLimpiarBusqueda);
        return actions;
    }
    public JTextField getTxtNombre(){return txtNombre;}
    public JTextField getTxtEdad(){return txtEdad;}
    public JComboBox<String> getCbEspecie(){return cbEspecie;}

    public JTextField getTxtRazaPerro(){return txtRazaPerro;}
    public JComboBox<String> getCbTamanoPerro(){return cbTamanoPerro;}
    public JComboBox<String> getCbActividadPerro(){return cbActividadPerro;}


    public JTextField getTxtColorGato(){return txtColorGato;}
    public JComboBox<String> getCbPeloGato(){return cbPeloGato;}
    public JComboBox<String> getCbTemperamentoGato(){return cbTemperamentoGato;}

    public JTextField getTxtEnvergaduraAve(){return txtEnvergaduraAve;}
    public JComboBox<String> getCbCantoAve(){return cbCantoAve;}
    public JComboBox<String> getCbDietaAve(){return cbDietaAve;}

    public JButton getBtnRegistrar(){return btnRegistrar;}
    public JButton getBtnVacunar(){return btnVacunar;}
    public JButton getBtnHistorial(){return btnHistorial;}
    public JButton getBtnBuscar(){return btnBuscar;}
    public JButton getBtnLimpiarBusqueda(){return btnLimpiarBusqueda;}

    public JTextField getTxtBuscar(){return txtBuscar;}
    public JTable getTablaMascotas(){return tablaMascotas;}
    public DefaultTableModel getModeloTabla(){return modeloTabla;}

}






