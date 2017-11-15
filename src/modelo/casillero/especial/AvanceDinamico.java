package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class AvanceDinamico extends Casillero{
	
	private static AvanceDinamico AVANCEDINAMICO = null;
	
	private AvanceDinamico() {
		
	}
	
	private synchronized static void crearAvanceDinamico() {
		if (AVANCEDINAMICO == null) {
			AVANCEDINAMICO = new AvanceDinamico();
		}
	}
	
	public static AvanceDinamico getAvanceDinamico() {
		if (AVANCEDINAMICO == null) crearAvanceDinamico();
		return AVANCEDINAMICO;
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

}
