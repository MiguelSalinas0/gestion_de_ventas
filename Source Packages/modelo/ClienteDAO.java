package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class ClienteDAO {

	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int r;

	public Cliente buscar(String dni) {
		Cliente c = new Cliente();
		String sql = "select * from cliente where Dni =" + dni;
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				c.setIdCliente(rs.getInt(1));
				c.setDni(rs.getString(2));
				c.setNombres(rs.getString(3));
				c.setDireccion(rs.getString(4));
				c.setEstado(rs.getString(5));
			}
		} catch (Exception e) {

		}
		return c;
	}

	public List<Cliente> Listar() {

		String sql = "SELECT * FROM cliente";
		List<Cliente> lista = new ArrayList<>();
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente e = new Cliente();
				e.setIdCliente(rs.getInt(1));
				e.setDni(rs.getString(2));
				e.setNombres(rs.getString(3));
				e.setDireccion(rs.getString(4));
				e.setEstado(rs.getString(5));
				lista.add(e);
			}
		} catch (Exception e) {

		}
		return lista;
	}

}
