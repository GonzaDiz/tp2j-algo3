package testUnitarios;

import org.junit.Test;

import junit.framework.Assert;
import modelo.casillero.especial.Carcel;
import modelo.casillero.especial.Policia;
import modelo.jugador.Jugador;

public class PoliciaTest {
	
	@Test
	public void testGetCarcelNoDevuelveNull() {
		Carcel carcel = Carcel.getCarcel();
		Assert.assertNotNull(carcel);
	}
	
	@Test
	public void testAfectarJugadorLlevaAlJugadorALaCarcel() {
		Jugador jugador = new Jugador("Juan");
		Policia policia = Policia.getPolicia();
		policia.afectarJugador(jugador);
		Assert.assertEquals(Carcel.getCarcel(), jugador.casilleroActual());
	}
}
