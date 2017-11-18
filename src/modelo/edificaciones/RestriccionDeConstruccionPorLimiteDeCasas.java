package modelo.edificaciones;

import modelo.casillero.terrenos.Terreno;
import modelo.excepciones.LimiteDeEdificacionesExcedidoError;

public class RestriccionDeConstruccionPorLimiteDeCasas implements RestriccionDeConstruccion {

	private Terreno terreno;
	private int limite;
	
	public RestriccionDeConstruccionPorLimiteDeCasas(Terreno unTerreno, int limiteCasas) {
		this.terreno = unTerreno;
		this.limite = limiteCasas;
		
	}

	@Override
	public void verificar() {
		if(this.terreno.cantidadDeCasas() == this.limite) {
			throw new LimiteDeEdificacionesExcedidoError("Se ha alcanzado el limite de casas edificadas permitidas.");
		}

	}

}
