package modelo.casillero.especial;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

import modelo.casillero.Casillero;
import modelo.excepciones.NoEsUnCasilleroComprableError;
import modelo.jugador.Jugador;

public class Quini6 extends Casillero{
	
	private ConcurrentHashMap<Jugador, Stack<Premio>> jugadores;
	
	public Quini6() {
		super();
		this.jugadores = new ConcurrentHashMap<>();
		this.nombreCasillero = "Quini 6";

	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		Premio premio = jugadores.get(unJugador).lastElement();
		premio.entregarPremio(unJugador,this);
	}

	public void registrarJugador(Jugador unJugador) {
		Stack <Premio> premios = new Stack<>();
		premios.push(new SinPremioQuini());
		premios.push(new PremioQuini(30000));
		premios.push(new PremioQuini(50000));
		jugadores.put(unJugador, premios);
	}
	
	public void actualizarPremios(Jugador unJugador) {
		jugadores.get(unJugador).pop();
	}
	
	@Override
	public void comprar(Jugador unJugador) {
		throw new NoEsUnCasilleroComprableError("El casillero en el que se encuentra no puede ser comprado");
	}
	
	@Override
	public boolean sosComprable() {
		return false;
	}
}
