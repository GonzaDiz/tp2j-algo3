package modelo.jugador;

import modelo.Turno;
import modelo.casillero.especial.Carcel;

public interface EstadoJugador {
	abstract public void desplazar(Jugador unJugador, int cantidadDeCasilleros);
	abstract public void actualizarEstado(Jugador jugador);
	abstract public void pagarFianza(Jugador jugador, Carcel unaCarcel);
	public abstract void terminarTurno(Turno turno, Jugador jugador);
	public abstract boolean puedoPagarFianza();
	public abstract boolean noPuedoTirarDados();

}
