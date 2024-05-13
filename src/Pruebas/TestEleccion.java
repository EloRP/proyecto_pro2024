package Pruebas;

public class TestEleccion {
    public static void main(String[] args) throws Exception {
        Eleccion jugador = new Eleccion();
        for (TipoEleccion eleccionJugador : TipoEleccion.values()) {
            jugador.tipo = eleccionJugador;
            for (TipoEleccion eleccionRival : TipoEleccion.values()) {
                Eleccion rival = new Eleccion();
                rival.tipo = eleccionRival;
                int resultado = jugador.ganaA(rival);
                if (resultado == 1) {
                    System.out.println(eleccionJugador + " gana a " + eleccionRival);
                } else if (resultado == 0) {
                    System.out.println(eleccionJugador + " empata con " + eleccionRival);
                } else {
                    System.out.println(eleccionJugador + " pierde contra " + eleccionRival);
                }
            }
        }
    }

}
