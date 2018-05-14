package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Classes.DataBase;
import sample.Classes.Member;
import sample.Classes.PreparedMethods;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccountController implements Initializable {

    PreparedMethods pm = new PreparedMethods();
    Member member = new Member();
    DataBase myDB = new DataBase();

    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    public void createMember() {

        String userName = usernameField.getText();
        String userEmail = emailTextField.getText();

        String password = passwordField.getText();

        //passwordEncryption(password);

        int encryptedPassword = passwordEncryption(password);
        System.out.println(userName + userEmail + encryptedPassword);

        myDB.createUser(userName, userEmail, encryptedPassword);


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

    public void ReEnterPassword() {

    }

    /*    public void CreateAction(){
            member.setName(usernameField.getText());
            member.setEmail(emailTextField.getText());
            myDB.createUser(member.getName(),member.getEmail());


        }*/
    public void GoBackAction(ActionEvent event) {
       pm.changeScene(event, "/sample/fxml/Sample.fxml","log in");

    }

    public void ProceedAction() {

    }

    public int passwordEncryption(String password) {  //det vi får från den här metoden skall sparas i databasen som password, till rätt user

        StringBuilder encryptPass = new StringBuilder(password);  //TODO Maybe use StringBuilder instead, it is faster than buffer


        for (int i = 0; i < password.length(); i++) {

            int temp = 0;

            temp = (int) encryptPass.charAt(i);
            temp = temp * 2 + 5;
            encryptPass.setCharAt(1, (char) temp);


            return temp;

        }

        return 5;

    }


}


