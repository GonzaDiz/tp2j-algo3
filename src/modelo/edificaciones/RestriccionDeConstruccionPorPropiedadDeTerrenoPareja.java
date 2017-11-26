package modelo.edificaciones;

import modelo.casillero.terrenos.TerrenoDoble;
import modelo.excepciones.SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError;
import modelo.jugador.Jugador;

public class RestriccionDeConstruccionPorPropiedadDeTerrenoPareja implements RestriccionDeConstruccion {

	private TerrenoDoble terrenoPareja;
	private Jugador jugador;
	
	public RestriccionDeConstruccionPorPropiedadDeTerrenoPareja(TerrenoDoble terrenoDoble, Jugador jugador) {
		this.jugador = jugador;
		this.terrenoPareja = terrenoDoble;
	}

	@Override
	public void verificar() {
			if(this.terrenoPareja.propietario().jugador() != this.jugador) {
				throw new SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError("Se necesitan ambos terrenos para edificar en un terreno doble.");
			}
	}

}
