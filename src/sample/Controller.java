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
import java.util.ResourceBundle;

public class Controller implements Initializable {
    DataBase myDB = new DataBase();
    Main myApp = new Main();
    ContollerProducts products = new ContollerProducts();

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button signInButton;
    @FXML
    private Button registerButton;
    @FXML
    private Button guestButton;
    CreateAccountController pass = new CreateAccountController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void SignInAction(ActionEvent event) throws IOException {

        try {

           int password = pass.passwordEncryption(passwordField.getText());

            myDB.memberLogIn(usernameField.getText(),password);
            NameTransfer.getInstance().setName(usernameField.getText());


            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("productssample.fxml"));
            Parent root = loader.load();

            stage.setTitle("Products");
            stage.setScene(new Scene(root));
            stage.show();


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Memeber name  not found and/or password incorrect ");
            alert.setHeaderText("Re-enter password and/or Member name");
            alert.showAndWait();
        }
    }

    public void RegisterAction(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateAccountSample.fxml"));
        Parent root = loader.load();

        stage.setTitle("Create Account");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void GuestAction(ActionEvent event) throws IOException {
        myDB.GuestLogIn();
        NameTransfer.getInstance().setName("Guest");




        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("productssample.fxml"));
        Parent root = loader.load();

        stage.setTitle("Products");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void TempAdmin(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("databasesample.fxml"));
        Parent root = loader.load();

        stage.setTitle("Admin");
        stage.setScene(new Scene(root));
        stage.show();

    }
}
