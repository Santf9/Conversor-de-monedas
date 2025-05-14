package services;
import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import modelos.Monedas;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    // Metodo para buscar la tasa de conversión entre dos monedas
    public static Monedas buscarMonedas(String monedaBase, String monedaDestino) {

        // Cargamos el archivo .env
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");

        // Crear la URI para la solicitud a consumir
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+monedaBase+"/"+monedaDestino);

        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Crear la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Enviar la solicitud y recibir la respuesta
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            // Mapear el JSON a la clase Monedas
            return new Gson().fromJson(response.body(), Monedas.class);

        } catch (Exception e) {
            throw new RuntimeException("Error al procesar la respuesta de la API: " + e.getMessage());
        }
    }
}

