package sample;

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


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    DataBase myDB;
    //Main myApp = new Main();
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
        myDB = new DataBase();
        System.out.println("test2");

    }

    public void SignInAction(ActionEvent event) throws IOException {
        CreateAccountController pass = new CreateAccountController();
        try {

            int password = pass.passwordEncryption(passwordField.getText());

            myDB.memberLogIn(usernameField.getText(), password);
            String email=myDB.Email(usernameField.getText());
            NameTransfer.getInstance().setName(usernameField.getText());
            NameTransfer.getInstance().setEmail(email);

            pm.changeScene(event,"productssample.fxml","products");


        } catch (Exception e) {
            pm.showAlert("Error", "User account and password does not match", "Please re-enter your information or create an account");

        }
    }

    public void RegisterAction(ActionEvent event) throws IOException {
       pm.changeScene(event,"CreateAccountSample.fxml","Register");
    }



    public void GuestAction(ActionEvent event) throws IOException {
        myDB.GuestLogIn();
        NameTransfer.getInstance().setName("Guest");

        pm.changeScene(event,"productssample.fxml","products");


    }

    public void TempAdmin(ActionEvent event) throws IOException {



        pm.changeScene(event, "databaseSample.fxml", "Admin");


    }




}