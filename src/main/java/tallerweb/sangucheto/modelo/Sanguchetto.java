package tallerweb.sangucheto.modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Sanguchetto {

	private static Sanguchetto instance = new Sanguchetto();
	private List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
	private Double precioTotal = 0.0;
	private Double ahorroTotal = 0.0;
	
	private Sanguchetto() {
	}

	public static Sanguchetto getInstance() {
		return instance;
	}

	/**
	 * Elimina todos los ingredientes del sanguchetto.<br>
	 */
	public void vaciar() {
		precioTotal = 0.0;
		ahorroTotal = 0.0;
		this.ingredientes.clear();
	}

	/**
	 * Agrega un ingrediente al carrito.<br>
	 * 
	 * @param ingrediente
	 * @param descuento
	 */
	public void agregarIngrediente(Ingrediente ingrediente,Double descuento) {
		precioTotal += ingrediente.getPrecio();
		ahorroTotal += descuento;
		this.ingredientes.add(ingrediente);
	}
	
	/**
	 * Agrega el mismo ingrediente la cantidad de veces especificada.<br>
	 * 
	 * @param ingrediente
	 * @param cantidad
	 * @param descuento
	 */
	public void agregarIngrediente(Ingrediente ingrediente, int cantidad,Double descuento) {
		for(int i = 0; i < cantidad ; i++){
			precioTotal += ingrediente.getPrecio();
			ahorroTotal += descuento;
			this.ingredientes.add(ingrediente);
		}
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	/**
	 * Lista todos los ingredientes que forman parte del sanguchetto.<br>
	 * 
	 * @return
	 */
	public List<Ingrediente> verIngredientes() {
		List<Ingrediente> ingrs = new LinkedList<Ingrediente>();
		for (Ingrediente ingrediente : ingredientes) {
			if (ingrediente.getTipo().equals(TipoIngrediente.INGREDIENTE)) {
				ingrs.add(ingrediente);
			}
		}
		return ingrs;
	}
	
	/**
	 * Lista todos los ingredientes que forman parte del sanguchetto y su cantidad.<br>
	 * 
	 * @return 
	 */
	public Map<Ingrediente,Integer> verIngredientesCantidad() {
		Map<Ingrediente, Integer> map = new HashMap<Ingrediente, Integer>();
		for (Ingrediente ingrediente : ingredientes) {
			if (ingrediente.getTipo().equals(TipoIngrediente.INGREDIENTE)) {
				Integer cantidad = 1;
				if(map.containsKey(ingrediente)){
					cantidad = map.get(ingrediente)+1;
				}
				map.put(ingrediente, cantidad);				
			}
		}
		return map;
	}

	/**
	 * Lista todos los condimentos que forman parte del sanguchetto.<br>
	 * 
	 * @return
	 */
	public List<Ingrediente> verCondimentos() {
		List<Ingrediente> condimentos = new LinkedList<Ingrediente>();
		for (Ingrediente ingrediente : ingredientes) {
			if (ingrediente.getTipo().equals(TipoIngrediente.CONDIMENTO)) {
				condimentos.add(ingrediente);
			}
		}
		return condimentos;
	}

	/**
	 * Lista todos los ingredientes que forman parte del sanguchetto y su cantidad.<br>
	 * 
	 * @return 
	 */
	public Map<Ingrediente,Integer> verCondimentosCantidad() {
		Map<Ingrediente, Integer> map = new HashMap<Ingrediente, Integer>();
		for (Ingrediente ingrediente : ingredientes) {
			if (ingrediente.getTipo().equals(TipoIngrediente.CONDIMENTO)) {
				Integer cantidad = 1;
				if(map.containsKey(ingrediente)){
					cantidad = map.get(ingrediente)+1;
				}
				map.put(ingrediente, cantidad);	
			}
		}
		return map;
	}
	
	/**
	 * Devuelve el precio total del sanguchetto.<br>
	 * 
	 * @return
	 */
	public Double getPrecio() {
		return this.precioTotal;
	}
	
	/**
	 * Devuelve el descuento total del sanguchetto.<br>
	 * 
	 * @return
	 */
	public Double getAhorro() {
		return this.ahorroTotal;
	}
}
