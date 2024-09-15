package Ejercicio2;

import java.util.Scanner;
import java.util.TreeSet;

public class ejercicio2 {
    // TreeSet para almacenar los gatos
    private static TreeSet<GatoSimple> gatos = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Crear gato simple");
            System.out.println("2 – Dar de comer a un gato simple");
            System.out.println("3 – Eliminar un gato simple");
            System.out.println("4 – Mostrar todos los gatos");
            System.out.println("5 – Crear gato contrincante para pelear con un gato simple");
            System.out.println("6 – Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Para consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearGato(scanner);
                    break;
                case 2:
                    darDeComer(scanner);
                    break;
                case 3:
                    eliminarGato(scanner);
                    break;
                case 4:
                    mostrarGatos();
                    break;
                case 5:
                    pelearGatos(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
        scanner.close();
    }

    // Método para crear un gato y agregarlo al TreeSet
    private static void crearGato(Scanner scanner) {
        System.out.print("Ingrese el nombre del gato: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el sexo del gato (macho/hembra): ");
        String sexo = scanner.nextLine();
        System.out.print("Ingrese el color del gato: ");
        String color = scanner.nextLine();
        System.out.print("Ingrese el peso del gato: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();  // Consumir salto de línea
        System.out.print("Ingrese la raza del gato: ");
        String raza = scanner.nextLine();
        System.out.print("Ingrese la edad del gato: ");
        int edad = scanner.nextInt();
        scanner.nextLine();  // Consumir salto de línea

        GatoSimple gato = new GatoSimple(color, peso, raza, edad, nombre, sexo);
        gatos.add(gato);
        System.out.println("Gato agregado correctamente.");
    }

    // Método para dar de comer a un gato
    private static void darDeComer(Scanner scanner) {
        System.out.print("Ingrese el nombre del gato: ");
        String nombre = scanner.nextLine();
        GatoSimple gato = buscarGatoPorNombre(nombre);
        if (gato != null) {
            System.out.print("Ingrese la comida: ");
            String comida = scanner.nextLine();
            gato.comer(comida);
        } else {
            System.out.println("Gato no encontrado.");
        }
    }

    // Método para eliminar un gato
    private static void eliminarGato(Scanner scanner) {
        System.out.print("Ingrese el nombre del gato: ");
        String nombre = scanner.nextLine();
        GatoSimple gato = buscarGatoPorNombre(nombre);
        if (gato != null) {
            gatos.remove(gato);
            System.out.println("Gato eliminado correctamente.");
        } else {
            System.out.println("Gato no encontrado.");
        }
    }

    // Método para mostrar todos los gatos
    private static void mostrarGatos() {
        if (gatos.isEmpty()) {
            System.out.println("No hay gatos para mostrar.");
        } else {
            for (GatoSimple gato : gatos) {
                System.out.println(gato);
                gato.maullar();
                gato.ronronear();
            }
        }
    }

    // Método para crear un gato contrincante y hacer que peleen
    private static void pelearGatos(Scanner scanner) {
        System.out.println("Datos del gato contrincante:");
        crearGato(scanner);
        System.out.print("Ingrese el nombre del gato con el que peleará: ");
        String nombre = scanner.nextLine();
        GatoSimple gato = buscarGatoPorNombre(nombre);
        if (gato != null) {
            GatoSimple gatoContrincante = gatos.last();  // Último agregado será el contrincante
            gato.pelear(gatoContrincante);
        } else {
            System.out.println("Gato no encontrado.");
        }
    }

    // Método para buscar un gato por su nombre
    private static GatoSimple buscarGatoPorNombre(String nombre) {
        for (GatoSimple gato : gatos) {
            if (gato.getNombre().equalsIgnoreCase(nombre)) {
                return gato;
            }
        }
        return null;
    }
}