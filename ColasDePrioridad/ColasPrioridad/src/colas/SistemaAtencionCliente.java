package colas;

/**
 *
 *
 * @author Steven Gracia (stevengilbertayala@gmail.com)
 */
public class SistemaAtencionCliente {
    private ColaDePrioridad<Cliente> colaPrioridad;

    public SistemaAtencionCliente() {
        this.colaPrioridad = new ColaDePrioridad<>();
    }

    /**
     * Agrega un nuevo cliente a la cola de prioridad.
     *
     * @param nombre         El nombre del cliente.
     * @param nivelPrioridad El nivel de prioridad del cliente.
     */
    public void llegadaCliente(String nombre, int nivelPrioridad) {
        Cliente cliente = new Cliente(nombre, nivelPrioridad);
        colaPrioridad.encolar(cliente, String.valueOf(nivelPrioridad));
    }

    public Cliente atenderCliente() {
        return colaPrioridad.desencolar();
    }

    public void mostrarCola() {
        if (colaPrioridad.estaVacia()) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("Elementos de la cola:");
            NodoCola<Cliente> actual = colaPrioridad.getInicioCola();
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
        }
    }

    public int atenderSiguientesClientes() {
        int clientesAtendidos = 0;
        int[] clientesPorPrioridad = new int[3];  // 0: Altos, 1: Medios, 2: Bajos

        // Atender clientes con prioridad alta
        while (!colaPrioridad.estaVacia() && clientesPorPrioridad[0] < 3) {
            Cliente cliente = colaPrioridad.desencolar();
            if (cliente.getPrioridad() >= 8) {
                System.out.println("Atendiendo al cliente: " + cliente);
                clientesAtendidos++;
                clientesPorPrioridad[0]++;
            } else {
                // Volver a encolar el cliente en la cola
                colaPrioridad.encolar(cliente, String.valueOf(cliente.getPrioridad()));
                break;
            }
        }

        // Atender clientes con prioridad media
        while (!colaPrioridad.estaVacia() && clientesPorPrioridad[1] < 2) {
            Cliente cliente = colaPrioridad.desencolar();
            if (cliente.getPrioridad() >= 5 && cliente.getPrioridad() < 8) {
                System.out.println("Atendiendo al cliente: " + cliente);
                clientesAtendidos++;
                clientesPorPrioridad[1]++;
            } else {
                // Volver a encolar el cliente en la cola
                colaPrioridad.encolar(cliente, String.valueOf(cliente.getPrioridad()));
                break;
            }
        }

        // Atender clientes con prioridad baja
        while (!colaPrioridad.estaVacia() && clientesPorPrioridad[2] < 1) {
            Cliente cliente = colaPrioridad.desencolar();
            if (cliente.getPrioridad() < 5) {
                System.out.println("Atendiendo al cliente: " + cliente);
                clientesAtendidos++;
                clientesPorPrioridad[2]++;
            } else {
                // Volver a encolar el cliente en la cola
                colaPrioridad.encolar(cliente, String.valueOf(cliente.getPrioridad()));
                break;
            }
        }

        return clientesAtendidos;
    }


}