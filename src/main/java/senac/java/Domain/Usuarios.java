package senac.java.Domain;

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
}
