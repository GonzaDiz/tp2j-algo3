package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.excepciones.NoEsUnCasilleroComprableError;
import modelo.jugador.Jugador;

public class ImpuestoDeLujo extends Casillero {
	
	private int porcentajeDeImpuesto;

	public ImpuestoDeLujo() {
		this.nombreCasillero = "Impuesto De Lujo";
		this.porcentajeDeImpuesto = 10;
	}
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		int monto = unJugador.capitalTotal() * (this.porcentajeDeImpuesto/100);
		unJugador.extraerDinero(monto);
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
