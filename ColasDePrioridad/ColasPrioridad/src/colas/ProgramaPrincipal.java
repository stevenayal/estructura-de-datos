package colas;

import java.util.Scanner;

/**
 * Sistema de Atencion al Cliente.
 *
 * @author Steven Gracia (stevengilbertayala@gmail.com)
 */
public class ProgramaPrincipal {
    public static void main(String[] args) {
        SistemaAtencionCliente sistemaAtencion = new SistemaAtencionCliente();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenu del Sistema de Atencion al Cliente:");
            System.out.println("1. Agregar un nuevo cliente");
            System.out.println("2. Atender al siguiente cliente");
            System.out.println("3. Mostrar la cola de clientes");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion (1-4): ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); //  salto de linea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el nivel de prioridad del cliente (1-10): ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine(); // consumir el salto de linea
                    sistemaAtencion.llegadaCliente(nombre, prioridad);
                    System.out.println("Cliente agregado a la cola de atencion.");
                    break;

                case 2:
                    int clientesAtendidos = sistemaAtencion.atenderSiguientesClientes();
                    System.out.println("Se han atendido " + clientesAtendidos + " clientes.");
                    break;
                case 3:
                    System.out.println("Cola de clientes en orden de prioridad:");
                    sistemaAtencion.mostrarCola();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
        }
    }
}