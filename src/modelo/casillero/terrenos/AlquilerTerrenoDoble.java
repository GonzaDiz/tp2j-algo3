package modelo.casillero.terrenos;

public class AlquilerTerrenoDoble {

	private static final int CASAS_0 = 0;
	private static final int CASAS_1 = 1;
	private static final int CASAS_2 = 2;
	private static final int HOTELES_0 = 0;
	private static final int HOTELES_1 = 1;

	private int tablaDeAlquileres[][] = new int [3][3];

	public int costoAlquilerCon(int cantidadDeCasas, int cantidadDeHoteles) {
		int costo = tablaDeAlquileres[cantidadDeCasas][cantidadDeHoteles];
		return costo;
	}
	
	public AlquilerTerrenoDoble(int precioSinCasaNiHoteles, int precioConUnaCasa, int precioConDosCasas, int precioConUnHotel) {
		tablaDeAlquileres[CASAS_0][HOTELES_0] = precioSinCasaNiHoteles;
		tablaDeAlquileres[CASAS_1][HOTELES_0] = precioConUnaCasa;
		tablaDeAlquileres[CASAS_2][HOTELES_0] = precioConDosCasas;
		tablaDeAlquileres[CASAS_0][HOTELES_1] = precioConUnHotel;
	}
}
