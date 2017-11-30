package modelo.casillero.compania;

import modelo.Propietario;
import modelo.PropietarioNull;
import modelo.PropietarioReal;
import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public class Compania extends Casillero {

	protected int precioCompania;
	protected Propietario propietario;
	protected Compania companiaPareja;
	protected BonificadorDeCompania bonificador;
	
	public Compania(String nombre, int precio, BonificadorDeCompania bonificador) {
		this.propietario = new PropietarioNull();
		this.nombreCasillero = nombre;
		this.precioCompania = precio;
		this.bonificador = bonificador;
	}
	
	public Compania(String nombreCompania) {
		this.nombreCasillero = nombreCompania;
	}

	@Override
	public void afectarJugador(Jugador unJugador) {
		if(this.tienePropietario()) {
			this.cobrarMultaA(unJugador);
		}
	}
	
	private boolean tienePropietario() {
		return this.propietario.sosPropietario();
	}

	@Override
	public void comprar(Jugador unJugador) {
		this.venderCompaniaA(unJugador);		
	}

	public Propietario propietario() {
		return this.propietario;
	}

	public void setCompaniaPareja(Compania compania) {
		this.companiaPareja = compania;
	}

	public void venderCompaniaA(Jugador jugador) {
		jugador.extraerDinero(this.precioCompania);
		this.propietario = new PropietarioReal(jugador);
		jugador.adquirirPropiedadDe(this);
	}

	public void cambiarPropietarioA(Jugador jugadorRival) {
		this.propietario = new PropietarioReal(jugadorRival);
		jugadorRival.adquirirPropiedadDe(this);
	}
	
	private void cobrarMultaA(Jugador unJugador) {
		int precioMulta = bonificador.bonificacionSegun(this, this.companiaPareja)*unJugador.ultimaTirada(); 
		unJugador.extraerDinero(precioMulta);	
		this.propietario.entregarDinero(precioMulta);
	}

	public void vender(Jugador jugador) {
		int monto = this.precioCompania * 85/100;
		jugador.entregarDinero(monto);
		this.propietario = new PropietarioNull();	
	}
	
	@Override
	public boolean sosComprable() {
		return !(this.tienePropietario());
	}

	public void entregarPropiedad() {
		this.propietario = new PropietarioNull();
	}

	
}
