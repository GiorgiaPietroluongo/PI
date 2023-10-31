package senac.java.Controllers;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import senac.java.Domain.Estoque;
import senac.java.Domain.Venda;
import senac.java.Services.ResponseEndPoints;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import javax.management.modelmbean.DescriptorSupport;

public class EstoqueController {

    public static List<Estoque> estoqueList = new ArrayList<>();
    static ResponseEndPoints res = new ResponseEndPoints();

    public static class EstoqueHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "";

            if ("GET".equals(exchange.getRequestMethod())) {
                List<Estoque> getAllFromArray = Estoque.getAllEstoque(estoqueList);
                Estoque estoqueJson = new Estoque();

                if (!getAllFromArray.isEmpty()) {
                    for (Estoque estoque : getAllFromArray) {
                        System.out.println("------------------------------------------");
                        System.out.println();
                        System.out.println("Nome: " + estoque.getName());
                        System.out.println("Fábrica: " + estoque.getFactory());
                        System.out.println("Quantidade: " + estoque.getQuantity());
                        System.out.println("Código de barra: " + estoque.getCodBarras());
                        System.out.println();
                        System.out.println("------------------------------------------");
                        System.out.println();
                    }
                    res.enviarResponseJson(exchange, estoqueJson.arrayToJson(getAllFromArray), 200);
                } else {
                    response = "Dados não encontrados!";
                    res.enviarResponse(exchange, response, 200);
                }


                //            }else if ("POST".equals(exchange.getRequestMethod())){
//                response = "Essa e a rota de estoque - POST";
//                res. enviarResponse(exchange, response,200);
//            }else if ("PUT".equals(exchange.getRequestMethod())) {
//                response = "Essa e a rota de estoque - PUT";
//                res. enviarResponse(exchange, response,200);
//            }else if ("DELETE".equals(exchange.getRequestMethod())) {
//                response = "Essa e a rota de estoque - DELETE";
//                res. enviarResponse(exchange, response,200);
//            }else {
//                response = "Rota estoque - ERRO!" +
//                        " O metodo utilizado foi: " + exchange.getRequestMethod();;
//                res. enviarResponse(exchange, response,405);

            } else if ("POST".equals(exchange.getRequestMethod())) {
                try (InputStream requestBody = exchange.getRequestBody()) {
                    JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));

                    Estoque estoque = new Estoque(
                            json.getString("name"),
                            json.getString("factory"),
                            json.getString("quantity"),
                            json.getString("codBarras")
                    );
                    estoqueList.add(estoque);

                    System.out.println(estoqueList);
                    res.enviarResponseJson(exchange, estoque.toJson(estoqueList), 200);

                } catch (Exception e) {
                    response = e.toString();
                    String exception = e.toString();

                    System.out.println(exception);

                    System.out.println("Cheguei no catch do post");
                    System.out.println(response);
                    System.out.println("_______________________________");
                }
            } else if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                exchange.close();
                return;

            }
        }
    }
}






























