package modelo.casillero.terrenos;

public class SaltaNorte extends TerrenoDoble{
	
	public SaltaNorte() {
		super();
		this.precioTerreno = 23000;
		this.propietario = null;
		this.costoCasa = 4500;
		this.costoHotel = 7500;
		this.nombreCasillero = "Salta Norte";
		this.alquiler = new AlquilerTerrenoDoble(this);
	}


}
