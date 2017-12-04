package modelo.casillero;

import modelo.Posicion;
import modelo.jugador.Jugador;

public abstract class Casillero {
	
	protected String nombreCasillero;
	protected Posicion posicion;

	
	public abstract void afectarJugador(Jugador unJugador);
	public abstract void comprar(Jugador unJugador);
	public abstract boolean sosComprable();
	
	// Se podria crear un constructor que recibe un nombre como parametro para diferenciar de casilleros iguales
	public boolean sos(Casillero unCasillero) {
		return unCasillero.nombre() == this.nombreCasillero;
	}
	
	public String nombre() {
		return this.nombreCasillero;
	}
	
	public void setPosicion(Posicion unaPosicion) {
		this.posicion = unaPosicion;
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}

	
	
}
