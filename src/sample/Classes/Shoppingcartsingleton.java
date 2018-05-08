package sample.Classes;

import java.util.ArrayList;

public class Shoppingcartsingleton {
    private static Shoppingcartsingleton ourInstance = new Shoppingcartsingleton();

    public static Shoppingcartsingleton getInstance() {
        return ourInstance;
    }
    private ArrayList<String> shoppingcart=new ArrayList<>();

    public ArrayList<String> getShoppingcart(){


        return shoppingcart;}

    public void setShoppingcart(ArrayList<String> shoppingcart){this.shoppingcart = shoppingcart;}

    private Shoppingcartsingleton() {
    }
}
