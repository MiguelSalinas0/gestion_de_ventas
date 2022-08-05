package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.Conexion;

public class VentaDAO {

	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Integer r;

	public String GenerarSerie() {
		String numerosrie = "";
		String sql = "select max(NumeroSerie) from ventas";
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				numerosrie = rs.getString(1);
			}
		} catch (Exception e) {

		}
		return numerosrie;
	}

	public String IdVentas() {
		String idventas = "";
		String sql = "select max(IdVentas) from ventas";
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				idventas = rs.getString(1);
			}
		} catch (Exception e) {

		}
		return idventas;
	}

	public Integer guardarVenta(Venta ve) {
		String sql = "insert into ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado) values(?,?,?,?,?,?)";
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ve.getIdcliente());
			ps.setInt(2, ve.getIdempleado());
			ps.setString(3, ve.getNumserie());
			ps.setString(4, ve.getFecha());
			ps.setDouble(5, ve.getMonto());
			ps.setString(6, ve.getEstado());
			ps.executeUpdate();
		} catch (Exception e) {

		}
		return r;
	}

	public Integer guardarDetalleventas(Venta ve) {
		String sql = "insert into detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta) values(?,?,?,?)";
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ve.getId());
			ps.setInt(2, ve.getIdproducto());
			ps.setInt(3, ve.getCantidad());
			ps.setDouble(4, ve.getPrecio());
			ps.executeUpdate();
		} catch (Exception e) {

		}
		return r;
	}

}
