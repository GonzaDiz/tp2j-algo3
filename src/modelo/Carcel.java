package modelo;

public class Carcel extends Casillero {

	private int precioFianza;

	
	public Carcel() {
		this.precioFianza = 45000;

	}
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		unJugador.encarcelar();
	}

	
}
