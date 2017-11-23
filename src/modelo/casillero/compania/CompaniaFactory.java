package modelo.casillero.compania;

public class CompaniaFactory {
	
	public Compania crearSubte() {
		BonificadorDeCompania bonificador = new BonificadorDeCompania(600,1100);
		Compania subte = new Compania("Subte",40000,bonificador);
		return subte;
	}
	
	public Compania crearTren() {
		BonificadorDeCompania bonificador = new BonificadorDeCompania(450,800);
		Compania tren = new Compania("Tren",38000,bonificador);
		return tren;
	}
	
	public Compania crearEdesur() {
		BonificadorDeCompania bonificador = new BonificadorDeCompania(500,1000);
		Compania edesur = new Compania("Edesur",35000,bonificador);
		return edesur;
	}
	
	public Compania crearAysa() {
		BonificadorDeCompania bonificador = new BonificadorDeCompania(300,500);
		Compania aysa = new Compania("Aysa",30000,bonificador);
		return aysa;
	}
}
