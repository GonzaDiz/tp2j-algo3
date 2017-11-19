package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class SaltaNorte extends TerrenoDoble{
	
	public SaltaNorte() {
		super();
		this.precio = 23000;
		this.propietario = null;
		this.costoCasa = 4500;
		this.costoHotel = 7500;
		this.nombreCasillero = "Salta Norte";
		this.alquiler = new AlquilerTerrenoDoble(this);
	}


}
