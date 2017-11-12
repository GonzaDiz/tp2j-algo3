package modelo.casillero.compania;

import modelo.jugador.Jugador;

public class Tren extends Compania {
	
	private static Tren TREN = null;
	
	private Tren() {
		
	}
	
	private synchronized static void crearTren() {
		if (TREN == null) {
			TREN = new Tren();
		}	
	}
	
	public static Tren getTren() {
		if (TREN == null) crearTren();
		return TREN;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub
		
	}

}
