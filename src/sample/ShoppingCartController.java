package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
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
        DataBase db = new DataBase();
        java.util.Date date = new java.util.Date();
        Emailsender es = new Emailsender();
        es.sendEmail(NameTransfer.getInstance().getEmail(), String.valueOf(Shoppingcartsingleton.getInstance()
                .getShoppingcart()),db.getOrderId(NameTransfer.getInstance().getName()));
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        db.orderDetails(sqldate,NameTransfer.getInstance().getName());




    }


}
