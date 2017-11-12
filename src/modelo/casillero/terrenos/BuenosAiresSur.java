package modelo.casillero.terrenos;

import modelo.jugador.Jugador;

public class BuenosAiresSur extends TerrenoDoble{
	
	private static BuenosAiresSur BUENOSAIRESSUR= null;

	// Constructor por defecto crea con precio del enunciado.
	private BuenosAiresSur() {
		
		precio = 20000;
		propietario = null;
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


}
