package modelo.jugador;

import java.util.ArrayList;

import modelo.casillero.terrenos.Terreno;
import modelo.excepciones.NoPuedeCederUnTerrenoNoPropioError;

public class RestriccionDeIntercambioDeTerrenoPorNoSerPropietario implements RestriccionDeIntercambio {

	private ArrayList<Terreno> listaDeTerrenos;
	private Terreno terrenoBuscado;
	
	public RestriccionDeIntercambioDeTerrenoPorNoSerPropietario(ArrayList<Terreno> terrenosComprados, Terreno unTerrenoPropio) {
		this.listaDeTerrenos = terrenosComprados;
		this.terrenoBuscado = unTerrenoPropio;
	}

	@Override
	public void verificar() {
		for(Terreno t: listaDeTerrenos) {
			if(t.sos(terrenoBuscado)) {
				return;
			}
		}
		throw new NoPuedeCederUnTerrenoNoPropioError("Para ceder un terreno debe ser el propietario");
	}

}
