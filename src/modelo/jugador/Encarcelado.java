package modelo.jugador;

import modelo.excepciones.NoPuedePagarFianzaException;
import modelo.excepciones.NoSePuedeDesplazarJugadorEncarceladoException;

public class Encarcelado extends EstadoJugador {
	
	@Override
	public void desplazar(Jugador unJugador, int cantidadDecasilleros) {
		throw new NoSePuedeDesplazarJugadorEncarceladoException();
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		//turnosEnCarcel++;
		//if(turnosEnCarcel == 4) {
		//	jugador.liberar();
		//}
		EncarceladoTurno1 encarceladoPor1Turno = new EncarceladoTurno1();
		jugador.cambiarEstado(encarceladoPor1Turno);
	}

	@Override
	public void pagarFianza(Jugador jugador) {
			throw new NoPuedePagarFianzaException();
		
		
	}


}
