package senac.java.Services;
import senac.java.Controllers.EstoqueController;
import senac.java.Controllers.UserController;
import senac.java.Controllers.VendaController;
import java.net.InetSocketAddress;
import java.io.IOException;
import com.sun.net.httpserver.HttpServer;

public class Servidor {

    public void apiServer() throws IOException{

        HttpServer server = HttpServer.create(new InetSocketAddress(4000),
                0);

        server.createContext("/api/users", new UserController.UserHandler());
        server.createContext("/api/products", new EstoqueController.EstoqueHandler());
        server.createContext("/api/sales", new VendaController.ProductsHandler());

        server.setExecutor(null);
        server.start();
        System.out.println("Servidor iniciado;");
    }
}
