package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.especial.RetrocesoDinamico;

public class RetrocesoDinamicoTest {
	
	@Test
	public void testGetRetrocesoDinamicoNoDevuelveNull() {
		RetrocesoDinamico retrocesoDinamico = RetrocesoDinamico.getRetrocesoDinamico();
		Assert.assertNotNull(retrocesoDinamico);
	}

}
