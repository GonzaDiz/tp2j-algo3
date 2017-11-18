package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.terrenos.BuenosAiresNorte;


public class BuenosAiresNorteTest {
	
	@Test
	public void testBuenosAiresNorteNoEsNull() {
		BuenosAiresNorte buenosAiresNorte = new BuenosAiresNorte();
		Assert.assertNotNull(buenosAiresNorte);
	}

}
