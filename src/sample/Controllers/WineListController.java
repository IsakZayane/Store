package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ListView;

import javafx.scene.control.TextArea;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import sample.Classes.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WineListController implements Initializable {

    private PreparedMethods pm = new PreparedMethods();
    @FXML
    TextField searchField;

    @FXML
    Button shoppingCartButton;
    @FXML
    public ListView<String> listView1;
    @FXML
    public ListView<String> listView2;
    public ArrayList<Wine> wine = new ArrayList<>();
    @FXML
    public TextArea textArea;
    @FXML
    TableView<Wine> tableViewOne, tableViewTwo;
    @FXML
    TableColumn nameColOne, nameColTwo, priceColOne, priceColTwo;


    private ObservableList<Wine> myList = FXCollections.observableArrayList();
    private ObservableList<Wine> myListTwo = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DataBase myDB = new DataBase();

        wine = myDB.getWineList();
        myList.addAll(wine);

        nameColOne.setCellValueFactory(new PropertyValueFactory<Wine, String>("name"));
        priceColOne.setCellValueFactory(new PropertyValueFactory<Wine, Double>("price"));


        for (int i = 0; i < wine.size(); i++) {

            tableViewOne.setItems(myList);
        }

        tableViewOne.setTooltip(new Tooltip("Products in store"));
        tableViewTwo.setTooltip(new Tooltip("Click add to shoppingcart to commit to your shoppingcart!"));
        searchField.setTooltip(new Tooltip("Search for products by their name! "));
        shoppingCartButton.setTooltip(new Tooltip("Click to commit to your shoppingcart"));


    }

    public void addButton() {
        // list2.add(listView1.getSelectionModel().getSelectedItem());
        myListTwo.add(tableViewOne.getSelectionModel().getSelectedItem());

        tableViewTwo.setItems(myListTwo);

        nameColTwo.setCellValueFactory(new PropertyValueFactory<Wine, String>("name")); //hämtar det som finns i objektet under name och price
        priceColTwo.setCellValueFactory(new PropertyValueFactory<Wine, Double>("price"));


    }

    public void removeButton() {
        myListTwo.remove(tableViewOne.getSelectionModel().getSelectedItem());
    }


    public void backButton(ActionEvent event) throws IOException {

        DataBase db = new DataBase();

        if (db.isAdmin()) {
            pm.changeScene(event, "/sample/fxml/AdminProductsSample.fxml", "Products-Admin");
            System.out.println("still admin");
        } else {
            System.out.println(" not admin ");
            pm.changeScene(event, "/sample/fxml/ProductsSample.fxml", "Products");
        }

    }

    public void showInfo() {
        // String name=listView1.getSelectionModel().getSelectedItem();
        // String info="";
        System.out.println("innan for");
        for (int i = 0; i < tableViewOne.getItems().size(); i++) {


            String name = tableViewOne.getSelectionModel().getSelectedItem().getName();

            if (name.equals(wine.get(i).getName())) {

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


    @FXML
    public void searchFunction() {
        String s = searchField.getText();

        DataBase db = new DataBase();
        ArrayList<Wine> myWineList = db.getWineList();


        for (int i = 0; i < myWineList.size(); i++) {
            System.out.println(myWineList.get(i).getName());

            if (s.equals(myWineList.get(i).getName())) {
                ObservableList<Wine> mySearchList = FXCollections.observableArrayList();
                mySearchList.add(myWineList.get(i));

                tableViewOne.setItems(mySearchList);
                nameColOne.setCellValueFactory(new PropertyValueFactory<Wine, String>("name"));
                priceColOne.setCellValueFactory(new PropertyValueFactory<Wine, Double>("price"));


            }

        }
    }


}






