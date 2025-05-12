package modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedas {

    public Monedas buscarMonedas (String monedaBase, String monedaDestino, double valorAConvertir) throws IOException, InterruptedException {

        // Crear la URI para la solicitud
        String apiKey = System.getenv("API_KEY");
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/".concat(apiKey)+"/pair/"
                +monedaBase+"/"+monedaDestino+"/"+valorAConvertir);

        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Crear la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response;

        try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("No se encontró esa moneda.");
        }

        return new Gson().fromJson(response.body(), Monedas.class);

    }

    public static void mostrarMenu() {
        System.out.println("""
        ******************************************************
        Sea Bienvenido/a al Conversor de Monedas
        
        1) Dólar =>> Peso argentino
        2) Peso argentino =>> Dólar
        3) Dólar =>> Real brasileño
        4) Real brasileño =>> Dólar
        5) Dólar =>> Peso colombiano
        6) Peso colombiano =>> Dólar
        7) Salir
        ******************************************************
        Elija una opción válida:
        """);
    }
}

