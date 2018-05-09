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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Classes.DataBase;
import sample.Classes.PreparedMethods;
import sample.Classes.Wine;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WineListController implements Initializable {

 private PreparedMethods pm = new PreparedMethods();

    @FXML
    public ListView<String> listView1;
    @FXML
    public ListView<String> listView2;
    public ArrayList<Wine> wine = new ArrayList<>();
    @FXML public TextArea textArea;

    ObservableList<String> list = FXCollections.observableArrayList();
    ObservableList<String> list2 = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DataBase myDB = new DataBase();


        wine=myDB.getWineList();

        listView1.setItems(list);
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        listView2.setItems(list2);
        listView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        for (int i = 0;i<wine.size();i++){
            list.add(wine.get(i).getName());
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

    public void showInfo(){
        String name=listView1.getSelectionModel().getSelectedItem();
        String info="";

        try {

            for (int i = 0; i < wine.size(); i++) {
                if (name == wine.get(i).getName()) {

                    info = "Name: " + name + "\n" +
                            "Price: " + wine.get(i).getPrice() + "\n" +
                            "Ingredients: " + wine.get(i).getIngredients() + "\n" +
                            "Weight: " + wine.get(i).getWeight() + "\n" +
                            "Origin: " + wine.get(i).getOrigin() + "\n" +
                            "Detail: " + wine.get(i).getDetail() + "\n";

                }
            }

            textArea.setText(info);

        }
        catch (Exception e){
            


        }
    }

}






