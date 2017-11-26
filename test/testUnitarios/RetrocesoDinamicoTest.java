package testUnitarios;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import modelo.ArmadorDeTablero;
import modelo.Tablero;
import modelo.TiroSimple;
import modelo.casillero.compania.Compania;
import modelo.casillero.compania.CompaniaFactory;
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
		CompaniaFactory companiaFactory = new CompaniaFactory();
		RetrocesoDinamico rd = new RetrocesoDinamico();
		Compania subte = companiaFactory.crearSubte();
		Jugador jugador = new Jugador("Lucas");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		ArrayList<Jugador> jugadores = new ArrayList<>();
		jugadores.add(jugador);
		armador.armarTablero(tablero, jugadores);
		jugador.obtuvo(new TiroSimple(12));
		jugador.caerEnCasillero(tablero.getCasillero(rd));
		Assert.assertEquals(tablero.getCasillero(subte), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaEnRetrocesoDinamicoHabiendoSumado11EntoncesRetrocede9HastaCordobaNorte() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		RetrocesoDinamico rd = new RetrocesoDinamico();
		Terreno c = terrenosFactory.crearCordobaNorte();
		Jugador jugador = new Jugador("Uriel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		ArrayList<Jugador> jugadores = new ArrayList<>();
		jugadores.add(jugador);
		armador.armarTablero(tablero, jugadores);
		jugador.obtuvo(new TiroSimple(11));
		jugador.caerEnCasillero(tablero.getCasillero(rd));
		Assert.assertEquals(tablero.getCasillero(c), jugador.casilleroActual());
	}
	
	@Test
	public void testUnJugadorCaeEnRetrocesoDinamicoHabiendoSumado10EntoncesRetrocede100000mod10() {
		RetrocesoDinamico rd = new RetrocesoDinamico();
		Jugador jugador = new Jugador("Damian");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		ArrayList<Jugador> jugadores = new ArrayList<>();
		jugadores.add(jugador);
		armador.armarTablero(tablero, jugadores);
		jugador.obtuvo(new TiroSimple(10));
		jugador.caerEnCasillero(tablero.getCasillero(rd));
		Assert.assertEquals(tablero.getCasillero(rd),jugador.casilleroActual());
	}
	
	@Test 
	public void testUnJugadorCaeEnRetrocesoDinamicoHabiendoSumado2EntoncesRetrocede2CasillerosHastaTrenAlTener0Propiedades() {
		CompaniaFactory companiaFactory = new CompaniaFactory();
		RetrocesoDinamico rd = new RetrocesoDinamico();
		Compania tren = companiaFactory.crearTren();
		Jugador jugador = new Jugador("Esteban");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		ArrayList<Jugador> jugadores = new ArrayList<>();
		jugadores.add(jugador);
		armador.armarTablero(tablero, jugadores);
		jugador.obtuvo(new TiroSimple(2));
		jugador.caerEnCasillero(tablero.getCasillero(rd));
		Assert.assertEquals(tablero.getCasillero(tren), jugador.casilleroActual());
	}

}
