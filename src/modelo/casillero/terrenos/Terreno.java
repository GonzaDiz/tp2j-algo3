package modelo.casillero.terrenos;

import java.util.ArrayList;

import modelo.casillero.Casillero;
import modelo.edificaciones.Casa;
import modelo.edificaciones.RestriccionDeConstruccion;
import modelo.jugador.Jugador;

public abstract class Terreno extends Casillero {
	
	protected int precioTerreno;
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
	
	public abstract int construcciones();
	public abstract void construirCasaPor(Jugador jugador);
	public abstract void cobrarAlquilerA(Jugador unJugador);
	protected abstract void demolerConstrucciones();
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		
		if(this.tienePropietario()) {
			if(this.propietario().sos(unJugador) == false) {
				this.cobrarAlquilerA(unJugador);
			}
		}
	}
	
	public boolean tienePropietario() {
		if(this.propietario == null) {
			return false;
		}
		return true;
	}

	public void venderTerrenoA(Jugador jugador) {
		jugador.extraerDinero(this.precioTerreno);
		this.propietario = jugador;
		jugador.adquirirPropiedadDe(this);
	}
	
	public Jugador propietario() {
		return this.propietario;
	}

	public void cambiarPropietarioA(Jugador jugadorRival) {
		this.demolerConstrucciones();
		this.propietario = jugadorRival;
		jugadorRival.adquirirPropiedadDe(this);
		
	}
	
	public int cantidadDeCasas() {
		return casas.size();
	}
	
	protected void verificarRestricciones() {
		for(RestriccionDeConstruccion r : this.restricciones) {
			r.verificar();
		}
		
		this.restricciones.clear(); // Eliminamos las restricciones ya verificadas.
	}

	protected void demolerCasas() {
		this.casas.clear(); // Vaciamos el ArrayList de casas cuando se construyeron
	}
	
}
