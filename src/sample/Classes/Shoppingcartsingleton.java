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

    @Override
    public String toString() {
        return "Shoppingcartsingleton{" +
                "shoppingcart=" + shoppingcart +
                '}';
    }

    public void setShoppingcart(Item addshopping) {
        shoppingcart.add(addshopping);
        //this.shoppingcart = shoppingcart;

    }

    private Shoppingcartsingleton() {
    }
}
