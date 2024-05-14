package Modelo_sin_interfaz;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SwitchScene {

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

    public void cambiarEscena(String fxml, Button boton, ObservableList<String> partidas) {
        Stage primaryStage;
        Parent root;

        try {
            primaryStage = (Stage) boton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            ListaPartidas.ListaPartidas_controller controller = loader.getController();
            controller.setListViewPartidas(partidas);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Error al cambiar de escena");
        }
    }


    // Variable estática para guardar el nombre de usuario para poder usarlo en cualquier escena
    static String username;

    public static void setUsername(String username) {
        SwitchScene.username = username;
    }

    public static String getUsername() {
        return SwitchScene.username;
    }

}
