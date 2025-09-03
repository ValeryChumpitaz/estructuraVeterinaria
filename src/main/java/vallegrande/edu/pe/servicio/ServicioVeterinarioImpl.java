package vallegrande.edu.pe.servicio;

import vallegrande.edu.pe.model.Mascota;  // Importa la clase Mascota, que es la que va a ser manipulada por los métodos del servicio.

public class ServicioVeterinarioImpl extends ServicioVeterinario {  // Esta clase extiende de ServicioVeterinario y proporciona implementaciones concretas de los métodos abstractos.

    // Implementación del método aplicarVacuna. Este método recibe una mascota y le aplica una vacuna.
    @Override
    public void aplicarVacuna(Mascota mascota) {
        System.out.println("Aplicando vacuna a " + mascota.getNombre());  // Imprime el nombre de la mascota a la que se le está aplicando la vacuna.
        mascota.registrarVisita();  // Actualiza la fecha de la última visita de la mascota.
    }

    // Implementación del método darTratamiento. Este método recibe una mascota y un tratamiento a administrar.
    @Override
    public void darTratamiento(Mascota mascota, String tratamiento) {
        System.out.println("Tratamiento '" + tratamiento + "' aplicado a " + mascota.getNombre());  // Imprime el nombre de la mascota y el tratamiento que se le está aplicando.
        mascota.registrarVisita();  // Registra la visita después de administrar el tratamiento.
    }

    // Implementación del método realizarChequeo. Este método realiza un chequeo a la mascota.
    @Override
    public void realizarChequeo(Mascota mascota) {
        System.out.println("Chequeo realizado a " + mascota.mostrarInfo());  // Muestra la información de la mascota que está siendo chequeada.
        mascota.registrarVisita();  // Actualiza la fecha de la última visita después de realizar el chequeo.
    }
}