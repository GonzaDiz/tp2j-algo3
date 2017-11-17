package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class BuenosAiresSur extends TerrenoDoble{
	
	private static BuenosAiresSur BUENOSAIRESSUR= null;

	// Constructor por defecto crea con precio del enunciado.
	private BuenosAiresSur() {
		super();
		this.precio = 20000;
		this.propietario = null;
		this.costoCasa = 5000;
		this.costoHotel = 8000;
	}
	
	private synchronized static void crearBuenosAiresSur() {
		if (BUENOSAIRESSUR == null) {
			BUENOSAIRESSUR = new BuenosAiresSur();
		}
	}
	
	public static BuenosAiresSur getBuenosAiresSur() {
		if (BUENOSAIRESSUR == null) crearBuenosAiresSur();
		return BUENOSAIRESSUR;
	}
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		// Aqui estaran contempladas las opciones del terreno hacia el jugador
		
	}
	public Jugador propietario() {
		return propietario;
	}


	@Override
	public int construcciones() {
		return 0;
	}

	@Override
	public Terreno terrenoPareja() {
		return BuenosAiresNorte.getBuenosAiresNorte();
	}


}
