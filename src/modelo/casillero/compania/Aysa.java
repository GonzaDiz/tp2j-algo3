package modelo.casillero.compania;

public class Aysa extends Compania{

	public Aysa() {
		super();
		this.nombreCasillero = "Aysa";
		this.precioCompania = 30000;
		this.bonificador = new BonificadorDeCompania(this);
	}


}
