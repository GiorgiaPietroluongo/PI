package senac.java.Domain;

import org.json.JSONObject;

import java.util.ArrayList;

public class Usuarios {
    int id;
    String name = "";
    String lastName = "";
    String cpf = "";
    String email = "";

    public Usuarios(){

    }
    public Usuarios(String name, String lastName,
                    String cpf, String email){
        this.name= name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;


    }
    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("name",name);
        json.put("last_name", lastName);
        json.put("cpf", cpf);
        json.put("email", email);

        return json;
    }

//    public ArrayList userList(){
//        ArrayList list = new ArrayList();
//        list.getClass();
//
//        return list;
//    }
}
