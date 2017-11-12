package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class AvanceDinamico extends Casillero{

	@Override
	public void afectarJugador(Jugador unJugador) {
		unJugador.desplazarseDinamicamente();	
	}

}
