package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class DetalleVentaDAO {

	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int r;

	public List<DetalleVenta> Listar() {
		String sql = "SELECT cliente.Nombres, cliente.Dni, producto.Nombres, detalle_ventas.Cantidad, ventas.Monto, ventas.NumeroSerie, ventas.FechaVentas\r\n"
				+ "FROM detalle_ventas\r\n" + "JOIN ventas\r\n" + "ON detalle_ventas.IdVentas = ventas.IdVentas\r\n"
				+ "JOIN producto\r\n" + "ON detalle_ventas.IdProducto = producto.IdProducto\r\n" + "JOIN cliente\r\n"
				+ "ON ventas.IdCliente = cliente.IdCliente";
		List<DetalleVenta> lista = new ArrayList<>();
		try {
			con = cn.getConexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				DetalleVenta dv = new DetalleVenta();
				dv.setNombreCL(rs.getString(1));
				dv.setDni(rs.getString(2));
				dv.setNombrePR(rs.getString(3));
				dv.setCantidad(rs.getInt(4));
				dv.setMonto(rs.getDouble(5));
				dv.setNserie(rs.getString(6));
				dv.setFecha(rs.getString(7));
				lista.add(dv);
			}
		} catch (SQLException sqle) {
		}
		return lista;
	}

}
