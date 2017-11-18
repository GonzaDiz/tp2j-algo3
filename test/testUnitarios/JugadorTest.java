package testUnitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import modelo.ArmadorDeTablero;
import modelo.Tablero;
import modelo.casillero.especial.Carcel;
import modelo.casillero.especial.Policia;
import modelo.casillero.especial.Quini6;
import modelo.casillero.terrenos.BuenosAiresNorte;
import modelo.casillero.terrenos.BuenosAiresSur;
import modelo.casillero.terrenos.CordobaNorte;
import modelo.casillero.terrenos.CordobaSur;
import modelo.casillero.terrenos.Neuquen;
import modelo.casillero.terrenos.SaltaNorte;
import modelo.casillero.terrenos.SaltaSur;
import modelo.casillero.terrenos.SantaFe;
import modelo.casillero.terrenos.Tucuman;
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
	
	// Test de la segunda entrega
	
	@Test
	public void testUnJugadorCaeEnBuenosAiresSurCompraElTerrenoYSuCapitalSeDecrementaEn20000() {
		Jugador j = new Jugador("Guillermo");
		BuenosAiresSur bsasSur = new BuenosAiresSur();
		j.caerEnCasillero(bsasSur);
		j.comprar(bsasSur);
		Assert.assertEquals(80000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnBuenosAiresNorteCompraElTerrenoYSuCapitalSeDecrementaEn25000() {
		Jugador j = new Jugador("Nico");
		BuenosAiresNorte baN = new BuenosAiresNorte();
		j.caerEnCasillero(baN);
		j.comprar(baN);
		Assert.assertEquals(75000, j.capitalTotal());
	}

	@Test
	public void testUnJugadorCaeEnCordobaSurCompraElTerrenoYSuCapitalSeDecrementaEn18000() {
		Jugador j = new Jugador("Katheryn");
		CordobaSur cs = new CordobaSur();
		j.caerEnCasillero(cs);
		j.comprar(cs);
		Assert.assertEquals(82000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnCordobaNorteCompraElTerrenoYSuCapitalSeDecrementaEn20000() {
		Jugador j = new Jugador("Jonathan");
		CordobaNorte cn = new CordobaNorte();
		j.caerEnCasillero(cn);
		j.comprar(cn);
		Assert.assertEquals(80000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSantaFeCompraElTerrenoYSuCapitalSeDecrementaEn15000() {
		Jugador j = new Jugador("Esteban");
		SantaFe sf = new SantaFe();
		j.caerEnCasillero(sf);
		j.comprar(sf);
		Assert.assertEquals(85000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSaltaNorteCompraElTerrenoYSuCapitalSeDecrementaEn23000() {
		Jugador j = new Jugador("Luciano");
		SaltaNorte sn = new SaltaNorte();
		j.caerEnCasillero(sn);
		j.comprar(sn);
		Assert.assertEquals(77000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSaltaSurCompraElTerrenoYSuCapitalSeDecrementaEn23000() {
		Jugador j = new Jugador("Diego");
		SaltaSur ss = new SaltaSur();
		j.caerEnCasillero(ss);
		j.comprar(ss);
		Assert.assertEquals(77000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnNeuquenCompraElTerrenoYSuCapitalSeDecrementaEn17000() {
		Jugador j = new Jugador("Manfred");
		Neuquen n = new Neuquen();
		j.caerEnCasillero(n);
		j.comprar(n);
		Assert.assertEquals(83000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnTucumanCompraElTerrenoYSuCapitalSeDecrementaEn25000() {
		Jugador j = new Jugador("Sid");
		Tucuman t = new Tucuman();
		j.caerEnCasillero(t);
		j.comprar(t);
		Assert.assertEquals(75000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeCuentaConBsAsSurYBsAsNorteYConstruyeUnaCasaEnBsAsSurEntoncesSuDineroDecrementaEn5000() {
		Jugador j = new Jugador("Shrek");
		BuenosAiresSur baS = new BuenosAiresSur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j.comprar(baS); // -25000
		j.comprar(baN); // -20000
		j.construirCasaEn(baS); // -5000
		Assert.assertEquals(50000, j.capitalTotal());
	}
	
	
}
