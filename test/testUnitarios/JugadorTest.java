package testUnitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import modelo.ArmadorDeTablero;
import modelo.Tablero;
import modelo.casillero.compania.Aysa;
import modelo.casillero.compania.Edesur;
import modelo.casillero.compania.Subte;
import modelo.casillero.compania.Tren;
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
import modelo.excepciones.LimiteDeEdificacionesExcedidoError;
import modelo.excepciones.NoEstasEncarceladoException;
import modelo.excepciones.NoPuedePagarFianzaException;
import modelo.excepciones.NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError;
import modelo.excepciones.NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;
import modelo.excepciones.SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError;
import modelo.excepciones.SoloElPropietarioPuedeEdificarEnElTerrenoError;
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
		jugador.comprarTerreno(bsasSur);
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
	
	
	// Test de compra de los terrenos
	@Test
	public void testUnJugadorCaeEnBuenosAiresSurCompraElTerrenoYSuCapitalSeDecrementaEn20000() {
		Jugador j = new Jugador("Guillermo");
		BuenosAiresSur bsasSur = new BuenosAiresSur();
		j.caerEnCasillero(bsasSur);
		j.comprarTerreno(bsasSur);
		Assert.assertEquals(80000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnBuenosAiresNorteCompraElTerrenoYSuCapitalSeDecrementaEn25000() {
		Jugador j = new Jugador("Nico");
		BuenosAiresNorte baN = new BuenosAiresNorte();
		j.caerEnCasillero(baN);
		j.comprarTerreno(baN);
		Assert.assertEquals(75000, j.capitalTotal());
	}

	@Test
	public void testUnJugadorCaeEnCordobaSurCompraElTerrenoYSuCapitalSeDecrementaEn18000() {
		Jugador j = new Jugador("Katheryn");
		CordobaSur cs = new CordobaSur();
		j.caerEnCasillero(cs);
		j.comprarTerreno(cs);
		Assert.assertEquals(82000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnCordobaNorteCompraElTerrenoYSuCapitalSeDecrementaEn20000() {
		Jugador j = new Jugador("Jonathan");
		CordobaNorte cn = new CordobaNorte();
		j.caerEnCasillero(cn);
		j.comprarTerreno(cn);
		Assert.assertEquals(80000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSantaFeCompraElTerrenoYSuCapitalSeDecrementaEn15000() {
		Jugador j = new Jugador("Esteban");
		SantaFe sf = new SantaFe();
		j.caerEnCasillero(sf);
		j.comprarTerreno(sf);
		Assert.assertEquals(85000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSaltaNorteCompraElTerrenoYSuCapitalSeDecrementaEn23000() {
		Jugador j = new Jugador("Luciano");
		SaltaNorte sn = new SaltaNorte();
		j.caerEnCasillero(sn);
		j.comprarTerreno(sn);
		Assert.assertEquals(77000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSaltaSurCompraElTerrenoYSuCapitalSeDecrementaEn23000() {
		Jugador j = new Jugador("Diego");
		SaltaSur ss = new SaltaSur();
		j.caerEnCasillero(ss);
		j.comprarTerreno(ss);
		Assert.assertEquals(77000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnNeuquenCompraElTerrenoYSuCapitalSeDecrementaEn17000() {
		Jugador j = new Jugador("Manfred");
		Neuquen n = new Neuquen();
		j.caerEnCasillero(n);
		j.comprarTerreno(n);
		Assert.assertEquals(83000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnTucumanCompraElTerrenoYSuCapitalSeDecrementaEn25000() {
		Jugador j = new Jugador("Sid");
		Tucuman t = new Tucuman();
		j.caerEnCasillero(t);
		j.comprarTerreno(t);
		Assert.assertEquals(75000, j.capitalTotal());
	}
	// ---------------------------------------------------------
	
	
	
	
	
	// Test de precio de la construccion de las casas
	@Test
	public void testUnJugadorCuentaConBsAsSurYBsAsNorteYConstruyeUnaCasaEnBsAsSurEntoncesSuDineroDecrementaEn5000() {
		Jugador j = new Jugador("Shrek");
		BuenosAiresSur baS = new BuenosAiresSur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j.comprarTerreno(baS); // -25000
		j.comprarTerreno(baN); // -20000
		j.construirCasaEn(baS); // -5000
		Assert.assertEquals(50000, j.capitalTotal());
	}
	
	@Test  (expected = LimiteDeEdificacionesExcedidoError.class)
	public void testUnJugadorNoPuedeConstruirMasDeDosCasasEnUnTerrenoDoble() {
		Jugador j = new Jugador("Shrek");
		BuenosAiresSur baS = new BuenosAiresSur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j.comprarTerreno(baS); // -25000
		j.comprarTerreno(baN); // -20000
		j.construirCasaEn(baS); // -5000
		j.construirCasaEn(baS); // -5000
		j.construirCasaEn(baS); // Lanza excepcion
	}
	
	@Test  (expected = SoloElPropietarioPuedeEdificarEnElTerrenoError.class)
	public void testUnJugadorNoPuedeConstruirEnUnTerrenoQueNoEsPropietario() {
		Jugador j1 = new Jugador("Shrek");
		Jugador j2 = new Jugador("Principe Encantador");
		BuenosAiresSur baS = new BuenosAiresSur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baN); // -20000
		j1.comprarTerreno(baS);
		j2.construirCasaEn(baS); // Lanza excepcion
	}
	
	@Test  (expected = SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError.class)
	public void testUnJugadorNecesitaAmbosTerrenosParaConstruirEnUnTerrenoDoble() {
		Jugador j1 = new Jugador("Mili De Mayolas");
		Jugador j2 = new Jugador("Magui Ilari");
		BuenosAiresSur baS = new BuenosAiresSur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS);
		j2.comprarTerreno(baN);
		j1.construirCasaEn(baS); // Lanza excepcion
	}
	
	@Test
	public void testUnJugadorCuentaConBsAsSurYBsAsNorteYConstruyeUnaCasaEnBsAsNortEntoncesSuDineroDecrementaEn5500() {
		Jugador j = new Jugador("Pedro");
		BuenosAiresSur baS = new BuenosAiresSur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j.comprarTerreno(baS); // -25000
		j.comprarTerreno(baN); // -20000
		j.construirCasaEn(baN); // -5500
		Assert.assertEquals(49500, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConCordobaSurYCordobaNorteYConstruyeUnaCasaEnCordobaSurEntoncesSuDineroDecrementaEn2000() {
		Jugador j = new Jugador("Diego");
		CordobaSur cS = new CordobaSur();
		CordobaNorte cN = new CordobaNorte();
		cS.setTerrenoPareja(cN);
		cN.setTerrenoPareja(cS);
		j.comprarTerreno(cS); // -18000
		j.comprarTerreno(cN); // -20000
		j.construirCasaEn(cS); // -2000
		Assert.assertEquals(60000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConCordobaSurYCordobaNorteYConstruyeUnaCasaEnCordobaNorteEntoncesSuDineroDecrementaEn2200() {
		Jugador j = new Jugador("Migu");
		CordobaSur cS = new CordobaSur();
		CordobaNorte cN = new CordobaNorte();
		cS.setTerrenoPareja(cN);
		cN.setTerrenoPareja(cS);
		j.comprarTerreno(cS); // -18000
		j.comprarTerreno(cN); // -20000
		j.construirCasaEn(cN); // -2200
		Assert.assertEquals(59800, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConSaltaSurYSaltaNorteYConstruyeUnaCasaEnSaltaSurEntoncesSuDineroDecrementaEn4500() {
		Jugador j = new Jugador("Diego");
		SaltaSur ss = new SaltaSur();
		SaltaNorte sn = new SaltaNorte();
		ss.setTerrenoPareja(sn);
		sn.setTerrenoPareja(ss);
		j.comprarTerreno(ss); // -23000
		j.comprarTerreno(sn); // -23000
		j.construirCasaEn(ss); // -4500
		Assert.assertEquals(49500, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConSaltaSurYSaltaNorteYConstruyeUnaCasaEnSaltaNorteEntoncesSuDineroDecrementaEn4500() {
		Jugador j = new Jugador("Diego");
		SaltaSur ss = new SaltaSur();
		SaltaNorte sn = new SaltaNorte();
		ss.setTerrenoPareja(sn);
		sn.setTerrenoPareja(ss);
		j.comprarTerreno(ss); // -23000
		j.comprarTerreno(sn); // -23000
		j.construirCasaEn(ss); // -4500
		Assert.assertEquals(49500, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnBuenosAiresSurQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3000() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		BuenosAiresSur baS = new BuenosAiresSur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS); // -25000
		j1.comprarTerreno(baN); // -20000
		j1.construirCasaEn(baS); // -5000
		j2.caerEnCasillero(baS);
		Assert.assertEquals(97000, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnBuenosAiresSurQueTieneDosCasasYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3500() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		BuenosAiresSur baS = new BuenosAiresSur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS); // -25000
		j1.comprarTerreno(baN); // -20000
		j1.construirCasaEn(baS); // -5000
		j1.construirCasaEn(baS); // -5000
		j2.caerEnCasillero(baS);
		Assert.assertEquals(96500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnBuenosAiresNorteQueTieneDosCasasYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe4000() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		BuenosAiresSur baS = new BuenosAiresSur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS); // -25000
		j1.comprarTerreno(baN); // -20000
		j1.construirCasaEn(baN); // -5500
		j1.construirCasaEn(baN); // -5500
		j2.caerEnCasillero(baN);
		Assert.assertEquals(96000, j2.capitalTotal());
	}
	//-------------------------------
	
	
	
	
	
	
	
	
	
	
	
	// Test de pago de alquileres con una casa
	@Test
	public void testUnJugadorCaeEnBuenosAiresNorteQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3500() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		BuenosAiresSur baS = new BuenosAiresSur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS); // -25000
		j1.comprarTerreno(baN); // -20000
		j1.construirCasaEn(baN); // -5500
		j2.caerEnCasillero(baN);
		Assert.assertEquals(96500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnCordobaSurQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe1500() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		CordobaSur c1 = new CordobaSur();
		CordobaNorte c2 = new CordobaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(98500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnCordobaNoQueTieneDosCasasYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe2500() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		CordobaSur c1 = new CordobaSur();
		CordobaNorte c2 = new CordobaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(97500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnCordobaNorteQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe1800() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		CordobaSur c1 = new CordobaSur();
		CordobaNorte c2 = new CordobaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(98200, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnCordobaNorteQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe2900() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		CordobaSur c1 = new CordobaSur();
		CordobaNorte c2 = new CordobaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(97100, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSaltaSurQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3250() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		SaltaSur c1 = new SaltaSur();
		SaltaNorte c2 = new SaltaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(96750, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSaltaSurQueTieneDosCasasYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3850() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		SaltaSur c1 = new SaltaSur();
		SaltaNorte c2 = new SaltaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(96150, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSaltaNorteQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3250() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		SaltaSur c1 = new SaltaSur();
		SaltaNorte c2 = new SaltaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(96750, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSaltaNorteQueTieneDosCasasYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3850() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		SaltaSur c1 = new SaltaSur();
		SaltaNorte c2 = new SaltaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(96150, j2.capitalTotal());
	}
	//-------------------------------
	
	
	
	
	
	
	
	// Test de restricciones de construccion de hoteles
	@Test
	public void testUnJugadorConstruyeUnHotelEnBuenosAiresSurSinTenerLaCapacidadMaximaDeCasasEntoncesSuCapitalNoSeDecrementa() {
		Jugador j1 = new Jugador("Martin");
		BuenosAiresSur baS = new BuenosAiresSur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS);
		j1.comprarTerreno(baN);
		j1.construirCasaEn(baN);
		j1.construirCasaEn(baN);
		int capital = j1.capitalTotal();
		try{
			j1.construirHotelEn(baS);
		}
		
		catch(NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError e) {
			Assert.assertEquals(capital, j1.capitalTotal());
		}
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnBuenosAiresSurSinTenerLaCapacidadMaximaDeCasasEnSuTerrenoParejaEntoncesSuCapitalNoSeDecrementa() {
		Jugador j1 = new Jugador("Gerardo");
		BuenosAiresSur c1 = new BuenosAiresSur();
		BuenosAiresNorte c2 = new BuenosAiresNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		int capital = j1.capitalTotal();
		try{
			j1.construirHotelEn(c1);
		}
		
		catch(NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError e) {
			Assert.assertEquals(capital, j1.capitalTotal());
		}
	}
	//----------------------------
	
	
	
	
	
	// Test de construcciones de hoteles
	@Test
	public void testUnJugadorConstruyeUnHotelEnBuenosAiresSurTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn8000() {
		Jugador j1 = new Jugador("Rochi");
		BuenosAiresSur c1 = new BuenosAiresSur();
		BuenosAiresNorte c2 = new BuenosAiresNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c1);
		Assert.assertEquals(capital-8000, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnBuenosAiresNorteTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn9000() {
		Jugador j1 = new Jugador("El Uro");
		BuenosAiresSur c1 = new BuenosAiresSur();
		BuenosAiresNorte c2 = new BuenosAiresNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c2);
		Assert.assertEquals(capital-9000, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnCordobaSurTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn3000() {
		Jugador j1 = new Jugador("Bianca");
		CordobaSur c1 = new CordobaSur();
		CordobaNorte c2 = new CordobaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c1);
		Assert.assertEquals(capital-3000, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnCordobaNorteTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn3500() {
		Jugador j1 = new Jugador("Bianca");
		CordobaSur c1 = new CordobaSur();
		CordobaNorte c2 = new CordobaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c2);
		Assert.assertEquals(capital-3500, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnSaltaSurTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn7500() {
		Jugador j1 = new Jugador("Mica");
		SaltaSur c1 = new SaltaSur();
		SaltaNorte c2 = new SaltaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c1);
		Assert.assertEquals(capital-7500, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnSaltaNorteTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn7500() {
		Jugador j1 = new Jugador("Lila Peralta");
		SaltaSur c1 = new SaltaSur();
		SaltaNorte c2 = new SaltaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c2);
		Assert.assertEquals(capital-7500, j1.capitalTotal());
	}
	//-----------------------------------
	
	
	
	
	
	
	// Test de pago de alquileres en terrenos con hoteles
	@Test
	public void testUnJugadorNoPropietarioCaeEnBuenosAiresSurQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn5000() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		BuenosAiresSur c1 = new BuenosAiresSur();
		BuenosAiresNorte c2 = new BuenosAiresNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(95000, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnBuenosAiresNorteQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn6000() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		BuenosAiresSur c1 = new BuenosAiresSur();
		BuenosAiresNorte c2 = new BuenosAiresNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(94000, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnCordobaSurQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn3000() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		CordobaSur c1 = new CordobaSur();
		CordobaNorte c2 = new CordobaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(97000, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnCordobaNorteQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn3500() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		CordobaSur c1 = new CordobaSur();
		CordobaNorte c2 = new CordobaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(96500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnSaltaSurQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn5500() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		SaltaSur c1 = new SaltaSur();
		SaltaNorte c2 = new SaltaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(94500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnSaltaNorteQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn5500() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		SaltaSur c1 = new SaltaSur();
		SaltaNorte c2 = new SaltaNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(94500, j2.capitalTotal());
	}
	//------------------------------
	
	
	
	// TEST TERRENOS SIMPLES
	// Test de construcciones de casas en terrenos simples
	@Test
	public void testUnJugadorCuentaConSantaFeYConstruyeUnaCasaEntoncesSuCapitalDecrementaEn4000() {
		Jugador j1 = new Jugador("Me canse de pensar nombres");
		SantaFe c1 = new SantaFe();
		j1.comprarTerreno(c1);
		int capital = j1.capitalTotal();
		j1.construirCasaEn(c1);
		Assert.assertEquals(capital - 4000, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConNeuquenYConstruyeUnaCasaEntoncesSuCapitalDecrementaEn4800() {
		Jugador j1 = new Jugador("Me canse de pensar nombres");
		Neuquen c1 = new Neuquen();
		j1.comprarTerreno(c1);
		int capital = j1.capitalTotal();
		j1.construirCasaEn(c1);
		Assert.assertEquals(capital - 4800, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConTucumanYConstruyeUnaCasaEntoncesSuCapitalDecrementaEn7000() {
		Jugador j1 = new Jugador("Me canse de pensar nombres");
		Tucuman c1 = new Tucuman();
		j1.comprarTerreno(c1);
		int capital = j1.capitalTotal();
		j1.construirCasaEn(c1);
		Assert.assertEquals(capital - 7000, j1.capitalTotal());
	}
	//----------------------------------
	
	
	
	
	// Test de pago de alquileres en terrenos simples
	@Test
	public void testUnJugadorNoPropietarioCaeEnSantaFeQueNoTieneCasasEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn1500() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		SantaFe c1 = new SantaFe();
		j1.comprarTerreno(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 1500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnNeuquenQueNoTieneCasasEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn1800() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		Neuquen c1 = new Neuquen();
		j1.comprarTerreno(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 1800, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnTucumanQueNoTieneCasasEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn2500() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		Tucuman c1 = new Tucuman();
		j1.comprarTerreno(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 2500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnSantaFeQueTieneUnaCasaEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn3500() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		SantaFe c1 = new SantaFe();
		j1.comprarTerreno(c1);
		j1.construirCasaEn(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 3500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnSantaFeQueTieneUnaCasaEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn3800() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		Neuquen c1 = new Neuquen();
		j1.comprarTerreno(c1);
		j1.construirCasaEn(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 3800, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnSantaFeQueTieneUnaCasaEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn4500() {
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		Tucuman c1 = new Tucuman();
		j1.comprarTerreno(c1);
		j1.construirCasaEn(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 4500, j2.capitalTotal());
	}
	//------------------------------------------
	
	
	
	
	
	
	
	// TEST COMPANIA
	
	// Test de compra de las companias
	@Test
	public void testUnJugadorCaeEnEdesurYCompraLaCompaniaYSuCapitalDecrementaEn35000() {
		Jugador j1 = new Jugador("Presidente");
		Edesur c1 = new Edesur();
		j1.caerEnCasillero(c1);
		int capital = j1.capitalTotal();
		j1.comprarCompania(c1);
		Assert.assertEquals(capital - 35000, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSubteYCompraLaCompaniaYSuCapitalDecrementaEn40000() {
		Jugador j1 = new Jugador("Presidente");
		Subte c1 = new Subte();
		j1.caerEnCasillero(c1);
		int capital = j1.capitalTotal();
		j1.comprarCompania(c1);
		Assert.assertEquals(capital - 40000, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnAysaYCompraLaCompaniaYSuCapitalDecrementaEn30000() {
		Jugador j1 = new Jugador("Presidente");
		Aysa c1 = new Aysa();
		j1.caerEnCasillero(c1);
		int capital = j1.capitalTotal();
		j1.comprarCompania(c1);
		Assert.assertEquals(capital - 30000, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnTrenYCompraLaCompaniaYSuCapitalDecrementaEn38000() {
		Jugador j1 = new Jugador("Presidente");
		Tren c1 = new Tren();
		j1.caerEnCasillero(c1);
		int capital = j1.capitalTotal();
		j1.comprarCompania(c1);
		Assert.assertEquals(capital - 38000, j1.capitalTotal());
	}
	//---------------------------------------------
	
	
	
	
	
	
	
	// Teste de las multas cobradas por las companias
	@Test
	public void testUnJugadorNoPropietarioCaeEnEdesurCuyoPropietarioNoTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor500() {
		Jugador j1 = new Jugador("Presidente");
		Jugador j2 = new Jugador("Empleado");
		Edesur c1 = new Edesur();
		Aysa c2 = new Aysa();
		c1.setCompaniaPareja(c2);
		c2.setCompaniaPareja(c1);
		j1.comprarCompania(c1);
		j2.obtuvo(10);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 500*10, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnEdesurCuyoPropietarioTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor1000() {
		Jugador j1 = new Jugador("Presidente");
		Jugador j2 = new Jugador("Empleado");
		Edesur c1 = new Edesur();
		Aysa c2 = new Aysa();
		c1.setCompaniaPareja(c2);
		c2.setCompaniaPareja(c1);
		j1.comprarCompania(c1);
		j1.comprarCompania(c2);
		Assert.assertTrue(c2.propietario().sos(j1));
		j2.obtuvo(10);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 1000*10, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnAysaCuyoPropietarioNoTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor300() {
		Jugador j1 = new Jugador("Presidente");
		Jugador j2 = new Jugador("Empleado");
		Edesur c1 = new Edesur();
		Aysa c2 = new Aysa();
		c1.setCompaniaPareja(c2);
		c2.setCompaniaPareja(c1);
		j1.comprarCompania(c2);
		j2.obtuvo(10);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c2);
		Assert.assertEquals(capital - 300*10, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnAysaCuyoPropietarioTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor500() {
		Jugador presidente = new Jugador("Presidente");
		Jugador j2 = new Jugador("Empleado");
		Edesur c1 = new Edesur();
		Aysa c2 = new Aysa();
		c1.setCompaniaPareja(c2);
		c2.setCompaniaPareja(c1);
		presidente.comprarCompania(c1);
		presidente.comprarCompania(c2);
		Assert.assertEquals(c2.propietario(), presidente);
		j2.obtuvo(10);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c2);
		Assert.assertEquals(capital - 500*10, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnTrenCuyoPropietarioNoTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor450() {
		Jugador j1 = new Jugador("Presidente");
		Jugador j2 = new Jugador("Empleado");
		Tren c1 = new Tren();
		Subte c2 = new Subte();
		c1.setCompaniaPareja(c2);
		c2.setCompaniaPareja(c1);
		j1.comprarCompania(c1);
		j2.obtuvo(10);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 450*10, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnTrenCuyoPropietarioTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor800() {
		Jugador j1 = new Jugador("Presidente");
		Jugador j2 = new Jugador("Empleado");
		Tren c1 = new Tren();
		Subte c2 = new Subte();
		c1.setCompaniaPareja(c2);
		c2.setCompaniaPareja(c1);
		j1.comprarCompania(c1);
		j1.comprarCompania(c2);
		j2.obtuvo(10);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 800*10, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnSubteCuyoPropietarioNoTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor600() {
		Jugador j1 = new Jugador("Presidente");
		Jugador j2 = new Jugador("Empleado");
		Tren c1 = new Tren();
		Subte c2 = new Subte();
		c1.setCompaniaPareja(c2);
		c2.setCompaniaPareja(c1);
		j1.comprarCompania(c2);
		j2.obtuvo(10);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c2);
		Assert.assertEquals(capital - 600*10, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnSubteCuyoPropietarioTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor1100() {
		Jugador j1 = new Jugador("Presidente");
		Jugador j2 = new Jugador("Empleado");
		Tren c1 = new Tren();
		Subte c2 = new Subte();
		c1.setCompaniaPareja(c2);
		c2.setCompaniaPareja(c1);
		j1.comprarCompania(c1);
		j1.comprarCompania(c2);
		j2.obtuvo(10);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c2);
		Assert.assertEquals(capital - 1100*10, j2.capitalTotal());
	}
	//----------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	// Test de impuesto de lujo
}
