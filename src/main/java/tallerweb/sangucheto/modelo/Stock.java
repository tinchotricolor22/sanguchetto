package tallerweb.sangucheto.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Maneja un stock de ingredientes, el mismo puede ser asociado a una
 * cantidad.<br>
 * No persiste, es decir, luego de la ejecucion del programa el Stock se
 * inicialza vacio.<br>
 * 
 * @author sismael
 *
 */
public class Stock {

	private static Stock instance = null;
	private Map<Ingrediente, Integer> stock = new HashMap<Ingrediente, Integer>();

	private Stock() {
	}

	public static Stock getInstance() {
		if (instance == null) {
			instance = new Stock();

			Ingrediente i1 = new Ingrediente();
			i1.setNombre("Tomate");
			i1.setPrecio(11.0);
			i1.setTipo(TipoIngrediente.INGREDIENTE);
			i1.setImg("tomate.png");
			Ingrediente i2 = new Ingrediente();
			i2.setNombre("Lechuga");
			i2.setPrecio(9.0);
			i2.setTipo(TipoIngrediente.INGREDIENTE);
			i2.setImg("lechuga.png");
			Ingrediente i3 = new Ingrediente();
			i3.setNombre("Sal");
			i3.setPrecio(2.0);
			i3.setTipo(TipoIngrediente.CONDIMENTO);
			i3.setImg("sal.png");
			Ingrediente i4 = new Ingrediente();
			i4.setNombre("queso cheddar");
			i4.setPrecio(6.0);
			i4.setTipo(TipoIngrediente.INGREDIENTE);
			i4.setImg("queso cheddar.png");
			Ingrediente i5 = new Ingrediente();
			i5.setNombre("Mayonesa");
			i5.setPrecio(2.0);
			i5.setTipo(TipoIngrediente.CONDIMENTO);
			i5.setImg("mayonesa.png");
			Ingrediente i6 = new Ingrediente();
			i6.setNombre("Ketchup");
			i6.setPrecio(2.0);
			i6.setTipo(TipoIngrediente.CONDIMENTO);
			i6.setImg("ketchup.png");

			instance.agregarIngrediente(i1);
			instance.agregarStock(i1, 10);
			instance.agregarIngrediente(i2);
			instance.agregarStock(i2, 0);
			instance.agregarIngrediente(i3);
			instance.agregarStock(i3, 1);
			instance.agregarIngrediente(i4);
			instance.agregarStock(i4, 5);
			instance.agregarIngrediente(i5);
			instance.agregarStock(i5, 2);
			instance.agregarIngrediente(i6);
			instance.agregarStock(i6, 10);
		}
		return instance;
	}

	/**
	 * Devuelve un listado de los ingredientes del stock, tengan o no stock, es
	 * decir, los ingredientes con cantidad 0 son incluidos.<br>
	 * 
	 * @param producto
	 * @param cantidad
	 * @return
	 */
	public Set<Ingrediente> listarIngredientesDisponibles() {
		return stock.keySet();
	}

	/**
	 * Devuelve un mapa con los ingredientes y su stock correspondiente, tengan
	 * o no stock, es decir, los ingredientes con cantidad 0 son incluidos.<br>
	 * 
	 * @param producto
	 * @param cantidad
	 * @return
	 */
	public Map<Ingrediente, Integer> obtenerStock() {
		return stock;
	}

	/**
	 * Permite agregar el ingrediente indicado al stock, con cantidad 0.<br>
	 * 
	 * @param ingrediente
	 * @param cantidad
	 * @return true en caso de exito, false si el ingrediente ya existe en el
	 *         stock.<br>
	 */
	public Boolean agregarIngrediente(Ingrediente ingrediente) {
		if (this.stock.containsKey(ingrediente)) {
			return false;
		}
		this.stock.put(ingrediente, 0);
		return true;
	}

	/**
	 * Permite agregar stock al existente para un ingrediente dado. Si el
	 * ingrediente tiene un stock de N, ahora tendra N + cantidad.<br>
	 * 
	 * @param ingrediente
	 * @param cantidad
	 * @return true en caso de exito, false si el ingrediente no existe en el
	 *         stock.<br>
	 */
	public Boolean agregarStock(Ingrediente ingrediente, Integer cantidad) {
		if (!this.stock.containsKey(ingrediente)) {
			return false;
		}
		Integer nuevaCantidad = this.stock.get(ingrediente) + cantidad;
		this.stock.put(ingrediente, nuevaCantidad);
		return true;
	}

	/**
	 * Devuelve el stock disponible para el ingrediente pedido. NULL si el
	 * ingrediente no existe en el stock<br>
	 * 
	 * @param ingrediente
	 * @return
	 */
	public Integer obtenerStockDisponible(Ingrediente ingrediente) {
		if (!this.stock.containsKey(ingrediente)) {
			return null;
		}
		return this.stock.get(ingrediente);
	}

	/**
	 * Indica si el ingrediente indicado fue incluido en el stock.<br>
	 * 
	 * @param ingrediente
	 * @return
	 */
	public Boolean existeIngrediente(Ingrediente ingrediente) {
		return this.stock.containsKey(ingrediente);
	}

	/**
	 * Permite comprar N unidades del ingrediente indicado.<br>
	 * 
	 * @param ingrediente
	 * @param unidades
	 * @return true en caso de exito, false si el ingrediente no existe en el
	 *         stock.<br>
	 */
	public Boolean comprarIngrediente(Ingrediente ingrediente, Integer unidades) {
		if (!this.stock.containsKey(ingrediente)) {
			return false;
		}
		Integer nuevaCantidad = this.stock.get(ingrediente) - unidades;
		// Se agrega la condición para manejar la concurrencia por cantidad
		if(nuevaCantidad < 0){
			return false;
		}
		this.stock.put(ingrediente, nuevaCantidad);
		return true;
	}

	/**
	 * Elimina el ingrediente indicado del stock, no importa cual sea la
	 * cantidad disponible del mismo.<br>
	 * 
	 * @param ingrediente
	 * @return true en caso de exito, false si el ingrediente no existe en el
	 *         stock.<br>
	 */
	public Boolean eliminarIngrediente(Ingrediente ingrediente) {
		if (!this.stock.containsKey(ingrediente)) {
			return false;
		}
		this.stock.remove(ingrediente);
		return true;
	}
}
