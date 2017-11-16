package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class SantaFe extends TerrenoSimple{
	
	private static SantaFe SANTAFE = null;
	
	private SantaFe() {
		this.precio = 15000;
		this.propietario = null;
	}
	
	private synchronized static void crearSantaFe() {
		if (SANTAFE == null) {
			SANTAFE = new SantaFe();
		}	
	}
	
	public static SantaFe getSantaFe() {
		if (SANTAFE == null) crearSantaFe();
		return SANTAFE;
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
