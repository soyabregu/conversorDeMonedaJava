public class Url {
//pongo mi clave para que el usuario no deba logearse para un mayor servicio
        final String  key = "/aafd4024a38845e16e3a0cd5";

        //posibles endpoints
        String endpointLatest = "/latest/";//necesita 1 moneda , la compara con todas
        String monedaLatest ;//una moneda que elija el usuario


    //endpoidPair
        String endpointPair = "/pair/";//requiere dos monedas y un monto
         String monedaBasePair;
          String monedaDestinoP;
          double montoP;

          //Endpoint history
        String endpointHistory = "/history/";//requiere año ,mes dia year month day

    //construccion de la url base
    String url = "https://v6.exchangerate-api.com/v6";





///history/USD/YEAR/MONTH/DAY

}
