package modelo.casillero.especial;

import modelo.excepciones.PorcentajeInvalidoError;

public class PorcentajeImpuesto {

	private int porcentaje;

	public PorcentajeImpuesto(int porcentaje) {
		if(porcentaje < 0 || porcentaje > 100) {
			throw new PorcentajeInvalidoError("El porcentaje debe estar entre 0 y 100");
		}
		this.porcentaje = porcentaje;
	}

	public int porcentajeDeImpuesto() {
		return this.porcentaje;
	}
	
	
}
