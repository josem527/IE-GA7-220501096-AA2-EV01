import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        // Se instancia el objeto
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        //CREATE
        //usuarioDAO.crearUsuario("Jose Marroquin", "Jose@example.com");
        //usuarioDAO.crearUsuario("Tatiana Barbosa", "Tatiana@example.com");
        //usuarioDAO.crearUsuario("Carlos Mendoza", "carlos@example.com");
        //usuarioDAO.crearUsuario("Laura López", "laura@example.com");
        //usuarioDAO.crearUsuario("Javier Torres", "javier@example.com");
        //usuarioDAO.crearUsuario("Sofía Martínez", "sofia@example.com");
        //usuarioDAO.crearUsuario("Andrés Rodríguez", "andres@example.com");
        //READ
        //usuarioDAO.leerUsuarios();
        //UPDATE
        //usuarioDAO.actualizarUsuario(11, "Jose Actualizado", "Jose_actualizado@example.com");
        //DELETE
        usuarioDAO.eliminarUsuario(14);
        //Se leen los usuarios después de eliminarlos
        System.out.println("Usuarios después de eliminar:");
        usuarioDAO.leerUsuarios();
        //Cierra la conexión
        usuarioDAO.cerrarConexion();

    }
}
