package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private GetPrimaryStage getPrimaryStage = new GetPrimaryStage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("PPTLS Game");
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("../Login/paginaLogin_proyecto.fxml"));
        Parent root = loader.load();

        // Guardar la primaryStage en una clase para poder acceder a ella desde cualquier controlador
        GetPrimaryStage colocarStage = new GetPrimaryStage();
        colocarStage.setPrimaryStage(primaryStage);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

      public GetPrimaryStage getGetPrimaryStage() {
        return getPrimaryStage;
    }
}
