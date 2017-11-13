package modelo.jugador;

import modelo.casillero.especial.Carcel;
import modelo.excepciones.NoPuedePagarFianzaException;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;

public class Encarcelado extends EstadoJugador {

	private int turnosEnCarcel;
	
	public Encarcelado() {
		this.turnosEnCarcel = 0;
	}
	
	@Override
	public void desplazar(Jugador unJugador, int unValorDeDados) {
		throw new NoSePuedeDesplazarJugadorEncarceladoException();
		//Tablero tablero = Tablero.getTablero();
		//unJugador.caerEnCasillero(tablero.getCasillero(unJugador.casilleroActual(), unValorDeDados));
		//return false;
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		turnosEnCarcel++;
		if(turnosEnCarcel == 4) {
			jugador.liberar();
		}
	}


	@Override
	public void retroceder(Jugador jugador, int cantidadDeCasillerosARetroceder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pagarFianza(Jugador jugador) {
		if(turnosEnCarcel <= 1) {
			throw new NoPuedePagarFianzaException();
		}
		Carcel carcel = Carcel.getCarcel();
		carcel.cobrarFianza(jugador);
		
	}


}
