package modelo.casillero.terrenos;

import modelo.casillero.Casillero;
import modelo.excepciones.CapitalInsuficienteError;
import modelo.jugador.Jugador;

public abstract class Terreno extends Casillero {
	
	int precio;
	Jugador propietario;
	public abstract int construcciones();
	public Terreno venderTerrenoA(Jugador jugador) throws CapitalInsuficienteError {
		jugador.extraerDinero(this.precio);
		this.propietario = jugador;
		return this;
	}
	
}
