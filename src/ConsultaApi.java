import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {



    //creo elcliente que hara la consulta
    HttpClient consultante = HttpClient.newHttpClient();

//pedido //solucionar la url porque no se que moneda pedira el usuario
    HttpRequest consulta = HttpRequest.newBuilder()
            .uri(URI.create())
            .build();

    //respuesta que da error en el envio porque pueden salir mal las cosas ahi
 HttpResponse<String> respuesta = consultante.send(consulta,HttpResponse.BodyHandlers.ofString());



}
