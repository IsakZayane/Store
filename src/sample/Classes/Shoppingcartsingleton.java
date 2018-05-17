package sample.Classes;

import java.util.ArrayList;

public class Shoppingcartsingleton {
    private static Shoppingcartsingleton ourInstance = new Shoppingcartsingleton();

    public static Shoppingcartsingleton getInstance() {
        return ourInstance;
    }

    private ArrayList<Item> shoppingcart = new ArrayList<>();

    public ArrayList<Item> getShoppingcart() {

        return shoppingcart;
    }
    

    public void setShoppingcart(Item addshopping) {
        shoppingcart.add(addshopping);
        this.shoppingcart = shoppingcart;

    }public void clearShoppincart(){
        for (int i=0;i<shoppingcart.size();i++)
        shoppingcart.remove(i);
    }

    private Shoppingcartsingleton() {
    }
}
