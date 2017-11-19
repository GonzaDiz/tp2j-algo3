package modelo.casillero.terrenos;

public class SantaFe extends TerrenoSimple{
	
	public SantaFe() {
		super();
		this.precio = 15000;
		this.propietario = null;
		this.nombreCasillero = "Santa Fe";
		this.costoCasa = 4000;
		this.alquiler = new AlquilerTerrenoSimple(this);
	}

}
