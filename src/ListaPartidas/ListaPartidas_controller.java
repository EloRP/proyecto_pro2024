package ListaPartidas;

import Modelo_sin_interfaz.SwitchScene;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    }

    @FXML
    void metodoVolverMenu(ActionEvent event) {
        SwitchScene cambiarEscena = new SwitchScene();
        cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml", botonVueltaMenu);
    }

    public void setListViewPartidas(ObservableList<String> partidas) {
        listaPartidas.setItems(partidas);
    }

}
