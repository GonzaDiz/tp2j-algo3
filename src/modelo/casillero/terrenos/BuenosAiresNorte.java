package modelo.casillero.terrenos;


import modelo.jugador.Jugador;

public class BuenosAiresNorte extends TerrenoDoble {

	
	public BuenosAiresNorte() {
		super();
		this.precio = 25000;
		this.propietario = null;
		this.costoCasa = 5500;
		this.costoHotel = 9000;
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

}
