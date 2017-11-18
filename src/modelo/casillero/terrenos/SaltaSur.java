package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class SaltaSur extends TerrenoDoble {

	
	public SaltaSur() {
		super();
		this.precio = 23000;
		this.propietario = null;
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
