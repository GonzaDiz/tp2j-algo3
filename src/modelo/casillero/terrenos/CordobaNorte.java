package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class CordobaNorte extends TerrenoDoble{
	
	private static CordobaNorte CORDOBANORTE = null;
	
	private CordobaNorte() {
		super();
		this.precio = 20000;
		this.propietario = null;
		this.costoCasa = 2200;
		this.costoHotel = 3500;
	}
	
	private synchronized static void crearCordobaNorte() {
		if (CORDOBANORTE == null) {
			CORDOBANORTE = new CordobaNorte();
		}
	}
	
	public static CordobaNorte getCordobaNorte() {
		if (CORDOBANORTE == null) crearCordobaNorte();
		return CORDOBANORTE;
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

	@Override
	public Terreno terrenoPareja() {
		return CordobaSur.getCordobaSur();
	}

}
