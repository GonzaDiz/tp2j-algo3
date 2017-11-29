package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.excepciones.NoEsUnCasilleroComprableError;
import modelo.jugador.Jugador;

public class RetrocesoDinamico extends Casillero {
	
	
	public RetrocesoDinamico() {
		super();
		this.nombreCasillero = "Retroceso Dinamico";

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
	@Override
	public void comprar(Jugador unJugador) {
		throw new NoEsUnCasilleroComprableError("El casillero en el que se encuentra no puede ser comprado");
	}
	
	@Override
	public boolean sosComprable() {
		return false;
	}

}
