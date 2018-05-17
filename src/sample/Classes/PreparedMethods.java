package sample.Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class PreparedMethods {


    public void changeScene(ActionEvent event, String fxml, String title) {
        try {


            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            stage.setTitle(title);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {

        }
    }


    public void showAlert(String title, String message, String messageTwo) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.setContentText(messageTwo);
        alert.showAndWait();


    }
    public void clearUserInfo(){
        NameTransfer.getInstance().setName("");
        NameTransfer.getInstance().setEmail("");
        Shoppingcartsingleton.getInstance().clearShoppincart();
        NameTransfer.getInstance().clearTotalsum();
    }


}
