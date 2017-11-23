package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.ArmadorDeTablero;
import modelo.Tablero;
import modelo.casillero.compania.Compania;
import modelo.casillero.compania.CompaniaFactory;
import modelo.casillero.especial.AvanceDinamico;
import modelo.casillero.especial.ImpuestoDeLujo;
import modelo.casillero.terrenos.Terreno;
import modelo.casillero.terrenos.TerrenoDoble;
import modelo.casillero.terrenos.TerrenosFactory;
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
		CompaniaFactory companiaFactory = new CompaniaFactory();
		AvanceDinamico ad = new AvanceDinamico();
		Compania subte = companiaFactory.crearSubte();
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
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		AvanceDinamico ad = new AvanceDinamico();
		TerrenoDoble cn = terrenosFactory.crearCordobaNorte();
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
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		AvanceDinamico ad = new AvanceDinamico();
		Terreno sf = terrenosFactory.crearSantaFe();
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
		CompaniaFactory companiaFactory = new CompaniaFactory();
		AvanceDinamico ad = new AvanceDinamico();
		Compania aysa = companiaFactory.crearAysa();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(7);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(aysa), jugador.casilleroActual());
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
		CompaniaFactory companiaFactory = new CompaniaFactory();
		AvanceDinamico ad = new AvanceDinamico();
		Compania subte = companiaFactory.crearSubte();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(9);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(subte), jugador.casilleroActual());
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
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		AvanceDinamico ad = new AvanceDinamico();
		TerrenoDoble c = terrenosFactory.crearCordobaNorte();
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
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		AvanceDinamico ad = new AvanceDinamico();
		Terreno tucuman = terrenosFactory.crearTucuman();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(12);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(tucuman), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorConTresPropiedadesCaeEnAvanceDinamicoHabiendoSumadoDoceEntoncesAvanzaNueve () throws CapitalInsuficienteError {
		CompaniaFactory companiaFactory = new CompaniaFactory();
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		AvanceDinamico ad = new AvanceDinamico();
		Compania tren = companiaFactory.crearTren();
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.comprarTerreno(terrenosFactory.crearNeuquen());
		jugador.comprarTerreno(terrenosFactory.crearSantaFe());
		jugador.comprarTerreno(terrenosFactory.crearSaltaSur());
		jugador.obtuvo(12);
		jugador.caerEnCasillero(tablero.getCasillero(ad));
		Assert.assertEquals(tablero.getCasillero(tren), jugador.casilleroActual());
	}
	
}
