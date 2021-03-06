package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Classes.DataBase;
import sample.Classes.DatabaseSingleton;
import sample.Classes.Member;
import sample.Classes.PreparedMethods;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccountController implements Initializable {
    
    PreparedMethods pm = new PreparedMethods();
    Member member = new Member();
    
    //NNA: Fetch the database object from the Singleton to avoid having to re-initialize it.
    DataBase myDB = DatabaseSingleton.getInstance().getDb();
    
    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField repasswordField;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    
    }
    
    @FXML
    public void createMember() {
        if (passwordField.getText().equals(repasswordField.getText())) {
            
            if (usernameField.getText().isEmpty()) {
                pm.showAlert("Please enter a account name", "Account name cannot be empty", "Please try again");
                throw new IllegalArgumentException();
                
            } else if (emailTextField.getText().isEmpty()) {
                pm.showAlert("Please enter your email adress here", "Email adress cannot be empty", "Please try again");
                
                throw new IllegalArgumentException();
            } else if (passwordField.getText().isEmpty()) {
                pm.showAlert("Pleaase enter a password", "Password field cannot be empty", "Please try again");
                
                throw new IllegalArgumentException();
            }
            
            
            String userName = usernameField.getText();
            String userEmail = emailTextField.getText();
            
            String password = passwordField.getText();
            
            
            String encryptedPassword = passwordEncryption(password);
            System.out.println(userName + userEmail + encryptedPassword);
            
            myDB.createUser(userName, userEmail, encryptedPassword);
            
            pm.showAlert("Info", "Account created", "");
            
            usernameField.clear();
            passwordField.clear();
            emailTextField.clear();
            repasswordField.clear();
            
        } else
            pm.showAlert("Alert", "Passwords dont match", "rewrite password");
    }
    
    
    //TODO UserName, UserEmail, Password. är ordningen i createUser metod under DataBase
    
    
    public void GoBackAction(ActionEvent event) {
        pm.changeScene(event, "/sample/fxml/Sample.fxml", "log in");
        
    }
    
    public void ProceedAction() {
    
    }
    
    public String passwordEncryption(String password) {  //det vi får från den här metoden skall sparas i databasen som password, till rätt user
        
        StringBuilder encryptPass = new StringBuilder(password);  //TODO Maybe use StringBuilder instead, it is faster than buffer
        
        
        for (int i = 0; i < password.length(); i++) {
            
            int temp = 0;
            
            temp = (int) encryptPass.charAt(i);
            temp = temp * 9;
            encryptPass.setCharAt(i, (char) temp);
            
            
        }
        System.out.println("new pass: " + encryptPass.toString());
//        for (int i = 0; i < password.length(); i++) {
//
//            int temp = 0;
//
//            temp = (int) encryptPass.charAt(i);
//            temp = temp / 9;
//            encryptPass.setCharAt(i, (char) temp);
//
//
//
//        }
//        System.out.println("old pass: "+encryptPass.toString());
        
        return encryptPass.toString();
        
    }
    
    
}


