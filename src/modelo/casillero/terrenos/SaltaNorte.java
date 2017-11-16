package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class SaltaNorte extends TerrenoDoble{
	
	private static SaltaNorte SALTANORTE = null;
	
	private SaltaNorte() {
		this.precio = 23000;
		this.propietario = null;
	}
	
	private synchronized static void crearSaltaNorte() {
		if (SALTANORTE == null) {
			SALTANORTE = new SaltaNorte();
		}	
	}
	
	public static SaltaNorte getSaltaNorte() {
		if (SALTANORTE == null) crearSaltaNorte();
		return SALTANORTE;
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
