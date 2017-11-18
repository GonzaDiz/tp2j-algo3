package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class BuenosAiresSur extends TerrenoDoble{
	
	

	// Constructor por defecto crea con precio del enunciado.
	public BuenosAiresSur() {
		super();
		precio = 20000;
		propietario = null;
		this.costoCasa = 5000;
		this.costoHotel = 8000;
	}
	
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		// Aqui estaran contempladas las opciones del terreno hacia el jugador
		
	}
	public Jugador propietario() {
		return propietario;
	}


	@Override
	public int construcciones() {
		return 0;
	}


}
