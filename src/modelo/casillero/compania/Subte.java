package modelo.casillero.compania;

public class Subte extends Compania {

	
	public Subte() {
		super();
		this.nombreCasillero = "Subte";
		this.precioCompania = 40000;
		this.bonificador = new BonificadorDeCompania(this);
	}
	
}
