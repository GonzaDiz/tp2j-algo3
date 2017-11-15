package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.especial.ImpuestoDeLujo;
import modelo.excepciones.NoPuedePagarFianzaException;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;
import modelo.jugador.Encarcelado;
import modelo.jugador.Jugador;

public class EncarceladoTest {
	
	@Test
	public void testNewEncarceladoNoEsNull() {
		Encarcelado encarcelado = new Encarcelado();
		Assert.assertNotNull(encarcelado);
	}
	
	@Test (expected = NoSePuedeDesplazarJugadorEncarceladoException.class)
	public void testDesplazarUnJugadorEncarceladoLanzaExcepcionNoSePuedeDesplazarJugadorEncarceladoException() {
		Jugador jugador = new Jugador("Gisella");
		jugador.encarcelar();
		jugador.desplazar(4);
	}
	
	@Test (expected = NoPuedePagarFianzaException.class) 
	public void testPagarFianzaHabiendoPasadoUnSoloTurnoEncarceladoLanzaNoPuedePagarFianzaException() {
		Jugador jugador = new Jugador("Cristian");
		jugador.encarcelar();
		jugador.esTuTurno();
		jugador.pagarFianza();
	}
	
	@Test (expected = NoPuedePagarFianzaException.class)
	public void testPagarFianzaSinHaberPasadoNingunTurnoEncarceladoLanzaNoPuedePagarFianzaException() {
		Jugador jugador = new Jugador("Bruno");
		jugador.encarcelar();
		jugador.pagarFianza();
	}
	
	@Test
	public void testPagarFianzaHabiendoPasadoDosTurnosEncarceladosLeResta45000AlCapitalDelJugador() {
		Jugador jugador = new Jugador("Laura");
		int capital = jugador.capitalTotal();
		jugador.encarcelar();
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.pagarFianza();
		Assert.assertEquals(capital - 45000, jugador.capitalTotal());
		
	}
	
	@Test
	public void testPagarFianzaHabiendoPasado3TurnosEncarceladoRestaEn45000ElCapitalDelJugador() {
		Jugador jugador = new Jugador("Monica");
		int capital = jugador.capitalTotal();
		jugador.encarcelar();
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.pagarFianza();
		Assert.assertEquals(capital - 45000, jugador.capitalTotal());
	}
	

}
