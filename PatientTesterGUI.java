import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class PatientTesterGUI extends Application
{
    @Override
    public void start (Stage stage) {
        VBox vroot = new VBox(10);
        Scene scene = new Scene(vroot,300,250);

        MenuBar menuBar = new MenuBar();
        Menu menuPatientManagement = new Menu("Patient Management");
        Menu menuPatientOperations = new Menu("Patient Operations");
        Menu menuDatabaseManagement = new Menu("Patient Management");
 
        menuBar.getMenus().addAll(menuPatientManagement, menuPatientOperations, menuDatabaseManagement);
        VBox contentVBox = new VBox(10);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar,contentVBox );

        Label label1 = new Label("Patient Class Tester");


            
        contentVBox.setAlignment(Pos.CENTER);
        contentVBox.getChildren().addAll(label1); 


        stage.setScene(scene);
        stage.setTitle("Patient Class Tester");
        stage.show();
    }
    
}
