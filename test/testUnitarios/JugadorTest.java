package testUnitarios;

import org.junit.Test;

import org.junit.Assert;

import modelo.BuenosAiresSur;
import modelo.Carcel;
import modelo.Jugador;
import modelo.Quini6;

public class JugadorTest {

	@Test
	public void testUnJugadorSeCreaConUnCiertoNombrePasadoComoParametro() {
		Jugador jugador = new Jugador("Ariel");
		Assert.assertEquals(jugador.tuNombreEs(), "Ariel");
	}

	@Test
	public void testUnJugadorSeCreaConCienMilPesosDeDineroDisponible() {
		Jugador jugador = new Jugador("Ariel");
		Assert.assertEquals(jugador.capitalTotal(), 100000);
	}

	@Test
	public void testUnJugadorCaeEnQuini6PorPrimeraVezYSuCapitalAumentaEn50000() {
		Jugador jugador = new Jugador("Ariel");
		Quini6 quini6 = new Quini6();
		quini6.registrarJugador(jugador);
		jugador.caerEnCasillero(quini6);
		Assert.assertEquals(jugador.capitalTotal(), 150000);
	}

	@Test
	public void testUnJugadorCaeEnQuini6PorSegundaVezYSuCapitalAumentaEn30000() {
		Jugador jugador = new Jugador("Gonzalo");
		Quini6 quini6 = new Quini6();
		quini6.registrarJugador(jugador);
		jugador.caerEnCasillero(quini6);
		jugador.caerEnCasillero(quini6);
		Assert.assertEquals(180000, jugador.capitalTotal());
	}

	@Test
	public void testUnJugadorCaeEnQuini6PorTerceraVezYSuCapitalNoAumenta() {
		Jugador jugador = new Jugador("Ariel");
		Quini6 quini6 = new Quini6();
		quini6.registrarJugador(jugador);
		jugador.caerEnCasillero(quini6);
		jugador.caerEnCasillero(quini6);
		jugador.caerEnCasillero(quini6);
		Assert.assertEquals(180000, jugador.capitalTotal());
	}

	@Test
	public void testUnJugadorCaeEnUnTerrenoYAlComprarloSeVuelveElPropietario() {
		Jugador jugador = new Jugador("Gonzalo");
		BuenosAiresSur bsasSur = new BuenosAiresSur();
		jugador.caerEnCasillero(bsasSur);
		Assert.assertEquals(jugador, bsasSur.propietario());
	}

	@Test 
	public void testUnJugadorCaeEnLaCarcelYNoPuedeDesplazarse() {
		Jugador jugador = new Jugador("Ariel");
		Carcel carcel = new Carcel();
		jugador.caerEnCasillero(carcel);
		Assert.assertFalse(jugador.desplazar(2));
	}
	
	
//	@Test
//	public void testUnJugadorCaeEnLaCarcelYPuedePagarLaFianzaSiElTurnoEsDosOTres() {
//		Jugador jugador = new Jugador("Gonzalo");
//		Carcel carcel = new Carcel();
//		jugador.caerEnCasillero(carcel);
//		jugador.esTuTurno(); // En este turno no puede realizar ninguna accion.
//		jugador.esTuTurno();
//		carcel.cobrarFianza(jugador);
//		Assert.assertTrue(jugador.desplazar(2));
		
//	}

}
