package modelo.casillero.terrenos;

public class Neuquen extends TerrenoSimple{
	
	
	public Neuquen() {
		super();
		this.precioTerreno = 17000;
		this.propietario = null;
		this.costoCasa = 4800;
		this.nombreCasillero = "Neuquen";
		this.alquiler = new AlquilerTerrenoSimple(this);
	}

}
