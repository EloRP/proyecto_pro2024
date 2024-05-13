package Pruebas;
public class Eleccion {
    protected TipoEleccion tipo;

    public int ganaA(Eleccion eleccionRival) throws Exception {
        int resultado = 0; // Por defecto, asumimos empate

        // Verificar si las elecciones son iguales
        if (tipo == eleccionRival.tipo) {
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
        if (relacionesVictoria[tipo.ordinal()][eleccionRival.tipo.ordinal()]) {
            resultado = 1; // Jugador gana
        } else if (relacionesVictoria[eleccionRival.tipo.ordinal()][tipo.ordinal()]) {
            resultado = 2; // Jugador pierde
        }

        return resultado;
    }
}
