package senac.java.Domain;

import java.util.Date;

public class Venda {
    int id;
    String user = "";
    String products = "";
    boolean finishedSale = false;
    double discount = 0.0;
    Date Sale;

    public Venda(){

    }
    public Venda(String user, String products,
                 boolean finishedSale, double discount, Date Sale){
        this.user = user;
        this.products = products;
        this.finishedSale = finishedSale;
        this.discount = discount;
        this.Sale = Sale;
    }
}
