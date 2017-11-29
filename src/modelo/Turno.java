package modelo;

import java.util.Collections;
import java.util.LinkedList;

import modelo.jugador.Jugador;

public class Turno {
	
	private LinkedList<Jugador> jugadores;
	private ParDeDados dados;
	
	public Turno() {
		this.jugadores = new LinkedList<>();
		this.dados = new ParDeDados();
	}
	
	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}
	
	public void asignarTurnos() {
		Collections.shuffle(jugadores);
	}

	public Jugador proximoJugador() {
		Jugador proximoJugador = jugadores.getFirst();
		proximoJugador.esTuTurno();
		return proximoJugador;
	}
	
	public Jugador jugadorConTurno() {
		return jugadores.getFirst();
	}

	public void terminarTurno(Jugador jugador) {
		jugadores.removeFirst();
		jugadores.addLast(jugador);
	}

	public int arrojarDados(Jugador jugador) {
		TiroDeDados tiroDeDados = dados.arrojar();
		jugador.obtuvo(tiroDeDados);
		jugador.desplazar(tiroDeDados.valor());
		return tiroDeDados.valor();
	}

	public void asignarTurnoExtra(Jugador jugador) {
		//jugadores.addFirst(jugador);
	}

	public void eliminarJugador(Jugador jugadorRendido) {
		this.jugadores.remove(jugadorRendido);
	}
}
