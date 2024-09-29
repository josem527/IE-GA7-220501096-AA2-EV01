import java.sql.*;
public class UsuarioDAO {

    private static final String URL = "jdbc:sqlserver://LAPTOP-JJJSBNLM\\SQLEXPRESS;databaseName=PruebaDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
    private Connection connection;

    public UsuarioDAO() {
        try {
            // Cargar el driver de SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Crear
    public void crearUsuario(String nombre, String email) {
        String sql = "INSERT INTO Usuarios (nombre, email) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Leer
    public void leerUsuarios() {
        String sql = "SELECT * FROM Usuarios";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre") + ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar
    public void actualizarUsuario(int id, String nuevoNombre, String nuevoEmail) {
        String sql = "UPDATE Usuarios SET nombre = ?, email = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevoEmail);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM Usuarios WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
