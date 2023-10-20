package senac.java.Services;
import com.sun.net.httpserver.HttpHandler;
import senac.java.Controllers.EstoqueController;
import senac.java.Controllers.UserController;
import senac.java.Controllers.VendaController;
import java.net.InetSocketAddress;
import java.io.IOException;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
public class Servidor {

    public void apiServer() throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(4000),
                0);


        HttpHandler userHandler = new UserController.UserHandler();
        HttpHandler estoqueHandler = new EstoqueController.EstoqueHandler();
        HttpHandler vendedorHandler = new VendaController.ProductsHandler();

        server.createContext("/api/user", exchange -> {
            configureCorsHeads(exchange);
            userHandler.handle(exchange);
        });
        server.createContext("/api/estoque", exchange -> {
            configureCorsHeads(exchange);
            estoqueHandler.handle(exchange);
        });
        server.createContext("/api/venda", exchange -> {
            configureCorsHeads(exchange);
            vendedorHandler.handle(exchange);
        });

        server.setExecutor(null);
        server.start();
        System.out.println("Servidor iniciado;");
    }

    private void configureCorsHeads(HttpExchange exchange) {
        Headers headers = exchange.getResponseHeaders();
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Access-Control-Allow-Methods", "GET, OPTIONS, PATCH, POST, PUT, DELETE");
        headers.set("Access-Control-Allow-Headers", "Content-Type");
    }
}