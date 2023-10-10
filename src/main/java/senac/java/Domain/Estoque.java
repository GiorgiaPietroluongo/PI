package senac.java.Domain;

public class Estoque {
    int id;
    String name = "";
    String factory = "";
    int quantity = 0;

    public Estoque(){

    }
    public Estoque(String name, String factory, int quantity){
        this.name = name;
        this.factory = factory;
        this.quantity= quantity;

    }
}
