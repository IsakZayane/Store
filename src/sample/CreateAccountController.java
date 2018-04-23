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

    //TODO UserName, UserEmail, Password. är ordningen i createUser metod under DataBase

    public void EnterName() {
        //member.setName(usernameField.getText());


    }


    public void EnterEmail() {
        //member.setEmail(emailTextField.getText());

    }

    public void EnterPassword() {

    }
    public void ReEnterPassword(){

    }

    public void CreateAction(){
        member.setName(usernameField.getText());
        member.setEmail(emailTextField.getText());
        myDB.createUser(member.getName(),member.getEmail());


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

    public void passwordEncryption(String password){

        StringBuffer encryptPass = new StringBuffer(password);  //TODO Maybe use StringBuilder instead, it is faster than buffer


        for (int i = 0; i <password.length(); i++ ){

            int temp = 0;

            temp = (int) encryptPass.charAt(i);
            temp = temp*2+5;
            encryptPass.setCharAt(1, (char) temp);

        }

    }


}

