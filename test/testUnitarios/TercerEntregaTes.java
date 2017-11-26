package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.TiroDoble;
import modelo.Turno;
import modelo.jugador.Jugador;

public class TercerEntregaTes {
	
	@Test
	public void test01() {
		Jugador jugador1 = new Jugador("Ariel");
		Jugador jugador2 = new Jugador("Gonza");
		Jugador jugador3 = new Jugador("Uriel");
		Turno turno = new Turno();
		turno.agregarJugador(jugador1);
		turno.agregarJugador(jugador2);
		turno.agregarJugador(jugador3);
		turno.asignarTurnos();
		
		Jugador jugadorConTurno = turno.getJugadorConTurno();
		
//		jugadorConTurno.arrojarDados(turno);
		jugadorConTurno.obtuvo(new TiroDoble(4));
		jugadorConTurno.terminarTurno(turno);
		Jugador proximoJugadorConTurno = turno.getJugadorConTurno();
		
		Assert.assertTrue(jugadorConTurno.sos(proximoJugadorConTurno));
	
//		jugadorConTurno.arrojarDados(turno);
	}

}
