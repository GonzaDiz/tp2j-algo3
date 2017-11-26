package modelo;

import java.util.Collections;
import java.util.LinkedList;

import modelo.jugador.Jugador;

public class Turno {
	
	private LinkedList<Jugador> jugadores;
	private Dado dado1;
	private Dado dado2;
	
	public Turno() {
		this.jugadores = new LinkedList<>();
		this.dado1 = new Dado();
		this.dado2 = new Dado();
	}
	
	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}
	
	public void asignarTurnos() {
		Collections.shuffle(jugadores);
	}

	public Jugador proximoJugador() {
		Jugador proximoJugador = jugadores.removeFirst();
		proximoJugador.esTuTurno();
		return proximoJugador;
	}

	public void terminarTurno(Jugador jugador) {
		jugadores.addLast(jugador);
	}

	public void arrojarDados(Jugador jugador) {
		int valorDado1 = dado1.arrojar();
		int valorDado2 = dado2.arrojar();
		
//		if (valorDado1 == valorDado2) {
//			jugador.obtuvo(new TiroDoble(valorDado1,valorDado2));
//		}
//		else {
//			jugador.obtuvo(new TiroSimple(valorDado1,valorDado2));
//		}
		jugador.desplazar(valorDado1 + valorDado2);
	}

	public void asignarTurnoExtra(Jugador jugador) {
		jugadores.addFirst(jugador);
	}
}
