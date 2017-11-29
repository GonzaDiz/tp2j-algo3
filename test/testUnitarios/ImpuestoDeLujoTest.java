package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.especial.ImpuestoDeLujo;
import modelo.jugador.Jugador;

public class ImpuestoDeLujoTest {
	
	@Test
	public void testUnJugadorCaeEnImpuestoDeLujoYEntoncesSiCapitalSeReduceEnUnDiezPorciento() {
		Jugador j1 = new Jugador("Moroso");
		ImpuestoDeLujo c1 = new ImpuestoDeLujo();
		int capital = j1.capitalTotal();
		j1.caerEnCasillero(c1);
		Assert.assertEquals(capital - (capital * 10 / 100), j1.capitalTotal());
	}

}
