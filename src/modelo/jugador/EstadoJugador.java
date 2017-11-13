package modelo.jugador;

abstract public class EstadoJugador {
	abstract public void avanzar(Jugador unJugador, int cantidadDeCasillerosAAvanzar);
	abstract public void actualizarEstado(Jugador jugador);
	abstract public void retroceder(Jugador jugador, int cantidadDeCasillerosARetroceder);
	abstract public void pagarFianza(Jugador jugador);

}
