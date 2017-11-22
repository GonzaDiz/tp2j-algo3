package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.ArmadorDeTablero;
import modelo.Tablero;
import modelo.casillero.compania.Aysa;
import modelo.casillero.compania.Subte;
import modelo.casillero.compania.Tren;
import modelo.casillero.especial.AvanceDinamico;
import modelo.casillero.especial.ImpuestoDeLujo;
import modelo.casillero.terrenos.CordobaNorte;
import modelo.casillero.terrenos.Neuquen;
import modelo.casillero.terrenos.SaltaSur;
import modelo.casillero.terrenos.SantaFe;
import modelo.casillero.terrenos.Tucuman;
import modelo.excepciones.CapitalInsuficienteError;
import modelo.jugador.Jugador;

public class AvanceDinamicoTest {
	
	@Test
	public void testAvanceDinamicoNoEsNull() {
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Assert.assertNotNull(avanceDinamico);
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoDosEntoncesAvanzaCeroLugares () {
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(2); // Este mensaje recibira una tirada de dados aleatoria como paramtero
		jugador.caerEnCasillero(tablero.getCasillero(new AvanceDinamico()));
		Assert.assertEquals(tablero.getCasillero(new AvanceDinamico()), jugador.casilleroActual());		
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoTresEntoncesAvanzaUnLugar () {
		AvanceDinamico ad = new AvanceDinamico();
		Subte subte = new Subte();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(3);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(subte), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoCuatroEntoncesAvanzaDosLugares () {
		AvanceDinamico ad = new AvanceDinamico();
		CordobaNorte cn = new CordobaNorte();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(4);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(cn), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoCincoEntoncesAvanzaTresLugares () {
		AvanceDinamico ad = new AvanceDinamico();
		ImpuestoDeLujo il = new ImpuestoDeLujo();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(5);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(il), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoSeisEntoncesAvanzaCuatroLugares () {
		AvanceDinamico ad = new AvanceDinamico();
		SantaFe sf = new SantaFe();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(6);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(sf), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoSieteEntoncesAvanza100000mod7 () {
		// 100000 % 7 = 5
		AvanceDinamico ad = new AvanceDinamico();
		Aysa c = new Aysa();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(7);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(c), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoOchoEntoncesAvanza100000mod8 () {
		// 100000 % 8 = 0
		AvanceDinamico ad = new AvanceDinamico();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(8);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(ad), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoNueveEntoncesAvanza100000mod9 () {
		// 100000 % 9 = 1
		AvanceDinamico ad = new AvanceDinamico();
		Subte c = new Subte();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(9);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(c), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoDiezEntoncesAvanza100000mod10 () {
		// 100000 % 10 = 0
		AvanceDinamico ad = new AvanceDinamico();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(10);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(ad), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorSinPropiedadesCaeEnAvanceDinamicoHabiendoSumadoOnceEntoncesAvanzaOnceCaeEnRetrocesoDinamicoYRetrocedeHastaSantaFe () {
		AvanceDinamico ad = new AvanceDinamico();
		CordobaNorte c = new CordobaNorte();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(11);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(c), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorSinPropiedadesCaeEnAvanceDinamicoHabiendoSumadoDoceEntoncesAvanzaDoce () {
		AvanceDinamico ad = new AvanceDinamico();
		Tucuman c = new Tucuman();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(12);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(c), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorConTresPropiedadesCaeEnAvanceDinamicoHabiendoSumadoDoceEntoncesAvanzaNueve () throws CapitalInsuficienteError {
		AvanceDinamico ad = new AvanceDinamico();
		Tren c = new Tren();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.comprarTerreno(new Neuquen());
		jugador.comprarTerreno(new SantaFe());
		jugador.comprarTerreno(new SaltaSur());
		jugador.obtuvo(12);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(c), jugador.casilleroActual());
	}
	
}
