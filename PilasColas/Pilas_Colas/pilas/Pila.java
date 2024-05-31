package pilas;

/**
 * Clase que implementa una Pila mediante Referencias ("punteros").
 * Para asegurarnos de que se defina minimamente lo especificado por la {@link InterfazPila},
 * esta clase implementa dicha Interfaz.
 * <p>
 * Para evitar tener una version de esta clase por cada tipo de dato, se utiliza
 * Generics de Java para generalizar y parametrizar el tipo de dato a almacenar.
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro de la cola
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public class Pila<TipoDeDato> implements InterfazPila<TipoDeDato> {

    private NodoPila<TipoDeDato> cabecera;
    private int tamanoPila;
    
    /**
     * Constructor de la clase, se inicializa la pila
     */
    public Pila() {
        tamanoPila = 0;
        cabecera = new NodoPila<>();
        cabecera.siguiente = null;
    }
    
    @Override
    public void apilar(TipoDeDato nuevoDato){
    	NodoPila<TipoDeDato> nuevoNodo = new NodoPila<>();
        nuevoNodo.dato = nuevoDato;
        nuevoNodo.siguiente = cabecera.siguiente;
        cabecera.siguiente = nuevoNodo;
        tamanoPila = tamanoPila + 1;
    }
    
    @Override
    //Si se intenta desapilar algo de una lista vacia, retorna null
    public TipoDeDato desapilar(){
    	TipoDeDato ret = null;
    	if (!esVacia()) {
    	    ret = cabecera.siguiente.dato;
            cabecera.siguiente = cabecera.siguiente.siguiente;
            tamanoPila = tamanoPila - 1;
        }
        return ret;
    }
    
    @Override
    //Si se intenta obtener algo de una lista vacia, retorna null
    public TipoDeDato obtenerTope(){
    	TipoDeDato ret = null;
    	if (!esVacia()) {
    	    ret = cabecera.siguiente.dato;            
        }
        return ret;
    }
    
    @Override
    public void anular(){
    	cabecera.siguiente = null;
    	tamanoPila = 0;
    }
    
    @Override
    public int tamanoPila() {
        return tamanoPila;
    }

    @Override
    public boolean esVacia() {
        return tamanoPila == 0;
    }    
        
}
