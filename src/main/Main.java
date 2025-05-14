package main;
import modelos.ConvertirMoneda;
import services.ConsultaMoneda;
import java.io.IOException;
import java.util.Scanner;
import static modelos.ConvertirMoneda.mostrarMenu;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        
        int opcion = 0;

        while (opcion != 8) {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ConvertirMoneda.convertir("USD", "ARS", consulta, scanner);
                    break;
                case 2:
                    ConvertirMoneda.convertir("ARS", "USD", consulta, scanner);
                    break;
                case 3:
                    ConvertirMoneda.convertir("USD", "BRL", consulta, scanner);
                    break;
                case 4:
                    ConvertirMoneda.convertir("BRL", "USD", consulta, scanner);
                    break;
                case 5:
                    ConvertirMoneda.convertir("USD", "COP", consulta, scanner);
                    break;
                case 6:
                    ConvertirMoneda.convertir("COP", "USD", consulta, scanner);
                    break;
                case 7:
                    ConvertirMoneda.convertirOtraMoneda(consulta, scanner);
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
                    break;
            }
        }
    }
}
