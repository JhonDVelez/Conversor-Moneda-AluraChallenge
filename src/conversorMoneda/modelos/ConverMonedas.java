package conversorMoneda.modelos;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ConverMonedas {
    private final Moneda monedaEntrada;
    private final Moneda monedaSalida;
    private final double tasaConversion;
    private final LocalTime tiempo;

    public ConverMonedas(Moneda monedaEntrada, Moneda monedaSalida, LocalTime tiempo) {
        this.monedaEntrada = monedaEntrada;
        this.monedaSalida = monedaSalida;
        this.tasaConversion = monedaSalida.getValor()/monedaEntrada.getValor();
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatTiempo
                = DateTimeFormatter.ISO_TIME;
        NumberFormat formatDinero = NumberFormat.getCurrencyInstance();
        return  "Hora: "+tiempo.format(formatTiempo) + " - " +
                "El valor " + formatDinero.format(monedaEntrada.getValor()) + " [" + monedaEntrada.getNombre() + "] " +
                "corresponde al valor final de =>>> " +
                formatDinero.format(monedaSalida.getValor()) + " [" + monedaSalida.getNombre() + "] " +
                "con una tasa de conversion de =>>> " + tasaConversion;
    }
}
