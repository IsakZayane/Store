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
import sample.Classes.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class ShoppingCartController implements Initializable {
    PreparedMethods pm = new PreparedMethods();

    @FXML
    TextArea cartView;
    @FXML
    TableView<Item> tableArea;
    @FXML
    TableColumn nameCol, priceCol;


    private ObservableList<Item> myList = FXCollections.observableArrayList();
    private ArrayList<Item> myItem = new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        myItem = Shoppingcartsingleton.getInstance().getShoppingcart();


        nameCol.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));
        tableArea.setItems(myList);

        myList.addAll(myItem);

        for (int i = 0; i < myList.size(); i++) {
            cartView.appendText(myList.get(i).getName() + "       " + myList.get(i).getPrice() + "\n");
        }


        for (int i = 0; i < myItem.size(); i++) {

            tableArea.setItems(myList);
        }


    }


    public void goBackAction(ActionEvent event) {
        //NNA: We could use the Singleton directly instead of first assigning it to a variable.
        //DataBase db = new DataBase();

        if (DatabaseSingleton.getInstance().getDb().isAdmin()) {

            pm.changeScene(event, "/sample/fxml/AdminProductsSample.fxml", "products");
        } else {
        }
        pm.changeScene(event, "/sample/fxml/ProductsSample.fxml", "products");


    }
    public void backLogInAction(ActionEvent event){
        pm.clearUserInfo();


        pm.changeScene(event, "/sample/fxml/Sample.fxml","login");
    }
    public void exitAction(){
        System.exit(0);
    }

    public void orderAction() {


        // NNA: Here we fetch the database object from the Singleton as the object will be used repeatedly.
        DataBase db = DatabaseSingleton.getInstance().getDb();
       java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());


        db.paymentsInsert(sqldate, NameTransfer.getInstance().getTotalsum(), NameTransfer.getInstance().getName());
        db.orderDetails(sqldate, NameTransfer.getInstance().getName());
        Emailsender es = new Emailsender();
        es.sendEmail(NameTransfer.getInstance().getEmail(), cartView.getText(), db.getOrderId(NameTransfer.getInstance().getName()),
                NameTransfer.getInstance().getTotalsum());
        for (int i = 0; i < myItem.size(); i++) {
            db.orderSpecifics(NameTransfer.getInstance().getName(), myItem.get(i).getName(),
                 Collections.frequency(myItem,myItem.get(i)));
        }

            Shoppingcartsingleton.getInstance().clearShoppincart();
            NameTransfer.getInstance().clearTotalsum();
            cartView.clear();
            myList.clear();
            tableArea.getItems().clear();
            tableArea.refresh();


        }


    }




