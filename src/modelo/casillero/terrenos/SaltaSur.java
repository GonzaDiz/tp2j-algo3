package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class SaltaSur extends TerrenoDoble {

	private static SaltaSur SALTASUR = null;
	
	private SaltaSur() {
		super();
		this.precio = 23000;
		this.propietario = null;
	}
	
	private synchronized static void crearSaltaSur() {
		if (SALTASUR == null) {
			SALTASUR = new SaltaSur();
		}	
	}
	
	public static SaltaSur getSaltaSur() {
		if (SALTASUR == null) crearSaltaSur();
		return SALTASUR;
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

	@Override
	public Terreno terrenoPareja() {
		return SaltaNorte.getSaltaNorte();
	}

}
