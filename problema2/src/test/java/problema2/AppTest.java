package problema2;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    // Helper para crear clientes sin liarnos con el orden
    private Cliente c(int edad, int freq, String clase, String destino, int ingresos,
                      boolean conNinos, boolean estudiaFuera, boolean vivePadres, boolean trabajador) {
        return new Cliente(edad, freq, clase, destino, ingresos, conNinos, estudiaFuera, vivePadres, trabajador);
    }

    // 0) Datos negativos -> excepción
    @Test(expected = ExcepcionDatosInvalidos.class)
    public void testDatosNegativos_LanzaExcepcion() throws ExcepcionDatosInvalidos {
        Tarificador t = new Tarificador();
        Cliente cliente = c(-1, 5, "turista", "Europa", 10000, false, false, false, false);
        t.calcularTarifa(cliente);
    }

    // 1) Pajarillo (10%): edad < 18 y frecuencia >= 6
    @Test
    public void testPajarillo() throws ExcepcionDatosInvalidos {
        Tarificador t = new Tarificador();
        Cliente cliente = c(16, 6, "turista", "Europa", 0, false, false, false, false);
        assertEquals("Pajarillo (10%)", t.calcularTarifa(cliente));
    }

    // 2) Gorrión (15%): 18-25, estudia fuera, turista, freq >= 12
    @Test
    public void testGorrion() throws ExcepcionDatosInvalidos {
        Tarificador t = new Tarificador();
        Cliente cliente = c(22, 12, "turista", "Europa", 0, false, true, false, false);
        assertEquals("Gorrión (15%)", t.calcularTarifa(cliente));
    }

    // 3a) Viaja ahora que puedes (5%): 18-25, trabajador, vive con padres, turista, freq >= 3
    @Test
    public void testViajaAhoraQuePuedes() throws ExcepcionDatosInvalidos {
        Tarificador t = new Tarificador();
        Cliente cliente = c(23, 3, "turista", "Europa", 0, false, false, true, true);
        assertEquals("Viaja ahora que puedes (5%)", t.calcularTarifa(cliente));
    }

    // 3b) Atreviéndose a saltar del Nido (25%): 18-25, trabajador, NO vive con padres
    @Test
    public void testAtreviendoseASaltarDelNido() throws ExcepcionDatosInvalidos {
        Tarificador t = new Tarificador();
        Cliente cliente = c(24, 1, "turista", "Europa", 0, false, false, false, true);
        assertEquals("Atreviéndose a saltar del Nido (25%)", t.calcularTarifa(cliente));
    }

    // 4a) Conoce Europa con tus peques (10%): edad > 25, ingresos (20000,35000), freq >= 6, turista, destino Europa, con niños
    @Test
    public void testConoceEuropaConPeques() throws ExcepcionDatosInvalidos {
        Tarificador t = new Tarificador();
        Cliente cliente = c(30, 6, "turista", "Europa", 25000, true, false, false, false);
        assertEquals("Conoce Europa con tus peques (10%)", t.calcularTarifa(cliente));
    }

    // 4b) Conoce Europa (15%): igual pero SIN niños
    @Test
    public void testConoceEuropa() throws ExcepcionDatosInvalidos {
        Tarificador t = new Tarificador();
        Cliente cliente = c(30, 6, "turista", "Europa", 25000, false, false, false, false);
        assertEquals("Conoce Europa (15%)", t.calcularTarifa(cliente));
    }

    // 5a) Conoce el Mundo con tus peques (10%): edad > 25, ingresos > 35000, freq >= 6, business, destino Asia o America, con niños
    @Test
    public void testConoceMundoConPeques_Asia() throws ExcepcionDatosInvalidos {
        Tarificador t = new Tarificador();
        Cliente cliente = c(40, 6, "business", "Asia", 40000, true, false, false, false);
        assertEquals("Conoce el Mundo con tus peques (10%)", t.calcularTarifa(cliente));
    }

    // 5b) Conoce el Mundo (20%): igual pero SIN niños
    @Test
    public void testConoceMundo_America() throws ExcepcionDatosInvalidos {
        Tarificador t = new Tarificador();
        Cliente cliente = c(40, 6, "business", "America", 40000, false, false, false, false);
        assertEquals("Conoce el Mundo (20%)", t.calcularTarifa(cliente));
    }

    // 6) Sin tarifa disponible (un caso que no cumpla ninguna regla)
    @Test
    public void testSinTarifaDisponible() throws ExcepcionDatosInvalidos {
        Tarificador t = new Tarificador();
        // edad 26, ingresos 10000 (no entra en Europa ni Mundo), freq 1, etc.
        Cliente cliente = c(26, 1, "turista", "Europa", 10000, false, false, false, false);
        assertEquals("Sin tarifa disponible", t.calcularTarifa(cliente));
    }
}
