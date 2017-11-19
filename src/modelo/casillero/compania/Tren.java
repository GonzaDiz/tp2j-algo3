package modelo.casillero.compania;

public class Tren extends Compania {

	public Tren() {
		super();
		this.nombreCasillero = "Tren";
		this.precioCompania = 38000;
		this.bonificador = new BonificadorDeCompania(this);
	}
	
}
