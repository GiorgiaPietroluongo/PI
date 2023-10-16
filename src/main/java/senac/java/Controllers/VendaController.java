package senac.java.Controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import senac.java.Domain.Venda;
import senac.java.Services.ResponseEndPoints;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class VendaController {
    public static List<Venda> vendaList = new ArrayList<>();
    static ResponseEndPoints res = new ResponseEndPoints();

    public static class ProductsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            if("GET".equals(exchange.getRequestMethod())){
                System.out.println("Método GET");
            }else if("POST".equals(exchange.getRequestMethod()));{
                try(InputStream requestBody = exchange.getRequestBody()){
                    JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));

                    Venda venda = new Venda(
                            json.getString("user"),
                            json.getString("products"),
                            json.getBoolean("finishedSale"),
                            json.getDouble("discount"),
                            json.getDate("Sale")

                            );

                    vendaList.add(venda);
                    res.enviarResponseJson(exchange,venda.toJson(), 201);

                }catch(Exception e){
                        String response = e.toString();
                    res.enviarResponse(exchange,response,405);
                }
            }
//            String response = "";
//
//            if ("GET".equals(exchange.getRequestMethod())) {
//                response = "Essa e a rota de vendas - GET";
//                res.enviarResponse(exchange, response,200);
//            } else if ("POST".equals(exchange.getRequestMethod())) {
//                response = "Essa e a rota de vendas - POST";
//                res.enviarResponse(exchange, response,200);
//            } else if ("PUT".equals(exchange.getRequestMethod())) {
//                response = "Essa é a rota de vendas - PUT";
//                res.enviarResponse(exchange, response,200);
//            } else if ("DELETE".equals(exchange.getRequestMethod())) {
//                response = "Essa e a rota de vendas - DELETE";
//                res.enviarResponse(exchange, response,200);
//            } else {
//                response = "Rota vendas - ERRO!" +
//                        " O metodo utilizado foi: " + exchange.getRequestMethod();
//                ;
//                res.enviarResponse(exchange, response,405);
//            }
        }
    }
}