package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ShoppingCartController implements Initializable {
    Controller cs = new Controller();
    
    @FXML TextField cartView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    public void goBack(ActionEvent event){

       cs.changeScene(event,"productssample.fxml","products");


    }


}
