package modelo.casillero.especial;

import modelo.casillero.Casillero;
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

	
}
