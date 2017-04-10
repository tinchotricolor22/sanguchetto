package tallerweb.sanguchetto.modelo;

import org.junit.Test;

import org.junit.Assert;
import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.TipoIngrediente;

public class SanguchettoTest {

    @Test
    public void testVaciar() {
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

		Sanguchetto.getInstance().agregarIngrediente(i1, 1, 0.5);
		Sanguchetto.getInstance().agregarIngrediente(i2, 1, 0.5);
		
		Sanguchetto.getInstance().vaciar();
        Integer esperado=0;
		Assert.assertEquals(esperado.intValue(),Sanguchetto.getInstance().getIngredientes().size());
    }

    @Test
    public void testAgregarIngrediente() {
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
		Sanguchetto.getInstance().vaciar();
		Sanguchetto.getInstance().agregarIngrediente(i1, 1, 0.5);
		Sanguchetto.getInstance().agregarIngrediente(i2, 1, 0.5);
		
        Integer esperado=2;
		Assert.assertEquals(esperado.intValue(),Sanguchetto.getInstance().getIngredientes().size());
    }

    @Test
    public void testVerIngredientes() {
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
		Sanguchetto.getInstance().vaciar();
		Sanguchetto.getInstance().agregarIngrediente(i1, 1, 0.0);
		Sanguchetto.getInstance().agregarIngrediente(i2, 1, 0.0);
		Sanguchetto.getInstance().agregarIngrediente(i3, 1, 0.0);
		
        Integer esperado=2;
		Assert.assertEquals(esperado.intValue(),Sanguchetto.getInstance().verIngredientes().size());
    }

    @Test
    public void testVerCondimentos() {
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
		Sanguchetto.getInstance().vaciar();
		Sanguchetto.getInstance().agregarIngrediente(i1, 1, 0.0);
		Sanguchetto.getInstance().agregarIngrediente(i2, 1, 0.0);
		Sanguchetto.getInstance().agregarIngrediente(i3, 1, 0.0);
		
        Integer esperado=1;
		Assert.assertEquals(esperado.intValue(),Sanguchetto.getInstance().verCondimentos().size());
    }

    @Test
    public void testGetPrecio() {
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
		Sanguchetto.getInstance().vaciar();
		Sanguchetto.getInstance().agregarIngrediente(i1, 1, 0.0);
		Sanguchetto.getInstance().agregarIngrediente(i2, 1, 0.0);
		Sanguchetto.getInstance().agregarIngrediente(i3, 1, 0.0);
		
        Double esperado=22.0;
		Assert.assertEquals(esperado,Sanguchetto.getInstance().getPrecio(),0.0);
    }
    
}
