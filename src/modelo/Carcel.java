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

	public void cobrarFianza(Jugador jugador) {
		jugador.extraerDinero(this.precioFianza);
		jugador.liberar();		
	}

	
}
