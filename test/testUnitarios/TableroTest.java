package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.Tablero;
import modelo.casillero.Casillero;
import modelo.casillero.especial.Carcel;

public class TableroTest {
	
	@Test
	public void testCrearTableroNoDevuelveNull() {
		Tablero tablero = Tablero.getInstance();
		Assert.assertNotNull(tablero);
	}
	
	@Test
	public void testAgregarUnCasilleroATablero(){
		Tablero unTablero = Tablero.getInstance();
		Carcel unaCarcel = new Carcel();
		unTablero.agregarCasillero(unaCarcel);
		Casillero otraCarcel = unTablero.getCasillero(0); 
		Assert.assertNotNull(otraCarcel);	
	}

}
