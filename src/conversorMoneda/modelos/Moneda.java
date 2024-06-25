package conversorMoneda.modelos;

public class Moneda {
    private String nombre;
    private double valor;

    public Moneda(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public Moneda(MonedaExcApi monedaExcApi){
        this.nombre = monedaExcApi.target_code();
        this.valor = monedaExcApi.conversion_result();
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }
}
