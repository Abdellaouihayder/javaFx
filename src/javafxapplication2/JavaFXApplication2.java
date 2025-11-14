package javafxapplication2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Asus
 */
public class JavaFXApplication2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
   
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxapplication2/hayder/GUI/home.fxml"));
    Scene scene = new Scene(loader.load());
    scene.getStylesheets().add(getClass().getResource("/javafxapplication2/hayder/GUI/home.css").toExternalForm());
    stage.setTitle("welcome to our application");
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
