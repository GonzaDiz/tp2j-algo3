package modelo;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class Edesur extends Casillero {
	
	private static Edesur EDESUR = null;
	
	private Edesur() {
		
	}
	
	private synchronized static void crearEdesur() {
		if (EDESUR == null) {
			EDESUR = new Edesur();
		}
	}
	
	public static Edesur getEdesur() {
		if (EDESUR == null) crearEdesur();
		return EDESUR;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub

	}

}
