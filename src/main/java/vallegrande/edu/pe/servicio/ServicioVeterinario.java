package vallegrande.edu.pe.servicio;

import vallegrande.edu.pe.model.Mascota;  // Importa la clase Mascota, que representa a una mascota en el sistema.

public abstract class ServicioVeterinario {  // Clase abstracta que define el servicio veterinario, es decir, las operaciones que se pueden realizar en una mascota.

public abstract void aplicarVacuna(Mascota mascota);
public abstract void darTratamiento(Mascota mascota, String Tratamiento);
public abstract void realizarChequedo(Mascota mascota);

    public abstract void realizarChequeo(Mascota mascota);
}






