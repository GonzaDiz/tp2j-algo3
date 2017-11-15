package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.especial.Carcel;
import modelo.excepciones.NoPuedePagarFianzaException;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;
import modelo.jugador.Jugador;

public class CarcelTest {
	
	@Test
	public void testGetCarcelNoDevuelveNull() {
		Carcel carcel = Carcel.getCarcel();
		Assert.assertNotNull(carcel);
	}
	
	@Test
	public void testCobrarFianzaDeUnJugadorReduceEn45000SuCapital() {
		Jugador jugador = new Jugador("Carlos");
		Carcel carcel = Carcel.getCarcel();
		int capitalOriginal = jugador.capitalTotal();
		carcel.cobrarFianza(jugador);
		Assert.assertEquals(capitalOriginal - 45000, jugador.capitalTotal());
	}
	
	@Test (expected = NoSePuedeDesplazarJugadorEncarceladoException.class)
	public void testUnJugadorEsAfectadoPorLaCarcelNoSePuedeDesplazar() {
		Jugador jugador = new Jugador("Emmanuel");
		Carcel carcel = Carcel.getCarcel();
		carcel.afectarJugador(jugador);
		jugador.desplazar(4);
		
	}
	
	@Test (expected = NoPuedePagarFianzaException.class)
	public void testUnJugadorIntentaPagarLaFianzaElPrimerTurnoEnCarcelSaltaExcepcionNoPuedePagarFianza() {
		Jugador jugador = new Jugador("Daniela");
		Carcel carcel = Carcel.getCarcel();
		carcel.afectarJugador(jugador);
		jugador.pagarFianza();
	}

}
