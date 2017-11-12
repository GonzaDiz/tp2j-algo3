package modelo;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class Salida extends Casillero {
	
	private static Salida SALIDA = null;
	
	private Salida() {
		
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub

	}
	
	private synchronized static void crearSalida() {
		if (SALIDA == null) {
			SALIDA = new Salida();
		}
	}
	
	public static Salida getSalida() {
		if (SALIDA == null) crearSalida();
		return SALIDA;
	}

}
