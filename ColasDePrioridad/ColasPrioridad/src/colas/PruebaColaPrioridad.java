package colas;

import java.util.Random;

/**
 * Clase de prueba Cola Prioridad
 *
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public class PruebaColaPrioridad {

    public static void main(String[] args) {

        ColaDePrioridad<String> cola = new ColaDePrioridad<>();
        String[] prioridades = {"ALTA", "MEDIA", "BAJA"};
        int cantidadClientes = 0;
        Random random = new Random();
        try {
            for (int i = 0; i < Nombres.data.length; i++) {
                int prioridad = random.nextInt(3);
                cola.encolar(Nombres.data[i], prioridades[prioridad]);
            }

            String cliente;
            while ((cliente = cola.desencolarComoCadena()) != null) {
                System.out.println("Cliente atendido: " + cliente);
                cantidadClientes++;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Cantidad de clientes atendidos: " + cantidadClientes);

    }
}
