package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class Policia extends Casillero {
	
	private static Policia POLICIA = null;
	
	private Policia() {
		
	}
	private synchronized static void crearPolicia() {
		if (POLICIA == null) {
			POLICIA = new Policia();
		}	
	}
	
	public static Policia getPolicia() {
		if (POLICIA == null) crearPolicia();
		return POLICIA;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		unJugador.caerEnCasillero(Carcel.getCarcel());
	}

}
