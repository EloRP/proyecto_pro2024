package Menu;

import Modelo_sin_interfaz.SwitchScene;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainPage_controller {

    @FXML
    private Button botonBuscarPartida;

    @FXML
    private Label labelUsuario;

    @FXML
    private Button botonCrearPartida;

    @FXML
    private Button botonInfo;

    @FXML
    private Button botonSalirJuego;

    @FXML
    private Button botonEstadisticas;



    @FXML
    void metodoBuscarPartida(ActionEvent event) {
        ObservableList<String> partidas = Menu_modelo.buscarPartidas();
        if (partidas != null) {
            SwitchScene cambiarEscena = new SwitchScene();
            cambiarEscena.cambiarEscena("../ListaPartidas/listaPartidas_proyecto.fxml",
                    botonBuscarPartida, partidas);
        } else {
            System.out.println("Hubo un error al buscar las partidas");
        }
    }

    @FXML
    void metodoCrearPartida(ActionEvent event) {

    }

    @FXML
    void metodoEnsenharInfo(ActionEvent event) {
        Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
        alertaInfo.setTitle("Información");
        alertaInfo.setHeaderText("Piedra, peper, tijera, lagarto, spock");
        alertaInfo.setContentText("Programa hecho por Eloy Rodal Pérez y Xabier Cendón Pazos");
        alertaInfo.showAndWait();
    }

    @FXML
    void metodoSalirJuego(ActionEvent event) {
        SwitchScene cambiarEscena = new SwitchScene();
        cambiarEscena.cambiarEscena("../Login/paginaLogin_proyecto.fxml", botonSalirJuego);
    }

    @FXML
    void metodoMostrarEstadisticas(ActionEvent event) {

    }
}
