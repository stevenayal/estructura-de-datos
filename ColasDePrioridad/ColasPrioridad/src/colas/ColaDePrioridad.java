package colas;

/**
 * Clase que implementa una Cola de Prioridad mediante {@link Cola} internas.
 * <p>
 * Para evitar tener una version de esta clase por cada tipo de dato, se utiliza
 * Generics de Java para generalizar y parametrizar el tipo de dato a almacenar.
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro de la cola
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public class ColaDePrioridad<TipoDeDato> {

	private Cola<TipoDeDato> prioridadAltas = new Cola<>();
	private Cola<TipoDeDato> prioridadMedia = new Cola<>();
	private Cola<TipoDeDato> prioridadBaja = new Cola<>();

	public void encolar(TipoDeDato nuevoDato, String prioridad) {

		if (prioridad.equalsIgnoreCase("ALTA")) {
			prioridadAltas.encolar(nuevoDato);
		} else if (prioridad.equalsIgnoreCase("MEDIA")) {
			prioridadMedia.encolar(nuevoDato);
		} else {
			prioridadBaja.encolar(nuevoDato);
		}

	}

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

}
