package ParticiparPartida;

import Util.Eleccion;
import Util.Partida;
import Util.Util;

class ParticiparPartida_modelo {
    static Partida partida;

    static void guardarDatosPartida(Eleccion eleccion) throws Exception {
        // Guardar los datos de la partida
        partida.setEleccionJugador2(eleccion);
        partida.setJugador2(Util.getUsername());
        

        // Guardar los datos de la partida en la base de datos
        Util.guardarDatosJugador2PartidaEnBD(partida);

        partida.setJugadorGanador(determinarGanador() == 1 ? partida.getJugador2() : determinarGanador() == 2 ? partida.getJugador1() : null);
        Util.guardarDatosJugadorGanadorPartidaEnBD(partida);
        Util.actualizarPartidasGanadasYJugadas(partida);

    }

    public static void crearObjetoPartida(String idPartida, String jugador1,
            String eleccionjugador1) {
        partida = new Partida(idPartida, jugador1, eleccionjugador1);
    }


    private static int determinarGanador(Partida partida) throws Exception {
        int resultado = 0; // Por defecto, asumimos empate

        // Verificar si las elecciones son iguales
        if (partida.getEleccionJugador1() == partida.getEleccionJugador2()) {
            return resultado; // Devolver empate
        }

        // Definir relaciones de victoria en una matriz
        boolean[][] relacionesVictoria = {
            // TIJERAS  PAPEL    PIEDRA   LAGARTO  SPOCK
            {false,   true,    false,   true,    false}, // TIJERAS
            {false,   false,   true,    false,   true},  // PAPEL
            {true,    false,   false,   true,    false}, // PIEDRA
            {false,   true,    false,   false,   true},  // LAGARTO
            {true,    false,   true,    false,   false}  // SPOCK
        };

        // Determinar el resultado basado en las relaciones de victoria
        if (relacionesVictoria[partida.getEleccionJugador2().ordinal()][partida.getEleccionJugador1().ordinal()]) {
            resultado = 1; // Jugador gana
            // Guardar los datos del jugador ganador (usuario) en la base de datos
        } else if (relacionesVictoria[partida.getEleccionJugador1().ordinal()][partida.getEleccionJugador2().ordinal()]) {
            resultado = 2; // Jugador pierde
        }
        return resultado;
    }

    static int determinarGanador() throws Exception {
        return determinarGanador(partida);
    }
}
