package modelo.casillero.compania;

import modelo.jugador.Jugador;

public class Subte extends Compania {
	
	private static Subte SUBTE = null;
	
	private Subte() {
		
	}
	private synchronized static void crearSubte() {
		if (SUBTE == null) {
			SUBTE = new Subte();
		}
	}
	
	public static Subte getSubte() {
		if (SUBTE == null) crearSubte();
		return SUBTE;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub
		
	}


}
