package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.especial.Carcel;
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
		Carcel carcel = new Carcel();
		jugador.pagarFianza(carcel);
	}
	
}