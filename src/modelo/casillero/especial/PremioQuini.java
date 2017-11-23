package modelo.casillero.especial;

import modelo.jugador.Jugador;

public class PremioQuini implements Premio{
	
	private int monto = 30000;
	
	public PremioQuini(int monto) {
		this.monto = monto;
	}

	@Override
	public void entregarPremio(Jugador unJugador, Quini6 quini6) {
		unJugador.entregarDinero(monto);
		quini6.actualizarPremios(unJugador);
	}

}
