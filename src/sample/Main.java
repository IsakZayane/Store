package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));

        primaryStage.setTitle("CatFood!");

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        DataBase myDB = new DataBase();


        myDB.showItems();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
