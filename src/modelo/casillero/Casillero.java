package modelo.casillero;

import modelo.jugador.Jugador;

public abstract class Casillero {
	
	
	Casillero siguiente;
	Casillero anterior;
	
	public abstract void afectarJugador(Jugador unJugador);
	
	public void setCasilleroSiguiente(Casillero unCasillero) {
		this.siguiente = unCasillero;
	}
	
	public void setCasilleroAnterior(Casillero unCasillero) {
		this.anterior = unCasillero;
	}

	public Casillero siguiente() {
		return siguiente;
	}
	
	
	

}
