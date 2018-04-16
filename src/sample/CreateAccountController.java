package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccountController implements Initializable {
    Member member = new Member();
    Main myApp = new Main();
    DataBase myDB = new DataBase();
    @FXML private TextField usernameField;
    @FXML private  TextField emailTextField;
    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    public void EnterName() {
        member.setName(usernameField.getText());


    }


    public void EnterEmail() {
        member.setEmail(emailTextField.getText());

    }

    public void EnterPassword() {

    }
    public void ReEnterPassword(){
    }

    public void CreateAction(){
        member.setName(usernameField.getText());
        myDB.createUser(member.getName());


    }
    public void GoBackAction(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        stage.setTitle("Admin");
        stage.setScene(new Scene(root));
        stage.show();

    }
    public void ProceedAction(){
    }
}


