package modelo.casillero.terrenos;

public class BuenosAiresNorte extends TerrenoDoble {

	
	public BuenosAiresNorte() {
		super();
		this.precioTerreno = 25000;
		this.propietario = null;
		this.costoCasa = 5500;
		this.costoHotel = 9000;
		this.nombreCasillero = "Buenos Aires Norte";
		this.alquiler = new AlquilerTerrenoDoble(this);
	}



}
