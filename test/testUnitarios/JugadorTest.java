package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.compania.Aysa;
import modelo.casillero.compania.Subte;
import modelo.casillero.compania.Tren;
import modelo.casillero.especial.AvanceDinamico;
import modelo.casillero.especial.Carcel;
import modelo.casillero.especial.ImpuestoDeLujo;
import modelo.casillero.especial.Policia;
import modelo.casillero.especial.Quini6;
import modelo.casillero.especial.RetrocesoDinamico;
import modelo.casillero.terrenos.BuenosAiresSur;
import modelo.casillero.terrenos.CordobaNorte;
import modelo.casillero.terrenos.Neuquen;
import modelo.casillero.terrenos.SaltaNorte;
import modelo.casillero.terrenos.SaltaSur;
import modelo.casillero.terrenos.SantaFe;
import modelo.casillero.terrenos.Tucuman;
import modelo.excepciones.CapitalInsuficienteError;
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
	public void testUnJugadorCaeEnUnTerrenoYAlComprarloSeVuelveElPropietario() throws CapitalInsuficienteError {
		Jugador jugador = new Jugador("Gonzalo");
		BuenosAiresSur bsasSur = new BuenosAiresSur();
		jugador.caerEnCasillero(bsasSur);
		jugador.comprar(bsasSur);
		Assert.assertEquals(jugador, bsasSur.propietario());
	}

	@Test 
	public void testUnJugadorCaeEnLaCarcelYNoPuedeDesplazarse() {
		Jugador jugador = new Jugador("Ariel");
		Carcel carcel = new Carcel();
		jugador.caerEnCasillero(carcel);
		Assert.assertFalse(jugador.desplazar(2));
	}
	
	
	@Test
	public void testUnJugadorCaeEnLaCarcelYPuedePagarLaFianzaSiElTurnoEsDosOTres() throws CapitalInsuficienteError {
		Jugador jugador = new Jugador("Gonzalo");
		Carcel carcel = new Carcel();
		carcel.setCasilleroSiguiente(carcel); // Para que pase la prueba y el jugador se desplace
		jugador.caerEnCasillero(carcel);
		jugador.esTuTurno(); // En este turno no puede realizar ninguna accion.
		jugador.esTuTurno();
		jugador.pagarFianza(carcel);
		Assert.assertTrue(jugador.desplazar(2));		
	}
	
	@Test
	public void testUnJugadorNoPuedePagarLaFianzaSiElTurnoEsUno() throws CapitalInsuficienteError {
		Jugador jugador = new Jugador("Ariel");
		Carcel carcel = new Carcel();
		jugador.caerEnCasillero(carcel);
		jugador.esTuTurno();
		Assert.assertFalse(jugador.pagarFianza(carcel));
	}
	
	@Test
	public void testUnJugadorPuedePagarLaFianzaSiEsElTercerTurnoQueEstaEnLaCarcel() throws CapitalInsuficienteError {
		Jugador jugador = new Jugador("Ariel");
		Carcel carcel = new Carcel();
		jugador.caerEnCasillero(carcel);
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.esTuTurno();
		Assert.assertTrue(jugador.pagarFianza(carcel));
	}
	
	@Test
	public void testUnJugadorEnLibertadNoPuedePagarLaFianza() throws CapitalInsuficienteError {
		Jugador jugador = new Jugador("Ariel");
		Carcel carcel = new Carcel();
		Assert.assertFalse(jugador.pagarFianza(carcel));
	}
	
	@Test
	public void testUnJugadorEncarceladoNoPuedeDesplazarse() {
		Jugador jugador = new Jugador("Ariel");
		jugador.encarcelar();
		Assert.assertFalse(jugador.desplazar(5));
	}
	
	@Test
	public void testUnJugadorQueCaeEnLaCarcelQuedaLibreAlCuartoTurno() {
		Jugador jugador = new Jugador("Ariel");
		Carcel carcel = new Carcel();
		carcel.setCasilleroSiguiente(carcel); // Para que pase la prueba y el jugador se desplace
		jugador.caerEnCasillero(carcel);
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.esTuTurno();
		Assert.assertTrue(jugador.desplazar(5));
	}
	
	@Test(expected = CapitalInsuficienteError.class)
	public void testUnJugadorNoPuedePagarLaFianzaPorFaltaDeFondosSiendoElTurnoDosOTres () throws CapitalInsuficienteError {
		Jugador jugador = new Jugador("Ariel", 40000); // Este constructor es solo para testear casos de saldo insuficiente
		Carcel carcel = new Carcel();
		carcel.setCasilleroSiguiente(carcel); // Para que pase la prueba y el jugador se desplace
		jugador.caerEnCasillero(carcel);
		jugador.esTuTurno();
		jugador.esTuTurno();
		jugador.pagarFianza(carcel);
		Assert.assertFalse(jugador.desplazar(5));
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoDosEntoncesAvanzaCeroLugares () {
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		jugador.obtuvo(2); // Este mensaje recibira una tirada de dados aleatoria como paramtero
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(ad, jugador.casilleroActual());		
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoTresEntoncesAvanzaUnLugar () {
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		Subte subte = new Subte();
		ad.setCasilleroSiguiente(subte); // Este tipo de mensajes los enviara la clase Tablero cuando se cree (junto con los casilleros)
		jugador.obtuvo(3); 
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(subte, jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoCuatroEntoncesAvanzaDosLugares () {
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		CordobaNorte cn = new CordobaNorte();
		Subte subte = new Subte();
		ad.setCasilleroSiguiente(subte);
		subte.setCasilleroSiguiente(cn);
		jugador.obtuvo(4); 
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(cn, jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoCincoEntoncesAvanzaTresLugares () {
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		Subte subte = new Subte();
		CordobaNorte cn = new CordobaNorte();
		ImpuestoDeLujo idl = new ImpuestoDeLujo();
		ad.setCasilleroSiguiente(subte);
		subte.setCasilleroSiguiente(cn);
		cn.setCasilleroSiguiente(idl);
		jugador.obtuvo(5); 
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(idl, jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoSeisEntoncesAvanzaCuatroLugares () {
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		Subte subte = new Subte();
		CordobaNorte cn = new CordobaNorte();
		ImpuestoDeLujo idl = new ImpuestoDeLujo();
		SantaFe sf = new SantaFe();
		ad.setCasilleroSiguiente(subte);
		subte.setCasilleroSiguiente(cn);
		cn.setCasilleroSiguiente(idl);
		idl.setCasilleroSiguiente(sf);
		jugador.obtuvo(6); 
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(sf, jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoSieteEntoncesAvanza100000mod7 () {
		// 100000 % 7 = 5
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		Subte subte = new Subte();
		CordobaNorte cn = new CordobaNorte();
		ImpuestoDeLujo idl = new ImpuestoDeLujo();
		SantaFe sf = new SantaFe();
		Aysa aysa = new Aysa();
		ad.setCasilleroSiguiente(subte);
		subte.setCasilleroSiguiente(cn);
		cn.setCasilleroSiguiente(idl);
		idl.setCasilleroSiguiente(sf);
		sf.setCasilleroSiguiente(aysa);
		jugador.obtuvo(7); 
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(aysa, jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoOchoEntoncesAvanza100000mod8 () {
		// 100000 % 8 = 0
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		jugador.obtuvo(8); 
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(ad, jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoNueveEntoncesAvanza100000mod9 () {
		// 100000 % 9 = 1
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		Subte subte = new Subte();
		ad.setCasilleroSiguiente(subte);
		jugador.obtuvo(9); 
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(subte, jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoDiezEntoncesAvanza100000mod10 () {
		// 100000 % 10 = 0
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		jugador.obtuvo(10); 
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(ad, jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorSinPropiedadesCaeEnAvanceDinamicoHabiendoSumadoOnceEntoncesAvanzaOnce () {
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		Subte subte = new Subte();
		CordobaNorte cn = new CordobaNorte();
		ImpuestoDeLujo idl = new ImpuestoDeLujo();
		SantaFe sf = new SantaFe();
		Aysa aysa = new Aysa();
		SaltaNorte sn = new SaltaNorte();
		SaltaSur ss = new SaltaSur();
		Policia p = new Policia();
		Tren t = new Tren();
		Neuquen n = new Neuquen();
		RetrocesoDinamico rd = new RetrocesoDinamico();
		ad.setCasilleroSiguiente(subte);
		subte.setCasilleroSiguiente(cn);
		cn.setCasilleroSiguiente(idl);
		idl.setCasilleroSiguiente(sf);
		sf.setCasilleroSiguiente(aysa);
		aysa.setCasilleroSiguiente(sn);
		sn.setCasilleroSiguiente(ss);
		ss.setCasilleroSiguiente(p);
		p.setCasilleroSiguiente(t);
		t.setCasilleroSiguiente(n);
		n.setCasilleroSiguiente(rd);
		jugador.obtuvo(11); 
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(rd, jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorSinPropiedadesCaeEnAvanceDinamicoHabiendoSumadoDoceEntoncesAvanzaDoce () {
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		Subte subte = new Subte();
		CordobaNorte cn = new CordobaNorte();
		ImpuestoDeLujo idl = new ImpuestoDeLujo();
		SantaFe sf = new SantaFe();
		Aysa aysa = new Aysa();
		SaltaNorte sn = new SaltaNorte();
		SaltaSur ss = new SaltaSur();
		Policia p = new Policia();
		Tren t = new Tren();
		Neuquen n = new Neuquen();
		RetrocesoDinamico rd = new RetrocesoDinamico();
		Tucuman tucu = new Tucuman();
		ad.setCasilleroSiguiente(subte);
		subte.setCasilleroSiguiente(cn);
		cn.setCasilleroSiguiente(idl);
		idl.setCasilleroSiguiente(sf);
		sf.setCasilleroSiguiente(aysa);
		aysa.setCasilleroSiguiente(sn);
		sn.setCasilleroSiguiente(ss);
		ss.setCasilleroSiguiente(p);
		p.setCasilleroSiguiente(t);
		t.setCasilleroSiguiente(n);
		n.setCasilleroSiguiente(rd);
		rd.setCasilleroSiguiente(tucu);
		jugador.obtuvo(12); 
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(tucu, jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorConTresPropiedadesPropiedadesCaeEnAvanceDinamicoHabiendoSumadoDoceEntoncesAvanzaNueve () throws CapitalInsuficienteError {
		Jugador jugador = new Jugador("Ariel");
		AvanceDinamico ad = new AvanceDinamico();
		Subte subte = new Subte();
		CordobaNorte cn = new CordobaNorte();
		ImpuestoDeLujo idl = new ImpuestoDeLujo();
		SantaFe sf = new SantaFe();
		Aysa aysa = new Aysa();
		SaltaNorte sn = new SaltaNorte();
		SaltaSur ss = new SaltaSur();
		Policia p = new Policia();
		Tren t = new Tren();
		Neuquen n = new Neuquen();
		RetrocesoDinamico rd = new RetrocesoDinamico();
		Tucuman tucu = new Tucuman();
		ad.setCasilleroSiguiente(subte);
		subte.setCasilleroSiguiente(cn);
		cn.setCasilleroSiguiente(idl);
		idl.setCasilleroSiguiente(sf);
		sf.setCasilleroSiguiente(aysa);
		aysa.setCasilleroSiguiente(sn);
		sn.setCasilleroSiguiente(ss);
		ss.setCasilleroSiguiente(p);
		p.setCasilleroSiguiente(t);
		t.setCasilleroSiguiente(n);
		n.setCasilleroSiguiente(rd);
		rd.setCasilleroSiguiente(tucu);
		jugador.comprar(n);
		jugador.comprar(sf);
		jugador.comprar(ss);
		jugador.obtuvo(12); 
		jugador.caerEnCasillero(ad);
		Assert.assertEquals(t, jugador.casilleroActual());
	}

}
