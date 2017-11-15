package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class RetrocesoDinamico extends Casillero {
	
	private static RetrocesoDinamico RETROCESODINAMICO = null;
	
	private RetrocesoDinamico() {
		
	}
	
	private synchronized static void crearRetrocesoDinamico() {
		if (RETROCESODINAMICO == null) {
			RETROCESODINAMICO = new RetrocesoDinamico();
		}	
	}
	
	public static RetrocesoDinamico getRetrocesoDinamico() {
		if (RETROCESODINAMICO == null) crearRetrocesoDinamico();
		return RETROCESODINAMICO;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		int casillerosADesplazar;
		if(unJugador.ultimaTirada() <=6) {
			casillerosADesplazar = unJugador.ultimaTirada() - unJugador.cantidadDePropiedades();
		}
		
		else if(unJugador.ultimaTirada() <=10){
			casillerosADesplazar = unJugador.capitalTotal() % unJugador.ultimaTirada();
		}
		else {
			casillerosADesplazar = unJugador.ultimaTirada() - 2;
		}
		
		unJugador.desplazar(-casillerosADesplazar);
	}

}
