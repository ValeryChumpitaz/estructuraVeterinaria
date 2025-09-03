package vallegrande.edu.pe.model;

public class Gato extends Mascota {  // La clase Gato extiende de Mascota, lo que significa que hereda las propiedades y métodos de Mascota.

    private String color;          // Atributo específico de los gatos que indica su color.
    private String tipoPelo;       // Atributo que indica el tipo de pelo del gato (por ejemplo, largo, corto).
    private String temperamento;   // Atributo que describe el temperamento del gato (por ejemplo, tranquilo, juguetón, agresivo).

    // Constructor de la clase Gato. Recibe el nombre, edad, color, tipo de pelo y temperamento para inicializar una nueva instancia de Gato.
    public Gato(String nombre, int edad, String color, String tipoPelo, String temperamento) {
        super(nombre, edad, "Gato");  // Llama al constructor de la clase padre (Mascota) con nombre, edad y la especie "Gato".
        this.color = color;           // Asigna el color del gato a la propiedad de la instancia.
        this.tipoPelo = tipoPelo;     // Asigna el tipo de pelo del gato a la propiedad de la instancia.
        this.temperamento = temperamento;  // Asigna el temperamento del gato a la propiedad de la instancia.
    }

    // Método que sobrescribe el método `mostrarInfo` de la clase `Mascota`. Devuelve una cadena con la información del gato.
    @Override
    public String mostrarInfo() {
        // Devuelve un string con la información formateada del gato, incluyendo su nombre, color, edad y temperamento.
        return getNombre() + " - Color " + color + " - Edad " + getEdad() +
                " años - Temperamento: " + temperamento;
    }
}