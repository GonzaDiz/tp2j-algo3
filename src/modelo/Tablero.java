package modelo;

import java.util.ArrayList;

import modelo.casillero.Casillero;
import modelo.excepciones.ElTableroNoPoseeEseCasilleroError;


public class Tablero {
	
	private static Tablero TABLERO = null;
	private ArrayList<Casillero> casilleros;

	private Tablero() {
		this.casilleros = new ArrayList<>();
	}
	
	private synchronized static void crearTablero() {
		if (TABLERO == null) {
			TABLERO = new Tablero();
		}	
	}
	
	public static Tablero getTablero() {
		if (TABLERO == null) crearTablero();
		return TABLERO;
	}

	// Una posible mejora para evitar estos ifs es implementar una estructura de datos Lista Circular
	public Casillero getCasilleroPorDesplazamiento(Casillero casilleroActual, int valorDesplazamiento) {
		int posicionActual = casilleros.indexOf(casilleroActual);
		
		if(posicionActual + valorDesplazamiento > casilleros.size()){
			return casilleros.get(valorDesplazamiento - (casilleros.size() - posicionActual));
		}
		return casilleros.get(posicionActual + valorDesplazamiento);
	}
	
	public Casillero getCasillero(int posicion) {
		return casilleros.get(posicion);
	}
	
	public void agregarCasillero(Casillero unCasillero) {
		casilleros.add(unCasillero);
	}

	public Casillero getCasillero(Casillero unCasillero) {
		for(Casillero c : casilleros) {
			if(c.sos(unCasillero)) {
				return c;
			}
		}
		
		throw new ElTableroNoPoseeEseCasilleroError("El tablero no tiene ese casillero");
	}

}
