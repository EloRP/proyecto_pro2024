package Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Menu_modelo {

    public static ObservableList<String> buscarPartidas() {
        // Crear una lista observable para almacenar las partidas
        ObservableList<String> partidas = FXCollections.observableArrayList();
        // Inicializar la conexión a la BD
        Connection conexionBD = ConexionBD.BD.conectarBD();
        // Si la conexión es nula, mostrar un mensaje de error
        if (conexionBD == null) {
            System.out.println("Error al conectar con la BD");
            // Si la conexión no es nula, ejecutar la consulta
        } else {
            // Crear un Statement para ejecutar la consulta
            try (Statement consulta = conexionBD.createStatement()) {
                // Crear la consulta
                String sql =
                        "SELECT * FROM Partida WHERE JugadorGanador IS NULL and Jugador2 IS NULL";
                consulta.executeQuery(sql);
                // Si la consulta devuelve un resultado, mostrar las partidas
                if (consulta.getResultSet().next()) {
                    System.out.println("Partidas encontradas");
                    // Recorrer los resultados de la consulta y añadirlos a la lista de partidas
                    ResultSet rs = consulta.getResultSet();
                    while (rs.next()) {
                        // Concatenar los valores de todas las columnas en una cadena
                        String partida = rs.getString("ID") + " - " + rs.getString("Jugador1");
                        // Agregar la cadena a la lista de partidas
                        partidas.add(partida);
                    }
                    // Si la consulta no devuelve un resultado, mostrar un mensaje de que no hay
                    // partidas
                } else {
                    System.out.println("No hay partidas");
                }
                // Si hay un error al ejecutar la consulta, mostrar un mensaje de error
            } catch (SQLException e1) {
                System.out.println("Error al ejecutar guardar las partidas en la lista");
            }
            // Cerrar la conexión con la BD
            try {
                conexionBD.close();
                // Si hay un error al cerrar la conexión, mostrar un mensaje de error
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión con la BD.");
            }
        }
        return partidas;
    }

}
