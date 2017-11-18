package modelo.casillero.terrenos;

import modelo.edificaciones.Casa;
import modelo.excepciones.LimiteDeEdificacionesExcedidoError;
import modelo.excepciones.SoloElPropietarioPuedeEdificarEnElTerrenoError;
import modelo.jugador.Jugador;

public abstract class TerrenoSimple extends Terreno{

	public TerrenoSimple() {
		super();
		this.limiteCasas = 1;
	}
	
	public void construirCasaPor(Jugador jugador) {
		if(this.propietario != jugador) {
			throw new SoloElPropietarioPuedeEdificarEnElTerrenoError("Solo el jugador propietario puede edificar en el terreno.");
		}
		
		if(this.casas.size() == this.limiteCasas) {
			throw new LimiteDeEdificacionesExcedidoError("Se ha alcanzado el limite de edificaciones permitidas.");
		}
		
		jugador.extraerDinero(this.precio);
		casas.add(new Casa());
		this.actualizarAlquiler();
	}
	
	public void actualizarAlquiler() {
		
	}
}
