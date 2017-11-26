package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.TiroDoble;
import modelo.Turno;
import modelo.casillero.compania.Compania;
import modelo.casillero.compania.CompaniaFactory;
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
	
//	@Test
//	public void testUnJugadorArrojaLosDadosYSuPosicionCambiaSegunLoQueIndiquenLosDados() {
//		Jugador jugador1 = new Jugador("Ariel");
//		Jugador jugador2 = new Jugador("Gonza");
//		Jugador jugador3 = new Jugador("Uriel");
//		Turno turno = new Turno();
//		turno.agregarJugador(jugador1);
//		turno.agregarJugador(jugador2);
//		turno.agregarJugador(jugador3);
//		turno.asignarTurnos();
//	}
}
