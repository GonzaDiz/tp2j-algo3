package modelo;

public class Encarcelado extends EstadoJugador {

	private int turnosEnCarcel;
	
	public Encarcelado() {
		this.turnosEnCarcel = 0;
	}
	
	@Override
	public boolean desplazar(Jugador unJugador, int unValorDeDados) {
		return false;
	}


}
