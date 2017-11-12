package modelo;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class BuenosAiresNorte extends Casillero {
	
	private static BuenosAiresNorte BUENOSAIRESNORTE = null;
	
	private BuenosAiresNorte() {
		
	}
	
	private synchronized static void crearBuenosAiresNorte() {
		if (BUENOSAIRESNORTE == null) {
			BUENOSAIRESNORTE = new BuenosAiresNorte();
		}	
	}
	
	public static BuenosAiresNorte getBuenosAiresNorte() {
		if (BUENOSAIRESNORTE == null) crearBuenosAiresNorte();
		return BUENOSAIRESNORTE;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub

	}

}
