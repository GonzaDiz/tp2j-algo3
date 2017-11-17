package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class BuenosAiresNorte extends TerrenoDoble {
	
	private static BuenosAiresNorte BUENOSAIRESNORTE = null;
	
	private BuenosAiresNorte() {
		super();
		this.precio = 25000;
		this.propietario = null;
		this.costoCasa = 5500;
		this.costoHotel = 9000;
	}
	
	private synchronized static void crearBuenosAiresNorte() {
		if (BUENOSAIRESNORTE == null) {
			BUENOSAIRESNORTE = new BuenosAiresNorte();
		}	
	}
	
	public static BuenosAiresNorte getBuenosAiresNorte() {
		if (BUENOSAIRESNORTE == null) crearBuenosAiresNorte();
		return BUENOSAIRESNORTE;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		// TODO Auto-generated method stub

	}

	@Override
	public int construcciones() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Terreno terrenoPareja() {
		return BuenosAiresSur.getBuenosAiresSur();
	}

}
