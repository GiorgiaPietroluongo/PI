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
import java.util.Arrays;

public class VendaController {
    public static List<Venda> vendaList = new ArrayList<>();
    static ResponseEndPoints res = new ResponseEndPoints();

    public static class ProductsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            if("GET".equals(exchange.getRequestMethod())) {
                // System.out.println("Método GET");
                List<Venda> getAllFromArray = Venda.getAllVenda(vendaList);
                Object teste = getAllFromArray.toArray();

                System.out.println();
                System.out.println("Print de object "+ teste);
                System.out.println();
                System.out.println();

                if (!getAllFromArray.isEmpty()) {
                    for (Venda venda : getAllFromArray) {
                        System.out.println("Nome: " + venda.getUser());
                        System.out.println("Produtos: " + venda.getProducts());
                        System.out.println("Compra final: " + venda.getfinishedSale());
                        System.out.println("Desconto: " + venda.getDiscount());
                        System.out.println("Compra:" + venda.getSale());
                        System.out.println();
                        System.out.println("-----------------------------------------------------");
                        System.out.println();
                    }
                    String response = "Dados encontrados com sucesso!";
                    res.enviarResponse(exchange, response, 200);


            }else{
                String response = "Dados não encontrados!";
                res.enviarResponse(exchange, response, 400);
                }


            }else if("POST".equals(exchange.getRequestMethod()));{
                try(InputStream requestBody = exchange.getRequestBody()){
                    JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));

                    Venda venda = new Venda(
                            json.getString("user"),
                            json.getString("products"),
                            json.getBoolean("finishedSale"),
                            json.getDouble("discount"),
                            json.getString("Sale")

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