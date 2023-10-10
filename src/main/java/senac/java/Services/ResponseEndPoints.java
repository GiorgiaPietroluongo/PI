package senac.java.Services;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class ResponseEndPoints {

    public static void enviarResponse(HttpExchange exchange , String response) throws IOException {

        exchange.sendResponseHeaders(200, response.getBytes().length);

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

        }

    }
