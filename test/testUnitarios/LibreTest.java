package testUnitarios;

import org.junit.Test;

import junit.framework.Assert;
import modelo.excepciones.NoEstasEncarceladoException;
import modelo.jugador.Jugador;
import modelo.jugador.Libre;

public class LibreTest {
	
	@Test
	public void testCrearEstadoLibreNoEsNull() {
		Libre libre = new Libre();
		Assert.assertNotNull(libre);
	}
	
	@Test (expected = NoEstasEncarceladoException.class)
	public void testUnJugadorIntentaPagarLaFianzaEstandoLibreLanzaNoEstasEncarceladoException() {
		Jugador jugador = new Jugador("Manuel");
		jugador.pagarFianza();
	}

}