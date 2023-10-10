package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import senac.java.Services.ResponseEndPoints;

import java.io.IOException;

public class VendaController {
    static ResponseEndPoints res = new ResponseEndPoints();

    public static class ProductsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "";

            if ("GET".equals(exchange.getRequestMethod())) {
                response = "Essa e a rota de vendas - GET";
                res.enviarResponse(exchange, response);
            } else if ("POST".equals(exchange.getRequestMethod())) {
                response = "Essa e a rota de vendas - POST";
                res.enviarResponse(exchange, response);
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                response = "Essa é a rota de vendas - PUT";
                res.enviarResponse(exchange, response);
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                response = "Essa e a rota de vendas - DELETE";
                res.enviarResponse(exchange, response);
            } else {
                response = "Rota vendas - ERRO!" +
                        " O metodo utilizado foi: " + exchange.getRequestMethod();
                ;
                res.enviarResponse(exchange, response);
            }
        }
    }
}