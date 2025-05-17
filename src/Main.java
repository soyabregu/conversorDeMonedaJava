import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner teclado = new Scanner(System.in);
        String monedaBase;
        String monedaAconvertir;
        double monto = 0;
        String continuar;

        String menu = """
                Puedes elegir entre los siguientes países. Ingresa la sigla correspondiente:
                
                Argentina: ARS (Peso Argentino)
                Brasil: BRL (Real Brasileño)
                Colombia: COP (Peso Colombiano)
                México: MXN (Peso Mexicano)
                Paraguay: PYG (Guaraní Paraguayo)
                Uruguay: UYU (Peso Uruguayo)
                Chile: CLP (Peso Chileno)
                Perú: PEN (Sol Peruano)
                Estados Unidos: USD (Dólar Estadounidense)
                Venezuela: VES (Bolívar Soberano)
                España: EUR (Euro)
                """;

        final String key = "/aafd4024a38845e16e3a0cd5";

        System.out.println("#### Bienvenido al conversor de moneda ####");
        System.out.println(menu);

        do {
            String entrada ="";
            System.out.print("Ingresa tu moneda base: ");
            monedaBase = teclado.nextLine();

            System.out.print("Ingresa la moneda a la que deseas convertir: ");
            monedaAconvertir = teclado.nextLine();

            //  Validación  del monto sin metodo porque no me andaba
            boolean montoValido = false;
            while (!montoValido) {
                System.out.print("Ingresa el monto: ");
                 entrada = teclado.nextLine().replace(",", ".");

                try {
                    monto = Double.parseDouble(entrada);
                    System.out.println(monto);
                    montoValido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Eso no parece un número válido. Intenta de nuevo.");
                }
            }

            // Construir la URL
            String url = "https://v6.exchangerate-api.com/v6" + key + "/pair/" +
                    monedaBase + "/" +
                    monedaAconvertir + "/" +
                    entrada;



            try {
                HttpClient consultante = HttpClient.newHttpClient();
                Gson gson = new Gson();

                HttpRequest consulta = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> respuesta = consultante.send(consulta, HttpResponse.BodyHandlers.ofString());

                RespuestaApi resultadoFinal = gson.fromJson(respuesta.body(), RespuestaApi.class);
                System.out.println("Tasa de conversión: " + resultadoFinal.conversion_rate());
                System.out.println("Resultado: " + resultadoFinal.conversion_result());

            } catch (Exception e) {
                System.out.println("Ocurrió un error al hacer la conversión: " + e.getMessage());
            }

            System.out.print("¿Desea hacer otra conversión? (s/n): ");
            continuar = teclado.nextLine();

            if (continuar.equalsIgnoreCase("s")) {
                System.out.println(menu);
            }

        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("¡Gracias por usar el conversor!");
    }
}

// ¿Que queriero lograr?
//Que el usuario pueda elegir moneda de origen y destino monto.
//  Que se genere una URL dinámica para consultar la API con esos datos.
// Que sea todo ordenado: cada clase con su tarea
// Que se pueda manejar errores.

//1. Contexto y orden lógico:
//Pedís datos al usuario (moneda base, moneda a convertir, monto).
//
//Armas la URL con esos datos.
//
//Haces la petición HTTP (con HttpClient).
//
//Recibís la respuesta JSON como texto.
//
//Convertís ese JSON en un objeto Java (aquí entra tu DTO).
//
//Usás esos datos en tu programa para hacer la conversión.
//
//Mostrás el resultado.




