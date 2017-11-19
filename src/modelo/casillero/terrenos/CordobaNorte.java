package modelo.casillero.terrenos;

public class CordobaNorte extends TerrenoDoble{
	
	public CordobaNorte() {
		super();
		this.precioTerreno = 20000;
		this.propietario = null;
		this.costoCasa = 2200;
		this.costoHotel = 3500;
		this.nombreCasillero = "Cordoba Norte";
		this.alquiler = new AlquilerTerrenoDoble(this);
	}



}
