package modelo;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class CordobaSur extends Casillero {
	
	private static CordobaSur CORDOBASUR = null;
	
	private CordobaSur() {
		
	}
	
	private synchronized static void crearCarcel() {
		if (CORDOBASUR == null) {
			CORDOBASUR = new CordobaSur();
		}
	}
	
	public static CordobaSur getCordobaSur() {
		if (CORDOBASUR == null) crearCarcel();
		return CORDOBASUR;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub

	}

}
