package modelo.casillero.terrenos;

public class AlquilerTerrenoSimple {

	private static final int CASAS_0 = 0;
	private static final int CASAS_1 = 1;
	
	private int tablaDeAlquileres[] = new int [2];

	public int costoAlquilerCon(int cantidadDeCasas) {
		return tablaDeAlquileres[cantidadDeCasas];
	}
	
	public AlquilerTerrenoSimple(int montoAlquilerSinCasa, int montoAlquilerConCasa) {
		tablaDeAlquileres[CASAS_0] = montoAlquilerSinCasa;
		tablaDeAlquileres[CASAS_1] = montoAlquilerConCasa;
	}
}
