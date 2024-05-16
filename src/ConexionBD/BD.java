package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
    final static String HOST = "ill.h.filess.io";
    final static String DATABASE = "PPTLSBD_hurrybroke";
    final static String USER = "PPTLSBD_hurrybroke";
    final static String PASSWD = "32a0f9c5bf89d3f6be9f058a71b1e1a4f9a5b6a4";
    final static String PORT = "3306";


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
