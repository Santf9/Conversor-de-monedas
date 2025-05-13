package modelos;
import services.ConsultaMoneda;

import java.io.IOException;
import java.util.Scanner;

public class ConvertirMoneda {
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

    public static void convertirOtraMoneda (ConsultaMoneda consulta, Scanner lectura) throws IOException, InterruptedException {
        System.out.println("Ingrese el codigo de la moneda base:");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese la moneda objetivo:");
        String monedaObjetivo = lectura.nextLine().toUpperCase();
        convertir(monedaBase, monedaObjetivo, consulta, lectura);
    }

    public static void mostrarMenu() {
        System.out.println("""
        ******************************************************
        🪙🪙 Bienvenido/a al Conversor de Monedas 🪙🪙
        ******************************************************
        1) Dólar ==>> Peso argentino
        2) Peso argentino ==>> Dólar
        3) Dólar ==>> Real brasileño
        4) Real brasileño ==>> Dólar
        5) Dólar ==>> Peso colombiano
        6) Peso colombiano ==>> Dólar
        7) Convertir otras monedas
        8) Salir
        ******************************************************
        Elija una opción válida:
        """);
    }
}
