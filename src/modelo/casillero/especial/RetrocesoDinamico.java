package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class RetrocesoDinamico extends Casillero {
	
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
