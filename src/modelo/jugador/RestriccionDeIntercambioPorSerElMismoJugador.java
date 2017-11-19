package modelo.jugador;

import modelo.excepciones.NoPuedeCederUnTerrenoASiMismoError;

public class RestriccionDeIntercambioPorSerElMismoJugador implements RestriccionDeIntercambio {

	private Jugador antiguoPropietario;
	private Jugador nuevoPropietario;
	
	public RestriccionDeIntercambioPorSerElMismoJugador(Jugador jugador, Jugador jugadorRival) {
		this.antiguoPropietario = jugador;
		this.nuevoPropietario = jugadorRival;
	}

	@Override
	public void verificar() {
		if(this.antiguoPropietario.sos(this.nuevoPropietario)) {
			throw new NoPuedeCederUnTerrenoASiMismoError("No puede cederse el terreno a si mismo");
		}

	}

}
