package colas;

/**
 * Clase que implementa una Cola mediante Referencias ("punteros").
 * Para asegurarnos de que se defina minimamente lo especificado por la {@link InterfazCola},
 * esta clase implementa dicha Interfaz.
 * <p>
 * Para evitar tener una version de esta clase por cada tipo de dato, se utiliza
 * Generics de Java para generalizar y parametrizar el tipo de dato a almacenar.
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro de la cola
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public class Cola<TipoDeDato> implements InterfazCola<TipoDeDato> {

    private NodoCola<TipoDeDato> iniCola;
    private NodoCola<TipoDeDato> finCola;
    private int tamanoCola;
    private int maxTamanoCola;

    /**
     * Constructor de la clase, se inicializa la cola
     */
    public Cola() {
        tamanoCola = 0;
        iniCola = null;
        finCola = null;
        this.maxTamanoCola = Integer.MAX_VALUE; // Valor por defecto
    }

    public Cola(int maxTamanoCola) {
        tamanoCola = 0;
        iniCola = null;
        finCola = null;
        this.maxTamanoCola = maxTamanoCola;
    }

    public static void encolar(int i) {
    }

    @Override
    public void encolar(Cliente nuevoDato) {
        if (tamanoCola < maxTamanoCola) {
            NodoCola<TipoDeDato> nuevoNodo = new NodoCola<>();
            nuevoNodo.dato = nuevoDato;
            nuevoNodo.siguiente = null;

            if (esVacia()) {
                iniCola = nuevoNodo;
                finCola = nuevoNodo;
            } else {
                finCola.siguiente = nuevoNodo;
                finCola = nuevoNodo;
            }

            tamanoCola = tamanoCola + 1;
        } else {
            throw new IllegalStateException("La cola está llena, no se pueden agregar más elementos.");
        }
    }

    @Override
    public TipoDeDato desencolar() {
        TipoDeDato ret = null;
        if (!esVacia()) {
            ret = (TipoDeDato) iniCola.dato;
            iniCola = iniCola.siguiente;
            tamanoCola = tamanoCola - 1;
        }
        return ret;
    }

    @Override
    public TipoDeDato obtenerFrente() {
        TipoDeDato ret = null;
        if (!esVacia()) {
            ret = (TipoDeDato) iniCola.dato;
        }
        return ret;
    }

    @Override
    public void anular() {
        tamanoCola = 0;
        iniCola = null;
        finCola = null;
    }

    @Override
    public int tamanoCola() {
        return tamanoCola;
    }

    @Override
    public boolean contiene(TipoDeDato elemento) {
        boolean encontrado = false;
        NodoCola<TipoDeDato> actual = iniCola;
        while (actual != null) {
            if (actual.dato.equals(elemento)) {
                encontrado = true;
                break;
            }
            actual = actual.siguiente;
        }
        return encontrado;
    }

    @Override
    public boolean esVacia() {
        return iniCola == null;
    }

    @Override
    public boolean estaLlena() {
        return false;
    }

    /**
     * Método que devuelve el nodo del inicio de la Cola.
     *
     * @return Nodo del inicio de la Cola.
     */
    public NodoCola<TipoDeDato> getInicioCola() {
        return iniCola;
    }

    public void iFrente() {
    }
}