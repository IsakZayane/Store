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
import sample.Classes.DataBase;
import sample.Classes.Food;
import sample.Classes.PreparedMethods;
import sample.Classes.Shoppingcartsingleton;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FoodListController implements Initializable {
    PreparedMethods pm = new PreparedMethods();

    @FXML
    TableView<Food> tableViewOne, tableViewTwo;
    @FXML
    TableColumn nameColOne, nameColTwo, priceColOne, priceColTwo;

    @FXML
    public ListView<String> listView1;
    @FXML
    public ListView<String> listView2;
    @FXML
    public TextArea textAreaInfo;

    public ArrayList<Food> food = new ArrayList<>();

    ObservableList<String> list = FXCollections.observableArrayList();
    ObservableList<String> list2 = FXCollections.observableArrayList();
    ObservableList<Food> myList = FXCollections.observableArrayList();
    ObservableList<Food> myListTwo = FXCollections.observableArrayList();


    ArrayList<String> shoppingcart = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DataBase myDB = new DataBase();
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


    public void backButton(ActionEvent event) throws IOException {
        pm.changeScene(event, "/sample/fxml/productssample.fxml", "Products");

    }

    public void addShoppingCartAction() {
        for (int i = 0; i < myListTwo.size(); i++) {
            Shoppingcartsingleton.getInstance().setShoppingcart(tableViewTwo.getItems().get(i));
            System.out.println(Shoppingcartsingleton.getInstance().getShoppingcart());

        }


    }

    public void showInfo() {
        //String name = listView1.getSelectionModel().getSelectedItem();
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


                textAreaInfo.setText(info);


            }
        }

    }
}





