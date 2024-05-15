package ListaPartidas;

import Util.Util;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class ListaPartidas_controller {

    @FXML
    private Button botonVueltaMenu;

    @FXML
    private ListView<String> listaPartidas;

    @FXML
    private Label listaPartidasDatos;

    @FXML
    void loadMatchMethod(MouseEvent event) {
        String partidaSeleccionada = listaPartidas.getSelectionModel().getSelectedItem();

        if (partidaSeleccionada != null) {
            Util cambiarEscena = new Util();
            // Antes de llamar a cambiarEscena
            cambiarEscena.cambiarEscena("../Partida/paginaPartida_proyecto.fxml", listaPartidas,
                    partidaSeleccionada);
        }
    }

    @FXML
    void metodoVolverMenu(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml", botonVueltaMenu);
    }

    @FXML
    private void initialize() {
        // Cargar las partidas disponibles, si no hay mostrar una alerta
        ObservableList<String> partidas = ListaPartidas_modelo.buscarPartidas();
        listaPartidas.setItems(partidas);
        if (!ListaPartidas_modelo.hayPartidas(partidas)) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información");
            alerta.setHeaderText("No hay partidas disponibles");
            alerta.setContentText("Ningún jugador ha creado una partida.");
            alerta.showAndWait();
        }
    }

}
