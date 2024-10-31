package Act;

import java.util.HashSet;
import java.util.Scanner;

class ComponenteCPU {
    private String componente;
    private String marca;
    private int cantidad;
    private double precio;

    public ComponenteCPU(String componente, String marca, int cantidad, double precio) {
        this.componente = componente;
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public double costoTotal() {
        return cantidad * precio;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10s %-8d %.2f %.2f", componente, marca, cantidad, precio, costoTotal());
    }
}

class Computadora {
    private String marca;
    private String modelo;
    private HashSet<ComponenteCPU> componentes;

    public Computadora(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.componentes = new HashSet<>();
    }

    public void agregarComponente(ComponenteCPU componente) {
        componentes.add(componente);
    }

    public double costoTotal() {
        double total = 0;
        for (ComponenteCPU componente : componentes) {
            total += componente.costoTotal();
        }
        return total;
    }

    public double precioSugerido() {
        double costo = costoTotal();
        double porcentaje = costo < 50000 ? 0.4 : 0.3;
        return costo + (costo * porcentaje);
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Componentes:");
        System.out.printf("Componente", "Marca", "Cantidad", "Precio", "SubTotal");
        for (ComponenteCPU componente : componentes) {
            System.out.println(componente);
        }
        System.out.printf("Costo Total: ", costoTotal());
        System.out.printf("Precio Sugerido de Venta: ", precioSugerido());
    }
}

public class Parte_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingrese la marca de la computadora: ");
            String marca = scanner.nextLine();
            System.out.print("Ingrese el modelo de la computadora: ");
            String modelo = scanner.nextLine();

            Computadora computadora = new Computadora(marca, modelo);
            while (true) {
                System.out.print("Ingrese el componente (o 'fin' para terminar): ");
                String componente = scanner.nextLine();
                if (componente.equalsIgnoreCase("fin")) {
                    break;
                }
                System.out.print("Ingrese la marca del componente: ");
                String marcaComponente = scanner.nextLine();
                System.out.print("Ingrese la cantidad: ");
                int cantidad = Integer.parseInt(scanner.nextLine());
                System.out.print("Ingrese el precio por unidad: ");
                double precio = Double.parseDouble(scanner.nextLine());

                ComponenteCPU nuevoComponente = new ComponenteCPU(componente, marcaComponente, cantidad, precio);
                computadora.agregarComponente(nuevoComponente);
            }

            computadora.mostrarInfo();

            System.out.print("¿Desea cotizar una nueva computadora? (si/no): ");
            String continuar = scanner.nextLine();
            if (continuar.equalsIgnoreCase("no")) {
                break;
            }
        }
    }
}
