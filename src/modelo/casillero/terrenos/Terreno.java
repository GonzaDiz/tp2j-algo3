package modelo.casillero.terrenos;

import java.util.ArrayList;

import modelo.Propietario;
import modelo.PropietarioNull;
import modelo.PropietarioReal;
import modelo.casillero.Casillero;
import modelo.edificaciones.RestriccionDeConstruccion;
import modelo.jugador.Jugador;

public abstract class Terreno extends Casillero {
	
	protected int precioTerreno;
	protected Propietario propietario;
	protected int limiteCasas;
//	protected ArrayList<Casa> casas;
	protected int cantidadCasas;
	protected int costoCasa;
	protected ArrayList<RestriccionDeConstruccion> restricciones;
	
	public Terreno() {
//		this.casas = new ArrayList<Casa>();
		this.cantidadCasas = 0;
		this.restricciones = new ArrayList<RestriccionDeConstruccion>();
		this.propietario = new PropietarioNull();

	}
	
	public abstract int construcciones();
	public abstract void construirCasaPor(Jugador jugador);
	protected abstract void cobrarAlquilerA(Jugador unJugador);
	protected abstract void demolerConstrucciones();
	protected abstract int valorTotal();
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		if(this.tienePropietario()) {
				this.cobrarAlquilerA(unJugador);
		}
	}
	
	@Override
	public void comprar(Jugador unJugador) {
		this.venderTerrenoA(unJugador);
	}
	
	public boolean tienePropietario() {
		return this.propietario.sosPropietario();
	}

	public void venderTerrenoA(Jugador jugador) {
		jugador.extraerDinero(this.precioTerreno);
		this.propietario = new PropietarioReal(jugador);
		jugador.adquirirPropiedadDe(this);
	}
	
	public Propietario propietario() {
		return this.propietario;
	}

	public void cambiarPropietarioA(Jugador jugadorRival) {
		this.demolerConstrucciones();
		this.propietario = new PropietarioReal(jugadorRival);
		jugadorRival.adquirirPropiedadDe(this);
		
	}
	
	public int cantidadDeCasas() {
//		return casas.size();
		return this.cantidadCasas;
	}
	
	protected void verificarRestricciones() {
		for(RestriccionDeConstruccion r : this.restricciones) {
			r.verificar();
		}
		
		this.restricciones.clear(); // Eliminamos las restricciones ya verificadas.
	}

	protected void demolerCasas() {
//		this.casas.clear(); // Vaciamos el ArrayList de casas cuando se construyeron
		this.cantidadCasas = 0;
	}

	public  void vender(Jugador jugador) { 
		int monto = this.valorTotal() * (85/100);
		jugador.entregarDinero(monto);
		this.demolerConstrucciones();
		this.propietario = new PropietarioNull();
	}
	
	@Override
	public boolean sosComprable() {
		return !this.tienePropietario();
	}
}
