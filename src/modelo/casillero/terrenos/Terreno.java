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
	protected int precioAlquiler;
	protected int limiteCasas;
	protected ArrayList<Casa> casas;
	protected int costoCasa;
	protected ArrayList<RestriccionDeConstruccion> restricciones;
	
	public Terreno() {
		this.casas = new ArrayList<Casa>();
		this.restricciones = new ArrayList<RestriccionDeConstruccion>();

	}
	
	public int cantidadDeCasas() {
		return casas.size();
	}
	
	public abstract int construcciones();
	protected abstract void actualizarAlquiler();
	public Terreno venderTerrenoA(Jugador jugador) throws CapitalInsuficienteError {
		jugador.extraerDinero(this.precio);
		this.propietario = jugador;
		return this;
	}
	public abstract void construirCasaPor(Jugador jugador);
	
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
