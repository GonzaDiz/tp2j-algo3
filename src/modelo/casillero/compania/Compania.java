package modelo.casillero.compania;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;

public abstract class Compania extends Casillero {

	protected int precioCompania;
	protected Propietario propietario;
	protected Compania companiaPareja;
	protected BonificadorDeCompania bonificador;
	
	public Compania() {
		this.propietario = new PropietarioNull();
		//this.companiaPareja = new CompaniaNull();
	}
	
	@Override
	public void afectarJugador(Jugador unJugador) {
		this.cobrarMultaA(unJugador);
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
}
