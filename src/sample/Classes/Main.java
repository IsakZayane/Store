package sample.Classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/sample/fxml/Sample.fxml"));
        
        
        primaryStage.setTitle("CatFood!");
        Scene scene = new Scene(root);
        
        primaryStage.setResizable(false);
    
        // NNA: This is NOT a nice solution as the startup will get delayed while the database queries are
        //      executed. However, this is the simplest solution that minimizes the changes to the code and
        //      that initializes the database only once.
        DatabaseSingleton.getInstance().setDb(new DataBase());
    
    
        primaryStage.setScene(scene);
        primaryStage.show();
        //DataBase myDB = new DataBase();
        
        
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
