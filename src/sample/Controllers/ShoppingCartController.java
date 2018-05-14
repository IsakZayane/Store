package sample.Controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classes.DataBase;
import sample.Classes.Emailsender;
import sample.Classes.NameTransfer;
import sample.Classes.Shoppingcartsingleton;

import sample.Classes.PreparedMethods;

import java.net.URL;

import sample.Classes.*;

import java.util.ArrayList;

import java.util.ResourceBundle;

public class ShoppingCartController implements Initializable {
    PreparedMethods pm = new PreparedMethods();

@FXML TextArea cartView;
@FXML
TableView<Item> tableArea;
@FXML TableColumn nameCol, priceCol;

ObservableList<Item> myList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


//cartView.setText(String.valueOf(Shoppingcartsingleton.getInstance().getShoppingcart()));
    //cartView.setText(Shoppingcartsingleton.getInstance().getShoppingcart().toString());


        ArrayList<Item> myItem = new ArrayList<>();
        myItem.addAll(Shoppingcartsingleton.getInstance().getShoppingcart());
        nameCol.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));
        tableArea.setItems(myList);

     myList.addAll(Shoppingcartsingleton.getInstance().getShoppingcart()); 



    for (int i =0; i < myList.size(); i ++) {
        // nameCol.setCellValueFactory();
        // nameCol.setCellValueFactory();

        //myList.get(i).getName();
        //tableArea.setItems(myList);
        cartView.appendText(myList.get(i).getName()+"       "+ myList.get(i).getPrice()+"\n");






    }



    }


    public void goBack(ActionEvent event){

       pm.changeScene(event, "/sample/fxml/ProductsSample.fxml","products");



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
