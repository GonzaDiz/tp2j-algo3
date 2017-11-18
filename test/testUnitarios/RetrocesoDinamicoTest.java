package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.ArmadorDeTablero;
import modelo.Tablero;
import modelo.casillero.especial.RetrocesoDinamico;
import modelo.jugador.Jugador;

public class RetrocesoDinamicoTest {
	
	@Test
	public void testRetrocesoDinamicoNoEsNull() {
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		Assert.assertNotNull(retrocesoDinamico);
	}
	
	@Test
	public void testUnJugadorCaeEnRetrocesoDinamicoHabiendoSumadoDoceEntoncesRetrocede10HastaSubte() {
		int posicion_retroceso_dinamico = 18;
		int posicion_subte = 8;
		Jugador jugador = new Jugador("Lucas");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(12);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_retroceso_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_subte), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaEnRetrocesoDinamicoHabiendoSumado11EntoncesRetrocede9HastaCordobaNorte() {
		Jugador jugador = new Jugador("Uriel");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(11);
		jugador.caerEnCasillero(tablero.getCasillero(18));
		Assert.assertEquals(tablero.getCasillero(9), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnRetrocesoDinamicoHabiendoSumado10EntoncesRetrocede100000mod10() {
		int posicion_retroceso_dinamico = 18;
		Jugador jugador = new Jugador("Damian");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(10);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_retroceso_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_retroceso_dinamico),jugador.casilleroActual());
	}
	
	@Test 
	public void testUnJugadorCaeEnRetrocesoDinamicoHabiendoSumado2EntoncesRetrocede2CasillerosHastaTrenAlTener0Propiedades() {
		int posicion_retroceso_dinamico = 18;
		int posicion_tren = 16;
		Jugador jugador = new Jugador("Esteban");
		Tablero tablero = Tablero.getTablero();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(2);
		jugador.caerEnCasillero(tablero.getCasillero(posicion_retroceso_dinamico));
		Assert.assertEquals(tablero.getCasillero(posicion_tren), jugador.casilleroActual());
	}

}
