package modelo.casillero.compania;

public class BonificadorDeCompania {

	private int bonificadorSinCompaniaPareja;
	private int bonificadorConCompaniaPareja;

	public BonificadorDeCompania(Aysa aysa) {
		
		this.bonificadorSinCompaniaPareja = 300;
		this.bonificadorConCompaniaPareja = 500;
	}

	public BonificadorDeCompania(Subte subte) {
		
		this.bonificadorSinCompaniaPareja = 600;
		this.bonificadorConCompaniaPareja = 1100;
	}

	public BonificadorDeCompania(Tren tren) {
		
		this.bonificadorSinCompaniaPareja = 450;
		this.bonificadorConCompaniaPareja = 800;
	}

	public BonificadorDeCompania(Edesur edesur) {
		
		this.bonificadorSinCompaniaPareja = 500;
		this.bonificadorConCompaniaPareja = 1000;
	}

	public int bonificacionSegun(Compania unaCompania, Compania companiaPareja) {
		if(unaCompania.propietario().sos(companiaPareja.propietario())) {
			return this.bonificadorConCompaniaPareja;
		}
		return this.bonificadorSinCompaniaPareja;
	}
}
