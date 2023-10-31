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

            if("GET".equals(exchange.getRequestMethod())) {
                // System.out.println("Método GET");
                List<Venda> getAllFromArray = Venda.getAllVenda(vendaList);
                Venda vendaJson = new Venda();

                if (!getAllFromArray.isEmpty()) {
                    for (Venda venda : getAllFromArray) {
                        System.out.println("Nome: " + venda.getUser());
                        System.out.println("Produtos: " + venda.getProducts());
                        System.out.println("Compra final: " + venda.gettotalVendas());
                        System.out.println("Desconto: " + venda.getentrada());
                        System.out.println("Compra:" + venda.getsaida());
                        System.out.println();
                        System.out.println("------------------------------------------");
                        System.out.println();
                    }
                    res.enviarResponseJson(exchange, vendaJson.arrayToJson(getAllFromArray), 200);

//                    res.enviarResponseJson(exchange, jsonResponse, 200);



//                    String response = "Dados encontrados com sucesso!";
//                    res.enviarResponse(exchange, response, 200);


                }else {
                    String response = "Dados não encontrados!";
                    res.enviarResponse(exchange, response, 200);
                }


            }else if ("POST".equals(exchange.getRequestMethod())){
                try(InputStream requestBody = exchange.getRequestBody()){
                    JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));

                    Venda venda = new Venda(
                            json.getString("user"),
                            json.getString("products"),
                            json.getString("finishedSale"),
                            json.getString("discount"),
                            json.getString("Sale")

                            );

                    vendaList.add(venda);

                    System.out.println(vendaList);
                    res.enviarResponseJson(exchange, venda.toJson(vendaList), 200);

                }catch(Exception e){
                        String response = e.toString();
                        String exception = e.toString();

                        System.out.println(exception);

                        System.out.println("Cheguei no catch do post");
                        System.out.println(response);
                        System.out.println("_______________________________");
                    res.enviarResponse(exchange,response,200);
                }

            }else if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                exchange.close();
                return;
            }
       }
    }
}