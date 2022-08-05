package modelo;

public class Producto {

	private Integer IdProducto;
	private String Nombres;
	private Double Precio;
	private Integer Stock;
	private String Estado;

	public Producto() {

	}

	public Producto(Integer idProducto, String nombres, Double precio, Integer stock, String estado) {
		IdProducto = idProducto;
		Nombres = nombres;
		Precio = precio;
		Stock = stock;
		Estado = estado;
	}

	public Integer getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(Integer idProducto) {
		IdProducto = idProducto;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	public Integer getStock() {
		return Stock;
	}

	public void setStock(Integer stock) {
		Stock = stock;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

}