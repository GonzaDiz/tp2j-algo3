package modelo.casillero.terrenos;

import java.util.ArrayList;

import modelo.casillero.Casillero;
import modelo.edificaciones.Casa;
import modelo.edificaciones.RestriccionDeConstruccion;
import modelo.excepciones.CapitalInsuficienteError;
import modelo.jugador.Jugador;

public abstract class Terreno extends Casillero {
	
	protected int precio;
	protected Jugador propietario;
	protected int limiteCasas;
	protected ArrayList<Casa> casas;
	protected int costoCasa;
	protected ArrayList<RestriccionDeConstruccion> restricciones;
	
	public Terreno() {
		this.casas = new ArrayList<Casa>();
		this.restricciones = new ArrayList<RestriccionDeConstruccion>();
		this.propietario = null;

	}
	
	public int cantidadDeCasas() {
		return casas.size();
	}
	
	public abstract int construcciones();
	public abstract void construirCasaPor(Jugador jugador);
	public abstract void cobrarAlquilerA(Jugador unJugador);
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		
		if(this.tienePropietario()) {
			if(this.propietario().sos(unJugador) == false) {
				this.cobrarAlquilerA(unJugador);
			}
		}
	}
	
	

	private boolean tienePropietario() {
		if(this.propietario == null) {
			return false;
		}
		return true;
	}

	public Terreno venderTerrenoA(Jugador jugador) throws CapitalInsuficienteError {
		jugador.extraerDinero(this.precio);
		this.propietario = jugador;
		return this;
	}
	
	
	public Jugador propietario() {
		return this.propietario;
	}
	
	protected void verificarRestricciones() {
		for(RestriccionDeConstruccion r : restricciones) {
			r.verificar();
		}
		
		restricciones.clear(); // Eliminamos las restricciones ya verificadas.
	}
	
}
