package modelo.edificaciones;

import modelo.casillero.terrenos.TerrenoDoble;
import modelo.excepciones.LimiteDeEdificacionesExcedidoError;

public class RestriccionDeConstruccionPorLimiteDeHoteles implements RestriccionDeConstruccion {
	
	private TerrenoDoble terreno;
	private int limite;
	
	public RestriccionDeConstruccionPorLimiteDeHoteles(TerrenoDoble unTerreno, int limiteHoteles) {
		this.terreno = unTerreno;
		this.limite = limiteHoteles;
	}
	@Override
	public void verificar() {
		if(this.terreno.cantidadDeHoteles() == this.limite) {
			throw new LimiteDeEdificacionesExcedidoError("Se ha alcanzado el limite de hoteles");
		}

	}

}
