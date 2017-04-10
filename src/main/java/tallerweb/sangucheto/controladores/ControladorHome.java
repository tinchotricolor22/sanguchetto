package tallerweb.sangucheto.controladores;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.IngredienteNC;
import tallerweb.sangucheto.modelo.IngredienteRequest;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.Stock;
import tallerweb.sangucheto.modelo.StockFormRequest;
import tallerweb.sangucheto.modelo.TipoIngrediente;
/*
 * TP Final - Taller Polo Java (Noche)
 * Equipo 12
 * Coronado Gabriel
 * 33423119
 * Morales Martín 
 * 39515894
 */
@Controller
public class ControladorHome {
	/*Martín*/
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView irAHome(@RequestParam(value = "errors", required = false) List<String> errors) {
		ModelMap map = new ModelMap();
		map.put("stockFormRequest", new StockFormRequest());
		map.put("stock", Stock.getInstance().obtenerStock());
		map.put("sanguchettoIngredientes", Sanguchetto.getInstance().verIngredientesCantidad());
		map.put("sanguchettoCondimentos", Sanguchetto.getInstance().verCondimentosCantidad());
		map.put("sanguchettoTotal", Sanguchetto.getInstance().getPrecio());
		map.put("sanguchettoAhorro", Sanguchetto.getInstance().getAhorro());
		if (errors != null) {
			map.put("errors", errors);
		}
		return new ModelAndView("home", map);
	}

	@RequestMapping(path = "/agregar_ingredientes", method = RequestMethod.POST)
	public ModelAndView agregarIngredientes(@ModelAttribute StockFormRequest sfr) {
		Integer index = 0;
		List<String> errors = new LinkedList<String>();
		Set<Ingrediente> ingrs = Stock.getInstance().obtenerStock().keySet();
		
		//Condición por concurrencia con el stock
		if(ingrs.size() == sfr.getIngredientes().size()){
			for (Ingrediente ingrediente : ingrs) {
				IngredienteRequest iR = sfr.getIngredientes().get(index);
				if (iR != null && iR.getCantidad() != null && iR.getCantidad() > 0) {
					if (Stock.getInstance().comprarIngrediente(ingrediente, iR.getCantidad())) {
						Double descuentoFinal = 0.0;
						if (iR.getDescuento() != null && iR.getDescuento() > 0) {
							descuentoFinal = iR.getDescuento()*ingrediente.getPrecio()/100;
						}
						Sanguchetto.getInstance().agregarIngrediente(ingrediente, iR.getCantidad(),descuentoFinal);
					} else {
						errors.add("No se pudo agregar el ingrediente: " + ingrediente.getNombre());
					}
				}
				index++;
			}
		}else{
			errors.add("No se pudo completar la transaccion. Intente nuevamente.");
		}
		return new ModelAndView("redirect:/", "errors", errors);
	}

	@RequestMapping(path = "/vaciar_sanguchetto", method = RequestMethod.GET)
	public ModelAndView vaciarSanguchetto() {
		for (Ingrediente ingrediente : Sanguchetto.getInstance().getIngredientes()) {
			Stock.getInstance().agregarStock(ingrediente, 1);
		}
		Sanguchetto.getInstance().vaciar();
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(path = "/confirmar_sanguchetto", method = RequestMethod.GET)
	public ModelAndView confirmarSanguchetto() {
		Sanguchetto.getInstance().vaciar();
		return new ModelAndView("redirect:/");
	}
	
	/*Gabriel*/
	@RequestMapping(value="/lista_stock")
	public ModelAndView acccion_lista_stock(){
		ModelMap map = new ModelMap();
		map.put("ingredientes", Stock.getInstance().obtenerStock());
		map.put("ingrediente_nc", new IngredienteNC());
		return new ModelAndView("stock",map);
	}
	@RequestMapping(path="/sumar_stock", method = RequestMethod.POST)
	public ModelAndView accion_sumar_stock(@ModelAttribute IngredienteNC ingredienteNC){
		Map<Ingrediente, Integer> stock = Stock.getInstance().obtenerStock();
		Ingrediente ingrediente=null;
		for (Map.Entry<Ingrediente, Integer> ing : stock.entrySet()) {
			if(ing.getKey().getNombre().compareTo(ingredienteNC.getNombre())==0){
				ingrediente = ing.getKey();
			}
		}
		Stock.getInstance().agregarStock(ingrediente, ingredienteNC.getCantidad());
		return new ModelAndView("redirect:/lista_stock");
	}
	@RequestMapping(path="/eliminar_ingrediente/{nombre}")
	public ModelAndView accion_eliminar_ingrediente(@PathVariable String nombre){
		Map<Ingrediente, Integer> stock = Stock.getInstance().obtenerStock();
		Ingrediente ingrediente=null;
		for (Map.Entry<Ingrediente, Integer> ing : stock.entrySet()) {
			if(ing.getKey().getNombre().compareTo(nombre)==0){
				ingrediente = ing.getKey();
			}
		}
		Stock.getInstance().eliminarIngrediente(ingrediente);
		return new ModelAndView("redirect:/lista_stock");
	}
	
	
	@RequestMapping(path="/vaciar_ingrediente/{nombre}")
	public ModelAndView accion_vaciar_ingrediente(@PathVariable String nombre){
		Map<Ingrediente, Integer> stock = Stock.getInstance().obtenerStock();
		Ingrediente ingrediente=null;
		for (Map.Entry<Ingrediente, Integer> ing : stock.entrySet()) {
			if(ing.getKey().getNombre().compareTo(nombre)==0){
				ingrediente = ing.getKey();
			}
		}
		Stock.getInstance().obtenerStock().replace(ingrediente, 0);
		return new ModelAndView("redirect:/lista_stock");
	}
	
	@RequestMapping(path="/alta_producto")
	public ModelAndView accion_alta_producto(@RequestParam("imagen") String imagen){
		ModelMap modelMap = new ModelMap();
		modelMap.put("ingrediente",new IngredienteNC());
		modelMap.put("imagen", imagen);
		return new ModelAndView("alta",modelMap);
		//return new ModelAndView("alta","ingrediente",new IngredienteNC());
	}
	
	@RequestMapping(value="/recibe_alta",method=RequestMethod.POST)
	public ModelAndView accion2_recibe_alta(@ModelAttribute IngredienteNC ingredienteNC){
		Map<Ingrediente, Integer> stock = Stock.getInstance().obtenerStock();
		Ingrediente ingrediente=null;
		
		for (Map.Entry<Ingrediente, Integer> ing : stock.entrySet()) {
			if(ing.getKey().getNombre().compareTo(ingredienteNC.getNombre())==0){
				ingrediente = ing.getKey();
			}
		}

		if(ingrediente==null){
			Ingrediente ing_aux = new Ingrediente();
			ing_aux.setNombre(ingredienteNC.getNombre());
			ing_aux.setPrecio(ingredienteNC.getPrecio());
			ing_aux.setTipo(ingredienteNC.getTipo());
			ing_aux.setImg(ingredienteNC.getImagen());
			Stock.getInstance().agregarIngrediente(ing_aux);
		}
		return new ModelAndView("redirect:/lista_stock");
		
	}
	
	@RequestMapping(path="/img")
	public ModelAndView accionImagen(){
		return new ModelAndView("imagen");
	}
	
}
