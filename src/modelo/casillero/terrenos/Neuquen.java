package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class Neuquen extends TerrenoSimple{
	
	
	public Neuquen() {
		super();
		this.precio = 17000;
		this.propietario = null;
		this.costoCasa = 4800;
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
