package modelo.casillero.terrenos;

import modelo.jugador.Jugador;


public class CordobaSur extends TerrenoDoble {
	
	public CordobaSur() {
		super();
		this.precio = 18000;
		this.propietario = null;
		this.costoCasa = 2000;
		this.costoHotel = 3000;
		this.nombreCasillero = "Cordoba Sur";
		this.alquiler = new AlquilerTerrenoDoble(this);
	}

}
