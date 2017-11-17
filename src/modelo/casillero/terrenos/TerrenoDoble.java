package modelo.casillero.terrenos;

import java.util.ArrayList;

import modelo.edificaciones.Casa;
import modelo.edificaciones.Hotel;
import modelo.edificaciones.RestriccionDeConstruccionPorLimiteDeCasas;
import modelo.edificaciones.RestriccionDeConstruccionPorPropiedad;
import modelo.edificaciones.RestriccionDeConstruccionPorPropiedadDeTerrenoPareja;
import modelo.jugador.Jugador;

public abstract class TerrenoDoble extends Terreno {

	protected ArrayList<Hotel> hoteles; // En principio es un hotel, pero en un futuro se podrian poner mas
	protected int limiteHoteles;
	protected int costoHotel;
	public abstract Terreno terrenoPareja();
	
	
	public TerrenoDoble() {
		super();
		this.limiteHoteles = 1;
		this.limiteCasas = 2;
	}
	
	public void construirCasaPor(Jugador jugador) {
		
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedad(this, jugador));
		this.restricciones.add(new RestriccionDeConstruccionPorLimiteDeCasas(this, this.limiteCasas));
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedadDeTerrenoPareja(this, jugador));
		this.verificarRestricciones();
		
		jugador.extraerDinero(this.costoCasa);
		casas.add(new Casa());
		this.actualizarAlquiler();
	}
	
	public void actualizarAlquiler() {
		
	}

}
