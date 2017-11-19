package modelo.casillero.terrenos;

public class Tucuman extends TerrenoSimple{
	
	
	public Tucuman() {
		super();
		this.precio = 25000;
		this.propietario = null;
		this.nombreCasillero = "Tucuman";
		this.costoCasa = 7000;
		this.alquiler = new AlquilerTerrenoSimple(this);
	}


}
