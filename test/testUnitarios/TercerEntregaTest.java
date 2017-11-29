package testUnitarios;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import modelo.ArmadorDeTablero;
import modelo.Tablero;
import modelo.TiroDoble;
import modelo.TiroSimple;
import modelo.Turno;
import modelo.casillero.Casillero;
import modelo.casillero.compania.Compania;
import modelo.casillero.compania.CompaniaFactory;
import modelo.casillero.especial.Salida;
import modelo.casillero.terrenos.TerrenoDoble;
import modelo.casillero.terrenos.TerrenosFactory;
import modelo.jugador.Jugador;

public class TercerEntregaTest {
	
	@Test
	public void testUnJugadorObtieneUnTiroDobleEntoncesTieneUnTurnoExtra() {
		Jugador jugador1 = new Jugador("Ariel");
		Jugador jugador2 = new Jugador("Gonza");
		Jugador jugador3 = new Jugador("Uriel");
		Turno turno = new Turno();
		turno.agregarJugador(jugador1);
		turno.agregarJugador(jugador2);
		turno.agregarJugador(jugador3);
		turno.asignarTurnos();
		
		Jugador jugadorConTurno = turno.proximoJugador();
		
//		jugadorConTurno.arrojarDados(turno);
		jugadorConTurno.obtuvo(new TiroDoble(4));
		jugadorConTurno.terminarTurno(turno);
		Jugador proximoJugadorConTurno = turno.proximoJugador();
		
		Assert.assertTrue(jugadorConTurno.sos(proximoJugadorConTurno));
	
//		jugadorConTurno.arrojarDados(turno);
	}
	
	@Test
	public void testUnJugadorObtieneUnTiroDobleEnSuTurnoExtraNoTieneOtroTurnoExtra() {
		Jugador jugador1 = new Jugador("Ariel");
		Jugador jugador2 = new Jugador("Gonza");
		Jugador jugador3 = new Jugador("Uriel");
		Turno turno = new Turno();
		turno.agregarJugador(jugador1);
		turno.agregarJugador(jugador2);
		turno.agregarJugador(jugador3);
		turno.asignarTurnos();
		
		Jugador jugadorConTurno = turno.proximoJugador();
		
//		jugadorConTurno.arrojarDados(turno);
		jugadorConTurno.obtuvo(new TiroDoble(4));
		jugadorConTurno.terminarTurno(turno);
		Jugador proximoJugadorConTurno = turno.proximoJugador();
		
		Assert.assertTrue(jugadorConTurno.sos(proximoJugadorConTurno));
		
		jugadorConTurno.obtuvo(new TiroDoble(10));
		jugadorConTurno.terminarTurno(turno);
		
		Assert.assertFalse(jugadorConTurno.sos(turno.proximoJugador()));
	}
	
	@Test
	public void testUnJugadorVendeUnTerrenoYObtieneElValorDelTerrenoYSusEdificacionesMenosUn15Porciento() {
		Jugador jugador = new Jugador("Ariel");
		int costoSaltaSur = 23000;
		int costoCasa =  4500;
		
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		TerrenoDoble saltaSur = terrenosFactory.crearSaltaSur();
		TerrenoDoble saltaNorte = terrenosFactory.crearSaltaNorte();
		saltaSur.setTerrenoPareja(saltaNorte);
		saltaNorte.setTerrenoPareja(saltaSur);
		
		jugador.comprarTerreno(saltaSur);
		jugador.comprarTerreno(saltaNorte);
		jugador.construirCasaEn(saltaSur);
		
		int capital = jugador.capitalTotal();
		jugador.venderTerreno(saltaSur);
		Assert.assertEquals(capital + ((85/100) * (costoSaltaSur + costoCasa)), jugador.capitalTotal());
	}
	
	@Test
	public void testUnJugadorVendeUnaCompaniaYObtieneElValorDeLaMismaMenosUn15Porciento() {
		Jugador jugador = new Jugador("Ariel");
		int costoAysa = 30000;
		CompaniaFactory companiaFactory = new CompaniaFactory();
		Compania aysa = companiaFactory.crearAysa();
		Compania edesur = companiaFactory.crearEdesur();
		aysa.setCompaniaPareja(edesur);
		edesur.setCompaniaPareja(aysa);
		jugador.comprarCompania(aysa);
		int capital = jugador.capitalTotal();
		jugador.venderCompania(aysa);
		Assert.assertEquals(capital + (85/100 * costoAysa), jugador.capitalTotal());
	}
	
	@Test
	public void testUnJugadorArrojaLosDadosYSuPosicionCambiaSegunLoQueIndiquenLosDados() {
		Jugador jugador1 = new Jugador("Ariel");
		Jugador jugador2 = new Jugador("Gonza");
		Jugador jugador3 = new Jugador("Uriel");
		Tablero tablero = Tablero.getInstance();
		ArmadorDeTablero armador = new ArmadorDeTablero();
		ArrayList<Jugador> jugadores = new ArrayList<>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		armador.armarTablero(tablero, jugadores);
		Casillero salida = tablero.getCasillero(new Salida());
		
		jugador1.caerEnCasillero(salida);
		jugador2.caerEnCasillero(salida);
		jugador3.caerEnCasillero(salida);
		
		Turno turno = new Turno();
		turno.agregarJugador(jugador1);
		turno.agregarJugador(jugador2);
		turno.agregarJugador(jugador3);
		turno.asignarTurnos();
		
		Jugador jugadorConTurno = turno.proximoJugador();
		
		int valorDeDados = jugadorConTurno.arrojaDados(turno);
		
		if (valorDeDados == 7) { // Si saca 7 cae en avance dinamico y se vuelve a desplazar
			Assert.assertEquals(tablero.getCasillero(100000%7 + valorDeDados),jugadorConTurno.casilleroActual() );
		}
		else {
		Assert.assertEquals(tablero.getCasilleroPorDesplazamiento(salida, valorDeDados), jugadorConTurno.casilleroActual());
		}
	}
	
	@Test
	public void testUnJugadorObtieneUnTiroSimpleEnSuTurnoExtraEntoncesNoTieneOtroTurnoExtra() {
		Jugador jugador1 = new Jugador("Ariel");
		Jugador jugador2 = new Jugador("Gonza");
		Jugador jugador3 = new Jugador("Uriel");
		Turno turno = new Turno();
		turno.agregarJugador(jugador1);
		turno.agregarJugador(jugador2);
		turno.agregarJugador(jugador3);
		turno.asignarTurnos();
		
		Jugador jugadorConTurno = turno.proximoJugador();
		
//		jugadorConTurno.arrojarDados(turno);
		jugadorConTurno.obtuvo(new TiroDoble(4));
		jugadorConTurno.terminarTurno(turno);
		Jugador proximoJugadorConTurno = turno.proximoJugador();
		
		Assert.assertTrue(jugadorConTurno.sos(proximoJugadorConTurno));
		
		jugadorConTurno.obtuvo(new TiroSimple(10));
		jugadorConTurno.terminarTurno(turno);
		
		Assert.assertFalse(jugadorConTurno.sos(turno.proximoJugador()));
	}
}
