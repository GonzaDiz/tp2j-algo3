package modelo.casillero.compania;

import modelo.jugador.Jugador;

public class NoPropietario extends Jugador {

	public NoPropietario(String unNombre) {
		super(unNombre);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean sos(Jugador jugador) {
		return false;
	}

}
