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
		this.nombreCasillero = "Buenos Aires Sur";
		this.alquiler = new AlquilerTerrenoDoble(this);
	}
	
	public Jugador propietario() {
		return propietario;
	}


}
