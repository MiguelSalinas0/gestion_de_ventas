package modelo;

public class Venta {

	private Integer id;
	private Integer item;
	private Integer idcliente;
	private Integer idempleado;
	private Integer idproducto;
	private String Numserie;
	private String DescripcionP;
	private String fecha;
	private Double precio;
	private Integer cantidad;
	private Double subtotal;
	private Double monto;
	private String estado;

	public Venta() {
	}

	public Venta(Integer id, Integer item, Integer idcliente, Integer idempleado, Integer idproducto, String numserie,
			String descripcionP, String fecha, Double precio, Integer cantidad, Double subtotal, Double monto,
			String estado) {
		this.id = id;
		this.item = item;
		this.idcliente = idcliente;
		this.idempleado = idempleado;
		this.idproducto = idproducto;
		Numserie = numserie;
		DescripcionP = descripcionP;
		this.fecha = fecha;
		this.precio = precio;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.monto = monto;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public Integer getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(Integer idempleado) {
		this.idempleado = idempleado;
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getNumserie() {
		return Numserie;
	}

	public void setNumserie(String numserie) {
		Numserie = numserie;
	}

	public String getDescripcionP() {
		return DescripcionP;
	}

	public void setDescripcionP(String descripcionP) {
		DescripcionP = descripcionP;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
