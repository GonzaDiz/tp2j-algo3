package modelo.casillero.terrenos;

import modelo.excepciones.AlquilerInexistenteError;

public class AlquilerTerrenoDoble {

	private static final int CASAS_0 = 0;
	private static final int CASAS_1 = 1;
	private static final int CASAS_2 = 2;
	private static final int HOTELES_0 = 0;
	private static final int HOTELES_1 = 1;
	private static final int HOTELES_2 = 2;


	private int tablaDeAlquileres[][] = new int [3][3];

	public int costoAlquilerCon(int cantidadDeCasas, int cantidadDeHoteles) {
		int costo = tablaDeAlquileres[cantidadDeCasas][cantidadDeHoteles];
		if(costo == 0) {
			throw new AlquilerInexistenteError("No existe un alquiler para la cantidad de casas y hoteles dada.");
		}
		return costo;
	}
	
	public AlquilerTerrenoDoble(int precioSinCasaNiHoteles, int precioConUnaCasa, int precioConDosCasas, int precioConUnHotel) {
		tablaDeAlquileres[CASAS_0][HOTELES_0] = precioSinCasaNiHoteles;
		tablaDeAlquileres[CASAS_1][HOTELES_0] = precioConUnaCasa;
		tablaDeAlquileres[CASAS_2][HOTELES_0] = precioConDosCasas;
		tablaDeAlquileres[CASAS_0][HOTELES_1] = precioConUnHotel;
		tablaDeAlquileres[CASAS_1][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_0][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_1][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_2] = 0;
	}
}
