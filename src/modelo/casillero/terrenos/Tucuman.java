package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class Tucuman extends TerrenoSimple{
	
	private static Tucuman TUCUMAN = null;
	
	private Tucuman() {
		super();
		this.precio = 25000;
		this.propietario = null;
	}
	
	private synchronized static void crearTucuman() {
		if (TUCUMAN == null) {
			TUCUMAN = new Tucuman();
		}	
	}
	
	public static Tucuman getTucuman() {
		if (TUCUMAN == null) crearTucuman();
		return TUCUMAN;
	}

	@Override
	public int construcciones() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub
		
	}

}
