package modelo.casillero.especial;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class Quini6 extends Casillero{
	
	private ConcurrentHashMap<Jugador, Stack<Premio>> jugadores;
	
	public Quini6() {
		this.jugadores = new ConcurrentHashMap<>();

	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		Premio premio = jugadores.get(unJugador).lastElement();
		premio.entregarPremio(unJugador,this);
	}

	public void registrarJugador(Jugador unJugador) {
		Stack <Premio> premios = new Stack<>();
		premios.push(new SinPremioQuini());
		premios.push(new PremioQuini30000());
		premios.push(new PremioQuini50000());
		jugadores.put(unJugador, premios);
	}
	
	public void actualizarPremios(Jugador unJugador) {
		jugadores.get(unJugador).pop();
	}
}
