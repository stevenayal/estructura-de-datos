package colas;

/**
 * Clase de prueba Cola
 *
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public class PruebaCola {

    public static void main(String[] args) {

        Cola<Integer> cola = new Cola<>();
        try {
            Cola.encolar(1);
            Cola.encolar(2);
            Cola.encolar(3);

            int tam = cola.tamanoCola();
            for (int idx = 1; idx <= tam; idx++) {
                System.out.println("Valor " + idx + ": " + cola.desencolar());
            }
        } catch (Exception e) {
            System.out.println("Error al ejecutar el programa. " + e.getMessage());
        }

    }
}
