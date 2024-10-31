package Act;

import java.util.HashMap;
import java.util.Scanner;

public class Parte_A {
    private HashMap<String, Long> agenda;

    public Parte_A() {
        agenda = new HashMap<>();
    }

    public void cargarDatos() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingrese el nombre completo: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el teléfono: ");
            Long telefono = Long.parseLong(scanner.nextLine());

            if (agenda.containsKey(nombre)) {
                System.out.println("El nombre ya existe en la agenda.");
            } else {
                agenda.put(nombre, telefono);
                System.out.println("Contacto agregado.");
            }

            System.out.print("¿Desea agregar otro contacto? (si/no): ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("si")) {
                break;
            }
        }
    }

    public void buscarTelefono() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la persona a buscar: ");
        String nombre = scanner.nextLine();
        if (agenda.containsKey(nombre)) {
            System.out.println("Teléfono: " + agenda.get(nombre));
        } else {
            System.out.println("La persona buscada no se encuentra en la agenda.");
        }
    }

    public void listarAgenda() {
        System.out.println("Lista de contactos:");
        for (String nombre : agenda.keySet()) {
            System.out.println("Nombre: " + nombre + ", Telefono: " + agenda.get(nombre));
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cargar Datos en la Agenda");
            System.out.println("2. Buscar Teléfono por Nombre");
            System.out.println("3. Listar Agenda");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    cargarDatos();
                    break;
                case 2:
                    buscarTelefono();
                    break;
                case 3:
                    listarAgenda();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción invalida. Intente nuevamente.");
            }
        }
    }

    public static void main(String[] args) {
        Parte_A agenda = new Parte_A();
        agenda.menu();
    }
}
