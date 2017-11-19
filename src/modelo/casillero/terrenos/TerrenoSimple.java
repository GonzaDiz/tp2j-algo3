package modelo.casillero.terrenos;

import modelo.edificaciones.Casa;
import modelo.edificaciones.RestriccionDeConstruccionPorLimiteDeCasas;
import modelo.edificaciones.RestriccionDeConstruccionPorPropiedad;
import modelo.jugador.Jugador;

public abstract class TerrenoSimple extends Terreno{

	protected AlquilerTerrenoSimple alquiler;
	
	public TerrenoSimple() {
		super();
		this.limiteCasas = 1;
	}
	
	public void construirCasaPor(Jugador jugador) {
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedad(this, jugador));
		this.restricciones.add(new RestriccionDeConstruccionPorLimiteDeCasas(this, this.limiteCasas));
		this.verificarRestricciones();
		jugador.extraerDinero(this.costoCasa);
		casas.add(new Casa());
	}
	
	public void cobrarAlquilerA(Jugador unJugador) {
		unJugador.extraerDinero(alquiler.costoAlquilerCon(this.cantidadDeCasas()));
	}
	
	public int construcciones() {
		return this.cantidadDeCasas();
	}

}
