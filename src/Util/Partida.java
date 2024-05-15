package Util;

public class Partida {
    String idPartida;
    String jugador1;
    String jugador2;
    String jugadorGanador;
    String eleccionJugador1;
    String eleccionJugador2;

    public Partida(String idPartida, String jugador1, String eleccionJugador1) {
        this.idPartida = idPartida;
        this.jugador1 = jugador1;
        this.eleccionJugador1 = eleccionJugador1;
    }
}
