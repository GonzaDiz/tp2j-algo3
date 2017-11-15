package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class Carcel extends Casillero {

	private static Carcel CARCEL = null;
	private int precioFianza;

	
	private Carcel() {
		this.precioFianza = 45000;

	}
	
	private synchronized static void crearCarcel() {
		if (CARCEL == null) {
			CARCEL = new Carcel();
		}
	}
	
	public static Carcel getCarcel() {
		if (CARCEL == null) crearCarcel();
		return CARCEL;
	}
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		Carcel carcel = Carcel.getCarcel();
		unJugador.caerEnCasillero(carcel);
	}

	public void cobrarFianza(Jugador jugador)  {
		jugador.extraerDinero(this.precioFianza);
		jugador.liberar();		
	}

	
}
