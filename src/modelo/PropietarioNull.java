package modelo;

import modelo.jugador.Jugador;

public class PropietarioNull extends Propietario {

	@Override
	public void entregarDinero(int precioMulta) {
		
	}

	@Override
	public boolean sos(Propietario unPropietario) {
		return false;
	}

	@Override
	public Jugador jugador() {
		return null;
	}

	@Override
	public boolean sosPropietario() {
		return false;
	}
}
