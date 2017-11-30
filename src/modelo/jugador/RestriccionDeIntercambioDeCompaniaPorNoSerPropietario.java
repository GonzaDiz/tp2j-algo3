package modelo.jugador;

import java.util.ArrayList;

import modelo.casillero.compania.Compania;
import modelo.excepciones.NoPuedeCederUnaCompaniaNoPropiaError;

public class RestriccionDeIntercambioDeCompaniaPorNoSerPropietario implements RestriccionDeIntercambio {

	private ArrayList<Compania> listaDeCompanias;
	private Compania companiaBuscada;
	
	public RestriccionDeIntercambioDeCompaniaPorNoSerPropietario(ArrayList<Compania> companiasCompradas, Compania unaCompaniaPropia) {
		this.listaDeCompanias = companiasCompradas;
		this.companiaBuscada = unaCompaniaPropia;
	}

	@Override
	public void verificar() {
		for(Compania c: this.listaDeCompanias) {
			if(c.sos(this.companiaBuscada)) {
				return;
			}
		}
		throw new NoPuedeCederUnaCompaniaNoPropiaError("Para ceder una compania debe ser el propietario");
	}
	

}
