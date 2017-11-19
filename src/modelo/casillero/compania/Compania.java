package modelo.casillero.compania;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public abstract class Compania extends Casillero {

	protected int precioCompania;
	protected Jugador propietario;
	protected Compania companiaPareja;
	protected BonificadorDeCompania bonificador;
	
	public Compania() {
		this.propietario = null;
	}
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		
		if(this.tienePropietario()) {
			if(this.propietario().sos(unJugador) == false) {
				this.cobrarMultaA(unJugador);
			}
		}
	}
	
	private void cobrarMultaA(Jugador unJugador) {
		int precioMulta = bonificador.bonificacionSegun(this, this.companiaPareja)*unJugador.ultimaTirada(); 
		unJugador.extraerDinero(precioMulta);	
		this.propietario.entregarDinero(precioMulta);
	}

	public Jugador propietario() {
		return this.propietario;
	}

	public boolean tienePropietario() {
		if(this.propietario == null) {
			return false;
		}
		return true;
	}

	public void setCompaniaPareja(Compania compania) {
		this.companiaPareja = compania;
	}

	public void venderCompaniaA(Jugador jugador) {
		jugador.extraerDinero(this.precioCompania);
		this.propietario = jugador;
		jugador.adquirirPropiedadDe(this);
	}

	public void cambiarPropietarioA(Jugador jugadorRival) {
		this.propietario = jugadorRival;
		jugadorRival.adquirirPropiedadDe(this);
		
	}
}
