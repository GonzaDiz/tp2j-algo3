package modelo.casillero.compania;

public class BonificadorDeCompania {

	private int bonificadorSinCompaniaPareja;
	private int bonificadorConCompaniaPareja;
	
	public BonificadorDeCompania(int bonificacionSinCompaniaPareja, int bonificacionConCompaniaPareja) {
		this.bonificadorConCompaniaPareja = bonificacionConCompaniaPareja;
		this.bonificadorSinCompaniaPareja = bonificacionSinCompaniaPareja;
	}

	public int bonificacionSegun(Compania unaCompania, Compania companiaPareja) {
		if(unaCompania.propietario().sos(companiaPareja.propietario())) {
			return this.bonificadorConCompaniaPareja;
		}
		return this.bonificadorSinCompaniaPareja;
	}
}
