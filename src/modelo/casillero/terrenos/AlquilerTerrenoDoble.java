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
	
	public AlquilerTerrenoDoble(BuenosAiresSur c) {
		tablaDeAlquileres[CASAS_0][HOTELES_0] = 2000;
		tablaDeAlquileres[CASAS_1][HOTELES_0] = 3000;
		tablaDeAlquileres[CASAS_2][HOTELES_0] = 3500;
		tablaDeAlquileres[CASAS_0][HOTELES_1] = 5000;
		tablaDeAlquileres[CASAS_1][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_0][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_1][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_2] = 0;
	}
	
	public AlquilerTerrenoDoble(BuenosAiresNorte c) {
		tablaDeAlquileres[CASAS_0][HOTELES_0] = 2500;
		tablaDeAlquileres[CASAS_1][HOTELES_0] = 3500;
		tablaDeAlquileres[CASAS_2][HOTELES_0] = 4000;
		tablaDeAlquileres[CASAS_0][HOTELES_1] = 6000;
		tablaDeAlquileres[CASAS_1][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_0][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_1][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_2] = 0;
	}
	
	public AlquilerTerrenoDoble(CordobaSur c) {
		tablaDeAlquileres[CASAS_0][HOTELES_0] = 1000;
		tablaDeAlquileres[CASAS_1][HOTELES_0] = 1500;
		tablaDeAlquileres[CASAS_2][HOTELES_0] = 2500;
		tablaDeAlquileres[CASAS_0][HOTELES_1] = 3000;
		tablaDeAlquileres[CASAS_1][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_0][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_1][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_2] = 0;	
	}
	
	public AlquilerTerrenoDoble(CordobaNorte c) {
		tablaDeAlquileres[CASAS_0][HOTELES_0] = 1300;
		tablaDeAlquileres[CASAS_1][HOTELES_0] = 1800;
		tablaDeAlquileres[CASAS_2][HOTELES_0] = 2900;
		tablaDeAlquileres[CASAS_0][HOTELES_1] = 3500;
		tablaDeAlquileres[CASAS_1][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_0][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_1][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_2] = 0;
	}
	
	public AlquilerTerrenoDoble(SaltaSur c) {
		tablaDeAlquileres[CASAS_0][HOTELES_0] = 2000;
		tablaDeAlquileres[CASAS_1][HOTELES_0] = 3250;
		tablaDeAlquileres[CASAS_2][HOTELES_0] = 3850;
		tablaDeAlquileres[CASAS_0][HOTELES_1] = 5500;
		tablaDeAlquileres[CASAS_1][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_0][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_1][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_2] = 0;
	}
	
	public AlquilerTerrenoDoble(SaltaNorte c) {
		tablaDeAlquileres[CASAS_0][HOTELES_0] = 2000;
		tablaDeAlquileres[CASAS_1][HOTELES_0] = 3250;
		tablaDeAlquileres[CASAS_2][HOTELES_0] = 3850;
		tablaDeAlquileres[CASAS_0][HOTELES_1] = 5500;
		tablaDeAlquileres[CASAS_1][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_1] = 0;
		tablaDeAlquileres[CASAS_0][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_1][HOTELES_2] = 0;
		tablaDeAlquileres[CASAS_2][HOTELES_2] = 0;
	}
}
