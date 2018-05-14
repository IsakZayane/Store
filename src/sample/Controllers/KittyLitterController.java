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

public class KittyLitterController implements Initializable {
    PreparedMethods pm = new PreparedMethods();


    @FXML
    public ListView<String> listView1;
    @FXML
    public ListView<String> listView2;
    @FXML
    public TextArea textArea;
    @FXML
    TableColumn nameColOne, nameColTwo, priceColOne, priceColTwo;
    @FXML
    TableView<KittyLitter> tableViewOne, tableViewTwo;


    ArrayList<KittyLitter> catlitter = new ArrayList<>();

    ObservableList<String> list = FXCollections.observableArrayList();
    ObservableList<String> list2 = FXCollections.observableArrayList();

    ObservableList<KittyLitter> myList = FXCollections.observableArrayList();
    ObservableList<KittyLitter> myListTwo = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DataBase myDB = new DataBase();
        catlitter = myDB.getKittylitterList();

        myList.addAll(catlitter);

        nameColOne.setCellValueFactory(new PropertyValueFactory<KittyLitter, String>("name"));
        priceColOne.setCellValueFactory(new PropertyValueFactory<KittyLitter, Double>("price"));

        for (int i = 0; i < catlitter.size(); i++) {
            tableViewOne.setItems(myList);
        }
    }

    public void addButton() {
//        list2.add(listView1.getSelectionModel().getSelectedItem());

        myListTwo.add(tableViewOne.getSelectionModel().getSelectedItem());
        tableViewTwo.setItems(myListTwo);
        nameColTwo.setCellValueFactory(new PropertyValueFactory<KittyLitter, String>("name")); //hämtar det som finns i objektet under name och price
        priceColTwo.setCellValueFactory(new PropertyValueFactory<KittyLitter, Double>("price"));
    }

    public void removeButton() {
        myListTwo.remove(tableViewOne.getSelectionModel().getSelectedItem());
    }


    public void backButton(ActionEvent event) throws IOException {
        pm.changeScene(event, "/sample/fxml/ProductsSample.fxml", "Products");
    }

    public void showInfo() {
        //   String name=listView1.getSelectionModel().getSelectedItem();
        //    String info="";


        for (int i = 0; i < tableViewOne.getItems().size(); i++) {


            String name = tableViewOne.getSelectionModel().getSelectedItem().getName();

            if (name.equals(catlitter.get(i).getName())) {

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
    }







