package Main;

import java.io.IOException;
import Login.Login_modelo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GetPrimaryStage {
    Stage primaryStage;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void colocarStage(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(Login_modelo.class.getResource(fxml));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
    }
}
