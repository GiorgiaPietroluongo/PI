package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class Venda {
    int id;
    public String user = "";
    public String products = "";
    public boolean finishedSale = false;
    public  double discount = 0.0;
    public String Sale;

    public Venda(){

    }
    public Venda(String user, String products,
                 boolean finishedSale, double discount, String Sale){
        this.user = user;
        this.products = products;
        this.finishedSale = finishedSale;
        this.discount = discount;
        this.Sale = Sale;
    }

    public String getUser(){
        return user;
    }
    public void setUser(String user){
        this.user = user;
    }
    public String getProducts(){
        return products;
    }
    public void setProducts(String products){
        this.products = products;
    }
    public boolean getfinishedSale(){
        return finishedSale;
    }
    public void setFinishedSale(boolean finishedSale){
        this.finishedSale = finishedSale;
    }
    public double getDiscount(){
        return discount;
    }
    public void setDiscount(double discount){
        this.discount = discount;
    }
    public String getSale(){
        return Sale;
    }
    public void setSale(String Sale){
        this.Sale = Sale;
    }
    public JSONObject toJson(List<Venda> arrayToJson){
        JSONObject json = new JSONObject();
        json.put("user", user);
        json.put("products",products);
        json.put("finishedSale", finishedSale);
        json.put("discount", discount);
        json.put("Sale",Sale);
        return json;
    }

    public JSONObject arrayToJson(List<Venda> vendaList) {
        JSONObject json = new JSONObject();

        if (!vendaList.isEmpty()) {
            var keyJson = 1;
            for (Venda venda : vendaList) {
                JSONObject js = new JSONObject();
                js.put("user", venda.getUser());
                js.put("products", venda.getProducts());
                js.put("finishedSale", venda.getfinishedSale());
                js.put("discount", venda.getDiscount());
                js.put("Sale", venda.getSale());
                keyJson++;
                json.put(String.valueOf(keyJson), js);


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
