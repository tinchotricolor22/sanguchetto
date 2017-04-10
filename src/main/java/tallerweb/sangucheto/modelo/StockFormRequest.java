package tallerweb.sangucheto.modelo;

import java.util.ArrayList;

public class StockFormRequest {
	private  ArrayList<IngredienteRequest> ingredientes = new ArrayList<IngredienteRequest>();

	public ArrayList<IngredienteRequest> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<IngredienteRequest> ingredientes) {
		this.ingredientes = ingredientes;
	}
}
