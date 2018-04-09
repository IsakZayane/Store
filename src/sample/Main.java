package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello you");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        DataBase myDB = new DataBase();

        myDB.showItems();
        myDB.getUpdate();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
