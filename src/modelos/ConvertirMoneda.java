package modelos;
import services.ConsultaMoneda;

import java.io.IOException;
import java.util.Scanner;

public class ConvertirMoneda {
    // Metodo para convertir de una moneda a otra
    public static void convertir (String monedaBase, String monedaDestino, ConsultaMoneda consulta, Scanner lectura) throws IOException, InterruptedException {
        double cantidad;
        double cantidadConvertida;

        Monedas monedas = consulta.buscarMonedas(monedaBase, monedaDestino);
        System.out.println("La Tasa de conversion para hoy\n" + monedaBase + " = " + monedas.conversion_rate() + " " + monedaDestino);
        System.out.println("Ingrese la cantidad de " + monedaBase + ": ");
        cantidad = Double.parseDouble(lectura.nextLine());
        cantidadConvertida = cantidad * monedas.conversion_rate();
        System.out.println(cantidad + " " + monedaBase + " = " + cantidadConvertida + " " + monedas.target_code());

    }

    // Metodo para convertir otro tipo de monedas
    public static void convertirOtraMoneda (ConsultaMoneda consulta, Scanner lectura) throws IOException, InterruptedException {
        System.out.println("Ingrese el código de la moneda Base: ");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese la moneda Destino a convertir: ");
        String monedaDestino = lectura.nextLine().toUpperCase();
        convertir(monedaBase, monedaDestino, consulta, lectura);
    }

    // Metodo que muestra el menu de opciones
    public static void mostrarMenu() {
        System.out.println("""
        ******************************************************
        🪙🪙 Bienvenido/a al Conversor de Monedas 🪙🪙
        ******************************************************
        1) Dólar("USD") ===> Peso Argentino("ARS")
        2) Peso Argentino("ARS") ===> Dólar("USD")
        3) Dólar("USD") ===> Real Brasileño("BRL")
        4) Real Brasileño("BRL") ===> Dólar("USD")
        5) Dólar("USD") ===> Peso Colombiano("COP")
        6) Peso Colombiano("COP") ===> Dólar("USD")
        7) Convertir otras monedas
        8) Salir
        ******************************************************
        Elija una opción válida:
        """);
    }
}
