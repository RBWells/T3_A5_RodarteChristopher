public class a_TEMPERATURAS {
    private double temperatura;
    private String fecha;

    public a_TEMPERATURAS(double temperaturas, String fecha){
        this.temperatura=temperaturas;
        this.fecha=fecha;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Registro de temperatura: "+getFecha()+" |Temperatura: "+getTemperatura()+" ";
    }
    

}
