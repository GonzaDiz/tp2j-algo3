package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.ArmadorDeTablero;
import modelo.Tablero;
import modelo.casillero.compania.Subte;
import modelo.casillero.compania.Tren;
import modelo.casillero.especial.RetrocesoDinamico;
import modelo.casillero.terrenos.Terreno;
import modelo.casillero.terrenos.TerrenosFactory;
import modelo.jugador.Jugador;

public class RetrocesoDinamicoTest {
	
	@Test
	public void testRetrocesoDinamicoNoEsNull() {
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		Assert.assertNotNull(retrocesoDinamico);
	}
	
	@Test
	public void testUnJugadorCaeEnRetrocesoDinamicoHabiendoSumadoDoceEntoncesRetrocede10HastaSubte() {
		RetrocesoDinamico rd = new RetrocesoDinamico();
		Subte c = new Subte();
		Jugador jugador = new Jugador("Lucas");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(12);
		jugador.caerEnCasillero(tablero.getCasillero(rd));
		Assert.assertEquals(tablero.getCasillero(c), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaEnRetrocesoDinamicoHabiendoSumado11EntoncesRetrocede9HastaCordobaNorte() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		RetrocesoDinamico rd = new RetrocesoDinamico();
		Terreno c = terrenosFactory.crearCordobaNorte();
		Jugador jugador = new Jugador("Uriel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(11);
		jugador.caerEnCasillero(tablero.getCasillero(rd));
		Assert.assertEquals(tablero.getCasillero(c), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnRetrocesoDinamicoHabiendoSumado10EntoncesRetrocede100000mod10() {
		RetrocesoDinamico rd = new RetrocesoDinamico();
		Jugador jugador = new Jugador("Damian");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(10);
		jugador.caerEnCasillero(tablero.getCasillero(rd));
		Assert.assertEquals(tablero.getCasillero(rd),jugador.casilleroActual());
	}
	
	@Test 
	public void testUnJugadorCaeEnRetrocesoDinamicoHabiendoSumado2EntoncesRetrocede2CasillerosHastaTrenAlTener0Propiedades() {
		RetrocesoDinamico rd = new RetrocesoDinamico();
		Tren c = new Tren();
		Jugador jugador = new Jugador("Esteban");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero);
		jugador.obtuvo(2);
		jugador.caerEnCasillero(tablero.getCasillero(rd));
		Assert.assertEquals(tablero.getCasillero(c), jugador.casilleroActual());
	}

}
