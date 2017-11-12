package modelo.casillero.especial;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class Quini6 extends Casillero{
	
	private ConcurrentHashMap<Jugador, Stack<Integer>> jugadores;
	
	public Quini6() {
		this.jugadores = new ConcurrentHashMap<>();

	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		
		if(this.puedeCobrar(unJugador)) {
			this.entregarPremio(unJugador);
		}
	}

	private void entregarPremio(Jugador unJugador) {
		unJugador.entregarDinero((jugadores.get(unJugador)).pop());		
	}

	private boolean puedeCobrar(Jugador unJugador) {
		return !(jugadores.get(unJugador)).empty();
	}

	public void registrarJugador(Jugador unJugador) {
		Stack <Integer> premios = new Stack<Integer>();
		premios.push(30000);
		premios.push(50000);
		jugadores.put(unJugador, premios);
	}
	
}
