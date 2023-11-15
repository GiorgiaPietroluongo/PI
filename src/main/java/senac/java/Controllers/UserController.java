package senac.java.Controllers;

import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import senac.java.DAL.UserDal;
import senac.java.Domain.Usuarios;
import senac.java.Services.Conexao;
import senac.java.Services.ResponseEndPoints;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
public class UserController {
    public static List<Usuarios> usersList = new ArrayList<>();

    public static class UserHandler implements HttpHandler{
        static ResponseEndPoints res = new ResponseEndPoints();

        @Override
        public void handle(HttpExchange exchange) throws IOException{
            String response = "";

            if("GET".equals(exchange.getRequestMethod())){
                UserDal  userDal = new UserDal();

                response = "Essa é a rota de usuario - GET";
                res. enviarResponse(exchange, response,200);
                usersList.reversed();

                try {
                    userDal.listarUsuario();
                }catch (Exception e){
                    System.out.println("O erro foi" + e);
                }
            }else if ("POST".equals(exchange.getRequestMethod())) {
                UserDal userDal = new UserDal();

                try (InputStream requestBody = exchange.getRequestBody()) {
                    JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));
                    int resp = 0;

                    Usuarios user = new Usuarios(

                            json.getString("name"),
                            json.getString("lastName"),
                            json.getString("genero"),
                            json.getString("datanasc"),
                            json.getString("email"),
                            json.getString("estado"),
                            json.getString("cidade"),
                            json.getString("cpf"),
                            json.getString("telefone")


                            );
                    usersList.add(user);
                    user.toJson();

                   resp = userDal.inserirUsuario(user.name, user.lastName, user.genero, user.datanasc,
                            user.email, user.estado, user.cidade, user.cpf, user.telefone);

                    if (resp == 0){
                        response= "Houve um problema ao criar o usuário";
                    }else {
                        response = "Usuário criado com sucesso";
                    }

                    res.enviarResponse(exchange, response, 201);
//                    res.enviarResponseJson(exchange, user.toJson(),200);


                } catch (Exception e) {
                    String resposta = e.toString();
                    res.enviarResponse(exchange, resposta, 200);

                }


//                res. enviarResponse(exchange, response);
//                response = "Essa é a rota de usuario - POST";
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                UserDal userDal = new UserDal();
                try{
                    userDal.atualizarUsuario();
                }catch (Exception e){
                    System.out.println("O erro foi: " + e);
                }

                res. enviarResponse(exchange, response,200);
                response = "Essa e a rota de usuario - PUT";
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                UserDal userDal= new UserDal();
                try {
                    userDal.excluirUsuario();
                }catch (Exception e){
                    System.out.println("O erro foi:" + e);
                }
                res. enviarResponse(exchange, response,200);
                response = "Essa e a rota de usuario - DELETE";
            }else {
                response = "Rota usuario - ERRO!" +
                        " O metodo utilizado foi: " + exchange.getRequestMethod();;
                res. enviarResponse(exchange, response,200);
            }
        }
    }
}
