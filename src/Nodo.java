public class Nodo {
    private double dato;
    private Nodo nodoSiguiente;

    public Nodo(double dato) {
        this.dato = dato;
    }

    // Getters y setters=====================================
    public double getDato() {
        return dato;
    }

    public void setDato(double dato) {
        this.dato = dato;
    }

    public Nodo getNodoSiguiente() {
        return nodoSiguiente;
    }

    public void setNodoSiguiente(Nodo nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    // ------------------------------------------------------
    @Override
    public String toString() {
        return "Nodo [dato=" + dato + ", nodoSiguiente=" + nodoSiguiente + "]";
    }
}
