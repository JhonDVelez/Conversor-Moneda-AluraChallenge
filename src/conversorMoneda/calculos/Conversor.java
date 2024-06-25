package conversorMoneda.calculos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import conversorMoneda.modelos.MonedaExcApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private final Gson gson;

    public Conversor() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public MonedaExcApi hacerConversion(String monedaEntrada,String monedaSalida, double cantidad){
        String apiKey = "6eb9e1656ba03806c6a7f0f4";
        String direccion = "https://v6.exchangerate-api.com/v6/"+ apiKey +"/pair/"+
                monedaEntrada +"/"+ monedaSalida + "/" + cantidad;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            //System.out.println(json);

            return gson.fromJson(json, MonedaExcApi.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Mensaje de error: "+e.getMessage());
        }
        return null;
    }
}
