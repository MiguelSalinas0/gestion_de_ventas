package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {

	Connection conexion = null;

	public Connection getConexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bd_ventas";
			String user = "root";
			String pass = "";
			conexion = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		}
		return conexion;
	}
}