package modelo.jugador;

abstract public class EstadoJugador {
	abstract public boolean desplazar(Jugador unJugador, int unValorDeDados);
	abstract public void actualizarEstado(Jugador jugador);
	abstract public boolean puedePagarFianza();
	abstract public void retroceder(Jugador jugador, int cantidadDeCasillerosARetroceder);

}
