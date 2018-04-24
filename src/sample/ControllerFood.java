package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ControllerFood implements Initializable {
    DataBase db = new DataBase();
    @FXML private ListView itemmenu;
    @Override
    public void initialize(URL location, ResourceBundle resources) {




    }
    public void FoodAction(){

    }

    public void WineAction() {

    }

    public void KittyLitterAction() {
    }

    public void CatNipAction() {
    }

    public void LogOutAction() {
    }

    public void CartAction() {
    }

    public void ExitAction() {
        System.exit(0);
    }
}
