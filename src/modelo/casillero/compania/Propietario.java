package modelo.casillero.compania;

import modelo.jugador.Jugador;

public abstract class Propietario {

	public abstract void entregarDinero(int precioMulta);

	public abstract boolean sos(Propietario unPropietario);

	public abstract Jugador jugador();

}
