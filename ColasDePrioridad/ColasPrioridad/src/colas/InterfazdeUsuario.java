package colas;
import java.util.Scanner;

public class InterfazdeUsuario {
    private static ColaDePrioridad<Cliente> colaDePrioridad = new ColaDePrioridad<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            procesarOpcion(opcion);
        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("_________________________________________________________________________________");
        System.out.println("Bienvenido al Sistema de Atención al Cliente - DESARROLLO III ");
        System.out.println("1. Añadir nuevo cliente");
        System.out.println("2. Atender siguiente cliente");
        System.out.println("3. Mostrar cola de espera");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        System.out.println("\n DESARROLLO REALIZADO POR STEVEN GRACIA");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarNuevoCliente();
                break;
            case 2:
                atenderSiguienteCliente();
                break;
            case 3:
                mostrarColaDeEspera();
                break;
            case 4:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }

    private static void agregarNuevoCliente() {
        String nombre;
        int prioridad;

        // Validar que el nombre del cliente no esté vacío
        do {
            System.out.print("Ingrese el nombre del cliente: ");
            nombre = scanner.nextLine();
            if (nombre.trim().isEmpty()) {
                System.out.println("El nombre del cliente no puede estar vacío. Por favor, ingrese un nombre válido.");
            }
        } while (nombre.trim().isEmpty());

        // Validar que la prioridad del cliente esté entre 1 y 3
        while (true) {
            System.out.print("Ingrese la prioridad del cliente (1, 2 o 3): ");
            String prioridadInput = scanner.nextLine();
            if (prioridadInput.matches("[123]")) {
                prioridad = Integer.parseInt(prioridadInput);
                break;
            } else {
                System.out.println("La prioridad del cliente debe ser 1, 2 o 3. Por favor, ingrese una prioridad válida.");
            }
        }

        Cliente nuevoCliente = new Cliente(nombre, prioridad);
        colaDePrioridad.encolar(nuevoCliente);
        System.out.println("Cliente agregado a la cola de espera.");
    }

    private static void atenderSiguienteCliente() {
        Cliente clienteAtendido = colaDePrioridad.desencolar();
        if (clienteAtendido != null) {
            System.out.println("Atendiendo al cliente: " + clienteAtendido.getNombre());
        } else {
            System.out.println("No hay clientes en la cola de espera.");
        }
    }

    private static void mostrarColaDeEspera() {
        System.out.println("Cola de espera:");
        ColaDePrioridad<Cliente> colaTemp = new ColaDePrioridad<>();
        while (!colaDePrioridad.esVacia()) {
            Cliente cliente = colaDePrioridad.desencolar();
            System.out.println("- " + cliente.getNombre() + " (Prioridad " + cliente.getPrioridad() + ")");
            colaTemp.encolar(cliente);
        }
        while (!colaTemp.esVacia()) {
            colaDePrioridad.encolar(colaTemp.desencolar());
        }
    }
}