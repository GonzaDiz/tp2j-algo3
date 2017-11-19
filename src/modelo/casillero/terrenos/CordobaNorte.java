package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class CordobaNorte extends TerrenoDoble{
	
	public CordobaNorte() {
		super();
		this.precio = 20000;
		this.propietario = null;
		this.costoCasa = 2200;
		this.costoHotel = 3500;
		this.nombreCasillero = "Cordoba Norte";
		this.alquiler = new AlquilerTerrenoDoble(this);
	}



}
