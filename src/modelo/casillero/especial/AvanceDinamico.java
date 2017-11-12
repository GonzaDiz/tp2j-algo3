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
		unJugador.desplazarseDinamicamente();	
	}

}
