package modelo.jugador;

abstract public class EstadoJugador {
	abstract public void desplazar(Jugador unJugador, int unValorDeDados);
	abstract public void actualizarEstado(Jugador jugador);
	abstract public void retroceder(Jugador jugador, int cantidadDeCasillerosARetroceder);
	abstract public void pagarFianza(Jugador jugador);

}
