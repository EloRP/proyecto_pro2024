package Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Util {

    public void cambiarEscena(String fxml, Button boton) {
        Stage primaryStage;
        Parent root;

        try {
            primaryStage = (Stage) boton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Error al cambiar de escena");
            e.printStackTrace();
        }
    }

    // Variable estática para guardar los datos de la partida para poder usarlos en cualquier escena
    public static String[] datosPartida = new String[3];

    public void cambiarEscena(String fxml, ListView<?> listView, String partidaSeleccionada) {
        // Obtener el escenario y la raíz de la escena actual
        Stage primaryStage = (Stage) listView.getScene().getWindow();
        Parent root;

        try {
            // Cargar la nueva escena desde el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            // Guardar los datos de la partida seleccionada
            guardarDatosPartida(partidaSeleccionada);
            root = loader.load();
            // Establecer la nueva escena en el escenario
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Error al cambiar de escena");
            e.printStackTrace();
        }
    }



    public static void guardarDatosPartida(String partidaSeleccionada) {
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
                    String sql =
                            "SELECT * FROM Partida WHERE ID = " + partidaSeleccionada.split("-")[0];
                    consulta.executeQuery(sql);
                    // Si la consulta devuelve un resultado, el login es correcto
                    if (consulta.getResultSet().next()) {
                        datosPartida[0] = consulta.getResultSet().getString("ID");
                        datosPartida[1] = consulta.getResultSet().getString("Jugador1");
                        datosPartida[2] = consulta.getResultSet().getString("EleccionJugador1");
                    }
                    // Si la consulta no devuelve un resultado, el login es incorrecto
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                }
            }
            // Cerrar la conexión con la BD
            conexionBD.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar la partida");
        }
    }

    public static void guardarDatosJugador2PartidaEnBD(Partida partida) {
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
                    String sql = "UPDATE Partida SET Jugador2 = '" + partida.getJugador2()
                            + "', EleccionJugador2 = '" + partida.getEleccionJugador2()
                            + "' WHERE ID = " + partida.getIdPartida();
                    consulta.executeUpdate(sql);
                    // Si la consulta devuelve un resultado, el login es correcto
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                }
            }
            // Cerrar la conexión con la BD
            conexionBD.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar la partida");
        }
    }

    // Variable estática para guardar el nombre de usuario para poder usarlo en cualquier escena
    static String username;

    public static void setUsername(String username) {
        Util.username = username;
    }

    public static String getUsername() {
        return Util.username;
    }



    public static void guardarDatosJugadorGanadorPartidaEnBD(Partida partida) {
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
                    if (partida.getJugadorGanador() != null) {
                        String sql = "UPDATE Partida SET JugadorGanador = '"
                                + partida.getJugadorGanador() + "' WHERE ID = "
                                + partida.getIdPartida();
                        consulta.executeUpdate(sql);
                    }
                    // Si la consulta devuelve un resultado, el login es correcto
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                }
            }
            // Cerrar la conexión con la BD
            conexionBD.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar la partida");
        }
    }

    public static void actualizarPartidasGanadasYJugadas(Partida partida) {
        try {
            Connection conexionBD = ConexionBD.BD.conectarBD();
            // Si la conexión es nula, mostrar un mensaje de error
            if (conexionBD == null) {
                System.out.println("Error al conectar con la BD");
                // Si la conexión no es nula, ejecutar la consulta
            } else {
                // Crear un Statement para ejecutar la consulta
                try (Statement consulta = conexionBD.createStatement()) {



                    // Imprimir por consola el valor de las partidas jugadas y ganadas de los
                    // jugadores antes de actualizar
                    System.out.println("Partidas jugadas antes de actualizar: ");
                    String sqlJugador1Antes =
                            "SELECT GamesPlayed, GamesWon FROM Jugador WHERE Username = '"
                                    + partida.getJugador1() + "'";
                    consulta.executeQuery(sqlJugador1Antes);
                    if (consulta.getResultSet().next()) {
                        System.out.println(
                                "Jugador 1: " + partida.getJugador1() + " - Partidas jugadas: "
                                        + consulta.getResultSet().getInt("GamesPlayed")
                                        + " - Partidas ganadas: "
                                        + consulta.getResultSet().getInt("GamesWon"));
                    }

                    // Lo mismo para el jugador 2
                    String sqlJugador2Antes =
                            "SELECT GamesPlayed, GamesWon FROM Jugador WHERE Username = '"
                                    + partida.getJugador2() + "'";
                    consulta.executeQuery(sqlJugador2Antes);
                    if (consulta.getResultSet().next()) {
                        System.out.println(
                                "Jugador 2: " + partida.getJugador2() + " - Partidas jugadas: "
                                        + consulta.getResultSet().getInt("GamesPlayed")
                                        + " - Partidas ganadas: "
                                        + consulta.getResultSet().getInt("GamesWon"));
                    }



                    // Actualizar las partidas jugadas de los jugadores
                    String sqlJugador1 =
                            "UPDATE Jugador SET GamesPlayed = GamesPlayed + 1 WHERE Username = '"
                                    + partida.getJugador1() + "'";
                    consulta.executeUpdate(sqlJugador1);

                    String sqlJugador2 =
                            "UPDATE Jugador SET GamesPlayed = GamesPlayed + 1 WHERE Username = '"
                                    + partida.getJugador2() + "'";
                    consulta.executeUpdate(sqlJugador2);

                    // Si hay un ganador, actualizar las partidas ganadas de ese jugador
                    if (partida.getJugadorGanador() != null) {
                        String sqlGanador =
                                "UPDATE Jugador SET GamesWon = GamesWon + 1 WHERE Username = '"
                                        + partida.getJugadorGanador() + "'";
                        consulta.executeUpdate(sqlGanador);
                    }



                    // Imprimir por consola el valor de las partidas jugadas y ganadas de los
                    // jugadores después de actualizar
                    System.out.println("Partidas jugadas después de actualizar: ");
                    String sqlJugador1Despues =
                            "SELECT GamesPlayed, GamesWon FROM Jugador WHERE Username = '"
                                    + partida.getJugador1() + "'";
                    consulta.executeQuery(sqlJugador1Despues);
                    if (consulta.getResultSet().next()) {
                        System.out.println(
                                "Jugador 1: " + partida.getJugador1() + " - Partidas jugadas: "
                                        + consulta.getResultSet().getInt("GamesPlayed")
                                        + " - Partidas ganadas: "
                                        + consulta.getResultSet().getInt("GamesWon"));
                    }
                    // Lo mismo para el jugador 2
                    String sqlJugador2Despues =
                            "SELECT GamesPlayed, GamesWon FROM Jugador WHERE Username = '"
                                    + partida.getJugador2() + "'";
                    consulta.executeQuery(sqlJugador2Despues);
                    if (consulta.getResultSet().next()) {
                        System.out.println(
                                "Jugador 2: " + partida.getJugador2() + " - Partidas jugadas: "
                                        + consulta.getResultSet().getInt("GamesPlayed")
                                        + " - Partidas ganadas: "
                                        + consulta.getResultSet().getInt("GamesWon"));
                    }



                    // Si la consulta devuelve un resultado, el login es correcto
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                    e1.printStackTrace();
                }
            }
            // Cerrar la conexión con la BD
            conexionBD.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar la partida");
            e.printStackTrace();
        }
    }


}
