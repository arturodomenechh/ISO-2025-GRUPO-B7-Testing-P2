package es.uclm.iso2.tarificador;

public class Tarificador {

    public String calcularTarifa(Cliente c) throws ExcepcionDatosInvalidos {

        if (c.getEdad() < 0 || c.getFrecuenciaViajes() < 0 || c.getIngresos() < 0) {
            throw new ExcepcionDatosInvalidos("Datos negativos no permitidos");
        }

        if (c.getEdad() < 18 && c.getFrecuenciaViajes() >= 6) {
            return "Pajarillo (10%)";
        }

        if (c.getEdad() >= 18 && c.getEdad() <= 25 &&
            c.isEstudiaFuera() &&
            c.getClase().equalsIgnoreCase("turista") &&
            c.getFrecuenciaViajes() >= 12) {
            return "Gorrión (15%)";
        }

        if (c.getEdad() >= 18 && c.getEdad() <= 25 && c.isTrabajador()) {

            if (c.isViveConPadres() && c.getFrecuenciaViajes() >= 3 &&
                c.getClase().equalsIgnoreCase("turista")) {

                return "Viaja ahora que puedes (5%)";
            }

            if (!c.isViveConPadres()) {
                return "Atreviéndose a saltar del Nido (25%)";
            }
        }

        if (c.getEdad() > 25 &&
            c.getIngresos() > 20000 && c.getIngresos() < 35000 &&
            c.getFrecuenciaViajes() >= 6 &&
            c.getClase().equalsIgnoreCase("turista") &&
            c.getDestino().equalsIgnoreCase("Europa")) {

            if (c.isViajaConNinos()) {
                return "Conoce Europa con tus peques (10%)";
            }
            return "Conoce Europa (15%)";
        }

        if (c.getEdad() > 25 &&
            c.getIngresos() > 35000 &&
            c.getFrecuenciaViajes() >= 6 &&
            c.getClase().equalsIgnoreCase("business") &&
            (c.getDestino().equalsIgnoreCase("Asia") || c.getDestino().equalsIgnoreCase("America"))) {

            if (c.isViajaConNinos()) {
                return "Conoce el Mundo con tus peques (10%)";
            }
            return "Conoce el Mundo (20%)";
        }

        return "Sin tarifa disponible";
    }
}
