package ejemplo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    String url = "jdbc:mysql://localhost:3306/alumnos";
    String user = "root";
    String pass = "4688";
    Connection c;

    public Connection conectar() throws SQLException {
        c = DriverManager.getConnection(url, user, pass);
        return c;
    }
}