package senac.java.Controllers;
import java.io.IOException;
import senac.java.Services.ResponseEndPoints;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class EstoqueController {
    static ResponseEndPoints res = new ResponseEndPoints();
    public static class EstoqueHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException{
            String response = "";

            if("GET".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de estoque - GET";
                res. enviarResponse(exchange, response, 200);
            }else if ("POST".equals(exchange.getRequestMethod())){
                response = "Essa e a rota de estoque - POST";
                res. enviarResponse(exchange, response,200);
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                response = "Essa e a rota de estoque - PUT";
                res. enviarResponse(exchange, response,200);
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                response = "Essa e a rota de estoque - DELETE";
                res. enviarResponse(exchange, response,200);
            }else {
                response = "Rota estoque - ERRO!" +
                        " O metodo utilizado foi: " + exchange.getRequestMethod();;
                res. enviarResponse(exchange, response,405);
            }
        }

    }
}
