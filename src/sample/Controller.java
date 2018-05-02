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
            NameTransfer.getInstance().setName(usernameField.getText());

            changeScene(event,"productssample.fxml","products");


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Memeber name  not found and/or password incorrect ");
            alert.setHeaderText("Re-enter password and/or Member name");
            alert.showAndWait();
        }
    }

    public void RegisterAction(ActionEvent event) throws IOException {
       changeScene(event,"CreateAccountSample.fxml","Register");
    }



    public void GuestAction(ActionEvent event) throws IOException {
        myDB.GuestLogIn();
        NameTransfer.getInstance().setName("Guest");

        changeScene(event,"productssample.fxml","products");


    }

    public void TempAdmin(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("databaseSample.fxml"));
        Parent root = loader.load();

        stage.setTitle("Admin");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void changeScene(ActionEvent event, String fxml, String title) {
        try {


            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {

        }
    }


}