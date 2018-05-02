package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class databaseController implements Initializable {

    @FXML
    private TextField nameProdField, priceProdField, typeProdField;
    @FXML
    private Button addItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

  @FXML  public void addNewProduct() {

        String name, type;
        Integer price;

        price = Integer.parseInt(priceProdField.getText());


        name = nameProdField.getText();
        type = typeProdField.getText();

        DataBase db = new DataBase();


        db.addItem(name,type,price);


    }

}
