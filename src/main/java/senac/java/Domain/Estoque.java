package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class Estoque {
    int id;
    String name = "";
    String factory = "";
    String quantity = "";
    String codBarras = "";

    public Estoque(){

    }
    public Estoque(String name, String factory, String quantity, String codBarras){
        this.name = name;
        this.factory = factory;
        this.quantity= quantity;
        this.codBarras = codBarras;

    }

    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getFactory(){return  factory;}
    public void setFactory(String factory){this.factory = factory;}
    public String getQuantity(){return quantity;}
    public void setQuantity(String quantity){this.quantity = factory;}
    public String getCodBarras(){return codBarras;}
    public void setCodBarras(String codBarras){this.codBarras =codBarras;}

    public JSONObject toJson(List<Estoque> estoqueList){
        JSONObject json = new JSONObject();

        json.put("user", name);
        json.put("factory",factory);
        json.put("quantity", quantity);
        json.put("codBarras", codBarras);
        return json;
    }

    public JSONObject arrayToJson(List<Estoque> estoqueList){
        JSONObject json = new JSONObject();

        if (!estoqueList.isEmpty()){
            var keysJson = 0;
            for(Estoque estoque: estoqueList){
                JSONObject js = new JSONObject();
                js.put("name", estoque.getName());
                js.put("factory", estoque.getFactory());
                js.put("quantity", estoque.getQuantity());
                js.put("codBarras", estoque.getCodBarras());

                json.put(String.valueOf(keysJson), js);
                keysJson++;
            }
            return json;
        }else{
            return null;
        }
    }

    public static List<Estoque> getAllEstoque(List<Estoque> estoqueList){
        return estoqueList;
    }


}
