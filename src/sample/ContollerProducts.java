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
    public void CatNipAction(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CatNipSample.fxml"));
        Parent root = loader.load();

        stage.setTitle("FoodList");
        stage.setScene(new Scene(root));
        stage.show();


    }
    public void KittyLitterAction(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("KittyLitterSample.fxml"));
        Parent root = loader.load();

        stage.setTitle("FoodList");
        stage.setScene(new Scene(root));
        stage.show();


    }
    public void WineAction(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WineListSample.fxml"));
        Parent root = loader.load();

        stage.setTitle("FoodList");
        stage.setScene(new Scene(root));
        stage.show();


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






