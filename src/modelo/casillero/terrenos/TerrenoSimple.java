package modelo.casillero.terrenos;

import modelo.edificaciones.Casa;
import modelo.edificaciones.RestriccionDeConstruccionPorLimiteDeCasas;
import modelo.edificaciones.RestriccionDeConstruccionPorPropiedad;
import modelo.jugador.Jugador;

public  class TerrenoSimple extends Terreno{

	protected AlquilerTerrenoSimple alquiler;
	
	public TerrenoSimple(int precioTerreno, Jugador propietario, String nombreCasillero, int costoCasa, AlquilerTerrenoSimple alquiler ) {
		super();
		this.limiteCasas = 1;
		this.precioTerreno = precioTerreno;
		this.propietario = propietario;
		this.nombreCasillero = nombreCasillero;
		this.costoCasa = costoCasa;
		this.alquiler = alquiler;
	}
	
	public void construirCasaPor(Jugador jugador) {
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedad(this, jugador));
		this.restricciones.add(new RestriccionDeConstruccionPorLimiteDeCasas(this, this.limiteCasas));
		this.verificarRestricciones();
		jugador.extraerDinero(this.costoCasa);
		casas.add(new Casa());
	}
	
	public void cobrarAlquilerA(Jugador unJugador) {
		int precioAlquiler = alquiler.costoAlquilerCon(this.cantidadDeCasas());
		unJugador.extraerDinero(precioAlquiler);
		this.propietario.entregarDinero(precioAlquiler);
	}
	
	public int construcciones() {
		return this.cantidadDeCasas();
	}
	
	@Override
	protected void demolerConstrucciones() {
		this.demolerCasas();
	}

}
