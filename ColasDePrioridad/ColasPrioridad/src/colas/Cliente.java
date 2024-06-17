package colas;
/**
 *
 *
 * @author Steven Gracia (stevengilbertayala@gmail.com)
 */
public class Cliente {
        private String nombre;
        private int nivelPrioridad;

        /**
         * Constructor de la clase Cliente.
         *
         * @param nombre          El nombre del cliente.
         * @param nivelPrioridad  El nivel de prioridad del cliente.
         */
        public Cliente(String nombre, int nivelPrioridad) {
            this.nombre = nombre;
            this.nivelPrioridad = nivelPrioridad;
        }

        /**
         * Obtiene el nombre del cliente.
         *
         * @return El nombre del cliente.
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Establece el nombre del cliente.
         *
         * @param nombre El nombre del cliente.
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        /**
         * Obtiene el nivel de prioridad del cliente.
         *
         * @return El nivel de prioridad del cliente.
         */
        public int getNivelPrioridad() {
            return nivelPrioridad;
        }

        /**
         * Establece el nivel de prioridad del cliente.
         *
         * @param nivelPrioridad El nivel de prioridad del cliente.
         */
        public void setNivelPrioridad(int nivelPrioridad) {
            this.nivelPrioridad = nivelPrioridad;
        }

        /**
         * Devuelve una representación en cadena del objeto Cliente.
         *
         * @return Una cadena que representa al Cliente.
         */
        @Override
        public String toString() {
            return "Cliente{" +
                    "nombre='" + nombre + '\'' +
                    ", nivelPrioridad=" + nivelPrioridad +
                    '}';
        }
    public int getPrioridad() {
        return this.nivelPrioridad;
    }



}
