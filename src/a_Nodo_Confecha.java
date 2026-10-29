public class a_Nodo_Confecha {
    private a_TEMPERATURAS temps;
    private a_Nodo_Confecha nodoSiguiente;

    public a_Nodo_Confecha(a_TEMPERATURAS temp){
        this.temps=temp;
    }

    public a_TEMPERATURAS getTemps() {
        return temps;
    }

    public void setTemps(a_TEMPERATURAS temps) {
        this.temps = temps;
    }

    public a_Nodo_Confecha getNodoSiguiente() {
        return nodoSiguiente;
    }

    public void setNodoSiguiente(a_Nodo_Confecha nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    @Override
    public String toString() {
        return "a_Nodo_Confecha [temps=" + temps + ", nodoSiguiente=" + nodoSiguiente + "]";
    }
}
