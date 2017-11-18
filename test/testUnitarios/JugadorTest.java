package testUnitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import modelo.ArmadorDeTablero;
import modelo.Tablero;
import modelo.casillero.especial.Carcel;
import modelo.casillero.especial.Policia;
import modelo.casillero.especial.Quini6;
import modelo.casillero.terrenos.BuenosAiresSur;
import modelo.excepciones.CapitalInsuficienteError;
import modelo.excepciones.NoEstasEncarceladoException;
import modelo.excepciones.NoPuedePagarFianzaException;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;
import modelo.jugador.Jugador;



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
		jugador.comprar(bsasSur);
		Assert.assertEquals(jugador, bsasSur.propietario());
	}

	@Test (expected = NoSePuedeDesplazarJugadorEncarceladoException.class)
	public void testUnJugadorCaeEnLaCarcelIntentaDesplazarse2LugaresSaltaNoSePuedeDesplazarJugadorEnCarcelException() {
		Jugador jugador = new Jugador("Ariel");
		Carcel carcel = new Carcel();
		jugador.caerEnCasillero(carcel);
		jugador.desplazar(2);
	}
	
	
	@Test 
	public void testUnJugadorCaeEnLaCarcelYPuedePagarLaFianzaSiElTurnoEsDosOTres()  {
		Jugador jugador = new Jugador("Gonzalo");
		Carcel carcel = new Carcel();
		int capital = jugador.capitalTotal();
		jugador.caerEnCasillero(carcel);
		jugador.esTuTurno(); // En este turno no puede realizar ninguna accion.
		jugador.esTuTurno();
		jugador.pagarFianza(carcel);
		assertEquals(capital - 45000, jugador.capitalTotal());
	}
	
	@Test (expected = NoPuedePagarFianzaException.class)
	public void testUnJugadorNoPuedePagarLaFianzaSiElTurnoEsUno()  {
		Jugador jugador = new Jugador("Ariel");
		Carcel carcel = new Carcel();
		jugador.caerEnCasillero(carcel);
		jugador.esTuTurno();
		jugador.pagarFianza(carcel);
	}
	
	@Test 
	public void testUnJugadorPuedePagarLaFianzaSiEsElTercerTurnoQueEstaEnLaCarcel() {
		Jugador jugador = new Jugador("Ariel");
		Carcel carcel = new Carcel();
		int capital = jugador.capitalTotal();
		jugador.caerEnCasillero(carcel);
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.pagarFianza(carcel);
		assertEquals(capital - 45000, jugador.capitalTotal());

	}
	
	@Test (expected = NoEstasEncarceladoException.class)
	public void testUnJugadorEnLibertadNoPuedePagarLaFianza() {
		Jugador jugador = new Jugador("Ariel");
		Carcel carcel = new Carcel();
		jugador.pagarFianza(carcel);
	}
	
	@Test (expected = NoSePuedeDesplazarJugadorEncarceladoException.class)
	public void testUnJugadorEncarceladoIntentaDesplazarse5CasillerosYSeLanzaNoSePuedeDesplazarJugadorEnCarcelException() {
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.encarcelar();
		jugador.desplazar(5);
	}
	
	@Test
	public void testUnJugadorQueCaeEnLaCarcelQuedaLibreAlCuartoTurnoEntoncesPuedeDesplazarse() {
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		Carcel carcel = new Carcel();
		jugador.caerEnCasillero(carcel);
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.desplazar(5);	
	}
	
	@Test (expected = CapitalInsuficienteError.class)
	public void testUnJugadorNoPuedePagarLaFianzaPorFaltaDeFondosSiendoElTurnoDosOTres () {
		Jugador jugador = new Jugador("Ariel", 40000); // Este constructor es solo para testear casos de saldo insuficiente
		Carcel carcel = new Carcel();
		jugador.caerEnCasillero(carcel);
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.pagarFianza(carcel);
	}
	
	@Test (expected = NoSePuedeDesplazarJugadorEncarceladoException.class)
	public void testUnJugadorCaeEnLaPoliciaYPasaAEstarEncarcelado() {
		Jugador jugador = new Jugador("Amado Budou");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);
		jugador.caerEnCasillero(policia);
		jugador.desplazar(5);	
	}
	
	@Test
	public void testUnJugadorCaeEnLaPoliciaYSuUbicacionActualEsLaCarcel() {
		Jugador jugador = new Jugador("Amado Budou");
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);
		jugador.caerEnCasillero(policia);
		Assert.assertEquals(carcel, jugador.casilleroActual());
	}
	
	// HASTA ACA LOS TEST DE LA PRIMERA ENTREGA

}
