package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    private SwitchScene getPrimaryStage = new SwitchScene();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("PPTLS Game");

        Parent root = FXMLLoader.load(getClass().getResource("../Login/paginaLogin_proyecto.fxml"));
        
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public SwitchScene getGetPrimaryStage() {
        return getPrimaryStage;
    }
}
