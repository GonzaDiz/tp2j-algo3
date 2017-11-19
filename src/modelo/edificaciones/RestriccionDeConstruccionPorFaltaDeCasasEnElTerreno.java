package modelo.edificaciones;

import modelo.casillero.terrenos.TerrenoDoble;
import modelo.excepciones.NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError;

public class RestriccionDeConstruccionPorFaltaDeCasasEnElTerreno implements RestriccionDeConstruccion {

	private TerrenoDoble terreno;
	private int limite;
	
	public RestriccionDeConstruccionPorFaltaDeCasasEnElTerreno(TerrenoDoble terrenoDoble, int limiteCasas) {
		this.terreno = terrenoDoble;
		this.limite = limiteCasas;
	}

	@Override
	public void verificar() {
		if(this.terreno.cantidadDeCasas() != this.limite) {
			throw new NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError("Para construir un hotel primero debe construir la capacidad maxima de casas permitida");
		}

	}

}
