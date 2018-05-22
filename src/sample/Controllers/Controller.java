package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Classes.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    PreparedMethods pm = new PreparedMethods();
    
    // NNA: Fetch the database object from the Singleton to avoid re-initializing the database
    DataBase myDB = DatabaseSingleton.getInstance().getDb();
    
    
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
            
            
            //NNA: No need for this as we have a instance variable
            //DataBase myDB = new DataBase();
            String password = pass.passwordEncryption(passwordField.getText());
            if (myDB.adminLogin(usernameField.getText(), password)) {
                String email = myDB.Email(usernameField.getText());
                NameTransfer.getInstance().setName(usernameField.getText());
                NameTransfer.getInstance().setEmail(email);
                pm.changeScene(event, "/sample/fxml/AdminProductsSample.fxml", "Admin");
            } else if (!myDB.adminLogin(usernameField.getText(), password) && !myDB.blockedUser(usernameField.getText(), password)) {
                
                myDB.memberLogIn(usernameField.getText(), password);
                String email = myDB.Email(usernameField.getText());
                NameTransfer.getInstance().setName(usernameField.getText());
                NameTransfer.getInstance().setEmail(email);
                
                pm.changeScene(event, "/sample/fxml/ProductsSample.fxml", "products");
            } else if (!myDB.adminLogin(usernameField.getText(), password) && myDB.blockedUser(usernameField.getText(), password)) {
                pm.showAlert("You have been blocked", "Please contact administrator", "thecatstoreproject@gmail.com");
            }
            
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Memeber name  not found and/or password incorrect ");
            alert.setHeaderText("Re-enter password and/or Member name");
            alert.showAndWait();
        }
    }
    
    public void RegisterAction(ActionEvent event) throws IOException {
        pm.changeScene(event, "/sample/fxml/CreateAccountSample.fxml", "Register");
    }
    
    
    public void GuestAction(ActionEvent event) throws IOException {
        
        // NNA: No need for this as we have an instance variable
        ///DataBase myDB = new DataBase();
        myDB.GuestLogIn();
        NameTransfer.getInstance().setName("Guest");
        
        pm.changeScene(event, "/sample/fxml/ProductsSample.fxml", "products");
        
        
    }
    
    public void forgotPassword(ActionEvent event) throws IOException {
        Emailsender forgot = new Emailsender();
        String email = myDB.Email(usernameField.getText());
        ArrayList<Member> member = new ArrayList<>();
        member = myDB.getMemberList2();
        for (int i = 0; i < member.size(); i++) {
            if (usernameField.getText().equals(member.get(i).getName())) {
                String password = member.get(i).getPassword();
                System.out.println("check encrypted password: " + password);
                
                StringBuilder encryptPass = new StringBuilder(password);  //TODO Maybe use StringBuilder instead, it is faster than buffer
                System.out.println("pass from db: " + encryptPass.toString());
                
                
                for (int e = 0; e < password.length(); e++) {
                    
                    int temp = 0;
                    
                    temp = (int) encryptPass.charAt(e);
                    temp = temp / 9;
                    encryptPass.setCharAt(e, (char) temp);
                    
                    
                }
                System.out.println("new pass: " + encryptPass.toString());
                
                forgot.forgotPassword(email, encryptPass.toString());
                
            }
        }
        
        
    }
    
}






