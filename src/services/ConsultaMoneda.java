package services;
import com.google.gson.Gson;
import modelos.Monedas;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Monedas buscarMonedas (String monedaBase, String monedaDestino) throws IOException, InterruptedException {

        // Crear la URI para la solicitud
        String apiKey = System.getenv("API_KEY");
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/".concat(apiKey)+"/pair/"+monedaBase+"/"+monedaDestino);

        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Crear la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        // Enviar la solicitud y recibir la respuesta
        HttpResponse<String> response;

        try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("No se encontró esa moneda.");
        }

        return new Gson().fromJson(response.body(), Monedas.class);

    }
}

