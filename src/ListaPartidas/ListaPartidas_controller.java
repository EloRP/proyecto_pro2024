package ListaPartidas;

import Util.Util;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class ListaPartidas_controller {
    public static ObservableList<String> partidas;

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
            cambiarEscena.cambiarEscena("../ParticiparPartida/paginaPartida_proyecto.fxml",
                    listaPartidas, partidaSeleccionada);
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
        listaPartidas.setItems(partidas);
    }

}
