package testUnitarios;

import org.junit.Test;

import junit.framework.Assert;
import modelo.Salida;
import modelo.casillero.compania.Aysa;
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
		jugador.pagarFianza();
	}
	
	@Test
	public void testDesplazarAUnJugador5CasillerosDesdeLaSalidaLoDesplazaHastaLaCarcel() {
		Jugador jugador = new Jugador("Milena");
		jugador.desplazar(5);
		Assert.assertEquals(Carcel.getCarcel(), jugador.casilleroActual());
	}
	
	@Test
	public void testDesplazarUnJugador0CasillerosDesdeLaSalidaNoLoDesplaza() {
		Jugador jugador = new Jugador("Camila");
		jugador.desplazar(0);
		Assert.assertEquals(Salida.getSalida(), jugador.casilleroActual());
	} 
	
	@Test
	public void testDesplazarUnJugador12casillerosDesdesalidaLoLlevaHastaAysa() {
		Jugador jugador = new Jugador("Pilar");
		jugador.desplazar(12);
		Assert.assertEquals(Aysa.getAysa(), jugador.casilleroActual());
	}
	
}