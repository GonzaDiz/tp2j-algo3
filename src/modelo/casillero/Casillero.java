package modelo.casillero;

import modelo.jugador.Jugador;

public abstract class Casillero {
	
	protected String nombreCasillero;
	public abstract void afectarJugador(Jugador unJugador);
	
	// Se podria crear un constructor que recibe un nombre como parametro para diferenciar de casilleros iguales
	public boolean sos(Casillero unCasillero) {
		return unCasillero.nombre() == this.nombreCasillero;
	}
	
	public String nombre() {
		return this.nombreCasillero;
	}
	
}
