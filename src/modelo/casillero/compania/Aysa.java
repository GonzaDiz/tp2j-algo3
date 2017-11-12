package modelo.casillero.compania;

import modelo.jugador.Jugador;

public class Aysa extends Compania{
	
	private static Aysa AYSA = null;
	
	private Aysa() {
		
	}
	
	private synchronized static void crearAysa() {
		if (AYSA == null) {
			AYSA = new Aysa();
		}	
	}
	
	public static Aysa getAysa() {
		if (AYSA == null) crearAysa();
		return AYSA;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub
		
	}

}
