package senac.java;
import java.io.IOException;

import senac.java.Services.Conexao;
import senac.java.Services.Servidor;
public class Main {
    public static void main(String[] args) throws IOException {

        Conexao conexao = new Conexao();
        conexao.conectar();
//        Servidor servidor = new Servidor();
//        servidor.apiServer();
    }
}