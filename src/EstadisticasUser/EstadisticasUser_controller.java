package EstadisticasUser;

import Util.Jugador;
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
    private Label estadisticasDeJugador;

    @FXML
    private Label partidasGanadas;

    @FXML
    private Label partidasJugadas;

    @FXML
    private Label partidasPerdidas;

    @FXML
    private Label ratioVictorias;

    @FXML
    void metodoEnsenharTopJugadores(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../EleccionEstadisticas/paginaEleccionEstadisticas_proyecto.fxml",
                botonTopPlayers);
    }

    @FXML
    void metodoVolverMenu(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml", botonVueltaMenu);
    }

    @FXML
    void initialize() {
        // Obtener las estadísticas del jugador
        Jugador usuario = EstadisticasUser_modelo.obtenerEstadisticas(Util.getUsername());
        // Mostrar el nombre del jugador
        estadisticasDeJugador.setText("Estadísticas de " + usuario.getUsername());
    }

}
