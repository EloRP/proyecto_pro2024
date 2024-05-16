package ListaPartidas;

import Util.Util;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
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


    // TODO IMPLEMENTAR LOS MÉTODOS DE OSCURECER Y DESOSCURECER LOS ÍTEMS DE LA LISTA, AHORA NO
    // FUNCIONAN
    @FXML
    void metodoOscurecerPartida(MouseEvent event) {
        // Obtener el ítem de la lista sobre el cual estaba el ratón
        Node node = event.getPickResult().getIntersectedNode();
        // Verificar si el nodo es un ítem de la lista
        if (node instanceof Labeled && !(node instanceof Label)) {
            // Cambiar el estilo del nodo para oscurecerlo
            node.setStyle("-fx-background-color: #d3d3d3");
        }
    }

    @FXML
    void metodoDesoscurecerPartida(MouseEvent event) {
        // Obtener el ítem de la lista sobre el cual estaba el ratón
        Node node = event.getPickResult().getIntersectedNode();
        // Verificar si el nodo es un ítem de la lista
        if (node instanceof Labeled && !(node instanceof Label)) {
            // Restaurar el estilo del nodo para desoscurecerlo
            node.setStyle("-fx-background-color: transparent");
        }
    }
    



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
