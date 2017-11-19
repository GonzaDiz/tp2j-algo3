package modelo.edificaciones;

import modelo.casillero.terrenos.TerrenoDoble;
import modelo.excepciones.NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError;

public class RestriccionDeConstruccionPorFaltaDeCasasEnElTerrenoPareja implements RestriccionDeConstruccion {

	private TerrenoDoble terrenoPareja;
	private int limite;
	
	public RestriccionDeConstruccionPorFaltaDeCasasEnElTerrenoPareja(TerrenoDoble terrenoPareja, int limiteCasas) {
		this.terrenoPareja = terrenoPareja;
		this.limite = limiteCasas;
	}

	@Override
	public void verificar() {
		if(this.terrenoPareja.cantidadDeCasas() != this.limite) {
			throw new NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError("Para construir un hotel primero debe construir la capacidad maxima de casas permitida en el terreno pareja");
		}
	}

}
