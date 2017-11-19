package modelo.casillero.compania;

public class Edesur extends Compania {
	
	
	public Edesur() {
		super();
		this.nombreCasillero = "Edesur";
		this.precioCompania = 35000;
		this.bonificador = new BonificadorDeCompania(this);
	}

}
