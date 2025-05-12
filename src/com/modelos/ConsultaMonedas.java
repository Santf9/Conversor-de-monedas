package com.modelos;

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
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/".concat(apiKey) + "/pair/"
                .concat(monedaBase) + "/".concat(monedaDestino) + "/" + valorAConvertir);

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

    public void mostrarMenu() {
        System.out.println("Bienvenido a la API de conversión de monedas");
        System.out.println("Por favor, ingrese la moneda base:");
        System.out.println("Por favor, ingrese la moneda destino:");
        System.out.println("Por favor, ingrese el valor a convertir:");
    }
}

