package vallegrande.edu.pe.model;

public class Ave extends Mascota {  // La clase Ave extiende de Mascota, lo que significa que hereda las propiedades y métodos de Mascota.

    private double envergadura;  // Atributo específico de las aves, envergadura del ala.
    private String tipoCanto;    // Atributo que describe el tipo de canto del ave.
    private String dieta;        // Atributo que describe la dieta del ave.

    // Constructor de la clase Ave. Recibe el nombre, edad, envergadura, tipo de canto y dieta para inicializar una nueva instancia de Ave.
    public Ave(String nombre, int edad, double envergadura, String tipoCanto, String dieta) {
        super(nombre, edad, "Ave");  // Llama al constructor de la clase padre (Mascota) con nombre, edad y la especie "Ave".
        this.envergadura = envergadura;  // Asigna la envergadura a la propiedad de la instancia.
        this.tipoCanto = tipoCanto;      // Asigna el tipo de canto a la propiedad de la instancia.
        this.dieta = dieta;              // Asigna la dieta a la propiedad de la instancia.
    }

    // Método que sobrescribe el método `mostrarInfo` de la clase `Mascota`. Devuelve una cadena con la información de la ave.
    @Override
    public String mostrarInfo() {
        // Devuelve un string con la información formateada de la ave, incluyendo su nombre, edad, envergadura, tipo de canto y dieta.
        return getNombre() + " - Edad " + getEdad() + " años - Envergadura: " + envergadura +
                "cm - Canto: " + tipoCanto + " - Dieta: " + dieta;
    }
}
