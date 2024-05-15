package ParticiparPartida;

import Util.Partida;
import Util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ParticiparPartida_controller {

    @FXML
    private ImageView botonSeleccionLagarto;

    @FXML
    private ImageView botonSeleccionPapel;

    @FXML
    private ImageView botonSeleccionPiedra;

    @FXML
    private ImageView botonSeleccionSpock;

    @FXML
    private ImageView botonSeleccionTijera;

    @FXML
    private Button botonVueltaMenu;

    @FXML
    void metodoOscurecerEleccion(MouseEvent event) {
        // Obtener la imagen sobre la que pasó el ratón
        ImageView imagen = (ImageView) event.getSource();

        // Crear un efecto de desenfoque
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.3); 

        // Aplicar el efecto de desenfoque a la imagen
        imagen.setEffect(colorAdjust);
    }

    @FXML
    void metodoSeleccionLagarto(MouseEvent event) {

    }

    @FXML
    void metodoSeleccionPapel(MouseEvent event) {

    }

    @FXML
    void metodoSeleccionPiedra(MouseEvent event) {

    }

    @FXML
    void metodoSeleccionSpock(MouseEvent event) {

    }

    @FXML
    void metodoSeleccionTijera(MouseEvent event) {

    }

    @FXML
    void metodoVolverMenu(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml", botonVueltaMenu);
    }

    @FXML
    private void initialize() {
        Partida partida =
                new Partida(Util.datosPartida[0], Util.datosPartida[1], Util.datosPartida[2]);
    }

}

