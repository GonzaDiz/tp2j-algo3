package modelo;

public class BuenosAiresSur extends Terreno{

	// Constructor por defecto crea con precio del enunciado.
	public BuenosAiresSur() {
		super();
		precio = 20000;
		propietario = null;
	}
	
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		
		if(unJugador.ofrecerTerrenoEn(this, this.precio)) {
			propietario = unJugador;
		}
		
	}
	public Jugador propietario() {
		return propietario;
	}


}
