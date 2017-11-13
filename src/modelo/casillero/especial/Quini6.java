package modelo.casillero.especial;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class Quini6 extends Casillero{
	
	private ConcurrentHashMap<Jugador, Stack<Integer>> jugadores;
	
	private static Quini6 QUINI6 = null;
	
	private Quini6() {
		this.jugadores = new ConcurrentHashMap<>();

	}
	
	private synchronized static void crearQuini6() {
		if (QUINI6 == null) {
			QUINI6 = new Quini6();
		}
	}
	
	public static Quini6 getQuini6() {
		if (QUINI6 == null) crearQuini6();
		return QUINI6;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		if (this.noEstaRegistrado(unJugador)) {
			this.registrarJugador(unJugador);
		}
		
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
	
	private boolean noEstaRegistrado(Jugador unJugador) {
		return !jugadores.containsKey(unJugador);
	}

	private void registrarJugador(Jugador unJugador) {
		Stack <Integer> premios = new Stack<Integer>();
		premios.push(30000);
		premios.push(50000);
		jugadores.put(unJugador, premios);
	}
	
}
