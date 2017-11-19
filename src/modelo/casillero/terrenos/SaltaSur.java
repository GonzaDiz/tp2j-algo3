package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class SaltaSur extends TerrenoDoble {

	
	public SaltaSur() {
		super();
		this.precio = 23000;
		this.propietario = null;
		this.costoCasa = 4500;
		this.costoHotel = 7500;
		this.nombreCasillero = "Salta Sur";
		this.alquiler = new AlquilerTerrenoDoble(this);
	}
	

}
