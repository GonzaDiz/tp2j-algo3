package modelo.casillero.terrenos;

import java.util.ArrayList;

import modelo.edificaciones.Casa;
import modelo.edificaciones.Hotel;
import modelo.edificaciones.RestriccionDeConstruccionPorFaltaDeCasasEnElTerreno;
import modelo.edificaciones.RestriccionDeConstruccionPorFaltaDeCasasEnElTerrenoPareja;
import modelo.edificaciones.RestriccionDeConstruccionPorLimiteDeCasas;
import modelo.edificaciones.RestriccionDeConstruccionPorPropiedad;
import modelo.edificaciones.RestriccionDeConstruccionPorPropiedadDeTerrenoPareja;
import modelo.jugador.Jugador;

public abstract class TerrenoDoble extends Terreno {

	protected ArrayList<Hotel> hoteles; // En principio es un hotel, pero en un futuro se podrian poner mas
	protected int limiteHoteles;
	protected int costoHotel;
	protected TerrenoDoble terrenoPareja;
	protected AlquilerTerrenoDoble alquiler;
	
	
	public TerrenoDoble() {
		super();
		this.hoteles = new ArrayList<Hotel>();
		this.limiteHoteles = 1;
		this.limiteCasas = 2;
	}
	
	public void construirCasaPor(Jugador jugador) {
		
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedad(this, jugador));
		this.restricciones.add(new RestriccionDeConstruccionPorLimiteDeCasas(this, this.limiteCasas));
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedadDeTerrenoPareja(this.terrenoPareja, jugador));
		this.verificarRestricciones();
		
		jugador.extraerDinero(this.costoCasa);
		casas.add(new Casa());
	}

	public void construirHotelPor(Jugador jugador) {
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedad(this, jugador));
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedadDeTerrenoPareja(this.terrenoPareja, jugador));
		this.restricciones.add(new RestriccionDeConstruccionPorFaltaDeCasasEnElTerreno(this, this.limiteCasas));
		this.restricciones.add(new RestriccionDeConstruccionPorFaltaDeCasasEnElTerrenoPareja(this, this.limiteCasas));
		this.verificarRestricciones();
		
		this.demolerCasas();
		jugador.extraerDinero(this.costoHotel);
		hoteles.add(new Hotel());
		
	}

	public void setTerrenoPareja(TerrenoDoble terreno) {
		this.terrenoPareja = terreno;
	}
	
	public void cobrarAlquilerA(Jugador unJugador) {
		int precioAlquiler = alquiler.costoAlquilerCon(this.cantidadDeCasas(), this.cantidadDeHoteles());
		unJugador.extraerDinero(precioAlquiler);
		this.propietario.entregarDinero(precioAlquiler);
	}

	public int cantidadDeHoteles() {
		return this.hoteles.size();
	}
	
	public int construcciones() {
		return this.cantidadDeCasas() + this.cantidadDeHoteles();
	}

	@Override
	protected void demolerConstrucciones() {
		this.demolerCasas();
		this.demolerHoteles();
	}

	private void demolerHoteles() {
		this.hoteles.clear();	
	}

}
