package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.control.ListView;

import javafx.scene.control.TextArea;
import sample.Classes.CatNip;
import sample.Classes.DataBase;
import sample.Classes.PreparedMethods;


import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import sample.Classes.*;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CatNipController implements Initializable {

    PreparedMethods pm = new PreparedMethods();
    @FXML Button shoppingCartButton;
    @FXML TextField searchField;
    @FXML
    public ListView<String> listView1;
    @FXML
    public ListView<String> listView2;
    @FXML
    public TextArea textArea;
    @FXML
    TableView<CatNip> tableViewOne, tableViewTwo;
    @FXML
    TableColumn nameColOne, nameColTwo, priceColOne, priceColTwo;

    private ArrayList<CatNip> catnip = new ArrayList<>();

 private   ObservableList<CatNip> myList = FXCollections.observableArrayList();
    private ObservableList<CatNip> myListTwo = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        DataBase myDB = new DataBase();
        catnip = myDB.getCatnipList();
        myList.addAll(catnip);
        nameColOne.setCellValueFactory(new PropertyValueFactory<CatNip, String>("name"));
        priceColOne.setCellValueFactory(new PropertyValueFactory<CatNip, Double>("price"));


        for (int i = 0; i < catnip.size(); i++) {

            tableViewOne.setItems(myList);
        }
        tableViewOne.setTooltip(new Tooltip("Products in store"));
        tableViewTwo.setTooltip(new Tooltip("Click add to shoppingcart to commit to your shoppingcart!"));
        searchField.setTooltip(new Tooltip("Search for products by their name! "));
        shoppingCartButton.setTooltip(new Tooltip("Click to commit to your shoppingcart"));




    }

    public void addButton() {


        myListTwo.add(tableViewOne.getSelectionModel().getSelectedItem());
        tableViewTwo.setItems(myListTwo);

        nameColTwo.setCellValueFactory(new PropertyValueFactory<CatNip, String>("name"));
        priceColTwo.setCellValueFactory(new PropertyValueFactory<CatNip, Double>("price"));


    }

    public void removeButton() {

        myListTwo.remove(tableViewOne.getSelectionModel().getSelectedItem());
    }


    public void backButton(ActionEvent event) throws IOException {

        DataBase db = new DataBase();

        if (db.isAdmin()) {
            pm.changeScene(event,"/sample/fxml/AdminProductsSample.fxml", "Products-Admin");
            System.out.println("still admin");
        }
        else {
            pm.changeScene(event, "/sample/fxml/productsSample.fxml", "Products");
        }


    }

    public void showInfo() {

        System.out.println("innan for");
        for (int i = 0; i < tableViewOne.getItems().size(); i++) {


            String name = tableViewOne.getSelectionModel().getSelectedItem().getName();

            if (name.equals(catnip.get(i).getName())) {

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
        for (int i=0;i<myListTwo.size();i++) {
            NameTransfer.getInstance().setTotalsum(myListTwo.get(i).getPrice());
        }
        pm.showAlert("Products added!", "You just added some products to your cart", "Continue shopping or order");
        for (int i = 0; i < myListTwo.size(); i++) {
            Shoppingcartsingleton.getInstance().setShoppingcart(tableViewTwo.getItems().get(i));
            System.out.println(Shoppingcartsingleton.getInstance().getShoppingcart());

        }


    }

    @FXML  public void searchFunction() {
        String s = searchField.getText();

        DataBase db = new DataBase();
        ArrayList<CatNip> myCatNipList = db.getCatnipList();






        for (int i = 0; i < myCatNipList.size(); i++) {
            System.out.println(myCatNipList.get(i).getName());

            if (s.equals(myCatNipList.get(i).getName())){
                ObservableList<CatNip> mySearchList = FXCollections.observableArrayList();
                mySearchList.add(myCatNipList.get(i) );

                tableViewOne.setItems(mySearchList);
                nameColOne.setCellValueFactory(new PropertyValueFactory<KittyLitter, String>("name"));
                priceColOne.setCellValueFactory(new PropertyValueFactory<KittyLitter, Double>("price"));



            }
            else if(s.isEmpty()) {
                tableViewOne.setItems(myList);

            }

        }
    }








}








