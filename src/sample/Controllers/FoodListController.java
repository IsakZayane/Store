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
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
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
    PreparedMethods pm  = new PreparedMethods();


    @FXML
    public ListView<String> listView1;
    @FXML
    public ListView<String> listView2;
    @FXML public TextArea textarea;

    public ArrayList<Food> food = new ArrayList<>();

    ObservableList<String> list = FXCollections.observableArrayList();
    ObservableList<String> list2 = FXCollections.observableArrayList();
    ArrayList<String> shoppingcart=new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DataBase myDB = new DataBase();
        food=myDB.getFoodList();

        listView1.setItems(list);
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        listView2.setItems(list2);
        listView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);





        for (int i = 0;i<food.size();i++){
            list.add(food.get(i).getName());
        }

    }

    public void addButton() {
        list2.add(listView1.getSelectionModel().getSelectedItem());

    }

    public void removeButton() {
        list2.remove(listView2.getSelectionModel().getSelectedItem());
    }


    public void backButton(ActionEvent event) throws IOException {
        pm.changeScene(event,"/sample/fxml/productssample.fxml","Products" );

    }
    public void addShoppingCartAction(){
        for (int i =0; i<list2.size();i++) {
            Shoppingcartsingleton.getInstance().setShoppingcart(listView2.getItems().get(i));


        }





    }

    public void showInfo(){
        String name=listView1.getSelectionModel().getSelectedItem();
        String info="";

        try {

            for (int i = 0; i < food.size(); i++) {
                if (name == food.get(i).getName()) {

                    info = "Name: " + name + "\n" +
                            "Price: " + food.get(i).getPrice() + "\n" +
                            "Ingredients: " + food.get(i).getIngredients() + "\n" +
                            "Weight: " + food.get(i).getWeight() + "\n" +
                            "Origin: " + food.get(i).getOrigin() + "\n" +
                            "Detail: " + food.get(i).getDetail() + "\n";

                }
            }

            textarea.setText(info);

        }
        catch (Exception e){

        }

    }

}






