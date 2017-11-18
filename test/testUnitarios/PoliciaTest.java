package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.especial.Carcel;
import modelo.casillero.especial.Policia;
import modelo.jugador.Jugador;

public class PoliciaTest {
	
	@Test
	public void testPoliciaNoEsNull() {
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);
		Assert.assertNotNull(policia);
	}
	
	@Test
	public void testAfectarJugadorLlevaAlJugadorALaCarcel() {
		Jugador jugador = new Jugador("Juan");
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);
		policia.afectarJugador(jugador);
		Assert.assertEquals(carcel, jugador.casilleroActual());
	}
}
