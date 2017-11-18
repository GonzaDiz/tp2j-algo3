package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.Tablero;

public class TableroTest {
	
	@Test
	public void testCrearTableroNoDevuelveNull() {
		Tablero tablero = Tablero.getTablero();
		Assert.assertNotNull(tablero);
	}
	
}
