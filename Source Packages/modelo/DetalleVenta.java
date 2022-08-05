package modelo;

public class DetalleVenta {

	private Integer cantidad;
	private Double monto;
	private String Nserie;
	private String nombreCL;
	private String dni;
	private String nombrePR;
	private String fecha;

	public DetalleVenta() {}
	
	public DetalleVenta(Integer cantidad, Double monto, String nserie, String nombreCL, String dni, String nombrePr, String fecha) {
		this.cantidad = cantidad;
		this.monto = monto;
		this.Nserie = nserie;
		this.nombreCL = nombreCL;
		this.dni = dni;
		this.nombrePR = nombrePr;
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getNserie() {
		return Nserie;
	}

	public void setNserie(String nserie) {
		Nserie = nserie;
	}

	public String getNombreCL() {
		return nombreCL;
	}

	public void setNombreCL(String nombreCL) {
		this.nombreCL = nombreCL;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombrePR() {
		return nombrePR;
	}

	public void setNombrePR(String nombrePR) {
		this.nombrePR = nombrePR;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
