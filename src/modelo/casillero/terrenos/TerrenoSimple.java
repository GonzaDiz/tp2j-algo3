package modelo.casillero.terrenos;

import modelo.edificaciones.RestriccionDeConstruccionPorLimiteDeCasas;
import modelo.edificaciones.RestriccionDeConstruccionPorPropiedad;
import modelo.jugador.Jugador;

public  class TerrenoSimple extends Terreno{

	private AlquilerTerrenoSimple alquiler;
	
	public TerrenoSimple(int precioTerreno, String nombreCasillero, int costoCasa, AlquilerTerrenoSimple alquiler ) {
		super();
		this.limiteCasas = 1;
		this.precioTerreno = precioTerreno;
		this.nombreCasillero = nombreCasillero;
		this.costoCasa = costoCasa;
		this.alquiler = alquiler;
	}
	
	
	public TerrenoSimple(String nombreTerrenoSimple) {
		super();
		this.nombreCasillero = nombreTerrenoSimple;
	}


	@Override
	public void construirCasaPor(Jugador jugador) {
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedad(this, jugador));
		this.restricciones.add(new RestriccionDeConstruccionPorLimiteDeCasas(this, this.limiteCasas));
		this.verificarRestricciones();
		jugador.extraerDinero(this.costoCasa);
//		casas.add(new Casa());
		this.cantidadCasas++;
	}
	
	@Override
	public void cobrarAlquilerA(Jugador unJugador) {
		int precioAlquiler = alquiler.costoAlquilerCon(this.cantidadDeCasas());
		unJugador.extraerDinero(precioAlquiler);
		this.propietario.entregarDinero(precioAlquiler);
	}
	
	@Override
	public int construcciones() {
		return this.cantidadDeCasas();
	}
	
	@Override
	protected void demolerConstrucciones() {
		this.demolerCasas();
	}


	@Override
	protected int valorTotal() {
		return this.precioTerreno + (this.cantidadCasas * this.costoCasa);
	}


	@Override
	public int cantidadDeHoteles() {
		return 0;
	}

}
