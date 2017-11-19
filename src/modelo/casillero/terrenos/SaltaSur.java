package modelo.casillero.terrenos;

public class SaltaSur extends TerrenoDoble {

	
	public SaltaSur() {
		super();
		this.precioTerreno = 23000;
		this.propietario = null;
		this.costoCasa = 4500;
		this.costoHotel = 7500;
		this.nombreCasillero = "Salta Sur";
		this.alquiler = new AlquilerTerrenoDoble(this);
	}
	

}
