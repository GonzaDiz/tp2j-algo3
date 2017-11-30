package modelo;

import java.util.ArrayList;

import modelo.casillero.compania.Compania;
import modelo.casillero.especial.Carcel;
import modelo.casillero.especial.Salida;
import modelo.casillero.terrenos.TerrenoDoble;
import modelo.casillero.terrenos.TerrenoSimple;
import modelo.jugador.Jugador;

public class Algopoly {
	
	private ArrayList<Jugador> jugadores;
	private Tablero tablero;
	private Turno turno;
	
	public Algopoly(ArrayList<Jugador> jugadores) {
		this.tablero = Tablero.getInstance();
		this.jugadores = jugadores;
		this.turno = new Turno();
		
		ArmadorDeTablero armador = new ArmadorDeTablero();
		armador.armarTablero(tablero, this.jugadores);
		
		for (Jugador jugador : jugadores) {
			jugador.caerEnCasillero(this.tablero.getCasillero(new Salida()));
			turno.agregarJugador(jugador);
		}
		
		this.turno.asignarTurnos();
	}

	public Tablero getTablero() {
		return this.tablero;
	}

	public ArrayList<Jugador> getJugadores() {
		return this.jugadores;
	}

	public Jugador getProximoJugadorConTurno() {
		return this.turno.proximoJugador();
	}
	
	public Jugador getJugadorConTurno() {
		return this.turno.jugadorConTurno();
	}

	public Turno getTurno() {
		return this.turno;
	}

	public Jugador proximoJugador() {
		return this.turno.proximoJugador();
	}

	public Carcel getCarcel() {
		return (Carcel) this.tablero.getCasillero(new Carcel());
	}

	public void eliminarJugador(Jugador jugadorRendido) {
		this.jugadores.remove(jugadorRendido);
		this.turno.eliminarJugador(jugadorRendido);
	}

	public TerrenoSimple getTerrenoSimple(String nombreTerrenoSimple) {
		return (TerrenoSimple) this.tablero.getCasillero(new TerrenoSimple(nombreTerrenoSimple));
	}
	
	public TerrenoDoble getTerrenoDoble(String nombreTerrenoDoble) {
		return (TerrenoDoble) this.tablero.getCasillero(new TerrenoDoble(nombreTerrenoDoble));
	}

	public Compania getCompania(String nombreCompania) {
		return (Compania) this.tablero.getCasillero(new Compania(nombreCompania));
	}

	public boolean hayGanador() {
		if(this.jugadores.size()==1)
			return true;
		return false;
	}

}
