package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class ImpuestoDeLujo extends Casillero {
	

	public ImpuestoDeLujo() {
		super();
		this.nombreCasillero = "Impuesto De Lujo";

	}
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		PorcentajeImpuesto porcentajeImpuesto = new PorcentajeImpuesto(10);
		unJugador.extraerDinero(unJugador.capitalTotal()*(porcentajeImpuesto.porcentajeDeImpuesto()/100));
	}

}
