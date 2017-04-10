package tallerweb.sangucheto.modelo;

import java.util.HashMap;
import java.util.Map;

public class StockForm {
	private Map<Ingrediente, Integer> stock = new HashMap<Ingrediente, Integer>();

	public Map<Ingrediente, Integer> getStock() {
		return stock;
	}

	public void setStock(Map<Ingrediente, Integer> stock) {
		this.stock = stock;
	}
}
