package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class Venda {
    int id;
    public String user = "";
    public String codigo = "";

    public  String entrada = "";
    public String saida = "";
    public String totalVendas = "";

    public Venda(){

    }
    public Venda(String user, String codigo,
                 String totalVendas, String entrada, String saida){
        this.user = user;
        this.codigo = codigo;
        this.totalVendas = totalVendas;
        this.entrada = entrada;
        this.saida = saida;
    }

    public String getUser(){
        return user;
    }
    public void setUser(String user){
        this.user = user;
    }
    public String getProducts(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public String gettotalVendas(){
        return totalVendas;
    }
    public void settotalVendas(String totalVendas){
        this.totalVendas = totalVendas;
    }
    public String getentrada(){
        return entrada;
    }
    public void setentrada(String entrada){
        this.entrada = entrada;
    }
    public String getsaida(){
        return saida;
    }
    public void setsaida(String saida){
        this.saida = saida;
    }
    public JSONObject toJson(List<Venda> arrayToJson){
        JSONObject json = new JSONObject();
        json.put("user", user);
        json.put("products",codigo);
        json.put("finishedSale", totalVendas);
        json.put("entrada", entrada);
        json.put("saida",saida);
        return json;
    }

    public JSONObject arrayToJson(List<Venda> vendaList) {
        JSONObject json = new JSONObject();

        if (!vendaList.isEmpty()) {
            var keyJson = 0;
            for (Venda venda : vendaList) {
                JSONObject js = new JSONObject();
                js.put("user", venda.getUser());
                js.put("codigo", venda.getProducts());
                js.put("totalvendas", venda.gettotalVendas());
                js.put("discount", venda.getentrada());
                js.put("saida", venda.getsaida());


                json.put(String.valueOf(keyJson), js);
                keyJson++;
            }
            return json;
        }else{
            return null;
        }
    }
    public static Venda getVenda(int index, List<Venda> vendaList){
        if(index >=0 && index < vendaList.size()){
            return vendaList.get(index);
        }else{
            return null;
        }
    }
    public static List<Venda> getAllVenda(List<Venda> vendaList){
        return vendaList;
    }
}
