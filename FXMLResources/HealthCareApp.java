//package FXMLResources;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.net.URL;

public class HealthCareApp extends Application
{
    @Override
    public void start (Stage primaryStage) {

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String file = classLoader.getResource("HealthCareApp-00.fxml").getFile();
            FXMLLoader lder = new FXMLLoader();
            lder.setLocation(new URL("file:" + file));
            Scene scene = lder.load();
            primaryStage.setTitle("Simple form example");
            primaryStage.setScene(scene);
            primaryStage.onCloseRequestProperty().setValue(e ->
            System.out.println("\nBye! See you later!"));
            primaryStage.show();
            } catch (Exception ex){
            ex.printStackTrace();
            }
    }
}
