package modelo.jugador;

import modelo.Tablero;
import modelo.excepciones.NoEstasEncarceladoException;

public class Libre extends EstadoJugador {

	@Override
	public void avanzar(Jugador unJugador, int unValorDeDados) {
		
		// Si no se tiene que desplazar, el casillero actual no lo debe tener que volver a afectar
		if(unValorDeDados == 0) {
			//return true;
		}
		else {
			Tablero tablero = Tablero.getTablero();
			unJugador.caerEnCasillero(tablero.getCasillero(unJugador.casilleroActual(), unValorDeDados));
			
		}
		//for(int i = 0 ; i< unValorDeDados ; i++) {
		//	unJugador.avanzarUnCasillero();
		//}
		
		
		//unJugador.caerEnCasillero(unJugador.casilleroActual());
		//return true;
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		
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

	@Override
	public void pagarFianza(Jugador jugador) {
		throw new NoEstasEncarceladoException();
	}

}
