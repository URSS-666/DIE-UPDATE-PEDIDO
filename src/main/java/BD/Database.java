package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final String url = "jdbc:postgresql://localhost:5432/prueba160225";
    private final String user = "postgres";
    private final String password = "your_password";

    private Connection conectar = null;

    public Connection establecerConexion() {
        try {
            conectar = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa.");
        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.getMessage());
            e.printStackTrace();
        }
        return conectar;
    }

    public void cerrarConexion() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Database db = new Database();
        db.establecerConexion();
        db.cerrarConexion();
    }
}
