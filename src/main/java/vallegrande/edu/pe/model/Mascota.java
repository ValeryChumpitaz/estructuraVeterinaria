package vallegrande.edu.pe.model;

import java.time.LocalDate;  // Importa la clase LocalDate para trabajar con fechas (en este caso, la fecha de la última visita).

public class Mascota {  // Esta es la clase base para representar una mascota general.
    private String nombre;        // Atributo que almacena el nombre de la mascota.
    private int edad;             // Atributo que almacena la edad de la mascota en años.
    private String especie;       // Atributo que describe la especie de la mascota (por ejemplo, "Perro", "Gato", "Ave").
    private LocalDate ultimaVisita;  // Atributo que almacena la fecha de la última visita de la mascota al veterinario.

    // Constructor de la clase Mascota. Inicializa los atributos de la mascota.
    public Mascota(String nombre, int edad, String especie) {
        this.nombre = nombre;           // Asigna el nombre de la mascota.
        this.edad = edad;               // Asigna la edad de la mascota.
        this.especie = especie;         // Asigna la especie de la mascota.
        this.ultimaVisita = LocalDate.now();  // Inicializa la fecha de la última visita con la fecha actual.
    }

    // Métodos Getters y Setters (Encapsulamiento):
    // Permiten obtener y modificar los valores de los atributos de forma controlada.

    public String getNombre() { return nombre; }  // Devuelve el nombre de la mascota.
    public void setNombre(String nombre) { this.nombre = nombre; }  // Modifica el nombre de la mascota.

    public int getEdad() { return edad; }  // Devuelve la edad de la mascota.
    public void setEdad(int edad) { this.edad = edad; }  // Modifica la edad de la mascota.

    public String getEspecie() { return especie; }  // Devuelve la especie de la mascota.
    public void setEspecie(String especie) { this.especie = especie; }  // Modifica la especie de la mascota.

    public LocalDate getUltimaVisita() { return ultimaVisita; }  // Devuelve la fecha de la última visita de la mascota.

    // Métodos comunes

    // Este método actualiza la fecha de la última visita con la fecha actual.
    public void registrarVisita() {
        this.ultimaVisita = LocalDate.now();  // Establece la fecha actual como la última visita.
    }

    // Este método calcula la edad de la mascota (en este caso, simplemente devuelve el valor de edad, pero podría ser ampliado).
    public int calcularEdad() {
        return edad;  // Devuelve la edad de la mascota.
    }

    // Método para mostrar la información de la mascota en forma de texto.
    public String mostrarInfo() {
        // Devuelve una cadena con el nombre, especie y edad de la mascota.
        return nombre + " - Especie: " + especie + " - Edad: " + edad + " años";
    }
}
