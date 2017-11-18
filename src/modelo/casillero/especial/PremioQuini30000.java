package modelo.casillero.especial;

import modelo.jugador.Jugador;

public class PremioQuini30000 implements Premio{
	
	private int PREMIO = 30000;

	@Override
	public void entregarPremio(Jugador unJugador, Quini6 quini6) {
		unJugador.entregarDinero(PREMIO);
		quini6.actualizarPremios(unJugador);
	}

}
