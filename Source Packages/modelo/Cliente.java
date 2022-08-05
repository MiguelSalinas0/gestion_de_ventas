package modelo;

public class Cliente {

	private Integer IdCliente;
	private String Dni;
	private String Nombres;
	private String Direccion;
	private String Estado;

	public Cliente() {
		super();
	}

	public Cliente(Integer idCliente, String dni, String nombres, String direccion, String estado) {
		IdCliente = idCliente;
		Dni = dni;
		Nombres = nombres;
		Direccion = direccion;
		Estado = estado;
	}

	public Integer getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

}
