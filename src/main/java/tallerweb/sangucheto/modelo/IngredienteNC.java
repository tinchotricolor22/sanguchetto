package tallerweb.sangucheto.modelo;



public class IngredienteNC {
	private String nombre;
	private Double precio;
	private Integer cantidad;
	private TipoIngrediente tipo;
	private String imagen;
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public TipoIngrediente getTipo() {
		return tipo;
	}
	public void setTipo(TipoIngrediente tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
