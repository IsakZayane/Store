package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Classes.DataBase;
import sample.Classes.Emailsender;
import sample.Classes.NameTransfer;
import sample.Classes.Shoppingcartsingleton;

import sample.Classes.PreparedMethods;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ShoppingCartController implements Initializable {
    PreparedMethods pm = new PreparedMethods();

@FXML TextArea cartView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


cartView.setText(String.valueOf(Shoppingcartsingleton.getInstance().getShoppingcart()));
cartView.setText(Shoppingcartsingleton.getInstance().getShoppingcart());



    }


    public void goBack(ActionEvent event){

       pm.changeScene(event,"/sample/fxml/productssample.fxml","products");


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
