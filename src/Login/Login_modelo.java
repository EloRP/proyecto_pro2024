package Login;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;


public class Login_modelo {


    static boolean login(String username, String password) {
        // Inicializar la variable login a false
        boolean login = false;
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
                String sql = "SELECT * FROM Jugador WHERE username = '" + username
                        + "' AND password = '" + password + "'";
                consulta.executeQuery(sql);
                // Si la consulta devuelve un resultado, el login es correcto
                if (consulta.getResultSet().next()) {
                    // TODO: COMPROBAR SI LA CONTRASEÑA ES CORRECTA CON EL HASH
                    login = true;
                }
                // Si la consulta no devuelve un resultado, el login es incorrecto
            } catch (SQLException e1) {
                System.out.println("Error al ejecutar la consulta");
            }
            // Cerrar la conexión con la BD
            try {
                conexionBD.close();
                // Si hay un error al cerrar la conexión, mostrar un mensaje de error
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión con la BD.");
            }

        }
        // Si el login es correcto, mostrar un mensaje de login correcto y abrir el menú principal
        if (login) {
            System.out.println("Login correcto");
            // Si el login es incorrecto, mostrar un mensaje de login incorrecto y mostrar una
            // alerta de error
        } else {
            System.out.println("Login incorrecto");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Login incorrecto");
            alert.setContentText("El usuario o la contraseña son incorrectos.");
            alert.showAndWait();
        }
        // Devolver el valor de la variable login
        return login;
    }

    public static boolean signup(String username, String password) {
        // Inicializar la variable signup a false
        boolean signup = false;
        // Inicializar la conexión a la BD
        Connection conexionBD = ConexionBD.BD.conectarBD();
        // Si la conexión es nula, mostrar un mensaje de error
        if (conexionBD == null) {
            System.out.println("Error al conectar con la BD");
            // Si la conexión no es nula, ejecutar la consulta
        } else {
            // Comprobar si el usuario ya existe
            boolean usuarioExistente = comprobarUsuario(username);
            if (usuarioExistente) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Usuario existente");
                alert.setContentText("El usuario ya existe.");
                alert.showAndWait();
                return signup;
            } else {
                // Crear un Statement para ejecutar la consulta
                try (Statement consulta = conexionBD.createStatement()) {
                    // TODO: HASHEAR LA CONTRASEÑA
                    // Crear la consulta
                    String sql = "INSERT INTO Jugador (username, password) VALUES ('" + username
                            + "', '" + password + "')";
                    consulta.executeUpdate(sql);
                    // Si la consulta se ejecuta correctamente, el signup es correcto
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                    e1.printStackTrace();
                }
                // Cerrar la conexión con la BD
                try {
                    conexionBD.close();
                    // Si hay un error al cerrar la conexión, mostrar un mensaje de error
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("Error al cerrar la conexión con la BD.");
                }
                signup = true;
            }
        }

        if (signup) {
            System.out.println("Signup correcto");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Signup correcto");
            alert.setContentText("El usuario se ha registrado correctamente.");
            alert.showAndWait();
        }
        return signup;

    }

    private static boolean comprobarUsuario(String username) {
        boolean usuarioExistente = false;
        Connection conexionBD = ConexionBD.BD.conectarBD();

        if (conexionBD == null) {
            System.out.println("Error al conectar con la BD");
        } else {
            try (Statement consulta = conexionBD.createStatement()) {
                String sql = "SELECT * FROM Jugador WHERE username = '" + username + "'";
                ResultSet resultado = consulta.executeQuery(sql); // Ejecutar la consulta de
                                                                  // selección

                // Verificar si la consulta devuelve algún resultado
                if (resultado.next()) {
                    usuarioExistente = true; // El usuario ya existe
                }
            } catch (SQLException e) {
                System.out.println("Error al ejecutar la consulta: " + e.getMessage());
            } finally {
                try {
                    if (conexionBD != null) {
                        conexionBD.close(); // Cerrar la conexión con la BD
                    }
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión con la BD: " + e.getMessage());
                }
            }
        }
        return usuarioExistente;
    }
}

