package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.ArmadorDeTablero;
import modelo.Tablero;
import modelo.casillero.especial.AvanceDinamico;
import modelo.casillero.terrenos.Neuquen;
import modelo.casillero.terrenos.SaltaSur;
import modelo.casillero.terrenos.SantaFe;
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
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(2); // Este mensaje recibira una tirada de dados aleatoria como paramtero
		jugador.caerEnCasillero(tablero.getCasillero(7));
		Assert.assertEquals(tablero.getCasillero(7), jugador.casilleroActual());		
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoTresEntoncesAvanzaUnLugar () {
		int posicion_avance_dinamico = 7;
		int posicion_subte = 8;
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(3);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_avance_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_subte), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoCuatroEntoncesAvanzaDosLugares () {
		int posicion_avance_dinamico = 7;
		int posicion_cordoba_norte = 9;
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(4);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_avance_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_cordoba_norte), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoCincoEntoncesAvanzaTresLugares () {
		int posicion_avance_dinamico = 7;
		int posicion_impuesto_de_lujo = 10;
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(5);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_avance_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_impuesto_de_lujo), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoSeisEntoncesAvanzaCuatroLugares () {
		int posicion_avance_dinamico = 7;
		int posicion_santa_fe = 11;
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(6);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_avance_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_santa_fe), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoSieteEntoncesAvanza100000mod7 () {
		// 100000 % 7 = 5
		int posicion_avance_dinamico = 7;
		int posicion_aysa = 12;
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(7);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_avance_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_aysa), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoOchoEntoncesAvanza100000mod8 () {
		// 100000 % 8 = 0
		int posicion_avance_dinamico = 7;
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(8);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_avance_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_avance_dinamico), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoNueveEntoncesAvanza100000mod9 () {
		// 100000 % 9 = 1
		int posicion_avance_dinamico = 7;
		int posicion_subte = 8;
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(9);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_avance_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_subte), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnAvanceDinamicoHabiendoSumadoDiezEntoncesAvanza100000mod10 () {
		// 100000 % 10 = 0
		int posicion_avance_dinamico = 7;
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(10);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_avance_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_avance_dinamico), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorSinPropiedadesCaeEnAvanceDinamicoHabiendoSumadoOnceEntoncesAvanzaOnceCaeEnRetrocesoDinamicoYRetrocedeHastaSantaFe () {
		int posicion_avance_dinamico = 7;
		int posicion_cordoba_norte = 9;
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(11);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_avance_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_cordoba_norte), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorSinPropiedadesCaeEnAvanceDinamicoHabiendoSumadoDoceEntoncesAvanzaDoce () {
		int posicion_avance_dinamico = 7;
		int posicion_tucuman = 19;
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(12);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_avance_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_tucuman), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorConTresPropiedadesCaeEnAvanceDinamicoHabiendoSumadoDoceEntoncesAvanzaNueve () throws CapitalInsuficienteError {
		int posicion_avance_dinamico = 7;
		int posicion_tren = 16;
		Jugador jugador = new Jugador("Ariel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.comprar(new Neuquen());
		jugador.comprar(new SantaFe());
		jugador.comprar(new SaltaSur());
		jugador.obtuvo(12);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_avance_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_tren), jugador.casilleroActual());
	}
	
}
