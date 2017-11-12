package modelo.jugador;

import modelo.Tablero;

public class Libre extends EstadoJugador {

	@Override
	public boolean desplazar(Jugador unJugador, int unValorDeDados) {
		
		// Si no se tiene que desplazar, el casillero actual no lo debe tener que volver a afectar
		if(unValorDeDados == 0) {
			return true;
		}
		
		//for(int i = 0 ; i< unValorDeDados ; i++) {
		//	unJugador.avanzarUnCasillero();
		//}
		
		Tablero tablero = Tablero.getTablero();
		unJugador.caerEnCasillero(tablero.getCasillero(unJugador.casilleroActual(), unValorDeDados));
		//unJugador.caerEnCasillero(unJugador.casilleroActual());
		return true;
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		
	}

	@Override
	public boolean puedePagarFianza() {
		return false;
	}

	@Override
	public void retroceder(Jugador unJugador, int cantidadDeCasillerosARetroceder) {
		if (cantidadDeCasillerosARetroceder == 0) {
		
		}
		else {
			Tablero tablero = Tablero.getTablero();
			unJugador.caerEnCasillero(tablero.getCasillero(unJugador.casilleroActual(), -cantidadDeCasillerosARetroceder));
		}
	}

}
