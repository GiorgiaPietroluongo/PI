package senac.java.Domain;

import org.json.JSONObject;

import java.util.ArrayList;

public class Usuarios {
    int id;
    public String name = "";
    public String lastName = "";
    public String genero = "";
    public String datanasc = "";
    public String email = "";
    public String estado = "";
    public String cidade = "";
    public String cpf = "";
    public String telefone = "";

    public Usuarios(){

    }
    public Usuarios(String name, String lastName, String genero, String datanasc,
                    String email, String estado, String cidade ,String cpf, String telefone){
        this.name= name;
        this.lastName = lastName;
        this.genero = genero;
        this.datanasc = datanasc;
        this.email = email;
        this.estado = estado;
        this.cidade = cidade;
        this.cpf = cpf;
        this.telefone= telefone;



    }
    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("name",name);
        json.put("last_name", lastName);
        json.put("genero", genero);
        json.put("datanasc", datanasc);
        json.put("email", email);
        json.put("estado", estado);
        json.put("cidade", cidade);
        json.put("cpf", cpf);
        json.put("telefone", telefone);

        return json;
    }

//    public ArrayList userList(){
//        ArrayList list = new ArrayList();
//        list.getClass();
//
//        return list;
//    }
}
