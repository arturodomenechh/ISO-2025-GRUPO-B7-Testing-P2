package es.uclm.iso2.tarificador;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Edad: ");
            int edad = sc.nextInt();

            System.out.print("Frecuencia viajes/año: ");
            int freq = sc.nextInt();

            System.out.print("Ingresos: ");
            int ingresos = sc.nextInt();
            sc.nextLine();

            System.out.print("Clase (turista/business): ");
            String clase = sc.nextLine();

            System.out.print("Destino (Europa/Asia/America): ");
            String destino = sc.nextLine();

            System.out.print("¿Viaja con niños? (true/false): ");
            boolean conNinos = sc.nextBoolean();

            System.out.print("¿Estudia fuera? (true/false): ");
            boolean estudia = sc.nextBoolean();

            System.out.print("¿Vive con padres? (true/false): ");
            boolean vivePadres = sc.nextBoolean();

            System.out.print("¿Es trabajador? (true/false): ");
            boolean trabajador = sc.nextBoolean();

            Cliente c = new Cliente(
                edad, freq, clase, destino, ingresos, conNinos,
                estudia, vivePadres, trabajador
            );

            Tarificador t = new Tarificador();
            System.out.println("Tarifa asignada: " + t.calcularTarifa(c));

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
