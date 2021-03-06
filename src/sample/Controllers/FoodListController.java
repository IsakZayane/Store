package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classes.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FoodListController implements Initializable {
    PreparedMethods pm = new PreparedMethods();
    
    @FXML TextField searchField;
    
    @FXML
    TableView<Food> tableViewOne, tableViewTwo;
    @FXML
    TableColumn nameColOne, nameColTwo, priceColOne, priceColTwo;
    @FXML Button shoppingCartButton;
    
    
    @FXML
    public TextArea textArea;
    
    public ArrayList<Food> food = new ArrayList<>();
    
    
    private ObservableList<Food> myList = FXCollections.observableArrayList();
    private ObservableList<Food> myListTwo = FXCollections.observableArrayList();
    
    
    ArrayList<String> shoppingcart = new ArrayList<>();
    //NNA: Fetch the database object from the Singleton to avoid re-initializing the database
    private DataBase myDB = DatabaseSingleton.getInstance().getDb();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        //NNA: No need for this as we have an instance variable
        // DataBase myDB = new DataBase();
        food = myDB.getFoodList();
        
        
        myList.addAll(food);
        
        nameColOne.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
        priceColOne.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
        
        
        //listView1.setItems(list);
        //listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


//        listView2.setItems(list2);
        //      listView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        
        for (int i = 0; i < food.size(); i++) {
            tableViewOne.setItems(myList);
        }
        
        tableViewOne.setTooltip(new Tooltip("Products in store"));
        tableViewTwo.setTooltip(new Tooltip("Click add to shoppingcart to commit to your shoppingcart!"));
        searchField.setTooltip(new Tooltip("Search for products by their name! "));
        shoppingCartButton.setTooltip(new Tooltip("Click to commit to your shoppingcart"));
        
        
    }
    
    public void addButton() {
        
        System.out.println("Tjoo you just added nothing");
        myListTwo.add(tableViewOne.getSelectionModel().getSelectedItem());
        tableViewTwo.setItems(myListTwo);
        
        
        nameColTwo.setCellValueFactory(new PropertyValueFactory<Food, String>("name")); //hämtar det som finns i objektet under name och price
        priceColTwo.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
        
        
    }
    
    public void removeButton() {
        myListTwo.remove(tableViewOne.getSelectionModel().getSelectedItem());
        
    }
    
    
    public void goBackAction(ActionEvent event) throws IOException {
        //NNA: No need for this as we have an instance variable
        //DataBase db = new DataBase();
        
        if (myDB.isAdmin()) {
            
            pm.changeScene(event, "/sample/fxml/AdminProductsSample.fxml", "Products-Admin");
            System.out.println("still admin");
        } else {
            pm.changeScene(event, "/sample/fxml/ProductsSample.fxml", "Products");
            System.out.println("not admin");
        }
    }
    
    public void backLogInAction(ActionEvent event) {
        pm.clearUserInfo();
        
        
        pm.changeScene(event, "/sample/fxml/Sample.fxml", "login");
    }
    
    public void addShoppingCartAction() {
        for (int i = 0; i < myListTwo.size(); i++) {
            NameTransfer.getInstance().setTotalsum(myListTwo.get(i).getPrice());
        }
        pm.showAlert("Products added!", "You just added some products to your cart", "Continue shopping or order");
        for (int i = 0; i < myListTwo.size(); i++) {
            Shoppingcartsingleton.getInstance().setShoppingcart(tableViewTwo.getItems().get(i));
            System.out.println(Shoppingcartsingleton.getInstance().getShoppingcart());
            
            
        }
    }
    
    public void showInfo() {
        
        System.out.println("innan for");
        for (int i = 0; i < tableViewOne.getItems().size(); i++) {
            
            
            String name = tableViewOne.getSelectionModel().getSelectedItem().getName();
            
            if (name.equals(food.get(i).getName())) {
                
                String info = "Name: " + tableViewOne.getItems().get(i).getName() + "\n" +
                        "Price: " + tableViewOne.getItems().get(i).getPrice() + "\n" +
                        "Ingredients: " + tableViewOne.getItems().get(i).getIngredients() + "\n" +
                        "Weight: " + tableViewOne.getItems().get(i).getWeight() + "\n" +
                        "Origin: " + tableViewOne.getItems().get(i).getOrigin() + "\n" +
                        "Details: " + tableViewOne.getItems().get(i).getDetail();
                
                
                textArea.setText(info);
                
                
            }
        }
        
        
    }
    
    @FXML public void searchFunction() {
        String s = searchField.getText();
    
        //NNA: No need for this as we have an instance variable
        //DataBase db = new DataBase();
        ArrayList<Food> myFoodList = myDB.getFoodList();
        
        
        for (int i = 0; i < myFoodList.size(); i++) {
            System.out.println(myFoodList.get(i).getName());
            
            if (s.equals(myFoodList.get(i).getName())) {
                ObservableList<Food> mySearchList = FXCollections.observableArrayList();
                mySearchList.add(myFoodList.get(i));
                
                tableViewOne.setItems(mySearchList);
                nameColOne.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
                priceColOne.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));
                
                
            } else if (s.isEmpty()) {
                tableViewOne.setItems(myList);
                
            }
            
        }
    }
    
    
}





