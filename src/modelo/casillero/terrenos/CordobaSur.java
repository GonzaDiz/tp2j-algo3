package modelo.casillero.terrenos;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class CordobaSur extends TerrenoDoble {
	
	private static CordobaSur CORDOBASUR = null;
	
	private CordobaSur() {
		this.precio = 18000;
		this.propietario = null;
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

	@Override
	public int construcciones() {
		// TODO Auto-generated method stub
		return 0;
	}

}
