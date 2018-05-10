package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import sample.Classes.DataBase;

import java.net.URL;
import java.util.ResourceBundle;

public class databaseController implements Initializable {

    @FXML
    private TextField namefield, ingridientfield, weightfield, originfield, detailfield, pricefield;
    @FXML
    private ChoiceBox<String> productype = new ChoiceBox<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productype.getItems().add("KittyLitter");
        productype.getItems().add("food");
        productype.getItems().add("CatWine");
        productype.getItems().add("CatNip");


    }

    @FXML
    public void addNewProduct() {
        try {


            DataBase mydb = new DataBase();
            mydb.addItem(productype.getSelectionModel().getSelectedItem(), namefield.getText(), ingridientfield.getText(),
                    Double.parseDouble(weightfield.getText()), originfield.getText(), detailfield.getText(),
                    Integer.parseInt(pricefield.getText()));
            System.out.println("added in dbcontroller");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
