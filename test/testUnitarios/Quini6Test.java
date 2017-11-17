package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.especial.Quini6;
import modelo.jugador.Jugador;

public class Quini6Test {
	
	@Test
	public void testGetQuini6NoDevuelveNull() {
		Quini6 quini6 = Quini6.getQuini6();
		Assert.assertNotNull(quini6);
	}
	
	@Test
	public void testAfectarJugadorPorPrimeraVezCon100000DeCapitalLoAumentaEn50000() {
		Jugador jugador = new Jugador("Jorge");
		Quini6 quini6 = Quini6.getQuini6();
		quini6.registrarJugador(jugador);
		quini6.afectarJugador(jugador);
		Assert.assertEquals(100000 + 50000, jugador.capitalTotal());
	}
	
	@Test
	public void testAfectarJugador2VecesCon100000DeCapitalAumentaEn50000y30000() {
		Jugador jugador = new Jugador("Damian");
		Quini6 quini6 =  Quini6.getQuini6();
		quini6.registrarJugador(jugador);
		quini6.afectarJugador(jugador);
		quini6.afectarJugador(jugador);
		Assert.assertEquals(100000 + 50000 + 30000, jugador.capitalTotal());
	}
	
	@Test
	public void testAfectarJugador10VecesCon100000DeCapitalAumentaEn50000y30000() {
		Jugador jugador = new Jugador("Ezequiel");
		Quini6 quini6 = Quini6.getQuini6();
		quini6.registrarJugador(jugador);
		for (int i = 0; i <10; i++) {
			quini6.afectarJugador(jugador);
		}
		Assert.assertEquals(100000 + 50000 + 30000, jugador.capitalTotal());
	}
	

}
