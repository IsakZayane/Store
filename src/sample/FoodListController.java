package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FoodListController implements Initializable {
    Controller cs = new Controller();

    @FXML private Label loggedinlabel;
    @FXML
    public ListView<String> listView1;
    @FXML
    public ListView<String> listView2;

    ObservableList<String> list = FXCollections.observableArrayList("test1", "test2", "test3");
    ObservableList<String> list2 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggedinlabel.setText(NameTransfer.getInstance().getName());
        listView1.setItems(list);
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        listView2.setItems(list2);
        listView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    public void addButton() {
        list2.add(listView1.getSelectionModel().getSelectedItem());

    }

    public void removeButton() {

        list2.remove(listView2.getSelectionModel().getSelectedItem());
    }


    public void GoBackLogIn(ActionEvent event)  {

        cs.changeScene(event,"sample.fxml","log in");

    }
    public void GoBackProducts(ActionEvent event)  {
        cs.changeScene(event,"productssample.fxml","products");
    }
    public void ExitAction(){
        System.exit(0);
    }

}







