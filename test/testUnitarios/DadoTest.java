package testUnitarios;


import org.junit.Assert;
import org.junit.Test;

import modelo.Dado;

public class DadoTest {
	
	@Test
	public void testCreacionDeUnDado() {
		Dado dado = new Dado();
		Assert.assertNotNull(dado);
	}
	
	@Test
	public void testArrojarUnDadoDevuelveUnNumeroEntreUnoYSeis() {
		Dado dado = new Dado();
		int valor = dado.arrojar();
		Assert.assertTrue(valor > 0 && valor < 7);
	}

}
