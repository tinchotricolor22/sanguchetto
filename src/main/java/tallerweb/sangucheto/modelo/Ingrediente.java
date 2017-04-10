package tallerweb.sangucheto.modelo;

public class Ingrediente {

	private String nombre;
	private Double precio;
	private TipoIngrediente tipo;
	private String img;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = "/Sangucheto/fonts/"+img;
	}
}
