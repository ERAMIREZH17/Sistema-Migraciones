import java.util.ArrayList;
import java.util.Scanner;

public class Migraciones {

    public static void main(String[] args) {
        ArrayList<Visitante> visitantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inicio del pre-registro de visitantes.");
        while (true) {
            System.out.println("Ingrese los datos del visitante o escriba 'salir' para terminar.");

            // Ingreso del nombre y apellido
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("salir")) break;

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            // Ingreso del tipo de documento y número
            System.out.print("Tipo de Documento (DNI o Pasaporte): ");
            String tipoDocumento = scanner.nextLine();

            System.out.print("Número de Documento: ");
            String numeroDocumento = scanner.nextLine();

            // Ingreso de la nacionalidad
            System.out.print("Nacionalidad: ");
            String nacionalidad = scanner.nextLine();

            // Ingreso de datos adicionales
            System.out.print("Número de Aerolínea: ");
            String numeroAerolínea = scanner.nextLine();

            System.out.print("Duración de Estancia (días): ");
            int duracionEstancia = scanner.nextInt();

            System.out.print("Bolsa de Viaje ($): ");
            double bolsaViaje = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            // Validar datos ingresados
            if (nombre.isEmpty() || apellido.isEmpty() || tipoDocumento.isEmpty() || numeroDocumento.isEmpty()
                    || nacionalidad.isEmpty() || numeroAerolínea.isEmpty() || duracionEstancia <= 0 || bolsaViaje <= 0) {
                System.out.println("Error: Datos inválidos. Intente nuevamente.");
                continue;
            }

            // Generar código único y agregar a la lista
            String codigoUnico = "PRE-" + (int) (Math.random() * 10000);
            visitantes.add(new Visitante(nombre, apellido, tipoDocumento, numeroDocumento, nacionalidad, numeroAerolínea, duracionEstancia, bolsaViaje, codigoUnico));
            System.out.println("Pre-registro exitoso. Código generado: " + codigoUnico);
        }

        // Generar reporte
        generarReporte(visitantes);
    }

    // Generar reporte general
    public static void generarReporte(ArrayList<Visitante> visitantes) {
        int total = visitantes.size();
        double sumaEstancia = 0, sumaBolsa = 0;

        for (Visitante v : visitantes) {
            sumaEstancia += v.duracionEstancia;
            sumaBolsa += v.bolsaViaje;
        }

        System.out.println("Reporte General:");
        System.out.println("Total de Visitantes: " + total);
        System.out.println("Promedio de Estancia: " + (sumaEstancia / total) + " días");
        System.out.println("Promedio de Bolsa de Viaje: $" + (sumaBolsa / total));
    }
}

class Visitante {
    String nombre, apellido, tipoDocumento, numeroDocumento, nacionalidad, numeroAerolínea, codigoUnico;
    int duracionEstancia;
    double bolsaViaje;

    public Visitante(String nombre, String apellido, String tipoDocumento, String numeroDocumento, String nacionalidad,
                     String numeroAerolínea, int duracionEstancia, double bolsaViaje, String codigoUnico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nacionalidad = nacionalidad;
        this.numeroAerolínea = numeroAerolínea;
        this.duracionEstancia = duracionEstancia;
        this.bolsaViaje = bolsaViaje;
        this.codigoUnico = codigoUnico;
    }
}