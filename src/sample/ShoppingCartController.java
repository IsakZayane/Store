package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ShoppingCartController implements Initializable {
    Controller cs = new Controller();

@FXML TextArea cartView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


cartView.setText(String.valueOf(Shoppingcartsingleton.getInstance().getShoppingcart()));

    }


    public void goBack(ActionEvent event){

       cs.changeScene(event,"productssample.fxml","products");


    }
    public void orderAction(){
        Emailsender es = new Emailsender();
        es.sendEmail(NameTransfer.getInstance().getEmail(), String.valueOf(Shoppingcartsingleton.getInstance().getShoppingcart()));

    }


}
