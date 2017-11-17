package modelo.edificaciones;

import modelo.casillero.terrenos.TerrenoDoble;
import modelo.excepciones.SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError;
import modelo.jugador.Jugador;

public class RestriccionDeConstruccionPorPropiedadDeTerrenoPareja implements RestriccionDeConstruccion {

	private TerrenoDoble terreno;
	private Jugador jugador;
	
	public RestriccionDeConstruccionPorPropiedadDeTerrenoPareja(TerrenoDoble terrenoDoble, Jugador jugador) {
		this.jugador = jugador;
		this.terreno = terrenoDoble;
	}

	@Override
	public void verificar() {
		if(this.terreno.terrenoPareja().propietario().sos(this.jugador) == false) {
			throw new SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError("Se necesitan ambos terrenos para edificar en un terreno doble.");
		}

	}

}
