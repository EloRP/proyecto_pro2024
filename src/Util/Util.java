package Util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Util {

    public void cambiarEscena(String fxml, Button boton) {
        Stage primaryStage;
        Parent root;

        try {
            primaryStage = (Stage) boton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Error al cambiar de escena");
        }


    }

    // Variable estática para guardar el nombre de usuario para poder usarlo en cualquier escena
    static String username;

    public static void setUsername(String username) {
        Util.username = username;
    }

    public static String getUsername() {
        return Util.username;
    }

}
