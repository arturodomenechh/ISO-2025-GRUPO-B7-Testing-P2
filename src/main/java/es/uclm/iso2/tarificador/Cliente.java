package es.uclm.iso2.tarificador;

public class Cliente {

    private int edad;
    private int frecuenciaViajes;
    private String clase;
    private String destino;
    private int ingresos;
    private boolean viajaConNinos;
    private boolean estudiaFuera;
    private boolean viveConPadres;
    private boolean esTrabajador;

    public Cliente(int edad, int frecuenciaViajes, String clase, String destino,
                   int ingresos, boolean viajaConNinos, boolean estudiaFuera,
                   boolean viveConPadres, boolean esTrabajador) {

        this.edad = edad;
        this.frecuenciaViajes = frecuenciaViajes;
        this.clase = clase;
        this.destino = destino;
        this.ingresos = ingresos;
        this.viajaConNinos = viajaConNinos;
        this.estudiaFuera = estudiaFuera;
        this.viveConPadres = viveConPadres;
        this.esTrabajador = esTrabajador;
    }

    public int getEdad() { return edad; }
    public int getFrecuenciaViajes() { return frecuenciaViajes; }
    public String getClase() { return clase; }
    public String getDestino() { return destino; }
    public int getIngresos() { return ingresos; }
    public boolean isViajaConNinos() { return viajaConNinos; }
    public boolean isEstudiaFuera() { return estudiaFuera; }
    public boolean isViveConPadres() { return viveConPadres; }
    public boolean isTrabajador() { return esTrabajador; }
}
