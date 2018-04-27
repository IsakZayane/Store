package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ContollerProducts implements Initializable {
    Controller cs = new Controller();
    DataBase db = new DataBase();
    @FXML
    private Label loggedin;
    @FXML private TextArea itemarea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggedin.setText(NameTransfer.getInstance().getName());

    }


    public void FoodAction(ActionEvent event)  {
        cs.changeScene(event,"FoodlistSample.fxml","Foodlist");


    }


    public void WineAction() {

    }

    public void KittyLitterAction() {
    }

    public void CatNipAction() {
    }

    public void LogOutAction(ActionEvent event) throws IOException {
        cs.changeScene(event,"sample.fxml","login");
    }

    public void CartAction() {
    }

    public void ExitAction() {
        System.exit(0);
    }


    }






