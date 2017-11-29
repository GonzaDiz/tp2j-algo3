package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.excepciones.NoEsUnCasilleroComprableError;
import modelo.jugador.Jugador;

public class Salida extends Casillero {
	

	public Salida() {
		super();
		this.nombreCasillero = "Salida";
	}
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub

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
