package modelo.edificaciones;

import modelo.excepciones.NoPuedeConstruirCasasEnUnTerrenoConHotelesError;

public class RestriccionDeConstruccionPorTenerHotelesEdificados implements RestriccionDeConstruccion {

	private int cantidadDeHoteles;

	public RestriccionDeConstruccionPorTenerHotelesEdificados(int cantidadDeHoteles) {
		this.cantidadDeHoteles = cantidadDeHoteles;
	}

	@Override
	public void verificar() {
		if(this.cantidadDeHoteles != 0) {
			throw new NoPuedeConstruirCasasEnUnTerrenoConHotelesError("No puede construir casas en un terreno que tiene edificado un hotel.");
		}
		
	}

}
