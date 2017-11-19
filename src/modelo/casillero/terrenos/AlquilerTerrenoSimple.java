package modelo.casillero.terrenos;

public class AlquilerTerrenoSimple {

	private static final int CASAS_0 = 0;
	private static final int CASAS_1 = 1;
	
	private int tablaDeAlquileres[] = new int [2];

	public int costoAlquilerCon(int cantidadDeCasas) {
		return tablaDeAlquileres[cantidadDeCasas];
	}
	
	public AlquilerTerrenoSimple(Neuquen c) {
		tablaDeAlquileres[CASAS_0] = 1800;
		tablaDeAlquileres[CASAS_1] = 3800;
	}
	
	public AlquilerTerrenoSimple(SantaFe c) {
		tablaDeAlquileres[CASAS_0] = 1500;
		tablaDeAlquileres[CASAS_1] = 3500;
	}
	
	public AlquilerTerrenoSimple(Tucuman c) {
		tablaDeAlquileres[CASAS_0] = 2500;
		tablaDeAlquileres[CASAS_1] = 4500;
	}
}
