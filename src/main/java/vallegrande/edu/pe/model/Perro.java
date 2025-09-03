package vallegrande.edu.pe.model;

public class Perro extends Mascota {  // La clase Perro extiende de Mascota, lo que significa que hereda las propiedades y métodos de Mascota.

    private String raza;            // Atributo específico de los perros que indica su raza (por ejemplo, "Labrador", "Poodle").
    private String tamano;          // Atributo que describe el tamaño del perro (por ejemplo, "Pequeño", "Mediano", "Grande").
    private String nivelActividad;  // Atributo que describe el nivel de actividad del perro (por ejemplo, "Bajo", "Moderado", "Alto").

    // Constructor de la clase Perro. Recibe el nombre, edad, raza, tamaño y nivel de actividad para inicializar una nueva instancia de Perro.
    public Perro(String nombre, int edad, String raza, String tamano, String nivelActividad) {
        super(nombre, edad, "Perro");  // Llama al constructor de la clase padre (Mascota) con nombre, edad y la especie "Perro".
        this.raza = raza;               // Asigna la raza del perro a la propiedad de la instancia.
        this.tamano = tamano;           // Asigna el tamaño del perro a la propiedad de la instancia.
        this.nivelActividad = nivelActividad;  // Asigna el nivel de actividad del perro a la propiedad de la instancia.
    }

    // Método que sobrescribe el método `mostrarInfo` de la clase `Mascota`. Devuelve una cadena con la información del perro.
    @Override
    public String mostrarInfo() {
        // Devuelve un string con la información formateada del perro, incluyendo su nombre, raza, edad y nivel de actividad.
        return getNombre() + " - Raza " + raza + " - Edad " + getEdad() +
                " años - Actividad: " + nivelActividad;
    }
}
