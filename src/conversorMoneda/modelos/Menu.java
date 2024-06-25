package conversorMoneda.modelos;

import conversorMoneda.calculos.Conversor;
import java.time.*;

import java.time.temporal.ChronoUnit;
import java.util.*;

public class Menu {
    private final List<String> nombreMoneda
            = new ArrayList<>(Arrays.asList("Dolar","Peso Argentino","Real Brasileño","Peso Colombiano", "Peso Mexicano",
            "Peso Cubano", "Boliviano de Bolivia", "Peso Chileno", "Colón Costarricense", "Quetzal Gualtemalteco"));
    private final List<String> codigoMoneda
            = new ArrayList<>(Arrays.asList("USD", "ARS", "BRL", "COP", "MXN",
            "CUP", "BOB", "CLP", "CRC", "GTQ"));

    public void mostrarMenu(){
        List<ConverMonedas> historial = new ArrayList<>();
        Scanner leer = new Scanner(System.in);
        Conversor conversor = new Conversor();
        while(true) {
            try {
                mostrarLista();
                int eleccion = Integer.parseInt(leer.nextLine());
                if(eleccion == codigoMoneda.size()*2-1) break;
                if(eleccion > 0 && eleccion < codigoMoneda.size()*2-1){
                    int eleccionMod = (int)(((double)eleccion/2)+0.5);
                    System.out.println("ingresa el valor que deseas convertir:");
                    double cantidad = Double.parseDouble(leer.nextLine());
                    Moneda monedaEntrada;
                    MonedaExcApi monedaExcApi;
                    if(eleccion%2 == 0) {
                        monedaEntrada = new Moneda(codigoMoneda.get(eleccionMod),cantidad);
                        monedaExcApi = conversor.hacerConversion(codigoMoneda.get(eleccionMod), codigoMoneda.getFirst(), cantidad);
                    }else{
                        monedaEntrada = new Moneda(codigoMoneda.getFirst(),cantidad);
                        monedaExcApi = conversor.hacerConversion(codigoMoneda.getFirst(), codigoMoneda.get(eleccionMod), cantidad);
                    }
                    Moneda monedaSalida = new Moneda(monedaExcApi);
                    LocalTime tiempo = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
                    ConverMonedas converMonedas = new ConverMonedas(monedaEntrada,monedaSalida,tiempo);
                    System.out.println(converMonedas + "\n");
                    historial.add(converMonedas);
                }
                else {
                    System.out.println("Ingresa una opcion valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Caracteres no validos por favor ingrese un numero");
            }
            System.out.println("Presione Enter para continuar...");
            leer.nextLine();
        }
        System.out.println("Conversor finalizado.");
        System.out.println("A continuacion se mostrara el historia de Conversiones...\n");
        for(ConverMonedas hist: historial){
            System.out.println(hist);
        }
    }

    private void mostrarLista(){
        System.out.println("********************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]\n");
        int cont = 1;
        for (int i = 1; i < nombreMoneda.size(); i++) {
            System.out.println(cont + ") " + nombreMoneda.getFirst() + " =>> " + nombreMoneda.get(i));
            System.out.println(cont+1 + ") " + nombreMoneda.get(i) + " =>> " + nombreMoneda.getFirst());
            cont += 2;
        }
        System.out.println(cont + ") Salir");
        System.out.println("Elija una opción valida:");
        System.out.println("********************************************************");
    }
}


