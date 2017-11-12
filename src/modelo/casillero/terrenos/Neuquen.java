package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class Neuquen extends TerrenoSimple{
	
	private static Neuquen NEUQUEN = null;
	
	private Neuquen() {
		
	}
	
	private synchronized static void crearNeuquen() {
		if (NEUQUEN == null) {
			NEUQUEN = new Neuquen();
		}	
	}
	
	public static Neuquen getNeuquen() {
		if (NEUQUEN == null) crearNeuquen();
		return NEUQUEN;
	}

	@Override
	public int construcciones() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub
		
	}

}
