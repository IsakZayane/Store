package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Classes.DataBase;
import sample.Classes.NameTransfer;
import sample.Classes.PreparedMethods;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    PreparedMethods pm = new PreparedMethods();




    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button signInButton;
    @FXML
    private Button registerButton;
    @FXML
    private Button guestButton, shoppingCartButton;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


        System.out.println("test2");





    }



    public void SignInAction(ActionEvent event) throws IOException {

        CreateAccountController pass = new CreateAccountController();
        try {


            DataBase myDB = new DataBase();
            int password = pass.passwordEncryption(passwordField.getText());
            if (myDB.adminLogin(usernameField.getText(),password)){
                String email = myDB.Email(usernameField.getText());
                NameTransfer.getInstance().setName(usernameField.getText());
                NameTransfer.getInstance().setEmail(email);
                pm.changeScene(event, "/sample/fxml/AdminProductsSample.fxml","Admin");
            }else if (!myDB.adminLogin(usernameField.getText(),password) && !myDB.blockedUser(usernameField.getText(),password)){

                myDB.memberLogIn(usernameField.getText(), password);
                String email = myDB.Email(usernameField.getText());
                NameTransfer.getInstance().setName(usernameField.getText());
                NameTransfer.getInstance().setEmail(email);

                pm.changeScene(event, "/sample/fxml/ProductsSample.fxml", "products");
            }else if (!myDB.adminLogin(usernameField.getText(),password) && myDB.blockedUser(usernameField.getText(),password)){
                pm.showAlert("You have been blocked","Please contact administrator","thecatstoreproject@gmail.com");
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Memeber name  not found and/or password incorrect ");
            alert.setHeaderText("Re-enter password and/or Member name");
            alert.showAndWait();
        }
    }

    public void RegisterAction(ActionEvent event) throws IOException {
       pm.changeScene(event,"/sample/fxml/CreateAccountSample.fxml","Register");
    }



    public void GuestAction(ActionEvent event) throws IOException {

        DataBase myDB = new DataBase();
        myDB.GuestLogIn();
        NameTransfer.getInstance().setName("Guest");

        pm.changeScene(event, "/sample/fxml/ProductsSample.fxml","products");




    }

    }






