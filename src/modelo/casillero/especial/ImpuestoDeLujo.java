package modelo.casillero.especial;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class ImpuestoDeLujo extends Casillero {
	
	private static ImpuestoDeLujo IMPUESTODELUJO = null;
	
	private ImpuestoDeLujo(){
		
	}
	
	private synchronized static void crearImpuestoDeLujo() {
		if (IMPUESTODELUJO == null) {
			IMPUESTODELUJO = new ImpuestoDeLujo();
		}	
	}
	
	public static ImpuestoDeLujo getImpuestoDeLujo() {
		if (IMPUESTODELUJO == null) crearImpuestoDeLujo();
		return IMPUESTODELUJO;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub
		
	}

}
