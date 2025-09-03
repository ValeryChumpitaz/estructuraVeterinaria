package vallegrande.edu.pe.servicio;

import vallegrande.edu.pe.model.Mascota;  // Importa la clase Mascota, que representa a una mascota en el sistema.

public abstract class ServicioVeterinario {  // Clase abstracta que define el servicio veterinario, es decir, las operaciones que se pueden realizar en una mascota.

    // Método abstracto para aplicar una vacuna a una mascota.
    // Este método deberá ser implementado por las subclases de ServicioVeterinario, proporcionando una implementación específica para aplicar la vacuna.
    public abstract void aplicarVacuna(Mascota mascota);

    // Método abstracto para dar un tratamiento a una mascota.
    // Recibe el nombre del tratamiento como parámetro. También debe ser implementado en las subclases.
    public abstract void darTratamiento(Mascota mascota, String tratamiento);

    // Método abstracto para realizar un chequeo médico a una mascota.
    // Al igual que los anteriores, este método deberá ser implementado por las subclases.
    public abstract void realizarChequeo(Mascota mascota);
}
