package modelo.casillero.terrenos;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class BuenosAiresNorte extends TerrenoDoble {
	
	private static BuenosAiresNorte BUENOSAIRESNORTE = null;
	
	private BuenosAiresNorte() {
		this.precio = 25000;
		this.propietario = null;
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

	@Override
	public int construcciones() {
		// TODO Auto-generated method stub
		return 0;
	}

}
