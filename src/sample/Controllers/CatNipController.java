package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Classes.*;

import java.io.IOException;
import java.net.URL;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CatNipController implements Initializable {

    PreparedMethods pm = new PreparedMethods();


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

    ArrayList<CatNip> catnip = new ArrayList<>();

    ObservableList<String> list = FXCollections.observableArrayList();
    ObservableList<String> list2 = FXCollections.observableArrayList();
    ObservableList<CatNip> myList = FXCollections.observableArrayList();
    ObservableList<CatNip> myListTwo = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        DataBase myDB = new DataBase();
        catnip = myDB.getCatnipList();
        myList.addAll(catnip);
        nameColOne.setCellValueFactory(new PropertyValueFactory<CatNip, String>("name"));
        priceColOne.setCellValueFactory(new PropertyValueFactory<CatNip, Double>("price"));


        for (int i = 0; i < catnip.size(); i++) {
          //  list.add(catnip.get(i).getName());
            tableViewOne.setItems(myList);
        }

    }

    public void addButton() {
//        list2.add(listView1.getSelectionModel().getSelectedItem());

        myListTwo.add(tableViewOne.getSelectionModel().getSelectedItem());
        tableViewTwo.setItems(myListTwo);

        nameColTwo.setCellValueFactory(new PropertyValueFactory<CatNip, String>("name"));
        priceColTwo.setCellValueFactory(new PropertyValueFactory<CatNip, Double>("price"));


    }

    public void removeButton() {
       // list2.remove(listView2.getSelectionModel().getSelectedItem());
        myListTwo.remove(tableViewOne.getSelectionModel().getSelectedItem());
    }


    public void backButton(ActionEvent event) throws IOException {
        pm.changeScene(event, "/sample/fxml/productssample.fxml", "Products");


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
        pm.showAlert("Products added!", "You just added some products to your cart", "Continue shopping or order");
        for (int i = 0; i < myListTwo.size(); i++) {
            Shoppingcartsingleton.getInstance().setShoppingcart(tableViewTwo.getItems().get(i));
            System.out.println(Shoppingcartsingleton.getInstance().getShoppingcart());

        }


    }
}






