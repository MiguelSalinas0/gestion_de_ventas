package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class ProductoDAO {

	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int r;

	public Producto buscar(Integer id) {
		Producto p = new Producto();
		String sql = "select * from producto where IdProducto =" + id;
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				p.setIdProducto(rs.getInt(1));
				p.setNombres(rs.getString(2));
				p.setPrecio(rs.getDouble(3));
				p.setStock(rs.getInt(4));
				p.setEstado(rs.getString(5));
			}
		} catch (SQLException sqle) {
		}
		return p;
	}

	public Integer actualizarStock(int id, int stock) {
		String sql = "update producto set Stock=? where IdProducto = ?";
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception sqle) {
		}
		return r;
	}

	public List<Producto> Listar() {
		String sql = "SELECT * FROM producto";
		List<Producto> lista = new ArrayList<>();
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Producto p = new Producto();
				p.setIdProducto(rs.getInt(1));
				p.setNombres(rs.getString(2));
				p.setPrecio(rs.getDouble(3));
				p.setStock(rs.getInt(4));
				p.setEstado(rs.getString(5));
				lista.add(p);
			}
		} catch (Exception sqle) {
		}
		return lista;
	}

	public Producto listarId(int id) {
		Producto pro = new Producto();
		String sql = "select * from producto where IdProducto=" + id;
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				pro.setIdProducto(rs.getInt(1));
				pro.setNombres(rs.getString(2));
				pro.setPrecio(rs.getDouble(3));
				pro.setStock(rs.getInt(4));
				pro.setEstado(rs.getString(5));
			}
		} catch (Exception sqle) {
		}
		return pro;
	}

	public void Delete(int id) {
		String sql = "delete from producto where IdProducto=" + id;
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception sqle) {
		}
	}

	public int Actualizar(Producto pr) {
		String sql = "update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, pr.getNombres());
			ps.setDouble(2, pr.getPrecio());
			ps.setInt(3, pr.getStock());
			ps.setString(4, pr.getEstado());
			ps.setInt(5, pr.getIdProducto());
			ps.executeUpdate();
		} catch (Exception sqle) {
		}
		return r;
	}

	public int Agregar(Producto pr) {
		String sql = "insert into producto(Nombres, Precio, Stock, Estado) values(?,?,?,?)";
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, pr.getNombres());
			ps.setDouble(2, pr.getPrecio());
			ps.setInt(3, pr.getStock());
			ps.setString(4, pr.getEstado());
			ps.executeUpdate();
		} catch (Exception sqle) {
		}
		return r;
	}
}