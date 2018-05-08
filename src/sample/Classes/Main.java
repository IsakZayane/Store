package sample.Classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/sample/fxml/Sample.fxml"));


        primaryStage.setTitle("CatFood!");
        Scene scene = new Scene(root);

        primaryStage.setResizable(false);


        primaryStage.setScene(scene);
        primaryStage.show();
        DataBase myDB = new DataBase();

    }


    public static void main(String[] args) {
        launch(args);
    }
}