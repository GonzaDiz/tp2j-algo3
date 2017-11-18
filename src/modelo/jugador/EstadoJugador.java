package modelo.jugador;

import modelo.casillero.especial.Carcel;

abstract public class EstadoJugador {
	abstract public void desplazar(Jugador unJugador, int cantidadDeCasilleros);
	abstract public void actualizarEstado(Jugador jugador);
	abstract public void pagarFianza(Jugador jugador, Carcel unaCarcel);

}
