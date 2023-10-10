package senac.java.Controllers;

import com.sun.net.httpserver.HttpHandler;
import senac.java.Services.ResponseEndPoints;
import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
public class UserController {

    public static class UserHandler implements HttpHandler{
        static ResponseEndPoints res = new ResponseEndPoints();
        @Override
        public void handle(HttpExchange exchange) throws IOException{
            String response = "";
            if("GET".equals(exchange.getRequestMethod())){
                response = "Essa é a rota de usuario - GET";
                res. enviarResponse(exchange, response);
            }else if ("POST".equals(exchange.getRequestMethod())){
                res. enviarResponse(exchange, response);
                response = "Essa é a rota de usuario - POST";
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                res. enviarResponse(exchange, response);
                response = "Essa é a rota de usuario - PUT";
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                res. enviarResponse(exchange, response);
                response = "Essa é a rota de usuario - DELETE";
            }else {
                response = "Rota usuario - ERRO!" +
                        " O metodo utilizado foi: " + exchange.getRequestMethod();;
                res. enviarResponse(exchange, response);
            }
        }
        }

}
