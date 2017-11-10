package modelo;

abstract public class EstadoJugador {
	abstract public boolean desplazar(Jugador unJugador, int unValorDeDados);
	abstract public void actualizarEstado(Jugador jugador);
	abstract public boolean puedePagarFianza();

}
