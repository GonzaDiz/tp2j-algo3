package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.excepciones.NoEsUnCasilleroComprableError;
import modelo.jugador.Jugador;

public class AvanceDinamico extends Casillero{
	
	public AvanceDinamico() {
		super();
		this.nombreCasillero = "Avance Dinamico";
	}
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		int cantidadDeCasillerosADesplazar;
		int ultimaTirada = unJugador.ultimaTirada();
		
		if (ultimaTirada <= 6) {
			cantidadDeCasillerosADesplazar = ultimaTirada - 2;
		}
		else if (ultimaTirada <= 10) {
			cantidadDeCasillerosADesplazar = unJugador.capitalTotal() % ultimaTirada;
		}
		else {
			cantidadDeCasillerosADesplazar = ultimaTirada - unJugador.cantidadDePropiedades();
		}
		
		unJugador.desplazar(cantidadDeCasillerosADesplazar);
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
