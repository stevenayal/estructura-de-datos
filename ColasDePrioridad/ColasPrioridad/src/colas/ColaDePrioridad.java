package colas;

/**
 * Clase que implementa una Cola de Prioridad mediante {@link Cola} internas.
 * <p>
 * Para evitar tener una version de esta clase por cada tipo de dato, se utiliza
 * Generics de Java para generalizar y parametrizar el tipo de dato a almacenar.
 *
 *   Explicacion: Esta clase implementa una cola de prioridad que permite encolar
 *   y desencolar elementos según su prioridad, utilizando tres colas internas: prioridadAltas,
 *   prioridadMedia y prioridadBaja.
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro de la cola
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public class ColaDePrioridad<TipoDeDato> {

	private Cola<TipoDeDato> prioridadAltas = new Cola<>();
	private Cola<TipoDeDato> prioridadMedia = new Cola<>();
	private Cola<TipoDeDato> prioridadBaja = new Cola<>();


	public void encolar(TipoDeDato nuevoDato, String s) {
		// Determinar la prioridad del Cliente y encolarlo en la cola correspondiente
		if (nuevoDato instanceof Cliente) {
			Cliente cliente = (Cliente) nuevoDato;
			encolar(cliente);
		} else {
			throw new IllegalArgumentException("El dato encolado debe ser de tipo Cliente");
		}
	}

	public void encolar(Cliente cliente) {
		if (cliente.getPrioridad() == 1) {
			prioridadAltas.encolar(cliente);
		} else if (cliente.getPrioridad() == 2) {
			prioridadMedia.encolar(cliente);
		} else {
			prioridadBaja.encolar(cliente);
		}
	}
/*
El metodo desencolar() devuelve el siguiente elemento en la cola,
priorizando los elementos de mayor prioridad.
 */
	public TipoDeDato desencolar() {
		TipoDeDato ret = null;

		if (!prioridadAltas.esVacia()) {
			ret = prioridadAltas.desencolar();
		} else if (!prioridadMedia.esVacia()) {
			ret = prioridadMedia.desencolar();
		} else {
			ret = prioridadBaja.desencolar();
		}

		return ret;
	}

	public String desencolarComoCadena() {
		TipoDeDato ret;
		String out = null;

		if (!prioridadAltas.esVacia()) {
			ret = prioridadAltas.desencolar();
			out = "[ALTA] " + ret.toString();
		} else if (!prioridadMedia.esVacia()) {
			ret = prioridadMedia.desencolar();
			out = "[MEDIA] " + ret.toString();
		} else if (!prioridadBaja.esVacia()) {
			ret = prioridadBaja.desencolar();
			out = "[BAJA] " + ret.toString();
		} else {
			System.out.println("*** Colas vacías *** ");
		}

		return out;
	}

	public boolean estaVacia() {
		return prioridadAltas.esVacia() && prioridadMedia.esVacia() && prioridadBaja.esVacia();
	}
	public NodoCola<TipoDeDato> getInicioCola() {
		if (!prioridadAltas.esVacia()) {
			return prioridadAltas.getInicioCola();
		} else if (prioridadMedia.esVacia()) {
            if (!prioridadBaja.esVacia()) {
                return prioridadBaja.getInicioCola();
            } else {
                return null; // Devuelve null si las colas están vacías
            }
        } else {
            return prioridadMedia.getInicioCola();
        }
    }
	public NodoCola<Cliente> getInicioColaClientes() {
		NodoCola<TipoDeDato> inicio = getInicioCola();
		if (inicio != null) {
			return (NodoCola<Cliente>) inicio;
		} else {
			return null;
		}
	}

	public boolean esVacia() {
		// Implementación específica de la clase ColaDePrioridad
		// Debería verificar si todas las colas de prioridad están vacías
		return prioridadAltas.esVacia() && prioridadMedia.esVacia() && prioridadBaja.esVacia();
	}
}

