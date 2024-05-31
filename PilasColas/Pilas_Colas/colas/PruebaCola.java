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
            cola.encolar(1);
            cola.encolar(2);
            cola.encolar(3);

            int n = cola.tamanoCola();
            for (int i = 1; i <= n; i++) {
                System.out.println("Valor " + i + ": " + cola.desencolar());
            }
        } catch (Exception e) {
            System.out.println("Error al ejecutar el programa. " + e.getMessage());
        }

    }
}
