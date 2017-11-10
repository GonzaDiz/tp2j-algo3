package testUnitarios;

import org.junit.Assert;
import org.junit.Test;


import modelo.Jugador;

public class JugadorTest {

	@Test
	public void testJugadorDevuelve0() {
		Jugador jugador = new Jugador();
		Assert.assertEquals(0,jugador.devolver0());
	}
}
