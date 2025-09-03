package vallegrande.edu.pe.servicio;

import vallegrande.edu.pe.model.Mascota;  // Importa la clase Mascota, que es la que va a ser manipulada por los métodos del servicio.

public class ServicioVeterinarioImpl extends ServicioVeterinario {  // Esta clase extiende de ServicioVeterinario y proporciona implementaciones concretas de los métodos abstractos.

    @Override
    public void aplicarVacuna(Mascota mascota) {
        System.out.println("Aplicando vacuna a " + mascota.getNombre());
        mascota.registrarVisita();
    }

    @Override
    public void darTratamiento(Mascota mascota, String tratamiento) {
        System.out.println("Tratamiento '" + tratamiento + "' aplicado a " + mascota.getNombre());
        mascota.registrarVisita();
    }

    @Override
    public void realizarChequedo(Mascota mascota) {
        System.out.println("Chequeo realizado a " + mascota.mostrarInfo());
        mascota.registrarVisita();
    }

}