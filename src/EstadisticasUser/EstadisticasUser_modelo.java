package EstadisticasUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Util.Jugador;

public class EstadisticasUser_modelo {
    static Jugador obtenerEstadisticas(String usuario) {
        // Buscar en la base de datos las estadísticas del jugador
        try {
            Connection conexionBD = ConexionBD.BD.conectarBD();
            // Si la conexión es nula, mostrar un mensaje de error
            if (conexionBD == null) {
                System.out.println("Error al conectar con la BD");
                // Si la conexión no es nula, ejecutar la consulta
            } else {
                // Crear un Statement para ejecutar la consulta
                try (Statement consulta = conexionBD.createStatement()) {
                    // Crear la consulta
                    String sql = "SELECT * FROM Jugador WHERE Username = '" + usuario + "'";
                    consulta.executeQuery(sql);
                    // Si la consulta devuelve un resultado, el login es correcto
                    if (consulta.getResultSet().next()) {
                        Jugador jugador = new Jugador(consulta.getResultSet().getString("Username"),
                                consulta.getResultSet().getInt("GamesWon"),
                                consulta.getResultSet().getInt("GamesPlayed"));
                        return jugador;
                    }
                    // Si la consulta no devuelve un resultado, el login es incorrecto
                    
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al seleccionar la partida");
        }
        return null;
    }

}
