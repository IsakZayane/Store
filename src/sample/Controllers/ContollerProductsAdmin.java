package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import sample.Classes.NameTransfer;
import sample.Classes.PreparedMethods;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContollerProductsAdmin implements Initializable {
   PreparedMethods pm = new PreparedMethods();

    @FXML
    private Label loggedin;
    @FXML private TextArea itemarea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggedin.setText(NameTransfer.getInstance().getName());

    }


    public void FoodAction(ActionEvent event) throws IOException {
        pm.changeScene(event,"/sample/fxml/FoodListSample.fxml","Food list");


    }
    public void CatNipAction(ActionEvent event) throws IOException {
        pm.changeScene(event,"/sample/fxml/CatNipSample.fxml","Catnip");


    }
    public void KittyLitterAction(ActionEvent event) throws IOException {
        pm.changeScene(event,"/sample/fxml/KittyLitterSample.fxml","Kitty litter");


    }
    public void WineAction(ActionEvent event) throws IOException {
        pm.changeScene(event,"/sample/fxml/WineListSample.fxml","Wine list");


    }
    public void ModifyAction(){

    }




    public void LogOutAction(ActionEvent event) throws IOException {
        pm.changeScene(event,"/sample/fxml/sample.fxml","login");
    }

    @FXML public void CartAction(ActionEvent event) {

        pm.changeScene(event,"/sample/fxml/ShoppingCartSample.fxml", "Shoppingcart");

        System.out.println("Connected");

    }

    public void ExitAction() {
        System.exit(0);
    }


    }






