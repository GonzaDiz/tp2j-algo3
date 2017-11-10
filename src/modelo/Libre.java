package modelo;

public class Libre extends EstadoJugador {

	@Override
	public boolean desplazar(Jugador unJugador, int unValorDeDados) {
		return true;
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		
	}

	@Override
	public boolean puedePagarFianza() {
		return false;
	}

}
