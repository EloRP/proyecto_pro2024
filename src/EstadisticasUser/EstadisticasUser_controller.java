package EstadisticasUser;

import Util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class EstadisticasUser_controller {

    @FXML
    private Button botonTopPlayers;

    @FXML
    private Button botonVueltaMenu;

    @FXML
    private Label estadisticasJugador;

    @FXML
    private ListView<?> listaEstadisticasUser;

    @FXML
    void metodoEnsenharTopJugadores(ActionEvent event) {

    }

    @FXML
    void metodoVolverMenu(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml", botonVueltaMenu);
    }

}
