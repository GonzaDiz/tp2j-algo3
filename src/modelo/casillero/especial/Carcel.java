package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.excepciones.NoEsUnCasilleroComprableError;
import modelo.jugador.Jugador;

public class Carcel extends Casillero {


	private int precioFianza;

	public Carcel() {
		super();
		this.precioFianza = 45000;
		this.nombreCasillero = "Carcel";

	}
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		unJugador.encarcelar();
	}

	public void cobrarFianza(Jugador jugador)  {
		jugador.extraerDinero(this.precioFianza);
		jugador.liberar();
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
