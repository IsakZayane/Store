package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ContollerProducts implements Initializable {
    DataBase db = new DataBase();
    @FXML
    private Label loggedin;
    @FXML private TextArea itemarea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggedin.setText(NameTransfer.getInstance().getName());

    }

    public void FoodAction() {
     //methods for showing items



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






