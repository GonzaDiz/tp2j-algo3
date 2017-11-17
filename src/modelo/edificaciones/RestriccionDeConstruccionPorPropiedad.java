package modelo.edificaciones;

import modelo.casillero.terrenos.Terreno;
import modelo.excepciones.SoloElPropietarioPuedeEdificarEnElTerrenoError;
import modelo.jugador.Jugador;

public class RestriccionDeConstruccionPorPropiedad implements RestriccionDeConstruccion {

	private Jugador jugador;
	private Terreno terreno;


	public RestriccionDeConstruccionPorPropiedad(Terreno terreno, Jugador jugador) {
		this.jugador = jugador;
		this.terreno = terreno;
	}

	@Override
	public void verificar() {
		if(terreno.propietario().sos(jugador) == false) {
			throw new SoloElPropietarioPuedeEdificarEnElTerrenoError("Solo el jugador propietario puede edificar en el terreno.");
		}

	}

}
