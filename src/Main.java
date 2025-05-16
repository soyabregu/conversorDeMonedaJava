import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String monedaBase ;
        String monedaAconvertir;
        final String  key = "/aafd4024a38845e16e3a0cd5";

        String url = "https://v6.exchangerate-api.com/v6";


        System.out.println("####bienvenido al conversor de moneda ######");

        System.out.println("ingresa tu moneda base ");
        monedaBase = teclado.next();

        System.out.println("ingresa el nombre de la moneda que desea convertir ");
        monedaAconvertir = teclado.next();

        System.out.println("ingresa el monto " );
          double monto = Double.parseDouble(teclado.nextLine());


        System.out.println("su resultado es : ");













// ¿Que queriero lograr?
//Que el usuario pueda elegir moneda de origen y destino monto.
//  Que se genere una URL dinámica para consultar la API con esos datos.
// Que sea todo ordenado: cada clase con su tarea
// Que se pueda manejar errores.







        }
    }
}