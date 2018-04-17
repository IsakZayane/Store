package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ContollerProducts implements Initializable {
    @FXML
    private Label loggedin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggedin.setText(NameTransfer.getInstance().getName());

    }

    public void FoodAction() {

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






