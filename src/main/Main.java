package main;
import services.ConsultaMoneda;
import java.io.IOException;
import java.util.Scanner;
import static modelos.ConvertirMoneda.mostrarMenu;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese la cantidad de Dólares a convertir: ");
                    double valorAConvertir = scanner.nextDouble();
                    try {
                        System.out.println(consulta.buscarMonedas("USD", "ARS", valorAConvertir));
                    } catch (IOException | InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Ingrese la cantidad de Pesos argentinos a convertir: ");
                    double valorAConvertir = scanner.nextDouble();
                    try {
                        System.out.println(consulta.buscarMonedas("ARS", "USD", valorAConvertir));
                    } catch (IOException | InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Ingrese la cantidad de Dólares a convertir: ");
                    double valorAConvertir = scanner.nextDouble();
                    try {
                        System.out.println(consulta.buscarMonedas("USD", "BRL", valorAConvertir));
                    } catch (IOException | InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese la cantidad de Reales brasileños a convertir: ");
                    double valorAConvertir = scanner.nextDouble();
                    try {
                        System.out.println(consulta.buscarMonedas("BRL", "USD", valorAConvertir));
                    } catch (IOException | InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.println("Ingrese la cantidad de Dólares a convertir: ");
                    double valorAConvertir = scanner.nextDouble();
                    try {
                        System.out.println(consulta.buscarMonedas("USD", "COP", valorAConvertir));
                    } catch (IOException | InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("Ingrese la cantidad de Pesos colombianos a convertir: ");
                    double valorAConvertir = scanner.nextDouble();
                    try {
                        System.out.println(consulta.buscarMonedas("COP", "USD", valorAConvertir));
                    } catch (IOException | InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 7 -> System.out.println("Gracias por usar el conversor de moneda.");
                default -> System.out.println("Opción no válida. Por favor, elija una opción del 1 al 7.");
            }
            break;

        } while (opcion != 7);

        scanner.close();
    }
}
