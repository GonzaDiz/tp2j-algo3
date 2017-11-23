package modelo.casillero.compania;

import modelo.jugador.Jugador;

public class PropietarioReal extends Propietario{
	
	private Jugador jugador;
	
	public PropietarioReal(Jugador unJugador) {
		this.jugador = unJugador;
	}

	@Override
	public void entregarDinero(int precioMulta) {
		this.jugador.entregarDinero(precioMulta);
	}

	@Override
	public boolean sos(Propietario unPropietario) {
		return this.jugador == unPropietario.jugador();
	}
	

	@Override
	public Jugador jugador() {
		return this.jugador;
	}

	@Override
	public boolean sosPropietario() {
		return true;
	}

}
