package conversorMoneda.modelos;

public class ConverMonedas {
    private Moneda monedaEntrada;
    private Moneda monedaSalida;
    private double tasaConversion;

    public ConverMonedas(Moneda monedaEntrada, Moneda monedaSalida) {
        this.monedaEntrada = monedaEntrada;
        this.monedaSalida = monedaSalida;
        this.tasaConversion = monedaSalida.getValor()/monedaEntrada.getValor();
    }

    @Override
    public String toString() {
        return "El valor " + monedaEntrada.getValor() + " [" + monedaEntrada.getNombre() + "] " +
                "corresponde al valor final de =>>> " +
                monedaSalida.getValor() + " [" + monedaSalida.getNombre() + "] " +
                "con una tasa de conversion de =>>> " + tasaConversion + "\n";
    }
}
