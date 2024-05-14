package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
    final static String HOST = "iib.h.filess.io";
    final static String DATABASE = "PPTLS_headingson";
    final static String USER = "PPTLS_headingson";
    final static String PASSWD = "e8cdef0b041ee2183dbc2e5e3a586ed891a1c92d";
    final static String PORT = "3307";


    static public Connection conectarBD() {
        String url = String.format("jdbc:mysql://%s:%s/%s", HOST, PORT, DATABASE);
        try {
            return DriverManager.getConnection(url, BD.USER, BD.PASSWD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
